package baaarkingDog.dp;

import java.util.*;

public class BOJ1788 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] dp = new int[1000004];
        dp[0] = 0;
        dp[1] = 1;

        for(int i = 2; i <= 1000000; i++) {
            dp[i] = ((dp[i-1] % 1000000000) + (dp[i-2] % 1000000000)) % 1000000000;
        }

        if(n == 0) {
            System.out.println(0);
        }
        else if(n < 0 && Math.abs(n) % 2 == 0) {
            System.out.println(-1);
        }
        else {
            System.out.println(1);
        }

        System.out.println(dp[Math.abs(n)]);



    }
}
