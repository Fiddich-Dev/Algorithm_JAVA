package baaarkingDog.math;

import java.util.*;

public class BOJ1929 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        int[] a = new int[n+4];
        a[1] = 1;

        for(int i = 2; i*i <= n; i++) {
            if(a[i] == 0) {
                for(int j = i*i; j <= n; j += i) {
                    a[j] = 1;
                }
            }
        }

        for(int i = m; i <= n; i++) {
            if(a[i] == 0) {
                System.out.println(i);
            }
        }

    }
}
