package baaarkingDog.math;

import java.util.*;

public class BOJ9613 {

    static long ret;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for(int t = 0; t < test; t++) {
            ret = 0;
            int n = sc.nextInt();
            int[] a = new int[n];
            for(int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            Arrays.sort(a);

            for(int i = 0; i < n; i++) {
                for(int j = i+1; j < n; j++) {
                    gcd(a[i], a[j]);
                }
            }

            System.out.println(ret);
        }
    }

    static void gcd(int a, int b) {
        if(b == 0) {
            ret += a;
            return;
        }

        gcd(b, a % b);
    }
}
