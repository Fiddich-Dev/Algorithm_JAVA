package baaarkingDog.sort;

import java.util.*;

public class BOJ5648 {

     public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         StringBuilder sb = new StringBuilder();
         int n = sc.nextInt();
         long[] a = new long[n];
         for(int i = 0; i < n; i++) {
             long num = sc.nextLong();
            a[i] = solve(num);
         }

         Arrays.sort(a);

         for(long i : a) {
             sb.append(i).append("\n");
         }

         System.out.println(sb);
     }

     static long solve(long num) {
         String s = String.valueOf(num);
         long sum = 0;
         long now = 1;
         for(int i = 0; i < s.length(); i++) {
             sum += (s.charAt(i) - '0') * now;
             now *= 10;
         }
         return sum;
     }
}
