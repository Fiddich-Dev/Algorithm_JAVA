package sweeping;

import java.util.*;

public class BOJ9881 {

    static int n;
    static int[] a = new int[1004];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            max = Math.max(max, a[i]);
            min = Math.min(min, a[i]);
        }

        int ret = Integer.MAX_VALUE;

        for(int i = min; i <= max - 17; i++) {
            int start = i;
            int end = i + 17;

            int price = 0;

            for(int j = 0; j < n; j++) {
                if(a[j] < start) {
                    price += (start - a[j]) * (start - a[j]);
                }
                else if(a[j] > end) {
                    price += (a[j] - end) * (a[j] - end);
                }
            }

            ret = Math.min(ret, price);
        }

        System.out.println(ret);
    }
}

