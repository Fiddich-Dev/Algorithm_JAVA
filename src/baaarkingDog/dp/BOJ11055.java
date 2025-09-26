package baaarkingDog.dp;

import java.util.*;

public class BOJ11055 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int[] dp = new int[n+1];
        for(int i = 0; i < n; i++) {
            dp[i] = a[i];
        }

        int ret = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(a[i] > a[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + a[i]);

                }
            }
            ret = Math.max(ret, dp[i]);
        }

//        for(int i = 0; i < n; i++) {
//            System.out.print(dp[i] + " ");
//        }
//        System.out.println();

        System.out.println(ret);

    }
}

// dp[a][b] = a번째까지 확인했을떄 b로 포함했는지 안했는지 확인
