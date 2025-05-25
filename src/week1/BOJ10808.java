package week1;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ10808 {

    static String s;
    static int[] ret = new int[26];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        s = sc.next();

        char[] arr = s.toCharArray();

        for(char c : arr) {
            ret[c - 'a']++;
        }

        for(int i = 0; i < 26; i++) {
            System.out.print(ret[i] + " ");
        }

    }
}
