package implementation;

import java.util.*;
import java.io.*;

public class BOJ2239 {

    static int[][] a = new int[9][9];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < 9; i++) {
            String s = sc.next();
            for(int j = 0; j < 9; j++) {
                a[i][j] = s.charAt(j) - '0';
            }
        }

        go(0, 0);


    }


    static void go(int y, int x) {
        if(y == 9) {
            for(int i = 0; i < 9; i++) {
                for(int j = 0; j < 9; j++) {
                    System.out.print(a[i][j]);
                }
                System.out.println();
            }
            System.exit(0);
        }

        int nx = x+1 == 9 ? 0 : x+1;
        int ny = nx == 0 ? y+1 : y;

//        System.out.println(ny + " : " + nx);

        if(a[y][x] == 0) {
            for(int i = 1; i <= 9; i++) {
                if(check1(y, x, i) && check2(y, x, i)) {
                    a[y][x] = i;
                    go(ny, nx);
                    a[y][x] = 0;
                }
            }
        }
        else {
            go(ny, nx);
        }
    }

    static boolean check1(int y, int x, int num) {
        for(int i = 0; i < 9; i++) {
            if(a[y][i] == num || a[i][x] == num) {
                return false;
            }
        }
        return true;
    }

    static boolean check2(int y, int x, int num) {
        int startY = y / 3 * 3;
        int startX = x / 3 * 3;

        for(int i = startY; i < startY+3; i++) {
            for(int j = startX; j < startX+3; j++) {
                if(a[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }
}
