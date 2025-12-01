package saffy;

import java.util.*;

public class SWEA1249 {

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int n;
    static int[][] a;
    static int[][] visited;
    static int ret;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int test = 1; test <= t; test++) {
            n = sc.nextInt();
            a = new int[n][n];
            visited = new int[n][n];
            ret = Integer.MAX_VALUE;
            for(int i = 0; i < n; i++) {
                String s = sc.next();
                for(int j = 0; j < n; j++) {
                    a[i][j] = s.charAt(j) - '0';
                }
            }

            int[][] cost = new int[n][n];
            visited[0][0] = 1;
            dfs(0, 0, 0);

            System.out.println("#" + test + " " + ret);
        }
    }


    static void dfs(int y, int x, int cost) {
//        System.out.println(y + " : " + x);
        if(y == n-1 && x == n-1) {
            ret = Math.min(ret, cost);
            return;
        }

        for(int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || nx < 0 || ny >= n || nx >= n) {
                continue;
            }
            if(visited[ny][nx] == 0) {
                if(cost + a[ny][nx] <= ret) {
                    visited[ny][nx] = 1;
                    dfs(ny, nx, cost + a[ny][nx]);
                    visited[ny][nx] = 0;
                }
            }
        }
    }
}
