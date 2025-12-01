package saffy;

import java.util.*;

public class SWEA1204 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int test = 1; test <= t; test++) {
            int temp = sc.nextInt();
            int[] a = new int[101];
            for(int i = 0; i < 1000; i++) {
                int score = sc.nextInt();
                a[score]++;
            }
            int ret = -1;
            int cnt = 0;
            for(int i = 0; i <= 100; i++) {
                if(cnt <= a[i]) {
                    cnt = a[i];
                    ret = i;
                }
            }

            System.out.println("#" + test + " " + ret);
        }
    }
}
