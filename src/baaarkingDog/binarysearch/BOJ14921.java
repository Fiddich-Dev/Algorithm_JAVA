package baaarkingDog.binarysearch;

import java.util.*;

public class BOJ14921 {

    static int ret = Integer.MAX_VALUE;
    static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        Arrays.sort(a);

        for(int i = 0; i < n; i++) {
            int now = a[i];
            int l = i + 1;
            int r = n - 1;

            while(l <= r) {
                int mid = (l + r) / 2;
                int result = now + a[mid];
                if(ret >= Math.abs(result)) {
                    ret = Math.abs(result);
                    answer = result;
                }

                if(result > 0) {
                    r = mid - 1;
                }
                else {
                    l = mid + 1;
                }

            }
        }

        System.out.println(answer);
    }
}
