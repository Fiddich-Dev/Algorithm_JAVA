package baaarkingDog.bfs;

import java.util.*;

public class BOJ4179 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char[][] a = new char[n][m];
        int[][] visited_j = new int[n][m];
        int[][] visited_f = new int[n][m];
        int[] dy = {-1, 0, 1, 0};
        int[] dx = {0, 1, 0, -1};

        Queue<Pair> q_j = new LinkedList<>();
        Queue<Pair> q_f = new LinkedList<>();

        for(int i = 0; i < n; i++) {
            String s = sc.next();
            for(int j = 0; j < m; j++) {
                a[i][j] = s.charAt(j);

                if(a[i][j] == 'J') {
                    q_j.add(new Pair(i, j));
                    visited_j[i][j] = 1;
                }
                else if(a[i][j] == 'F') {
                    q_f.add(new Pair(i, j));
                    visited_f[i][j] = 1;
                }
            }
        }

        while(!q_j.isEmpty()) {
            Pair p = q_j.poll();
            int y = p.y;
            int x = p.x;
            for(int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if(ny < 0 || nx < 0 || ny >= n || nx >= m) {
                    continue;
                }
                if(a[ny][nx] != '#' && visited_j[ny][nx] == 0) {
                    visited_j[ny][nx] = visited_j[y][x] + 1;
                    q_j.add(new Pair(ny, nx));
                }
            }
        }

        while(!q_f.isEmpty()) {
            Pair p = q_f.poll();
            int y = p.y;
            int x = p.x;
            for(int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if(ny < 0 || nx < 0 || ny >= n || nx >= m) {
                    continue;
                }
                if(a[ny][nx] != '#' && visited_f[ny][nx] == 0) {
                    visited_f[ny][nx] = visited_f[y][x] + 1;
                    q_f.add(new Pair(ny, nx));
                }
            }
        }

        int ret = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(i == 0 || i == n-1 || j == 0 || j == m-1) {
                    // 지훈이 갈수있을때
                    if(visited_j[i][j] != 0) {
                        // 지훈이가 불보다 빠를때
                        if(visited_j[i][j] < visited_f[i][j]) {
                            ret = Math.min(ret, visited_j[i][j]);
                        }
                        // 불이 안올때
                        if(visited_f[i][j] == 0) {
                            ret = Math.min(ret, visited_j[i][j]);
                        }
                    }
                }
            }
        }

        if(ret == Integer.MAX_VALUE) {
            System.out.println("IMPOSSIBLE");
        }
        else {
            System.out.println(ret);
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
