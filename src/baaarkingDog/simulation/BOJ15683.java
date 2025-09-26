package baaarkingDog.simulation;

import java.util.*;

public class BOJ15683 {

    static int n, m;
    static int[][] a;
    static int[][] visited;
    static List<Pair> arr = new ArrayList<>();
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static int ret = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a = new int[n][m];
        visited = new int[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
                if(a[i][j] >= 1 && a[i][j] <= 5) {
                    arr.add(new Pair(i, j));
                }
            }
        }


        go(0);

        System.out.println(ret);
    }

    static void go(int now) {
        if(now == arr.size()) {
            int cnt = 0;
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(visited[i][j] == 0 && a[i][j] == 0) {
                        cnt++;
                    }
                }
            }
            ret = Math.min(ret, cnt);
            return;
        }
        int y = arr.get(now).y;
        int x = arr.get(now).x;

        for(int i = 0; i < 4; i++) {
            solve(y, x, a[y][x], i, 1);
            go(now+1);
            solve(y, x, a[y][x], i, -1);
        }

    }

    static void solve(int y, int x, int num, int dir, int v) {
        if(num == 1) {
            solve2(y, x, dir, v);
        }

        else if(num == 2) {
            solve2(y, x, dir, v);
            solve2(y, x, (dir+2)%4, v);
        }

        else if(num == 3) {
            solve2(y, x, dir, v);
            solve2(y, x, (dir+1)%4, v);
        }

        else if(num == 4) {
            solve2(y, x, dir, v);
            solve2(y, x, (dir+1)%4, v);
            solve2(y, x, (dir+2)%4, v);
        }

        else if(num ==5) {
            solve2(y, x, dir, v);
            solve2(y, x, (dir+1)%4, v);
            solve2(y, x, (dir+2)%4, v);
            solve2(y, x, (dir+3)%4, v);
        }
    }

    // 한쪽 방향으로 채우기
    static void solve2(int y, int x, int dir, int v) {
        int ny = y;
        int nx = x;

        while(true) {
            if(ny < 0 || nx < 0 || ny >= n || nx >= m || a[ny][nx] == 6) {
                break;
            }
            if(a[ny][nx] >= 1 && a[ny][nx] <= 5) {

            }
            visited[ny][nx] += v;
            ny += dy[dir];
            nx += dx[dir];
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
