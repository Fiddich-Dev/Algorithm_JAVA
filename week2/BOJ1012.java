package week2;

import java.util.Scanner;

public class BOJ1012 {
    
    static int t;
    static int n, m, k;
    static int[][] a = new int[54][54];
    static int[][] visited = new int[54][54];
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void dfs(int y, int x) {
        visited[y][x] = 1;

        for(int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny < 0 || nx < 0 || ny >= n || nx >= m) {
                continue;
            }
            if(visited[ny][nx] == 0 && a[ny][nx] == 1) {
                dfs(ny, nx);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();

        while(t-- != 0) {

            int cnt = 0;

            m = sc.nextInt();
            n = sc.nextInt();
            k = sc.nextInt();

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    visited[i][j] = 0;
                    a[i][j] = 0;
                }
            }

            for(int i = 0; i < k; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                a[y][x] = 1;
            }

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(visited[i][j] == 0 && a[i][j] == 1) {
                        dfs(i, j);
                        cnt++;
                    }
                    
                }
            }

            System.out.println(cnt);
            
        }
    }
}
