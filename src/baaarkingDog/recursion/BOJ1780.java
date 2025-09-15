package baaarkingDog.recursion;

import java.util.*;

public class BOJ1780 {

    static int n;
    static int[][] a = new int[2200][2200];
    static int[] ret = new int[3];


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        go(n, 0, 0);
        for(int i = 0; i < 3; i++) {
            System.out.println(ret[i]);
        }


    }

    static void go(int num, int y, int x) {
        if(num == 0) {
            return;
        }

        if(check(num, y, x)) {
            int v = a[y][x];
            ret[v+1]++;
        }
        else {
            int nxt = num/3;
            go(nxt, y, x);
            go(nxt, y, x+nxt);
            go(nxt, y, x+nxt*2);
            go(nxt, y+nxt, x);
            go(nxt, y+nxt, x+nxt);
            go(nxt, y+nxt, x+nxt*2);
            go(nxt, y+nxt*2, x);
            go(nxt, y+nxt*2, x+nxt);
            go(nxt, y+nxt*2, x+nxt*2);
        }
    }

    static boolean check(int num, int y, int x) {
        int v = a[y][x];
        for(int i = y; i < y+num; i++) {
            for(int j = x; j < x+num; j++) {
                if(a[i][j] != v) {
                    return false;
                }
            }
        }
        return true;
    }
}
