package implementation;

import java.util.*;

public class BOJ21610 {

    static int n, m;
    static int[][] a = new int[54][104];
    static int[][] temp = new int[54][104];
    static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};

    static List<Pair> p = new ArrayList<>();


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        Pair q = new Pair(n-1, 0);
        Pair w = new Pair(n-1, 1);
        Pair e = new Pair(n-2, 0);
        Pair r = new Pair(n-2, 1);

        p.add(q);
        p.add(w);
        p.add(e);
        p.add(r);

        for(int i = 0; i < m; i++) {
            int d = sc.nextInt();
            d--;
            int s = sc.nextInt();

            solve(d, s);
        }

        int ret = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                ret += a[i][j];
            }
        }

        System.out.println(ret);

    }



    static void solve(int d, int s) {

        temp = new int[54][104];
        List<Pair> p_temp = new ArrayList<>();

        // 구름 움직이기
        for(int k = 0; k < p.size(); k++) {
            int y = p.get(k).y;
            int x = p.get(k).x;

            for(int i = 0; i < s; i++) {
                int ny = y + dy[d];
                int nx = x + dx[d];
                // 윗쪽
                if(ny < 0) {
                    ny = n - 1;
                }
                // 오른쪽
                if(nx >= n) {
                    nx = 0;
                }
                // 아랫쪽
                if(ny >= n) {
                    ny = 0;
                }
                // 왼쪽
                if(nx < 0) {
                    nx = n - 1;
                }
                y = ny;
                x = nx;
            }

            a[y][x] += 1;
            temp[y][x] = 1;
            p_temp.add(new Pair(y, x));
        }

        p.clear();



        // 물복사
        for(int k = 0; k < p_temp.size(); k++) {
            int cnt = 0;

            int y = p_temp.get(k).y;
            int x = p_temp.get(k).x;

            for(int i = 1; i <= 7; i += 2) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if(ny < 0 || nx < 0 || ny >= n || nx >= n) {
                    continue;
                }
                if(a[ny][nx] > 0) {
                    cnt++;
                }
            }
            a[y][x] += cnt;
        }




        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(a[i][j] >= 2 && temp[i][j] == 0) {
                    p.add(new Pair(i, j));
                    a[i][j] -= 2;
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
