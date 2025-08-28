package dp;

import java.util.*;
import java.io.*;

public class BOJ9251 {

    static String s1;
    static String s2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        s1 = sc.next();
        s2 = sc.next();

        int[][] dp = new int[1004][1004];

        for(int i = 1; i <= s1.length(); i++) {
            for(int j = 1; j <= s2.length(); j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        System.out.println(dp[s1.length()][s2.length()]);

    }
}

// 테이블 : dp[n][m] = s1을 n까지 s2를 m까지 확인했을때 가장긴 부분 수열
// 점화식 : dp[n][m] = s1[n] == s2[m] dp[n-1][m-1] + 1
//                   s1[n] != s2[m] dp[n-1][m] dp[n][m-1]
