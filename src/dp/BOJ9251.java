package dp;

import java.util.*;
import java.io.*;

public class BOJ9251 {

    static String s1 = "";
    static String s2 = "";

    static int[][] dp = new int[1004][1004];


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        s1 = sc.next();
        s2 = sc.next();

        for(int i = 0; i < s1.length(); i++) {
            for(int j = 0; j < s2.length(); j++) {
                dp[i][j] = -1;
            }
        }

//        go(s1.length()-1, s2.length()-1)
        System.out.println(go(s1.length()-1, s2.length()-1));

    }



    static int go(int i, int j) {

        if(i == -1 || j == -1) {
            return 0;
        }


        if(dp[i][j] != -1) {
            return dp[i][j];
        }

        if(s1.charAt(i) == s2.charAt(j)) {
            dp[i][j] = go(i-1, j-1) + 1;
        }
        else {
            dp[i][j] = Math.max(go(i-1, j), go(i, j-1));
        }

        return dp[i][j];
    }



}

// 테이블 : dp[i][j] = s1을 i개 확인하고, s2를 j개 확인했을때의 lcs
// 점화식 : if(A[i] == B[j]) dp[i][j] = dp[i-1][j-1] + 1, if(A[i] != B[j]) dp[i][j] = max(dp[i-1][j], dp[i][j-1])
