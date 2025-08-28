package implementation;

import java.util.*;

public class BOJ21610 {

    static int n, m;
    static int[][] a = new int[54][54];
    static int[][] visited = new int[54][54];
    static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static List<Pair> c = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        c.add(new Pair(n-1, 0));
        c.add(new Pair(n-1, 1));
        c.add(new Pair(n-2, 0));
        c.add(new Pair(n-2, 1));

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        for(int i = 0; i < m; i++) {
            int d = sc.nextInt();
            int s = sc.nextInt();
            d--;

            visited = new int[54][54];

            // 움직인다
            move(d, s);

            // 비가 내린다
            rain();

            // 구름이 사라진다
//            c.clear();

            // 물복사를 한다
            copy();

            // 구름이 생긴다
            create();
        }

        int ret = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                ret += a[i][j];
            }
        }
        System.out.println(ret);
    }

    // 구름 움직이기
    static void move(int d, int s) {
        for(Pair p : c) {
            p.y += dy[d] * s;
            p.y %= n;
            if(p.y < 0) {
                p.y += n;
            }


            p.x += dx[d] * s;
            p.x %= n;
            if(p.x < 0) {
                p.x += n;
            }
        }
    }

    static void rain() {
        for(Pair p : c) {
            a[p.y][p.x]++;
            visited[p.y][p.x] = 1;
        }
    }

    static void copy() {
        for(Pair p : c) {
            int y = p.y;
            int x = p.x;
            int cnt = 0;

            for(int j = 0; j < 4; j++) {
                int ny = y + dy[j*2 + 1];
                int nx = x + dx[j*2 + 1];
                if(ny < 0 || nx < 0 || ny >= n || nx >= n) {
                    continue;
                }
                if(a[ny][nx] > 0) {
                    cnt++;
                }
            }

            a[y][x] += cnt;
        }
    }

    static void create() {
        c.clear();
        for(int q = 0; q < n; q++) {
            for(int w = 0; w < n; w++) {
                if(visited[q][w] == 0 && a[q][w] >= 2) {
                    c.add(new Pair(q, w));
                    a[q][w] -= 2;
                }
            }
        }
    }

    static class Pair {
        int y;
        int x;

        public Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
