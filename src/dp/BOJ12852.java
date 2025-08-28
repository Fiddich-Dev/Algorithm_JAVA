package dp;

import java.util.*;

public class BOJ12852 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[1000004];
        int[] prev = new int[1000004];

        dp[1] = 0;


        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + 1;
            prev[i] = i-1;
            if(i % 2 == 0) {
                if(dp[i] > dp[i/2] + 1) {
                    dp[i] = dp[i/2] + 1;
                    prev[i] = i/2;
                }
            }
            if(i % 3 == 0) {
                if(dp[i] > dp[i/3] + 1) {
                    dp[i] = dp[i/3] + 1;
                    prev[i] = i/3;
                }
            }
        }

        System.out.println(dp[n]);

        while(true) {
            System.out.print(n + " ");
            if(n == 1) {
                break;
            }
            n = prev[n];
        }

    }
}
