package baaarkingDog.math;

import java.util.*;

public class BOJ5347 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int t = 0; t < n; t++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            long ret = a / gcd(Math.max(a, b), Math.min(a, b));
            ret *= b;

            System.out.println(ret);
        }
    }

    static int gcd(int a, int b) {
        if(b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }
}
