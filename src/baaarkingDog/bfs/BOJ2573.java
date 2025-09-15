package baaarkingDog.bfs;

import java.util.*;

public class BOJ2573 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] a = new int[n][m];
        int[] dy = {-1, 0, 1, 0};
        int[] dx = {0, 1, 0, -1};

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        int ret = 0;

        while(true) {
            int[][] temp = new int[n][m]; // 인접한 바다의 칸 수

            // 바다 칸수 세기
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(a[i][j] == 0) {
                        continue;
                    }

                    int cnt = 0;
                    for(int k = 0; k < 4; k++) {
                        int ny = i + dy[k];
                        int nx = j + dx[k];

                        if(ny < 0 || nx < 0 || ny >= n || nx >= m) {
                            continue;
                        }
                        if(a[ny][nx] == 0) {
                            cnt++;
                        }
                    }
                    temp[i][j] = cnt;
                }
            }

            // 빙하 녹이기
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    a[i][j] = Math.max(0, a[i][j] - temp[i][j]);
                }
            }

            // 시간 증가
            ret++;

            // 빙하의 수 세기
            Queue<Pair> q = new LinkedList<>();
            int[][] visited = new int[n][m];
            int cnt = 0; // 빙하 덩어리수

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(a[i][j] != 0 && visited[i][j] == 0) {
                        q.add(new Pair(i, j));
                        visited[i][j] = 1;
                        cnt++;

                        while(!q.isEmpty()) {
                            Pair p = q.poll();
                            int y = p.y;
                            int x = p.x;
                            for(int k = 0; k < 4; k++) {
                                int ny = y + dy[k];
                                int nx = x + dx[k];
                                if(ny < 0 || nx < 0 || ny >= n || nx >= m) {
                                    continue;
                                }
                                if(a[ny][nx] != 0 && visited[ny][nx] == 0) {
                                    q.add(new Pair(ny, nx));
                                    visited[ny][nx] = visited[y][x] + 1;
                                }
                            }
                        }
                    }
                }
            }

            if(cnt == 0) {
                System.out.println(0);
                return;
            }
            else if(cnt >= 2) {
                System.out.println(ret);
                return;
            }

        }


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

