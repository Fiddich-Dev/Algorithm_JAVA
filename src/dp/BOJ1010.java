package dp;

import java.util.*;
import java.io.*;

public class BOJ1010 {

    static int n, m, cnt;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());

        for(int q = 0; q < t; q++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            n = Math.min(n, m-n);

            long a = 1;
            long b = 1;


            for(int i = 1; i <= n; i++) {
                a *= m;
                m--;
            }
            for(int i = 1; i <= n; i++) {
                b *= i;
            }

            System.out.println(a / b);


        }



    }


}

// 테이블 : dp[a][b] = a개 중에 b개를 고르는 경우의 수
// 점화식 : dp[m][n] = dp[m-1][n-1] + dp[m-1][n];

