package baaarkingDog.recursion;

import java.util.*;

public class BOJ2447 {

    static int n;
    static char[][] a;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        n = sc.nextInt();

        a = new char[n][n];

        for(int i = 0; i < n; i++) {
            Arrays.fill(a[i], ' ');
        }

        go(n, 0, 0);

        for(int i = 0; i < n; i++) {
            sb.append(a[i]).append("\n");
        }

        System.out.println(sb);
    }

    static void go(int num, int y, int x) {
        if(num == 1) {
            a[y][x] = '*';
            return;
        }
        go(num/3, y, x);
        go(num/3, y, x+num/3);
        go(num/3, y, x+num/3*2);
        go(num/3, y+num/3, x);
//        go(num/3, y+num/3, x+num/3, ' ');
        go(num/3, y+num/3, x+num/3*2);
        go(num/3, y+num/3*2, x);
        go(num/3, y+num/3*2, x+num/3);
        go(num/3, y+num/3*2, x+num/3*2);

    }
}
