package baaarkingDog.bfs;

import java.util.*;

public class BOJ2667 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a = new int[n][n];
        int[][] visited = new int[n][n];
        int[] dy = {-1, 0, 1, 0};
        int[] dx = {0, 1, 0, -1};

        for(int i = 0; i < n; i++) {
            String s = sc.next();
            for(int j = 0; j < n; j++) {
                a[i][j] = s.charAt(j) - '0';
            }
        }

        Queue<Pair> q = new LinkedList<>();

        int cnt = 0;
        List<Integer> ret = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(a[i][j] == 1 && visited[i][j] == 0) {
                    q.add(new Pair(i, j));
                    visited[i][j] = 1;
                    cnt++;

                    int now = 0;

                    while(!q.isEmpty()) {
                        Pair p = q.poll();
                        now++;
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
                                visited[ny][nx] = visited[y][x] + 1;
                            }
                        }
                    }

                    ret.add(now);
                }
            }
        }

        System.out.println(cnt);
        Collections.sort(ret);
        for(int i : ret) {
            System.out.println(i);
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
