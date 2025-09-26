package baaarkingDog.sort;

import java.util.*;

public class BOJ2750 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        StringBuilder sb = new StringBuilder();
        Arrays.sort(a);
        for(int i : a) {
            sb.append(i).append("\n");
        }

        System.out.println(sb);
    }
}
