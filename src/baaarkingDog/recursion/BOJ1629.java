package baaarkingDog.recursion;

import java.util.*;

public class BOJ1629 {

    static int a, b, c;
    static int ret = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();


        System.out.println(go(b));
    }

    static long go(int n) {
        if(n == 1) {
            return a % c;
        }

        long temp = go(n/2) % c;

        if(n % 2 == 0) {
            return (temp * temp) % c;
        }
        else {
            return (((temp * temp) % c) * (a % c)) % c;
        }
    }
}
