package baaarkingDog.binarysearch;

import java.util.*;

public class BOJ2467 {

    static int n;
    static int[] a;
    static int ret = Integer.MAX_VALUE;
    static int retL, retR;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        for(int i = 0; i < n; i++) {
            binarySearch(i);
        }

        System.out.println(retL + " " + retR);

    }

    static void binarySearch(int idx) {
        int target = a[idx];
        int l = idx + 1;
        int r = n-1;
        while(l <= r) {
            int mid = (l + r) / 2;
            int mixed = target + a[mid];

            if(Math.abs(mixed) <= ret) {
                ret = Math.abs(mixed);
                retL = target;
                retR = a[mid];
            }

            if(mixed < 0) {
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }
    }


}
