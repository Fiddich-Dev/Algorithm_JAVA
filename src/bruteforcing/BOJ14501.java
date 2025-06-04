package bruteforcing;

import java.util.*;
import java.io.*;

public class BOJ14501 {

    static int n;
    static int[] a = new int[18];
    static int[] b = new int[18];
    static int ret = Integer.MIN_VALUE;
    static int[] dp = new int[18];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            a[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < 18; i++) {
            dp[i] = -1;
        }

        System.out.println(go(0));



//        for(int i = 0; i < n; i++) {
//            // 일은 안할때
//            dp[i+1] = Math.max(dp[i+1], dp[i]);
//
//            // 일을 할 수 있으면
//            if(i + a[i] <= n) {
//                dp[i + a[i]] = Math.max(dp[i + a[i]], dp[i] + b[i]);
//            }
//        }
//
//        System.out.println(dp[n]);
    }


    static int go(int num) {
        if(num >= n) {
            return 0;
        }

        if(dp[num] != -1) {
            return dp[num];
        }

        int temp = -1;


        // 일을 할때
        if(num + a[num] <= n) {
            temp = Math.max(temp, go(num + a[num]) + b[num]);
        }

        // 일을 안할때
        temp = Math.max(temp, go(num + 1));

        return dp[num] = temp;



    }

}
// 테이블 : dp[n] = n일까지 일했을때 가장 높은 수익
// 점화식 : dp[n] = max(
