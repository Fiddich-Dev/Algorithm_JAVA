package baaarkingDog.binarysearch;

import java.io.*;
import java.util.*;

public class BOJ1654 {

    static int n, k;
    static int[] a;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        a = new int[n];
        long mx = 0;
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
            mx = Math.max(mx, a[i]);
        }

        System.out.println(binarySearch(1, mx));
    }

    static long binarySearch(long l, long r) {
        long ret = 0;
        while (l <= r) {
            long mid = (l + r) / 2;
            if (isValid(mid)) {
                ret = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ret;
    }

    static boolean isValid(long mid) {
        int ret = 0;
        for (int i = 0; i < n; i++) {
            ret += (int) (a[i] / mid);
        }
        return ret >= k;
    }
}


