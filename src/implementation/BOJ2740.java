package implementation;

import java.util.*;

public class BOJ2740 {

    static  int n, m, k;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        int[][] a = new int[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        m = sc.nextInt();
        k = sc.nextInt();

        int[][] b = new int[m][k];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < k; j++) {
                b[i][j] = sc.nextInt();
            }
        }




        for(int i = 0; i < n; i++) {
            for(int j = 0; j < k; j++) {
                System.out.print(solve(i, j, a, b) + " ");
            }
            System.out.println();
        }


    }

    static int solve(int y, int x, int[][] a, int[][] b) {
        int sum = 0;
        for(int i = 0; i < m; i++) {
            sum += a[y][i] * b[i][x];
        }
        return sum;
    }
}

