package baaarkingDog.bfs;

import java.util.*;

public class BOJ1926 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] a = new int[n][m];
        int[][] visited = new int[n][m];
        int[] dy = {-1, 0, 1, 0};
        int[] dx = {0, 1, 0, -1};

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        int cnt = 0;
        int ret = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(a[i][j] == 1 && visited[i][j] == 0) {
                    cnt++;
                    int w = 0;
                    Queue<Pair> q = new LinkedList<>();
                    visited[i][j] = 1;
                    q.add(new Pair(i, j));

                    while(!q.isEmpty()) {
                        w++;
                        Pair now = q.poll();
                        int y = now.y;
                        int x = now.x;

                        for(int k = 0; k < 4; k++) {
                            int ny = y + dy[k];
                            int nx = x + dx[k];
                            if(ny < 0 || nx < 0 || ny >= n || nx >= m) {
                                continue;
                            }
                            if(a[ny][nx] == 1 && visited[ny][nx] == 0) {
                                visited[ny][nx] = visited[y][x] + 1;
                                q.add(new Pair(ny, nx));
                            }
                        }

                    }

                    ret = Math.max(ret, w);
                }
            }
        }

        System.out.println(cnt);
        System.out.println(ret);

    }

    static class Pair {
        int y;
        int x;
        Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
