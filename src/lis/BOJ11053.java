package lis;

import java.util.*;
import java.io.*;

public class BOJ11053 {

    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] a = new int[n];
        int[] lis = new int[n];

        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int len = 0;

        for(int i = 0; i < n; i++) {
            int pos = lower_bound(a[i], len, lis);
            if(pos == len) {
                len++;
            }
            lis[pos] = a[i];
        }

        System.out.println(len);


    }

    static int lower_bound(int target, int len, int[] lis) {
        int l = 0;
        int r = len;

        while(l < r) {
            int mid = (l + r) / 2;
            if(target > lis[mid]) {
                l = mid + 1;
            }
            else {
                r = mid;
            }
        }

        return r;
    }

}

