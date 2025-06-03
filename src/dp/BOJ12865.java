package dp;

import java.util.*;
import java.io.*;

public class BOJ12865 {

    static int n, k;
    static int[] w = new int[104];
    static int[] v = new int[104];
    static int[] dp = new int[100004];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            w[i] = Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < n; i++) {
            for(int j = k; j >= w[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j-w[i]] + v[i]);
            }
        }

        System.out.println(dp[k]);
    }
}

// 테이블 : dp[무게] = 가치
// 점화식 : dp[i] = dp[i-6] + 13
