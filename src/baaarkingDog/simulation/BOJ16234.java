package baaarkingDog.simulation;

import java.util.*;

public class BOJ16234 {

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = sc.nextInt();
        int r = sc.nextInt();
        int[][] a = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        int ret = 0;

        while(true) {
            int[][] visited = new int[n][n];
            int temp = 0;

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(visited[i][j] == 0) {
                        temp++;
                        List<Pair> city = new ArrayList<>();
                        int cnt = 0;
                        int sum = 0;

                        Queue<Pair> q = new LinkedList<>();
                        q.add(new Pair(i, j));
                        visited[i][j] = 1;

                        while(!q.isEmpty()) {
                            Pair p = q.poll();
                            int y = p.y;
                            int x = p.x;
                            cnt++;
                            sum += a[y][x];
                            city.add(new Pair(y, x));

                            int now = a[y][x];
                            for(int k = 0; k < 4; k++) {
                                int ny = y + dy[k];
                                int nx = x + dx[k];
                                if(ny < 0 || nx < 0 || ny >= n || nx >= n) {
                                    continue;
                                }
                                int next = a[ny][nx];
                                if(visited[ny][nx] == 0 && Math.abs(now - next) >= l && Math.abs(now - next) <= r) {
                                    q.add(new Pair(ny, nx));
                                    visited[ny][nx] = visited[y][x] + 1;
                                }
                            }
                        }

                        for(Pair p : city) {
                            a[p.y][p.x] = sum / cnt;
                        }

                    }
                }
            }

            if(temp == n*n) {
                break;
            }

            ret++;
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
// bfs를 돌며 한번 끝날때 마다
