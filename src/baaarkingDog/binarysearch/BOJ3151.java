package baaarkingDog.binarysearch;

import java.util.*;

public class BOJ3151 {

    static int n;
    static int[] a;
    static long ret = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        Arrays.sort(a);

        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                int sum = a[i] + a[j];
                int idx = j;

                int l = lowerBound(sum, idx);
                int r = upperBound(sum, idx);
//                System.out.println(l + " : " + r);
                ret += r - l;
            }
        }

        System.out.println(ret);
    }

    static int lowerBound(int sum, int idx) {
        int l = idx + 1;
        int r = n;
        while(l < r) {
            int mid = (l + r) / 2;
            if(sum + a[mid] >= 0) {
                r = mid;
            }
            else {
                l = mid + 1;
            }
        }
        return l;
    }

    static int upperBound(int sum, int idx) {
        int l = idx + 1;
        int r = n;
        while(l < r) {
            int mid = (l + r) / 2;
            if(sum + a[mid] > 0) {
                r = mid;
            }
            else {
                l = mid + 1;
            }
        }
        return l;
    }
}
