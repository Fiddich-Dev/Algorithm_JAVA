package lis;

import java.util.*;

public class BOJ11568 {

    static int n;
    static int[] a = new int[1004];
    static int[] cnt = new int[1004];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] lis = new int[1004];
        for (int i = 0; i < n; i++) {
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
            if(target <= lis[mid]) {
                r = mid;
            }
            else {
                l = mid + 1;
            }
        }
        return r;
    }
}
