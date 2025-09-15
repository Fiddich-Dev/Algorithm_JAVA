package baaarkingDog.bfs;

import java.util.*;

public class BOJ6593 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] dz = {0, 0, 0, 0, 1, -1};
        int[] dy = {-1, 0, 1, 0, 0, 0};
        int[] dx = {0, 1, 0, -1, 0, 0};

        while(true) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            int c = sc.nextInt();

            if(l == 0 && r == 0 && c == 0) {
                break;
            }

            char[][][] a = new char[l][r][c];
            int[][][] visited = new int[l][r][c];

            Pos s = null;
            Pos e = null;

            for(int i = 0; i < l; i++) {
                for(int j = 0; j < r; j++) {
                    String temp = sc.next();
                    for(int k = 0; k < c; k++) {
                        a[i][j][k] = temp.charAt(k);
                        if(a[i][j][k] == 'S') {
                            s = new Pos(i, j, k);
                            a[i][j][k] = '.';
                        }
                        else if(a[i][j][k] =='E') {
                            e = new Pos(i, j, k);
                            a[i][j][k] = '.';
                        }
                    }
                }
            }

            Queue<Pos> q = new LinkedList<>();
            q.add(s);
            visited[s.z][s.y][s.x] = 1;

            while(!q.isEmpty()) {
                Pos p = q.poll();
                int z = p.z;
                int y = p.y;
                int x = p.x;

                for(int i = 0; i < 6; i++) {
                    int nz = z + dz[i];
                    int ny = y + dy[i];
                    int nx = x + dx[i];
                    if(nz < 0 || ny < 0 || nx < 0 || nz >= l || ny >= r || nx >= c) {
                        continue;
                    }
                    if(a[nz][ny][nx] == '.' && visited[nz][ny][nx] == 0) {
                        q.add(new Pos(nz, ny, nx));
                        visited[nz][ny][nx] = visited[z][y][x] + 1;
                    }
                }
            }

            if(visited[e.z][e.y][e.x] == 0) {
                System.out.println("Trapped!");
            }
            else {
                System.out.println("Escaped in " + (visited[e.z][e.y][e.x]-1) + " minute(s).");
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
