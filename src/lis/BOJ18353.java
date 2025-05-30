package lis;

import java.util.*;
import java.io.*;

public class BOJ18353 {


//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        int n = Integer.parseInt(st.nextToken());
//        int[] a = new int[2004];
//        int[] cnt = new int[2004];
//
//        st = new StringTokenizer(br.readLine());
//        for(int i = 0; i < n; i++) {
//            a[i] = Integer.parseInt(st.nextToken());
//            cnt[i] = 1;
//        }
//        int ret = 0;
//
//        for(int i = 0; i < n; i++) {
//            for(int j = 0; j < i; j++) {
//                if(a[i] < a[j]) {
//                    cnt[i] = Math.max(cnt[i], cnt[j] + 1);
//                }
//            }
//            ret = Math.max(ret, cnt[i]);
//        }
//
//        System.out.println(n - ret);
//    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] a = new int[2004];
        int[] lis = new int[2004];

        st = new StringTokenizer(br.readLine());
        for(int i = n-1; i >= 0; i--) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int len = 0;

        for(int i = 0; i < n; i++) {
            int pos = solve(lis, len, a[i]);
            if(pos == len) {
                len++;
            }
            lis[pos] = a[i];
        }

        System.out.println(n - len);
    }

    static int solve(int[] lis, int len, int target) {
        int l = 0;
        int r = len;

        while(l < r) {
            int mid = (l + r) / 2;
            if(lis[mid] < target) {
                l = mid + 1;
            }
            else {
                r = mid;
            }
        }
        return l;
    }
}
