package week2;

import java.util.Scanner;

public class BOJ10026 {

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    
    static void solve1(int y, int x, int[][] visited, int n, char c, char[][] a) {
        visited[y][x] = 1;

        for(int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny < 0 || nx < 0 || ny >= n || nx >= n) {
                continue;
            }

            if(visited[ny][nx] == 0 && a[ny][nx] == c) {
                solve1(ny, nx, visited, n, c, a);
            }
        }
    }

    static void solve2(int y, int x, int[][] visited, int n, char c, char[][] a) {
        visited[y][x] = 1;

        for(int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny < 0 || nx < 0 || ny >= n || nx >= n) {
                continue;
            }

            if(c == 'R' || c == 'G') {
                if(visited[ny][nx] == 0 && (a[ny][nx] == 'R' || a[ny][nx] == 'G')) {
                    solve2(ny, nx, visited, n, c, a);
                }
            }
            else if(c == 'B') {
                if(visited[ny][nx] == 0 && a[ny][nx] == c) {
                    solve2(ny, nx, visited, n, c, a);
                }
            }

            
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        char[][] a = new char[n+4][n+4];

        for(int i = 0; i < n; i++) {
            String s = sc.next();
            for(int j = 0; j < n; j++) {
                a[i][j] = s.charAt(j);
            }
        }

        int[][] visited = new int[n+4][n+4];


        int cnt1 = 0;
        int cnt2 = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(visited[i][j] == 0) {
                    solve1(i, j, visited, n, a[i][j], a);
                    cnt1++;
                }
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                visited[i][j] = 0;
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(visited[i][j] == 0) {
                    solve2(i, j, visited, n, a[i][j], a);
                    cnt2++;
                }
            }
        }





        System.out.println(cnt1 + " " + cnt2);
    }
}

