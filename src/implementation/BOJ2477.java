package implementation;

import java.util.*;
import java.io.*;

public class BOJ2477 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Pair[] a = new Pair[6];
        for(int i = 0; i < 6; i++ ) {
            int dir = sc.nextInt();
            int l = sc.nextInt();

            a[i] = new Pair(dir, l);
        }

        int ret = 0;

        for(int i = 0; i < 6; i++) {
            int start = i;
            if(a[start].dir == a[(start + 2) % 6].dir && a[(start+1) % 6].dir == a[(start+3) % 6].dir) {
                ret = a[(start+4) % 6].l * a[(start+5) % 6].l - a[(start+1) % 6].l * a[(start+2) % 6].l;
            }
        }

        System.out.println(ret * n);
    }

    static class Pair {
        int dir;
        int l;

        public Pair(int dir, int l) {
            this.dir = dir;
            this.l = l;
        }
    }
}

