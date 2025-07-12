package graph;

import java.util.*;
import java.io.*;

public class BOJ2667 {

    static int n;
    static int[][] a = new int[28][28];
    static int[][] visited = new int[28][28];
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            String s = sc.next();
            for(int j = 0; j < n; j++) {
                a[i][j] = s.charAt(j) - '0';
            }
        }

        List<Integer> ret = new ArrayList<>();
        int cnt = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(visited[i][j] == 0 && a[i][j] == 1) {
                    cnt++;
                    ret.add(dfs(i, j));
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
        visited[y][x] = 1;
        int cnt = 1;

        for(int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny < 0 || nx < 0 || ny >= n || nx >= n) {
                continue;
            }
            if(visited[ny][nx] == 0 && a[ny][nx] == 1) {
                cnt += dfs(ny, nx);
            }
        }
        return cnt;
    }
}
