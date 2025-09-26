package baaarkingDog.dp;

import java.util.*;

public class BOJ15988 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] dp = new int[1000005];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for(int i = 4; i <= 1000004; i++) {
            int a = dp[i-1] % 1000000009;
            int b = dp[i-2] % 1000000009;
            int c = dp[i-3] % 1000000009;
            int temp = ((a + b) % 1000000009);
            temp = (temp + c) % 1000000009;
            dp[i] = temp;
        }

        while(t-- != 0) {
            int n = sc.nextInt();
            System.out.println(dp[n]);
        }
    }
}
