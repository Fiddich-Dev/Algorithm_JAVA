package saffy;

import java.util.*;

public class SWEA1208 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int q = 1; q <= 10; q++) {
            int n = sc.nextInt();
            int[] a = new int[100];
            for(int i = 0; i < 100; i++) {
                a[i] = sc.nextInt();
            }

            for(int i = 0; i < n; i++) {
                Arrays.sort(a);
                int dis = a[99] - a[0];
                if(dis == 0 || dis == 1) {
                    break;
                }
                a[99]--;
                a[0]++;
            }

            Arrays.sort(a);
            System.out.println("#" + q + " " + (a[99] - a[0]));

        }
    }
}
