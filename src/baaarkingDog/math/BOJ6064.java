package baaarkingDog.math;

import java.util.*;

public class BOJ6064 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for(int t = 0; t < test; t++) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();

            System.out.println(solve(m, n, x, y));
        }
    }

    static int solve(int m, int n, int x, int y) {
        if(x == m) {
            x = 0;
        }
        if(y == n) {
            y = 0;
        }

        int limit = lcm(m, n);

        for(int i = x; i <= limit; i += m) {
            if(i == 0) {
                continue;
            }
            if(i % n == y) {
                return i;
            }
        }

        return -1;
    }

    static int lcm(int a, int b) {
        return a / gcd(a, b) * b;
    }


    static int gcd(int a, int b) {
        if(b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }
}
