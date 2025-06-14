package implementation;

import java.util.*;

public class BOJ2740 {

    static int n, m, k;
    static int[][] a = new int[104][104];
    static int[][] b = new int[104][104];
    static int[][] ret = new int[104][104];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        m = sc.nextInt();
        k = sc.nextInt();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < k; j++) {
                b[i][j] = sc.nextInt();
            }
        }


        // n * k의 행렬이 완성됨
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < k; j++) {
                ret[i][j] = solve(i, j);
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < k; j++) {
                System.out.print(ret[i][j] + " ");
            }
            System.out.println();
        }

    }


    static int solve(int y, int x) {
        int sum = 0;
        for(int i = 0; i < m; i++) {
            sum += a[y][i] * b[i][x];
        }
        return sum;
    }
}

