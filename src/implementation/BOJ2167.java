package implementation;

import java.util.*;
import java.io.*;

public class BOJ2167 {

    static int n , m;
    static int[][] a = new int[304][304];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        int k = sc.nextInt();
        for(int i = 0; i < k; i++) {
            int q = sc.nextInt() - 1;
            int w = sc.nextInt() - 1;
            int e = sc.nextInt() - 1;
            int r = sc.nextInt() - 1;

            int ret = 0;
            for(int j = q; j <= e; j++) {
                for(int l = w; l <= r; l++) {
                    ret += a[j][l];
                }
            }
            System.out.println(ret);
        }
    }

}




