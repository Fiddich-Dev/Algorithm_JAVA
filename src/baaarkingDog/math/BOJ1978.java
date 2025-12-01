package baaarkingDog.math;

import java.util.*;

public class BOJ1978 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int ret = 0;
        for(int i = 0; i < n; i++) {
            if(check(a[i])) {
                ret++;
            }
        }

        System.out.println(ret);

    }

    static boolean check(int num) {
        if(num == 1) {
            return false;
        }
        if(num == 2) {
            return true;
        }

        for(int i = 2; i*i <= num; i++) {
            if(num % i == 0) {
                return false;
            }
        }

        return true;
    }
}
