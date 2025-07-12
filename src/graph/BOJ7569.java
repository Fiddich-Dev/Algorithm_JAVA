package graph;

import java.util.*;
import java.io.*;

public class BOJ7569 {

    static int m, n, h;
    static int[][][] a = new int[104][104][104];
    static int[][][] visited = new int[104][104][104];

    static int[] dy = {-1, 0, 1, 0, 0, 0};
    static int[] dx = {0, 1, 0, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};

    static List<Status> start = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        h = sc.nextInt();


        for(int i = 0; i < h; i++) {
            for(int j = 0; j < n; j++) {
                for(int k = 0; k < m; k++) {
                    a[i][j][k] = sc.nextInt();
                    if(a[i][j][k] == 1) {
                        start.add(new Status(i, j, k));
                    }
                }
            }
        }

        Queue<Status> q = new LinkedList<>();

        for(Status s : start) {
            visited[s.z][s.y][s.x] = 1;
            q.add(s);
        }

        int cnt = 0;

        while(true) {


            Queue<Status> q_temp = new LinkedList<>();

            while(!q.isEmpty()) {
                Status now = q.poll();
                int y = now.y;
                int x = now.x;
                int z = now.z;

                for(int i = 0; i < 6; i++) {
                    int ny = y + dy[i];
                    int nx = x + dx[i];
                    int nz = z + dz[i];

                    if(ny < 0 || nx < 0 || nz < 0 || ny >= n || nx >= m || nz >= h) {
                        continue;
                    }
//                    if(visited[nz][ny][nx] == 0 && a[nz][ny][nx] == 1) {
//                        visited[nz][ny][nx] = visited[z][y][x] + 1;
//                        q.add(new Status(ny, nx, nz));
//                    }
                    if(visited[nz][ny][nx] == 0 && a[nz][ny][nx] == 0) {
                        visited[nz][ny][nx] = visited[z][y][x] + 1;
                        q_temp.add(new Status(nz, ny, nx));
                    }
                }
            }

            if(q_temp.isEmpty()) {
                break;
            }

            q = q_temp;
            cnt++;
        }

        for(int i = 0; i < h; i++) {
            for(int j = 0; j < n; j++) {
                for(int k = 0; k < m; k++) {
                    if(a[i][j][k] == 0 && visited[i][j][k] == 0) {
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }

        System.out.println(cnt);
    }

    static class Status {
        int z;
        int y;
        int x;

        public Status(int z, int y, int x) {
            this.z = z;
            this.y = y;
            this.x = x;
        }
    }
}
