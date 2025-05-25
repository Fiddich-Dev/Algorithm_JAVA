package week7;

import java.util.*;

public class BOJ1932 {
    static int n;
    static int[][] a = new int[504][504];
    static int[][] dp = new int[504][504];


    static int go(int depth, int idx) {
        if(depth == n-1) {
            return a[depth][idx];
        }

        if(dp[depth][idx] != -1) {
            return dp[depth][idx];
        }

        return dp[depth][idx] = Math.max(go(depth+1, idx), go(depth+1, idx+1)) + a[depth][idx];  

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for(int i = 0; i < 504; i++) {
            for(int j = 0; j < 504; j++) {
                dp[i][j] = -1;
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < i+1; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        System.out.println(go(0, 0));

    }
}

// 테이블  dp[n][idx] = 지금까지 지나온 수들의 합
// 점화식  dp[n][idx] = max(dp[n-1][idx-1], dp[n-1][idx]) + a[n][idx]  
// 초기화  dp[0][0] = a[0][0]
