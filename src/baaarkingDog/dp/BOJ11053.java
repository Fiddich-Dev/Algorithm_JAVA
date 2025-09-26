package baaarkingDog.dp;

import java.util.*;

public class BOJ11053 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int ret = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(a[i] > a[j]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            ret = Math.max(ret, dp[i]);
        }

        System.out.println(ret);
    }
}
