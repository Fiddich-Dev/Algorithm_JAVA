package baaarkingDog.bfs;

import java.util.*;

public class BOJ1012 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int qq = 0; qq < t; qq++) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            int k = sc.nextInt();

            int[] dy = {-1, 0, 1, 0};
            int[] dx = {0, 1, 0, -1};

            int[][] a = new int[n][m];
            int[][] visited = new int[n][m];

            Queue<Pair> q = new LinkedList<>();

            for(int i = 0; i < k; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();

                a[y][x] = 1;
            }

            int cnt = 0;

            for(int i= 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(a[i][j] == 1 && visited[i][j] == 0) {
                        q.add(new Pair(i, j));
                        cnt++;
                        while(!q.isEmpty()) {
                            Pair p = q.poll();
                            int y = p.y;
                            int x = p.x;

                            for(int l = 0; l < 4; l++) {
                                int ny = y + dy[l];
                                int nx = x + dx[l];

                                if(ny < 0 || nx < 0 || ny >= n || nx >= m) {
                                    continue;
                                }
                                if(a[ny][nx] == 1 && visited[ny][nx] == 0) {
                                    q.add(new Pair(ny, nx));
                                    visited[ny][nx] = visited[y][x] + 1;
                                }
                            }
                        }
                    }
                }
            }


            System.out.println(cnt);

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
