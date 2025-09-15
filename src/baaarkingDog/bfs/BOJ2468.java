package baaarkingDog.bfs;

import java.util.*;

public class BOJ2468 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a = new int[n][n];

        int[] dy = {-1, 0, 1, 0};
        int[] dx = {0, 1, 0, -1};

        int mx = -1;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
                mx = Math.max(mx, a[i][j]);
            }
        }

        int ret = -1;

        // 잠기는 높이
        for(int i = 0; i <= mx; i++) {
            int[][] visited = new int[n][n];
            Queue<Pair> q = new LinkedList<>();

            int cnt = 0;

            for(int j = 0; j < n; j++) {
                for(int k = 0; k < n; k++) {
                    if(a[j][k] > i && visited[j][k] == 0) {
                        visited[j][k] = 1;
                        q.add(new Pair(j, k));
                        cnt++;

                        while(!q.isEmpty()) {
                            Pair p = q.poll();
                            int y = p.y;
                            int x = p.x;

                            for(int l = 0; l < 4; l++) {
                                int ny = y + dy[l];
                                int nx = x + dx[l];
                                if(ny < 0 || nx < 0 || ny >= n || nx >= n) {
                                    continue;
                                }
                                if(a[ny][nx] > i && visited[ny][nx] == 0) {
                                    visited[ny][nx] = visited[y][x] + 1;
                                    q.add(new Pair(ny, nx));
                                }

                            }
                        }
                    }
                }
            }

            ret = Math.max(ret, cnt);
        }

        System.out.println(ret);
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
