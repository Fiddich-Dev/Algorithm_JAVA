package baaarkingDog.bfs;

import java.util.*;

public class BOJ2146 {

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int ret = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a = new int[n][n];
        int[][] visited = new int[n][n]; // 섬을 나타내는 것
        int[][] dist = new int[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }



        // 섬 표시
        int cnt = 0;
        Queue<Pair> q = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(a[i][j] == 1 && visited[i][j] == 0) {
                    cnt++;

                    q.add(new Pair(i, j));
                    visited[i][j] = cnt;

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
                                visited[ny][nx] = cnt;
                                q.add(new Pair(ny, nx));
                            }
                        }
                    }
                }
            }
        }



        Queue<Status> qq = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(visited[i][j] != 0) {
                    qq.add(new Status(i, j, visited[i][j]));
                    dist[i][j] = 1;
                }
            }
        }

        while(!qq.isEmpty()) {
            Status s = qq.poll();
            int y = s.y;
            int x = s.x;
            int num = s.num;

            for(int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if(ny < 0 || nx < 0 || ny >= n || nx >= n) {
                    continue;
                }
                // 다리나 땅이 없을때
                if(visited[ny][nx] == 0) {
                    visited[ny][nx] = num;
                    dist[ny][nx] = dist[y][x] + 1;
                    qq.add(new Status(ny, nx, num));
                }
                if(visited[ny][nx] != 0 && visited[ny][nx] != num) {
                    ret = Math.min(ret, dist[y][x] + dist[ny][nx] - 2);
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

    static class Status {
        int y;
        int x;
        int num;

        public Status(int y, int x, int num) {
            this.y = y;
            this.x = x;
            this.num = num;
        }
    }
}
