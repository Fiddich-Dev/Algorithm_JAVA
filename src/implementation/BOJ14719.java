package implementation;

import java.util.*;
import java.io.*;

public class BOJ14719 {

    static int h, w;
    static int[] a = new int[504];
    static int[][] map = new int[504][504];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        h = sc.nextInt();
        w = sc.nextInt();
        for(int i = 0; i < w; i++) {
            a[i] = sc.nextInt();
        }
        for(int i = 0; i < w; i++) {
            for(int j = 0; j < a[i]; j++) {
                map[h - 1 - j][i] = 1;
            }
        }
        int ret = 0;
        for(int i = h-1; i >= 0; i--) {
            int startBlock = -1;
            int endBlock = w;

            for(int j = 0; j < w; j++) {
                if(map[i][j] == 1) {
                    startBlock = j;
                    break;
                }
            }

            for(int j = w-1; j >= 0; j--) {
                if (map[i][j] == 1) {
                    endBlock = j;
                    break;
                }
            }

            if(startBlock != -1 && endBlock != w && startBlock != endBlock) {
                for(int j = startBlock+1; j < endBlock; j++) {
                    if(map[i][j] == 0) {
                        ret++;
                    }
                }
            }
        }

        System.out.println(ret);
    }
}

