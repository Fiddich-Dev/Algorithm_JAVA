package dp;

import java.util.*;
import java.io.*;

public class BOJ9251 {

    static int[][] dp = new int[1004][1004];
    static int n, m;
    static String s1 = "";
    static String s2 = "";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        s1 = st.nextToken();
        n = s1.length();
        st = new StringTokenizer(br.readLine());
        s2 = st.nextToken();
        m = s2.length();

        for(int i = 0; i < 1004; i++) {
            for(int j = 0; j < 1004; j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println(go(n-1, m-1));

    }

    static int go(int i, int j) {

        if(i == -1 || j == -1) {
            return 0;
        }

        if(dp[i][j] != -1) {
            return dp[i][j];
        }

        if(s1.charAt(i) == s2.charAt(j)) {
            return dp[i][j] = go(i-1, j-1) + 1;
        }
        else {
            return dp[i][j] = Math.max(go(i-1, j), go(i, j-1));
        }
    }


}

// 테이블 : dp[i][j] = s1을 i개 확인하고, s2를 j개 확인했을때의 lcs
// 점화식 : if(A[i] == B[j]) dp[i][j] = dp[i-1][j-1] + 1, if(A[i] != B[j]) dp[i][j] = max(dp[i-1][j], dp[i][j-1])
