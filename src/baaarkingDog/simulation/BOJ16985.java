package baaarkingDog.simulation;

import java.util.*;
import java.io.*;

public class BOJ16985 {

    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int[] dy = {-1, 0, 1, 0, 0, 0};
    static int[] dx = {0, 1, 0, -1, 0, 0};
    static int[][][] map = new int[5][5][5];
    static int[][][] a = new int[5][5][5];
    static int[] visited = new int[5];
    static int[][][] dist = new int[5][5][5];
    static int ret = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                st = new StringTokenizer(br.readLine());
                for(int k = 0; k < 5; k++) {
                    a[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }

        solve1(0);

        if(ret == Integer.MAX_VALUE) {
            System.out.println(-1);
        }
        else {
            System.out.println(ret);
        }

    }

    static void bfs(int z, int y, int x) {
        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(z, y, x));
        dist[z][y][x] = 1;

        while(!q.isEmpty()) {
            Pos p = q.poll();

            for(int i = 0; i < 6; i++) {
                int nz = p.z + dz[i];
                int ny = p.y + dy[i];
                int nx = p.x + dx[i];

                if(nz < 0 || ny < 0 || nx < 0 || nz >= 5 || ny >= 5 || nx >= 5) {
                    continue;
                }
                if(a[nz][ny][nx] == 1 && dist[nz][ny][nx] == 0) {
                    dist[nz][ny][nx] = dist[p.z][p.y][p.x] + 1;
                    q.add(new Pos(nz, ny, nx));
                }
            }
        }
    }

    static void next_permutation(int depth) {
        if(depth == 5) {
            // 탐색
            for(int i = 0; i < 2; i++) {
                for(int j = 0; j < 2; j++) {
//                    for(int k = 0; k < 2; k++) {
                    dist = new int[5][5][5];
                    int sz = i*4;
                    int sy = j*4;
                    int sx = 0;

                    int ez = (i^1) * 4;
                    int ey = (j^1) * 4;
                    int ex = 4;

                    if(a[sz][sy][sx] == 1) {
                        bfs(sz, sy, sx);
                        if(dist[ez][ey][ex] != 0) {
                            ret = Math.min(ret, dist[ez][ey][ex]-1);
                        }
                    }
//                    }
                }
            }
            return;
        }
        for(int i = depth; i < 5; i++) {
            swap(depth, i);
            next_permutation(depth+1);
            swap(depth, i);
        }
    }

    static void swap(int q, int w) {
        int temp[][] = new int[5][5];
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                temp[i][j] = a[q][i][j];
            }
        }

        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                a[q][i][j] = a[w][i][j];
            }
        }

        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                a[w][i][j] = temp[i][j];
            }
        }
    }


    static void solve1(int num) {
        if(num == 5) { // 돌리기는 끝
            // 배치
            next_permutation(0);
            return;
        }

        for(int i = 0; i < 4; i++) {
            roll(num);
            solve1(num+1);
        }
    }

    static void roll(int num) {
        int[][] temp = new int[5][5];
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                temp[i][j] = a[num][i][j];
            }
        }

        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                a[num][i][j] = temp[5-j-1][i];
            }
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

// 맵 고르기 : 1024 * 5!
// 입구 고르기 : 8
// 탐색 : 5 * 5 * 5