package baaarkingDog.bfs;

import java.util.*;

public class BOJ2206 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] a = new int[n][m];
        int[][][] visited = new int[n][m][2];
        int[] dy = {-1, 0, 1, 0};
        int[] dx = {0, 1, 0, -1};


        for(int i = 0; i < n; i++) {
            String s = sc.next();
            for(int j = 0; j < m; j++) {
                a[i][j] = s.charAt(j) - '0';
            }
        }

        Queue<Status> q = new LinkedList<>();
        q.add(new Status(0, 0, 0));
        visited[0][0][0] = 1;

        while(!q.isEmpty()) {
            Status s = q.poll();
            int y = s.y;
            int x = s.x;
            int isBreak = s.isBreak;

            for(int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if(ny < 0 || nx < 0 || ny >= n || nx >= m) {
                    continue;
                }

                if(a[ny][nx] == 0 && visited[ny][nx][isBreak] == 0) {
                    visited[ny][nx][isBreak] = visited[y][x][isBreak] + 1;
                    q.add(new Status(ny, nx, isBreak));
                }
                else if(a[ny][nx] == 1 && isBreak == 0 && visited[ny][nx][1] == 0) {
                    visited[ny][nx][1] = visited[y][x][0] + 1;
                    q.add(new Status(ny, nx, 1));
                }

            }
        }

        if(visited[n-1][m-1][0] == 0 && visited[n-1][m-1][1] == 0) {
            System.out.println(-1);
            return;
        }
        if(visited[n-1][m-1][0] == 0 || visited[n-1][m-1][1] == 0) {
            System.out.println(Math.max(visited[n-1][m-1][0], visited[n-1][m-1][1]));
            return;
        }
        System.out.println(Math.min(visited[n-1][m-1][0], visited[n-1][m-1][1]));
    }

    static class Status {
        int y;
        int x;
        int isBreak;

        public Status(int y, int x, int isBreak) {
            this.y = y;
            this.x = x;
            this.isBreak = isBreak;
        }
    }
}
