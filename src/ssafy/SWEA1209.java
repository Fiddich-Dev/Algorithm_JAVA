package ssafy;

import java.util.*;

public class SWEA1209 {

    static int mx;
    static int[][] a;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int t = 1; t <= 10; t++) {
            int temp = sc.nextInt();
            mx = Integer.MIN_VALUE;
            a = new int[100][100];
            for(int i = 0; i < 100; i++) {
                for(int j = 0; j < 100; j++) {
                    a[i][j] = sc.nextInt();
                }
            }

            int temp1 = 0;
            int temp2 = 0;
            for(int i = 0; i < 100; i++) {
                solve_row(i);
                solve_col(i);
                temp1 += a[i][i];
                temp2 += a[i][100 - 1 - i];
            }

            mx = Math.max(mx, temp1);
            mx = Math.max(mx, temp2);

            System.out.println("#" + t + " " + mx);

        }
    }

    // ->
    static void solve_row(int n) {
        int sum = 0;
        for(int i = 0; i < 100; i++) {
            sum += a[n][i];
        }
        mx = Math.max(mx, sum);
    }

    static void solve_col(int n) {
        int sum = 0;
        for(int i = 0; i < 100; i++) {
            sum += a[i][n];
        }
        mx = Math.max(mx, sum);
    }
}
