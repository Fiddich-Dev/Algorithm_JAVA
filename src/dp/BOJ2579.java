package dp;

import java.util.*;

public class BOJ2579 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[10004];
        int[] dp = new int[10004];

        int sum = 0;

        for(int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
            sum += a[i];
        }


        dp[1] = a[1];
        dp[2] = a[2];
        dp[3] = a[3];

        for(int i = 4; i <= n; i++) {
            dp[i] = a[i] + Math.min(dp[i-2], dp[i-3]);
        }

        System.out.println(sum - Math.min(dp[n-2], dp[n-1]));

    }
}

// 테이블: dp[n] = n까지 오면서 안밟은 수의 합의 최솟값 단, n번째 계단은 안밟이야함
// 점화식: dp[n] = a[n-1] + min(dp[n-2] + a[n-2], dp[n-3] + a[n-3])
// 전칸까지 밟고 건너뛰기, 전전칸이나 전전전칸 둘중하나 밟기

