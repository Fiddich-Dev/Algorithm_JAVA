package baaarkingDog.binarysearch;

import java.util.*;

public class BOJ10815 {

    static int[] a;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);
        int m = sc.nextInt();
        int[] b = new int[m];
        for(int i = 0; i < m; i++) {
            b[i] = sc.nextInt();
            int ret = binarySearch(0, n-1, b[i]);
            sb.append(ret).append(" ");
        }



        System.out.println(sb);

    }

    static int binarySearch(int l, int r, int target) {
        while(l <= r) {
            int mid = (l + r) / 2;
            if(a[mid] == target) {
                return 1;
            }
            else if(a[mid] < target) {
                l = mid + 1;
            }
            else if(a[mid] > target) {
                r = mid - 1;
            }
        }
        return 0;
    }
}
