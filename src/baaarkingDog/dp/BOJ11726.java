package baaarkingDog.dp;

import java.util.*;

public class BOJ11726 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n+1];

        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i <= n; i++) {
            dp[i] = (dp[i-1] % 10007) + (dp[i-2] % 10007);
        }

        System.out.println(dp[n] % 10007);
    }
}

// dp[num] = num 번째까지 채웠을떄 경우의 수
// dp[num] = dp[num-1] + dp[num-2]
// dp[0] = 1 dp[1] = 1
