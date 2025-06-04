package graph;

import java.util.*;
import java.io.*;

public class BOJ2667 {

    static int n;
    static int[][] a = new int[28][28];
    static int[][] visited = new int[28][28];
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            String s = br.readLine();
            for(int j = 0; j < n; j++) {
                a[i][j] = s.charAt(j) - '0';
            }
        }

        int cnt = 0;
        List<Integer> ret = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(visited[i][j] == 0 && a[i][j] == 1) {
                    ret.add(dfs(i, j));
                    cnt++;
                }
            }
        }

        Collections.sort(ret);

        System.out.println(cnt);

        for(int i : ret) {
            System.out.println(i);
        }

    }

    static int dfs(int y, int x) {
//        System.out.println("dfs");
        visited[y][x] = 1;
        int num = 1;

        for(int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny < 0 || nx < 0 || ny >= n || nx >= n) {
                continue;
            }
            if(visited[ny][nx] == 0 && a[ny][nx] == 1) {
                num += dfs(ny, nx);
            }
        }
        return num;
    }
}
