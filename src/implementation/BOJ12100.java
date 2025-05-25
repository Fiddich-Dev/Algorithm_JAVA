package implementation;

import java.util.Scanner;

public class BOJ12100 {
    
    static int n;
    // static int[][] a = new int[24][24];
    static int[][] map = new int[24][24];

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int ret = -1;



    static void go(int y, int x, Integer[][] visited, int dir, int[][] a) {
        while(true) {
            int ny = y + dy[dir];
            int nx = x + dx[dir];
            // 다음 좌표가 범위 밖이면 멈춤
            if(ny < 0 || nx < 0 || ny >= n || nx >= n) {
                break;
            }
            // 다음좌표가 0일때
            if(a[ny][nx] == 0) {
                a[ny][nx] = a[y][x];
                a[y][x] = 0;
            }
            // 다음좌표가 나랑 같을떄
            if(a[ny][nx] == a[y][x]) {
                // 합칠떄
                if(visited[ny][nx] == 0) {
                    a[ny][nx] += a[y][x];
                    a[y][x] = 0;
                    visited[ny][nx] = 1;
                    break;
                }
                // 못합칠때
                else {
                    break;
                }
            }

            // 다음좌표가 나랑 다를때
            if(a[ny][nx] != a[y][x]) {
                break;
            }
            y = ny;
            x = nx;
        }
    }



    static int[][] move(int dir, int[][] a) {
        Integer[][] visited = new Integer[24][24];

        int[][] b = new int[n][n];
        for (int i = 0; i < n; i++) {
            b[i] = a[i].clone();
        }

        for(int i = 0; i < 24; i++) {
            for(int j = 0; j < 24; j++) {
                visited[i][j] = 0;
            }
        }

        if(dir == 0) {
            // x좌표
            for(int i = 0; i < n; i++) {
                // y좌표
                for(int j = 0; j < n; j++) {
                    if(b[j][i] == 0) {
                        continue;
                    }
                    go(j, i, visited, dir, b);
                }
            }
        }
        

        else if(dir == 2) {
            // x좌표
            for(int i = 0; i < n; i++) {
                // y좌표
                for(int j = n-1; j >= 0; j--) {
                    if(b[j][i] == 0) {
                        continue;
                    }
                    go(j, i, visited, dir, b);
                }
            }
        }

        else if(dir == 1) {
            // y좌표
            for(int i = 0; i < n; i++) {
                // x좌표
                for(int j = n-1; j >= 0; j--) {
                    if(b[i][j] == 0) {
                        continue;
                    }
                    go(i, j, visited, dir, b);
                }
            }
        }

        else if(dir == 3) {
            // y좌표
            for(int i = 0; i < n; i++) {
                // x좌표
                for(int j = 0; j < n; j++) {
                    if(b[i][j] == 0) {
                        continue;
                    }
                    go(i, j, visited, dir, b);
                }
            }
        }

        return b;
    }

    static void solve(int cnt, int[][] m) {
        if(cnt == 5) {
            check(m);
            return;
        }

        check(m);

        int[][] temp = new int[n][n];

        temp = move(0, m);
        solve(cnt+1, temp);

        
        temp = move(1, m);
        solve(cnt+1, temp);

        
        temp = move(2, m);
        solve(cnt+1, temp);

        
        temp = move(3, m);
        solve(cnt+1, temp);
        
    } 
    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        solve(0, map);

        System.out.println(ret);





    }

    static void check(int[][] m) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                ret = Math.max(ret, m[i][j]);
            }
        }
    }
}

// 상하좌우 중 하나로 움직임
