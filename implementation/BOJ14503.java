package implementation;

import java.util.Scanner;

public class BOJ14503 {
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};    

    static int n, m;
    static int sy, sx, sd;

    // 0은 빈칸, 1은 벽
    static int[][] a = new int[54][54];
    static int[][] visited = new int[54][54];

    static int ret;

    // true면 진행가능
    static boolean check(int y, int x) {
        for(int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(a[ny][nx] == 0 && visited[ny][nx] == 0) {
                return true;
            }
        }
        return false;
    }

    static void solve(int y, int x, int dir) {
        if(visited[y][x] == 0) {
            visited[y][x] = 1;
            ret++;
        }

        if(check(y, x) == false) {
            int temp = dir ^ (1 << 1);
            int ny = y + dy[temp];
            int nx = x + dx[temp];

            if(ny < 0 || nx < 0 || ny >= n || nx >= m || a[ny][nx] == 1) {
                return;
            }
            else {
                solve(ny, nx, dir);
                return;
            }
        }
        else {
            for(int i = 0; i < 4; i++) {
                dir = (dir + 3) % 4;
                int ny = y + dy[dir];
                int nx = x + dx[dir];
                
                if(a[ny][nx] == 0 && visited[ny][nx] == 0) {
                    solve(ny, nx, dir);
                    return;
                }
            }


        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        sy = sc.nextInt();
        sx = sc.nextInt();
        sd = sc.nextInt();


        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        solve(sy, sx, sd);

        System.out.println(ret);
        
    }
}

