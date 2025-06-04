package implementation;

import java.util.Scanner;

public class BOJ2167 {
    static int n, m;
    static int[][] a = new int[304][304];
    static int k;



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        k = sc.nextInt();
        for(int i = 0; i < k; i++) {
            Pair start = new Pair(sc.nextInt()-1, sc.nextInt()-1);
            Pair end = new Pair(sc.nextInt()-1, sc.nextInt()-1);

            int sum = 0;
            for(int j = start.y; j <= end.y; j++) {
                for(int q = start.x; q <= end.x; q++) {
                    sum += a[j][q];
                }
            }

            System.out.println(sum);
        }
    }

    static class Pair {
        int y;
        int x;

        public Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}

