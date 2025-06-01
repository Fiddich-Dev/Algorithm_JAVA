package dp;

import java.util.*;
import java.io.*;

public class BOJ1535 {

    static int[] los = new int[24];
    static int[] add = new int[24];
    static int[][] dp = new int[24][104];
    static int n = 0;

    static int[] dp2 = new int[104];

    static int go(int now, int hp) {


        if(dp[now][hp] != -1) {
            return dp[now][hp];
        }

        // 인사 안할때
        int ret = go(now+1, hp);

        // 안사 할때
        if(hp > los[now]) {
            ret = Math.max(ret, go(now+1, hp - los[now]) + add[now]);
        }

        return dp[now][hp] = ret;
    }

//    public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
//        n = sc.nextInt();
//        for(int i = 0; i < n; i++) {
//            los[i] = sc.nextInt();
//        }
//        for(int i = 0; i < n; i++) {
//            add[i] = sc.nextInt();
//        }
//
//        for(int i = 0; i < n; i++) {
//            for(int j = 0; j < 104; j++) {
//                dp[i][j] = -1;
//            }
//        }
//
//        System.out.println(go(0, 100));
//    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            los[i] = sc.nextInt();
        }
        for(int i = 0; i < n; i++) {
            add[i] = sc.nextInt();
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < 104; j++) {
                dp[i][j] = -1;
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 100; j > los[i]; j--) {
                dp2[j] = Math.max(dp2[j], dp2[j-los[i]] + add[i]);
            }
        }

        System.out.println(dp2[100]);
    }
}

// 테이블 : dp[체력] = 얻을 수 있는 최대 기쁨
// 점화식 : dp[n] = max(dp[n-1] + 20, dp[n-21] + 30, dp[n-79] + 25)
