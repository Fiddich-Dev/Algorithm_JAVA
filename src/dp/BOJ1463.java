package dp;

import java.util.*;
import java.io.*;

public class BOJ1463 {

    static int[] dp = new int[1000004];

    public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        Arrays.fill(dp, -1);
//        dp[1] = 0;
        go(n);

        System.out.println(dp[n]);
    }

    static int go(int num) {

        if(num == 1) {
            return 0;
        }

        if(dp[num] != -1) {
            return dp[num];
        }

        int next = Integer.MAX_VALUE;
        next = Math.min(next, go(num-1) + 1);
        if(num % 2 == 0) {
            next = Math.min(next, go(num / 2) + 1);
        }
        if(num % 3 == 0) {
            next = Math.min(next, go(num / 3) + 1);
        }

        return dp[num] = next;
    }
}

// 테이블 : dp[n] = n을 1로 만들기 위한 최소 횟수
// 점화식 : dp[n] = min(dp[2*n], dp[3*n], dp[n+1]) + 1
