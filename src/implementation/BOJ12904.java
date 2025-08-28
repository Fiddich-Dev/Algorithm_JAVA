package implementation;

import java.util.*;
import java.io.*;

public class BOJ12904 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();

        while(t.length() > s.length()) {
            int i = t.length() - 1;
            if(t.charAt(i) == 'A') {
                t = t.substring(0, t.length()-1);
            }
            else if(t.charAt(i) == 'B') {
                t = t.substring(0, t.length()-1);
                String temp = "";
                for(int j = t.length()-1; j >= 0; j--) {
                    temp += t.charAt(j);
                }
                t = temp;
            }
        }

        if(s.equals(t)) {
            System.out.println(1);
        }
        else {
            System.out.println(0);
        }
    }

}
// t의 가장 뒤가 A이면 A를 뺸다
// t의 가장 뒤가 B이면 B를 빼고 뒤집는다