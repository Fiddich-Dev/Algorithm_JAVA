package sweeping;

import java.util.*;

public class BOJ9881 {

    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] a = new int[n];

        int start = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            start = Math.min(start, a[i]);
            end = Math.max(end, a[i]);
        }

        int ret = Integer.MAX_VALUE;

        for(int i = start; i <= end-17; i++) {
            int num = 0;
            int left = i;
            int right = i+17;

            for(int j = 0; j < n; j++) {
                // 쌓아야함
                if(a[j] < left) {
                   int temp = left - a[j];
                   num += temp * temp;
                }
                // 없애야함
                else if(a[j] > right) {
                    int temp = a[j] - right;
                    num += temp * temp;
                }
            }

            ret = Math.min(ret, num);
        }
        System.out.println(ret);
    }
}


// 1 4 20 21 24

// 3 4  18 21 24
// 2

// 4 4  18 20 24
// 1

// 6 4 18 20 22
// 2


// 20 4 1 24 21

