package baaarkingDog.dp;

import java.util.*;

public class BOJ1463 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[1000004];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[1] = 0;

        for(int i = 1; i < 1000004; i++) {
            if(i+1 <= 1000000) {
                dp[i + 1] = Math.min(dp[i + 1], dp[i]+1);
            }
            if(i*2 <= 1000000) {
                dp[i * 2] = Math.min(dp[i * 2], dp[i]+1);
            }
            if(i*3 <= 1000000) {
                dp[i * 3] = Math.min(dp[i * 3], dp[i]+1);
            }
        }

        System.out.println(dp[n]);
    }
}

// 테이블 : dp[num] = 1에서 num 까지 연산의 수
// 점화식 : dp[num] = min(dp[num/3] dp[num/2] dp[num-1]) + 1
