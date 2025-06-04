package graph;

import java.util.*;
import java.io.*;

public class BOJ7569 {

    static int n, m, h;
    static int[][][] a = new int[104][104][104];
    static int[][][] visited = new int[104][104][104];
    static int[] dy = {-1, 0, 1, 0, 0, 0};
    static int[] dx = {0, 1, 0, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        List<Pos> arr = new ArrayList<>();


        for(int i = 0; i < h; i++) {
            for(int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for(int k = 0; k < m; k++) {
                    a[i][j][k] = Integer.parseInt(st.nextToken());

                    if(a[i][j][k] == 1) {
                        arr.add(new Pos(j, k, i));
                    }

                }
            }
        }


        Queue<Pos> q = new LinkedList<>();

        for(Pos p : arr) {
            q.add(p);
            visited[p.z][p.y][p.x] = 1;
        }

        int ret = 0;

        while(true) {
            Queue<Pos> q_temp = new LinkedList<>();


            while(!q.isEmpty()) {
                Pos now = q.poll();
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
                    // 익은 토마토
                    if(visited[nz][ny][nx] == 0 && a[nz][ny][nx] == 1) {
                        q.add(new Pos(ny, nx, nz));
                        visited[nz][ny][nx] = visited[z][y][x] + 1;
                    }
                    // 안익은 토마토
                    if(visited[nz][ny][nx] == 0 && a[nz][ny][nx] == 0) {
                        q_temp.add(new Pos(ny, nx, nz));
                        visited[nz][ny][nx] = visited[z][y][x] + 1;
                    }

                }
            }




            if(q_temp.isEmpty()) {
                break;
            }

            q = q_temp;
            ret++;

        }

        // a가 0인데 visited가 0인게 있으면 -1
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

        System.out.println(ret);

    }



    static class Pos {
        int y;
        int x;
        int z;

        public Pos(int y, int x, int z) {
            this.y = y;
            this.x = x;
            this.z = z;
        }
    }
}
