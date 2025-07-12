package implementation;

import java.util.*;
import java.io.*;

public class BOJ1051 {

    static int n, m;
    static int[][] a = new int[54][54];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 0; i < n; i++) {
            String s = sc.next();
            for(int j = 0; j < m; j++) {
                a[i][j] = s.charAt(j) - '0';
            }
        }

        int ret = -987654321;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                for(int k = 0; k < Math.min(n, m); k++) {
                    if(i+k < n && j+k < m) {
                        if(check(i, j, k)) {
                            ret = Math.max(ret, k);
                        }
                    }
                }
            }
        }

        System.out.println((ret+1) * (ret+1));

    }

    static boolean check(int y, int x, int len) {
        int temp = a[y][x];
        if(temp == a[y+len][x] && temp == a[y][x+len] && temp == a[y+len][x+len]) {
            return true;
        }
        return false;
    }
}

