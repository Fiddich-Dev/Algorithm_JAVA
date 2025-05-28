package binary_search;

import java.util.*;

public class BOJ2110 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();

        int[] a = new int[n];

        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);

        int l = 1;
        int r = a[n-1] - a[0];

        int ret = Integer.MIN_VALUE;

        while(l <= r) {
            int mid = (l + r) / 2;
            if(check(a, mid, c)) {
                l = mid + 1;
                ret = mid;
            }
            else {
                r = mid - 1;
            }
        }

        System.out.println(ret);
    }

    static boolean check(int[] a, int mid, int c) {
        int cnt = 1;
        int now = a[0];

        for(int i = 1; i < a.length; i++) {
            if(a[i] - now >= mid) {
                cnt++;
                now = a[i];
            }
        }
        // mid가 충분히 작다
        if(cnt >= c) {
            return true;
        }
        // mid가 너무 크다
        else {
            return false;
        }
    }

}
