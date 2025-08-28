package implementation;

import java.util.*;
import java.io.*;

public class BOJ16926 {

    static int n, m, r;
    static int[][] a = new int[304][304];
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        roll();


        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                sb.append(a[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    static void roll() {
        int[][] visited = new int[304][304];
        int[][] visited2 = new int[304][304];

        for(int i = 0; i < Math.min(n, m) / 2; i++) {
            int y = i;
            int x = i;
            int dir = 1;

            List<Integer> arr = new ArrayList<>();
            arr.add(a[y][x]);
            visited[y][x] = 1;

            while(true) {

                int ny = y + dy[dir];
                int nx = x + dx[dir];

                if(ny < 0 || nx < 0 || ny >= n || nx >= m) {
                    dir = (dir + 1) % 4;
                    continue;
                }
                if(ny == i && nx == i) {
                    break;
                }
                if(visited[ny][nx] == 1) {
                    dir = (dir + 1) % 4;
                    continue;
                }

                arr.add(a[ny][nx]);
                visited[ny][nx] = 1;

                y = ny;
                x = nx;



            }

            Collections.rotate(arr, -1 * r);


            y = i;
            x = i;
            dir = 1;
            int now = 0;

            a[y][x] = arr.get(now);
            visited2[y][x] = 1;
            now++;

            while(true) {
                int ny = y + dy[dir];
                int nx = x + dx[dir];

                if(ny < 0 || nx < 0 || ny >= n || nx >= m) {
                    dir = (dir + 1) % 4;
                    continue;
                }
                if(ny == i && nx == i) {
                    break;
                }
                if(visited2[ny][nx] == 1) {
                    dir = (dir + 1) % 4;
                    continue;
                }

                visited2[ny][nx] = 1;
                a[ny][nx] = arr.get(now);
                now++;

                y = ny;
                x = nx;

            }


        }
    }
}

