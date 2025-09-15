package baaarkingDog.bfs;

import java.util.*;

public class BOJ10026 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[][] a = new char[n][n];
        int[][] visited = new int[n][n];
        int[] dy = {-1, 0, 1, 0};
        int[] dx = {0, 1, 0, -1};

        for(int i = 0; i < n; i++) {
            String s = sc.next();
            for(int j = 0; j < n; j++) {
                a[i][j] = s.charAt(j);
            }
        }

        Queue<Pair> q = new LinkedList<>();

        int ret1 = 0;
        int ret2 = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(visited[i][j] == 0) {
                    q.add(new Pair(i, j));
                    ret1++;
                    visited[i][j] = 1;
                    char now = a[i][j];

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
                            if(a[ny][nx] == now && visited[ny][nx] == 0) {
                                q.add(new Pair(ny, nx));
                                visited[ny][nx] = visited[y][x] + 1;
                            }

                        }
                    }
                }
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(a[i][j] == 'R') {
                    a[i][j] = 'G';
                }
            }
        }

        visited = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(visited[i][j] == 0) {
                    q.add(new Pair(i, j));
                    ret2++;
                    visited[i][j] = 1;
                    char now = a[i][j];

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
                            if(a[ny][nx] == now && visited[ny][nx] == 0) {
                                q.add(new Pair(ny, nx));
                                visited[ny][nx] = visited[y][x] + 1;
                            }

                        }
                    }
                }
            }
        }

        System.out.println(ret1 + " "  + ret2);
//        System.out.println(ret2);
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
