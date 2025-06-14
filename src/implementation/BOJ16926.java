package implementation;

import java.util.*;

public class BOJ16926 {

    static int n, m, r;
    static int[][] a = new int[304][304];
    static int[][] visited = new int[304][304];
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        r = sc.nextInt();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        for(int i = 0; i < r; i++) {
            visited = new int[304][304];
            for(int j = 0; j < Math.min(n, m) / 2; j++) {
                roll(j, j);
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }

    }

    static void roll(int y, int x) {
        int startY = y;
        int startX = x;
        int dir = 0;



        visited[y][x] = 1;
        int temp;
        int prev = a[y][x];

        while(true) {
            int ny = y + dy[dir];
            int nx = x + dx[dir];

            if(ny < 0 || nx < 0 || ny >= n || nx >= m || visited[ny][nx] != 0) {
                dir = (dir + 1) % 4;
                ny = y + dy[dir];
                nx = x + dx[dir];
            }
            temp = a[ny][nx];
            a[ny][nx] = prev;
            prev = temp;
            visited[ny][nx] = 1;

            if(ny == startY && nx == startX) {
                break;
            }
            y = ny;
            x = nx;

        }


    }
}
// 한번 회전할때 도는 배열의 수 min(n, m) / 2