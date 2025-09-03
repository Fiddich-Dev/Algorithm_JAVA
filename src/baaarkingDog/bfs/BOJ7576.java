package baaarkingDog.bfs;

import java.util.*;

public class BOJ7576 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] a = new int[n][m];
        int[][] visited = new int[n][m];
        int[] dy = {-1, 0, 1, 0};
        int[] dx = {0, 1, 0 , -1};

        Queue<Pair> q = new LinkedList<>();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();

                if(a[i][j] == 1) {
                    q.add(new Pair(i, j));
                    visited[i][j] = 1;
                }
            }
        }

        int ret = 1;

        while(!q.isEmpty()) {
            Pair now = q.poll();
            int y = now.y;
            int x = now.x;

            for(int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if(ny < 0 || nx < 0 || ny >= n || nx >= m) {
                    continue;
                }
                if(a[ny][nx] == 0 && visited[ny][nx] == 0) {
                    visited[ny][nx] = visited[y][x] + 1;
                    ret = Math.max(ret, visited[ny][nx]);
                    q.add(new Pair(ny, nx));
                }
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(a[i][j] == 0 && visited[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(ret - 1);

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

//정수 1은 익은 토마토, 정수 0은 익지 않은 토마토, 정수 -1은 토마토가 들어있지 않은 칸
