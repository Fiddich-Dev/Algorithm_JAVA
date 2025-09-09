package baaarkingDog.recursion;

import java.util.*;

public class BOJ2630 {

    static int n;
    static int[][] a = new int[150][150];
    static int[] ret = new int[2];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        go(n, 0, 0);
        System.out.println(ret[0]);
        System.out.println(ret[1]);
    }

    static void go(int num, int y, int x) {
        if(num == 0) {
            return;
        }
        int v = a[y][x];
        if(check(num, y, x)) {
            ret[v]++;
        }
        else {
            go(num/2, y, x);
            go(num/2, y, x+num/2);
            go(num/2, y+num/2, x);
            go(num/2, y+num/2, x+num/2);
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
