package baaarkingDog.sort;

import javax.sound.midi.Soundbank;
import java.util.*;

public class BOJ1431 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] a = new String[n];

        for(int i = 0; i < n; i++) {
            a[i] = sc.next();
        }

        Arrays.sort(a, (s1, s2) -> {
            if(s1.length() == s2.length()) {
                if(solve(s1) == solve(s2)) {
                    return s1.compareTo(s2);
                }
                return solve(s1) - solve(s2);
            }
            return s1.length() - s2.length();
        });

        StringBuilder sb = new StringBuilder();
        for(String temp : a) {
            sb.append(temp).append("\n");
        }

        System.out.println(sb);
    }

    static int solve(String s) {
        int sum = 0;
        for(char c : s.toCharArray()) {
            int i = c - '0';
            if(i >= 0 && i <= 9) {
                sum += i;
            }
        }
        return sum;
    }
}
