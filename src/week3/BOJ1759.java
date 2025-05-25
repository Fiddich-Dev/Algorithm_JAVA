package week3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BOJ1759 {
    static int l, c;
    static List<Character> a = new ArrayList<>();

    static boolean check(List<Character> b) {
        // 최소 모음 한개 자음 두개
        int a1 = 0;
        int a2 = 0;

        for(char c : b) {
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                a1++;
            }
            else {
                a2++;
            }
        }

        if(a1 >= 1 && a2 >= 2) {
            return true;
        }
        return false;

    }

    static void combi(int start, List<Character> b) {
        if(b.size() == l) {
            if(check(b) == false) {
                return;
            }
            for(char c : b) {
                System.out.print(c);
            }
            System.out.println();
            return;
        }
        for(int i = start+1; i < c; i++) {
            b.add(a.get(i));
            combi(i, b);
            b.remove(b.size()-1);
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        l = sc.nextInt();
        c = sc.nextInt();
        for(int i = 0; i < c; i++) {
            String temp = sc.next();
            a.add(temp.charAt(0));
        }
        Collections.sort(a);

        List<Character> v = new ArrayList<>();
        combi(-1, v);
    }
}


