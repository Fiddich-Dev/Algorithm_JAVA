package lis;

import java.util.*;

public class BOJ11568 {

    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] a = new int[n];
        int[] cnt = new int[n];

        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            cnt[i] = 1;
        }

        int ret = 0;
        int len = 0;

        for(int i = 0; i < n; i++) {
            // target이상의 값을 찾는다
            int pos = lower_bound(a[i], len, cnt);
            // 못찾았을때
            if(pos == len) {
                len++;
            }
            cnt[pos] = a[i];
        }

        System.out.println(len);

    }

    static int lower_bound(int target, int len, int[] cnt) {
        int l = 0;
        int r = len;

        while(l < r) {
            int mid = (l + r) / 2;
            if(cnt[mid] < target) {
                l = mid + 1;
            }
            else {
                r = mid;
            }
        }
        return r;
    }
}
