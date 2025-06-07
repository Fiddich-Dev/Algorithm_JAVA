package implementation;

import java.util.*;
import java.io.*;

public class BOJ2477 {

    static int n;
    static int maxR, maxC;
    static int retR, retC;

    static int[] dir = new int[6];
    static int[] l = new int[6];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for(int i = 0; i < 6; i++) {
            dir[i] = sc.nextInt();
            l[i] = sc.nextInt();
        }

        for(int i = 0; i < 6; i++) {
            if(dir[i] == 1 || dir[i] == 2) {
                if(maxC <= l[i]) {
                    maxC = l[i];
                    retR = Math.min(l[(i+1) % 6], l[(i+5) % 6]);
                }
            }

            else if(dir[i] == 3 || dir[i] == 4) {
                if(maxR <= l[i]) {
                    maxR = l[i];
                    retC = Math.min(l[(i+1) % 6], l[(i+5) % 6]);
                }
            }
        }

//        System.out.println(maxR);
//        System.out.println(maxC);
//        System.out.println(retR);
//        System.out.println(retC);

        System.out.println((maxR * maxC - (maxR - retR) * (maxC - retC)) * n);
    }
}

// 가로 최대, 최소 구하고 세로 최대, 최소 구하고
// 가로 최대 * 세로 최대 - 가로 최소 * 세로 최소
