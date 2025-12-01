package saffy;

import java.util.*;

public class SWEA1954 {

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for(int t = 1; t <= test; t++) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            int[][] visited = new int[n][n];

            int y = 0;
            int x = 0;
            int dir = 1;
            for(int i = 0; i < n*n; i++) {
                a[y][x] = i+1;
                visited[y][x] = 1;

                int ny = y + dy[dir];
                int nx = x + dx[dir];
                if(ny < 0 || nx < 0 || ny >= n || nx >= n || visited[ny][nx] == 1) {
                    dir = (dir + 1) % 4;
                    ny = y + dy[dir];
                    nx = x + dx[dir];
                }
                y = ny;
                x = nx;
            }

            System.out.println("#" + t);
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    System.out.print(a[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
