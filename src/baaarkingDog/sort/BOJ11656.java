package baaarkingDog.sort;

import java.util.*;

public class BOJ11656 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String[] a = new String[s.length()];
        for(int i = 0; i < s.length(); i++) {
            a[i] = s.substring(i);
        }

        Arrays.sort(a);

        StringBuilder sb = new StringBuilder();
        for(String temp : a) {
            sb.append(temp).append("\n");
        }

        System.out.println(sb);
    }
}
