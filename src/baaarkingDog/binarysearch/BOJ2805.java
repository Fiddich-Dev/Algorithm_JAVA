package baaarkingDog.binarysearch;

import java.util.*;

public class BOJ2805 {

    static int n, m;
    static int[] a;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        Arrays.sort(a);

        int ret = binarySearch(0, a[n-1]);
        System.out.println(ret);
    }

    static int binarySearch(int l, int r) {
        while(l < r) {
            int mid = (l + r + 1) / 2;
            if(isValid(mid)) {
                l = mid;
            }
            else {
                r = mid - 1;
            }
        }
        return l;
    }

    // 만족하는 가장 큰 수 찾기
    static boolean isValid(int mid) {
        long ret = 0;
        for(int i = 0; i < n; i++) {
            ret += Math.max(0, a[i] - mid);
        }
        return ret >= m;
    }
}
