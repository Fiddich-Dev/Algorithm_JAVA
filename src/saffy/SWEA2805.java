package saffy;

import java.util.*;

public class SWEA2805 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for(int t = 1; t <= tc; t++) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for(int i = 0; i < n; i++) {
                String s = sc.next();
                for(int j = 0; j < n; j++) {
                    a[i][j] = s.charAt(j) - '0';
                }
            }

            int ret = 0;
            for(int i = 0; i < n; i++) {
                ret += a[n/2][i];
            }

            for(int i = 0; i < n/2; i++) {
                int start = n/2;
                ret += a[i][start];
                ret += a[n-1-i][start];

                for(int j = 0; j < i; j++) {
                    ret += a[i][start-(j+1)];
                    ret += a[i][start+(j+1)];
                    ret += a[n-1-i][start-(j+1)];
                    ret += a[n-1-i][start+(j+1)];
                }
            }

            System.out.println("#" + t + " " + ret);
        }
    }
}
