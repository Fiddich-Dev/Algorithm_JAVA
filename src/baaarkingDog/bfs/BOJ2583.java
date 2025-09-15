package baaarkingDog.bfs;

import java.util.*;

public class BOJ2583 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        int[][] a = new int[n][m];
        int[][] visited = new int[n][m];
        int[] dy = {-1, 0, 1, 0};
        int[] dx = {0, 1, 0, -1};

        for(int i = 0; i < k; i++) {
            int sx = sc.nextInt();
            int sy = sc.nextInt();
            int ex = sc.nextInt();
            int ey = sc.nextInt();

            for(int j = sy; j < ey; j++) {
                for(int l = sx; l < ex; l++) {
                    a[j][l] = 1;
                }
            }
        }

        Queue<Pair> q = new LinkedList<>();

        int cnt = 0;
        List<Integer> ret = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(a[i][j] == 0 && visited[i][j] == 0) {
                    q.add(new Pair(i, j));
                    visited[i][j] = 1;
                    cnt++;

                    int now = 0;

                    while(!q.isEmpty()) {
                        Pair p = q.poll();
                        now++;
                        int y = p.y;
                        int x = p.x;

                        for(int l = 0; l < 4; l++) {
                            int ny = y + dy[l];
                            int nx = x + dx[l];
                            if(ny < 0 || nx < 0 || ny >= n || nx >= m) {
                                continue;
                            }
                            if(a[ny][nx] == 0 && visited[ny][nx] == 0) {
                                visited[ny][nx] = visited[y][x] + 1;
                                q.add(new Pair(ny, nx));
                            }
                        }
                    }

                    ret.add(now);
                }
            }
        }

        Collections.sort(ret);

        System.out.println(cnt);
        for(int i : ret) {
            System.out.print(i + " ");
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
