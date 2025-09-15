package baaarkingDog.recursion;

import java.util.*;

public class BOJ2448 {

    static int n;
    static char[][] a;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        n = sc.nextInt();
        a = new char[n][2*n - 1];

        for(int i = 0; i < n; i++) {
            Arrays.fill(a[i], ' ');
        }


        go(n, 0, n-1);

        for(int i = 0; i < n; i++) {
            sb.append(a[i]).append("\n");
        }
        System.out.println(sb);
    }


    // num 은 높이
    static void go(int num, int y, int x){
        if(num == 3) {
            a[y][x] = '*';
            a[y+1][x-1] = '*';
            a[y+1][x+1] = '*';
            a[y+2][x-2] = '*';
            a[y+2][x-1] = '*';
            a[y+2][x] = '*';
            a[y+2][x+1] = '*';
            a[y+2][x+2] = '*';
            return;
        }
        int nxt = num/2;

        go(nxt, y, x);
        go(nxt, y+nxt, x-nxt);
        go(nxt, y+nxt, x+nxt);
    }
}
