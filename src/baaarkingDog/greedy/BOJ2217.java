package baaarkingDog.greedy;

import java.util.*;

public class BOJ2217 {

    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         int n = sc.nextInt();
         int[] a = new int[n];
         for(int i = 0; i < n; i++) {
             a[i] = sc.nextInt();
         }
         Arrays.sort(a);


         int ret = Integer.MIN_VALUE;
         for(int i = 0; i < n; i++) {
             ret = Math.max(ret, a[i] * (n-i));
         }

         System.out.println(ret);
    }
}
