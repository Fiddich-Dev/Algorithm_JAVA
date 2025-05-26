package implementation;

import java.util.*;

public class BOJ15683 {

    static class Info {
        int y;
        int x;
        int num;
        Info(int y, int x, int num) {
            this.y = y;
            this.x = x;
            this.num = num;
        }
    }

    static int n, m;
    static int[][] a = new int[10][10];
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static List<Info> cctv = new ArrayList<>();

    // 0의 최소 개수
    static int ret = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();



        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
                if(a[i][j] >= 1 && a[i][j] <= 5) {
                    cctv.add(new Info(i, j, a[i][j]));
                }
            }
        }

        go(0);

        System.out.println(ret);

    }

    static void fill(int y, int x, int dir) {
        while(true) {
            int ny = y + dy[dir];
            int nx = x + dx[dir];

            if (ny < 0 || nx < 0 || ny >= n || nx >= m) {
                break;
            }
            if(a[ny][nx] == 6) {
                break;
            }
            if(a[ny][nx] >= 1 && a[ny][nx] <= 5) {
                y = ny;
                x = nx;
                continue;
            }
            a[ny][nx]--;
            y = ny;
            x = nx;
        }
    }

    static void unfill(int y, int x, int dir) {
        while(true) {
            int ny = y + dy[dir];
            int nx = x + dx[dir];

            if (ny < 0 || nx < 0 || ny >= n || nx >= m) {
                break;
            }
            if(a[ny][nx] == 6) {
                break;
            }
            if(a[ny][nx] >= 1 && a[ny][nx] <= 5) {
                y = ny;
                x = nx;
                continue;
            }
            a[ny][nx]++;
            y = ny;
            x = nx;
        }
    }

    static void go(int now) {

//        System.out.println(now);
        if(now == cctv.size()) {
            int cnt = 0;

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(a[i][j] == 0) {
                        cnt++;
                    }
                }
            }

            ret = Math.min(ret, cnt);
            return;
        }

        for(int i = 0; i < 4; i++) {
            // 돌려가며 맵에 확인가능한 구역을 -1로 표시하고 재귀
            int state = cctv.get(now).num;

            // 한방향
            if(state == 1) {
                int y = cctv.get(now).y;
                int x = cctv.get(now).x;

                fill(y, x, i);
                go(now+1);
                // 백트래킹
                unfill(y, x, i);
            }

            else if(state == 2) {
                int y = cctv.get(now).y;
                int x = cctv.get(now).x;
                fill(y, x, i);
                fill(y, x, (i+2)%4);
                go(now+1);
                // 백트래킹
                unfill(y, x, i);
                unfill(y, x, (i+2)%4);

            }
            else if(state == 3) {
                int y = cctv.get(now).y;
                int x = cctv.get(now).x;
                fill(y, x, i);
                fill(y, x, (i+1)%4);
                go(now+1);
                unfill(y, x, i);
                unfill(y, x, (i+1)%4);
            }
            else if(state == 4) {
                int y = cctv.get(now).y;
                int x = cctv.get(now).x;
                fill(y, x, i);
                fill(y, x, (i+1)%4);
                fill(y, x, (i+2)%4);
                go(now+1);
                unfill(y, x, i);
                unfill(y, x, (i+1)%4);
                unfill(y, x, (i+2)%4);
            }

            else if(state == 5) {
                int y = cctv.get(now).y;
                int x = cctv.get(now).x;
                fill(y, x, i);
                fill(y, x, (i+1)%4);
                fill(y, x, (i+2)%4);
                fill(y, x, (i+3)%4);
                go(now+1);
                unfill(y, x, i);
                unfill(y, x, (i+1)%4);
                unfill(y, x, (i+2)%4);
                unfill(y, x, (i+3)%4);
            }



        }
    }
}

// 0은 빈 칸, 6은 벽, 1~5는 CCTV

