package implementation;

import java.util.*;
import java.io.*;

public class BOJ2167 {

    static int n, m;
    static int[][] a = new int[304][304];
    static int[][] psum = new int[304][304];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                psum[i][j] = a[i-1][j-1] + psum[i-1][j] + psum[i][j-1] - psum[i-1][j-1];
            }
        }


        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());



        for(int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int sy = Integer.parseInt(st.nextToken());
            int sx = Integer.parseInt(st.nextToken());
            int ey = Integer.parseInt(st.nextToken());
            int ex = Integer.parseInt(st.nextToken());

            int ret = 0;

            System.out.println(psum[ey][ex] - psum[ey][sx-1] - psum[sy-1][ex] + psum[sy-1][sx-1]);
        }



    }

}




