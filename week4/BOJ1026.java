package week4;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class BOJ1026 {

    static int solve(Integer[] a, Integer[] b, int n) {
        int ret = 0;
        for(int i = 0; i < n; i++) {
            ret += a[i] * b[i];
        }
        return ret;
    }
    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Integer[] a = new Integer[n];
        Integer[] b = new Integer[n];

        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for(int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }

        Arrays.sort(a);
        Arrays.sort(b, Comparator.reverseOrder());


        System.out.println(solve(a, b, n));


    }
}
