package baaarkingDog.binarysearch;

import java.util.*;

public class BOJ16401 {

    static int m, n;
    static int[] a;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt(); // 조카 수
        n = sc.nextInt(); // 과자 수
        a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        Arrays.sort(a);

        int ret = binarySearch();
        System.out.println(ret);
    }

    static int binarySearch() {
        int l = 0;
        int r = 1000_000_000;
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

    static boolean isValid(int mid) {
        long ret = 0;
        for(int i = 0; i < n; i++) {
            ret += a[i] / mid;
        }
        return ret >= m;
    }
}
