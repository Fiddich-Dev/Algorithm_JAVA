package dp;

import java.util.*;

public class BOJ2293 {

    static int n, k;
    static int[] dp = new int[100004];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        dp[0] = 1;
        for(int i = 0; i < n; i++) {
            int temp = sc.nextInt();
            for(int j = temp; j <= k; j++) {
                dp[j] += dp[j-temp];
            }
        }

        for(int i = 0; i <= k; i++) {
            System.out.print(dp[i] + " ");
        }
    }
}

// 테이블 : dp[가치] = 만들수 있는 경우의 수
// 점화식 : dp[num] = dp[num - 1]

