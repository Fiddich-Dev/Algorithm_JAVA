package baaarkingDog.dp;

import java.util.*;

public class BOJ9095 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] dp = new int[14];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for(int i = 4; i < 14; i++) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }

        int t = sc.nextInt();
        while(t-- != 0) {
            int n = sc.nextInt();
            System.out.println(dp[n]);
        }
    }
}

// 테이블 : dp[num] = num을 1, 2, 3으로 만들수 있는 경우의 수
// 점화식 : dp[num] = dp[num-1] + dp[num-2] + dp[num-3]
