package baaarkingDog.bfs;

import java.util.*;

public class BOJ5427 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] dy = {-1, 0, 1, 0};
        int[] dx = {0, 1, 0, -1};

        int t = sc.nextInt();
        for(int qq = 0; qq < t; qq++) {
            int m = sc.nextInt();
            int n = sc.nextInt();

            char[][] a = new char[n][m];

            Queue<Pair> q_f = new LinkedList<>();
            Queue<Pair> q_sg = new LinkedList<>();

            int[][] visited_f = new int[n][m];
            int[][] visited_sg = new int[n][m];

            for(int i = 0; i < n; i++) {
                String s = sc.next();
                for(int j = 0; j < m; j++) {
                    a[i][j] = s.charAt(j);
                    if(a[i][j] == '@') {
                        q_sg.add(new Pair(i, j));
                        visited_sg[i][j] = 1;
                        a[i][j] = '.';
                    }
                    else if(a[i][j] == '*') {
                        q_f.add(new Pair(i, j));
                        visited_f[i][j] = 1;
                        a[i][j] = '.';
                    }
                }
            }

            // 상근이 탐색
            while(!q_sg.isEmpty()) {
                Pair p = q_sg.poll();
                int y = p.y;
                int x = p.x;

                for(int i = 0; i < 4; i++) {
                    int ny = y + dy[i];
                    int nx = x + dx[i];

                    if(ny < 0 || nx < 0 || ny >= n || nx >= m) {
                        continue;
                    }
                    if(a[ny][nx] == '.' && visited_sg[ny][nx] == 0) {
                        q_sg.add(new Pair(ny, nx));
                        visited_sg[ny][nx] = visited_sg[y][x] + 1;
                    }
                }
            }

            // 불 탐색
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
                    if(a[ny][nx] == '.' && visited_f[ny][nx] == 0) {
                        q_f.add(new Pair(ny, nx));
                        visited_f[ny][nx] = visited_f[y][x] + 1;
                    }
                }
            }

            int ret = Integer.MAX_VALUE;

            for(int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(i == 0 || i == n-1 || j == 0 || j == m-1) {
                        // 상근이가 갈수 있을때
                        if(visited_sg[i][j] != 0) {
                            // 불이 안올때
                            if(visited_f[i][j] == 0) {
                                ret = Math.min(ret, visited_sg[i][j]);
                            }
                            // 불보다 빠를때
                            else if(visited_sg[i][j] < visited_f[i][j]) {
                                ret = Math.min(ret, visited_sg[i][j]);
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

//'.': 빈 공간
//'#': 벽
//'@': 상근이의 시작 위치
//'*': 불