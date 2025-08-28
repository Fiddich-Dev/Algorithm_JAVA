package dp;

import java.util.*;

public class BOJ1915 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] a = new int[n][m];

        int[][] dp = new int[1004][1004];

        for(int i = 0; i < n; i++) {
            String s = sc.next();
            for(int j = 0; j < m; j++) {
                a[i][j] = s.charAt(j) - '0';
            }
        }

        int ret = 0;

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(a[i-1][j-1] == 1) {
                    int temp = dp[i-1][j-1];
                    temp = Math.min(temp, dp[i-1][j]);
                    temp = Math.min(temp, dp[i][j-1]);

                    dp[i][j] = temp + 1;

                    ret = Math.max(ret, dp[i][j]);
                }
            }
        }
        System.out.println(ret * ret);


    }
}

// 테이블 : dp[n][m] = n,m의 가장큰 정사각형의 크기
