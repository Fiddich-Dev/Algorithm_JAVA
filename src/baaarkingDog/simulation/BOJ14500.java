package baaarkingDog.simulation;

import java.util.*;

public class BOJ14500 {

    static int n, m;
    static int[][] a;
    static int[][] visited;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int sum;
    static int ret;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a = new int[n][m];
        visited = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                visited[i][j] = 1;
                sum += a[i][j];

                dfs(i, j, 1);

                visited[i][j] = 0;
                sum -= a[i][j];
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                visited[i][j] = 1;
                sum += a[i][j];

                dfs2(i, j, 1);

                visited[i][j] = 0;
                sum -= a[i][j];
            }
        }

        System.out.println(ret);

    }

    static void dfs2(int y, int x, int depth) {

        if(depth == 2) {
            for(int i = 0; i < 4; i++) {
                for(int j = i+1; j < 4; j++) {
                    int ny1 = y + dy[i];
                    int nx1 = x + dx[i];

                    int ny2 = y + dy[j];
                    int nx2 = x + dx[j];

//                    System.out.println("여기");

                    if(ny1 < 0 || nx1 < 0 || ny1 >= n || nx1 >= m || ny2 < 0 || nx2 < 0 || ny2 >= n || nx2 >= m) {
                        continue;
                    }
                    if(visited[ny1][nx1] == 0 && visited[ny2][nx2] == 0) {
//                        sum += a[ny1][nx1];
//                        sum += a[ny2][nx2];

                        ret = Math.max(ret, sum + a[ny1][nx1] + a[ny2][nx2]);
//                        System.out.println(ret);
//                        System.out.println("여기");
                    }

                }
            }
            return;
        }

        for(int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny < 0 || nx < 0 || ny >= n || nx >= m) {
                continue;
            }

            if(visited[ny][nx] == 0) {
                visited[ny][nx] = 1;
                sum += a[ny][nx];

                dfs2(ny, nx, depth+1);

                visited[ny][nx] = 0;
                sum -= a[ny][nx];
            }
        }
    }


    static void dfs(int y, int x, int depth) {

        if(depth == 4) {
            ret = Math.max(ret, sum);
            return;
        }

        for(int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny < 0 || nx < 0 || ny >= n || nx >= m) {
                continue;
            }

            if(visited[ny][nx] == 0) {
                visited[ny][nx] = 1;
                sum += a[ny][nx];

                dfs(ny, nx, depth+1);

                visited[ny][nx] = 0;
                sum -= a[ny][nx];
            }
        }
    }
}

// 500 * 500
// 4 * 4 * 5