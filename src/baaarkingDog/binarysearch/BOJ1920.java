package baaarkingDog.binarysearch;

import java.util.*;

public class BOJ1920 {

    static int n, m;
    static int[] a;
    static int[] b;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n  = sc.nextInt();
        a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        m = sc.nextInt();
        b = new int[m];
        for(int i = 0; i < m; i++) {
            b[i] = sc.nextInt();
        }

        Arrays.sort(a);

        for(int i = 0; i < m; i++) {
            System.out.println(binarySearch(0, n-1, b[i]));
        }

    }

    static int binarySearch(int l, int r, int value) {
        int mid;

        while(l <= r) {
            mid = (l + r) / 2;
            if(a[mid] == value) {
                return 1;
            }
            else if(a[mid] < value) {
                l = mid + 1;
            }
            else if(a[mid] > value) {
                r = mid - 1;
            }
        }
        return 0;
    }
}
