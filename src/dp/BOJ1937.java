package dp;

import java.util.*;

public class BOJ1937 {

    static int n;
    static int[][] a = new int[504][504];
    static int[][] dp = new int[504][504];
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for(int i = 0; i < 504; i++) {
            Arrays.fill(dp[i], -1);
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        int ret = 1;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                ret = Math.max(ret, go(i, j));
            }
        }

        System.out.println(ret);

    }

    static int go(int y, int x) {

        if(dp[y][x] != -1) {
            return dp[y][x];
        }

        int now = a[y][x];

        int mx = 0;

        for(int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny < 0 || nx < 0 || ny >= n || nx >= n) {
                continue;
            }

            if(a[ny][nx] > now) {
                mx = Math.max(mx, go(ny, nx));
            }
        }

        return dp[y][x] = mx + 1;

    }
}
// 테이블 : dp[n][m] = n, m에서 출발했을때 이동할 수 있는 칸의 최댓값
// 점화식 : dp[n][m] = 갈수있는 곳의 dp값 + 1
