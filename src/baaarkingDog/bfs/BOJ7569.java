package baaarkingDog.bfs;

import java.util.*;

public class BOJ7569 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int h = sc.nextInt();

        int[][][] a = new int[h][n][m];
        int[][][] visited = new int[h][n][m];
        int[] dy = {-1, 0, 1, 0, 0, 0};
        int[] dx = {0, 1, 0, -1, 0, 0};
        int[] dz = {0, 0, 0, 0, 1, -1};

        Queue<Pos> q = new LinkedList<>();

        int appleCnt = 0;

        for(int i = 0; i < h; i++) {
            for(int j = 0; j < n; j++) {
                for(int k = 0; k < m; k++) {
                    a[i][j][k] = sc.nextInt();
                    if(a[i][j][k] == 1) {
                        q.add(new Pos(i, j, k));
                        visited[i][j][k] = 1;
                    }
                    if(a[i][j][k] == 1 || a[i][j][k] == 0) {
                        appleCnt++;
                    }
                }
            }
        }

        int cnt = 0;
        int ret = 0;

        while(!q.isEmpty()) {
            Pos p = q.poll();
            cnt++;
            int z = p.z;
            int y = p.y;
            int x = p.x;

            for(int i = 0; i < 6; i++) {
                int nz = z + dz[i];
                int ny = y + dy[i];
                int nx = x + dx[i];
                if(nz < 0 || ny < 0 || nx < 0 || nz >= h || ny >= n || nx >= m) {
                    continue;
                }
                if(a[nz][ny][nx] == 0 && visited[nz][ny][nx] == 0) {
                    q.add(new Pos(nz, ny, nx));
                    visited[nz][ny][nx] = visited[z][y][x] + 1;
                    ret = Math.max(ret, visited[nz][ny][nx]);
                }
            }
        }

        if(appleCnt == cnt) {
            System.out.println(Math.max(ret-1, 0));
        }
        else {
            System.out.println(-1);
        }

    }

    static class Pos {
        int z;
        int y;
        int x;

        public Pos(int z, int y, int x) {
            this.z = z;
            this.y = y;
            this.x = x;
        }
    }
}
