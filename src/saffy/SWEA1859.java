package saffy;

import java.util.*;

public class SWEA1859 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int q = 1; q <= t; q++) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for(int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int[] dp = new int[n]; // dp[n] = n부터 끝까지 중 가장 큰 수
            int temp = 0;
            for(int i = n-1; i >= 0; i--) {
                temp = Math.max(temp, a[i]);
                dp[i] = temp;
            }

            long ret = 0;
            for(int i = 0; i < n; i++) {
                ret += dp[i] - a[i];
            }


            System.out.println("#" + q + " " + ret);
        }
    }
}
