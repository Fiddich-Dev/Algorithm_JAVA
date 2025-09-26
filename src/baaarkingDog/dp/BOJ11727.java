package baaarkingDog.dp;

import java.util.*;

public class BOJ11727 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n+1];

        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i <= n; i++) {
            dp[i] = ((dp[i-1] % 10007) + (dp[i-2] % 10007)*2) % 10007;
        }

        System.out.println(dp[n] % 10007);


    }
}

// dp[n] = n번쨰까지 타일 채우는 가지숮
// dp[n] = dp[n-1] + dp[n-2]*2
