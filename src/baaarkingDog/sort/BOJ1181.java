package baaarkingDog.sort;

import java.util.*;

public class BOJ1181 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        String[] a = new String[n];
        for(int i = 0; i < n; i++) {
            a[i] = sc.next();
        }

        Arrays.sort(a, (s1, s2) -> {
            if(s1.length() == s2.length()) {
                return s1.compareTo(s2);
            }
            return s1.length() - s2.length();
        });

        String prev = "";
        for(String s : a) {
            if(s.equals(prev)) {
                continue;
            }
            sb.append(s).append("\n");
            prev = s;
        }

        System.out.println(sb);
    }
}
