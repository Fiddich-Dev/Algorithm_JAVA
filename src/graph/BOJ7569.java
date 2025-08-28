package graph;

import java.util.*;
import java.io.*;

public class BOJ7569 {

    static int m, n, h;
    static int[][][] a = new int[104][104][104];
    static int[][][] visited = new int[104][104][104];
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int[] dy = {-1, 0, 1, 0, 0, 0};
    static int[] dx = {0, 1, 0, -1, 0, 0};

    // 1 : 익은 토마토, 0 : 안익은 토마토 -1 : 빈칸
    // 익은 토마토 근처는 익는다
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        h = sc.nextInt();

        Queue<Status> q = new LinkedList<>();

        for(int i = 0; i < h; i++) {
            for(int j = 0; j < n; j++) {
                for(int k = 0; k < m; k++) {
                    a[i][j][k] = sc.nextInt();
                    if(a[i][j][k] == 1) {
                        q.add(new Status(i, j, k));
                    }
                }
            }
        }

        int ret = 0;

        while(true) {

            Queue<Status> q_temp = new LinkedList<>();

            while (!q.isEmpty()) {
                Status now = q.poll();
                visited[now.z][now.y][now.x] = 1;

                for (int i = 0; i < 6; i++) {
                    int nz = now.z + dz[i];
                    int ny = now.y + dy[i];
                    int nx = now.x + dx[i];

                    if (nz < 0 || ny < 0 || nx < 0 || nz >= h || ny >= n || nx >= m) {
                        continue;
                    }
                    // 안익은거 만났을때
                    if (visited[nz][ny][nx] == 0 && a[nz][ny][nx] == 0) {
                        q_temp.add(new Status(nz, ny, nx));
                        visited[nz][ny][nx] = 1;
                    }

                }
            }



            if(q_temp.isEmpty()) {
                break;
            }

            ret++;
            q = q_temp; //익게하기

        }

        for(int i = 0; i < h; i++) {
            for(int j = 0; j < n; j++) {
                for(int k = 0; k < m; k++) {
                    if(visited[i][j][k] == 0 && a[i][j][k] == 0) {
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }

        System.out.println(ret);
    }

    static class Status {

        int z;
        int y;
        int x;

        Status(int z, int y, int x) {
            this.z = z;
            this.y = y;
            this.x = x;
        }
    }
}
