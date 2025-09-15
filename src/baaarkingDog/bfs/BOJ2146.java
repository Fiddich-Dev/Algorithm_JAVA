package baaarkingDog.bfs;

import java.util.*;

public class BOJ2146 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a = new int[n][n];
        int[] dy = {-1, 0, 1, 0};
        int[] dx = {0, 1, 0, -1};


        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        Queue<Pair> q = new LinkedList<>();
        int[][] visited = new int[n][n];

        int id = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(a[i][j] == 1 && visited[i][j] == 0) {
                    id++;
                    q.add(new Pair(i, j));
                    visited[i][j] = id;

                    while(!q.isEmpty()) {
                        Pair p = q.poll();
                        int y = p.y;
                        int x = p.x;
                        for(int k = 0; k < 4; k++) {
                            int ny = y + dy[k];
                            int nx = x + dx[k];
                            if(ny < 0 || nx < 0 || ny >= n || nx >= n) {
                                continue;
                            }
                            if(a[ny][nx] == 1 && visited[ny][nx] == 0) {
                                q.add(new Pair(ny, nx));
                                visited[ny][nx] = id;
                            }
                        }
                    }
                }
            }
        }

        int[][] dist = new int[n][n];
        Queue<Pair> qq = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(visited[i][j] != 0) {
                    qq.add(new Pair(i, j));
                    dist[i][j] = 1;
                }
            }
        }

        int ret = Integer.MAX_VALUE;

        while(!qq.isEmpty()) {
            Pair p = qq.poll();
            int y = p.y;
            int x = p.x;
            int num = visited[y][x];

            for(int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if(ny < 0 || nx < 0 || ny >= n || nx >= n) {
                    continue;
                }

                if(dist[ny][nx] != 0 && visited[ny][nx] != num) {
                    ret = Math.min(ret, dist[ny][nx] + dist[y][x] - 2);
                }
                if(visited[ny][nx] == 0 && dist[ny][nx] == 0) {
                    visited[ny][nx] = num;
                    qq.add(new Pair(ny, nx));
                    dist[ny][nx] = dist[y][x] + 1;
                }

            }
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
