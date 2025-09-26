package baaarkingDog.dp;

import java.util.*;

public class BOJ12852 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[1000004];
        int[] prev = new int[1000004];
        Arrays.fill(dp, Integer.MAX_VALUE);
        Arrays.fill(prev, -1);
        dp[1] = 0;

        for(int i = 1; i <= n; i++) {
            if(i+1 <= 1000000) {
                if(dp[i]+1 < dp[i+1]) {
                    dp[i+1] = dp[i] + 1;
                    prev[i+1] = i;
                }
            }
            if(i*2 <= 1000000) {
                if(dp[i]+1 < dp[i*2]) {
                    dp[i*2] = dp[i] + 1;
                    prev[i*2] = i;
                }
            }
            if(i*3 <= 1000000) {
                if(dp[i]+1 < dp[i*3]) {
                    dp[i*3] = dp[i] + 1;
                    prev[i*3] = i;
                }
            }
        }

        System.out.println(dp[n]);
        System.out.print(n + " ");
        while(prev[n] != -1) {
            System.out.print(prev[n] + " ");
            n = prev[n];
        }
    }
}
