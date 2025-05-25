package week5;

import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class BOJ9935 {
    static String s;
    static String s2;

    static Stack<Character> stk = new Stack<>();

    // static String ret = "";



    public static void main(String[] args) {
        

        Scanner sc = new Scanner(System.in);
        s = sc.next();
        s2 = sc.next();

        for(int i = 0; i < s.length(); i++) {
            stk.push(s.charAt(i));
            if(stk.size() >= s2.length() && stk.peek() == s2.charAt(s2.length()-1)) {
                String temp = "";
                for(int j = 0; j < s2.length(); j++) {
                    temp += stk.pop();
                }

                StringBuffer sb1 = new StringBuffer(temp);
                if(sb1.reverse().toString().equals(s2)) {

                }
                else {
                    for(int j = temp.length()-1; j >= 0; j--) {
                        stk.push(temp.charAt(j));
                    }
                }
            }
        }

        StringBuffer ret = new StringBuffer();

        if(stk.size() == 0) {
            System.out.println("FRULA");
        }
        else {
            while(stk.size() != 0) {
                ret.append(stk.pop());
            }
        }

        // StringBuffer sb2 = new StringBuffer(ret);
        System.out.println(ret.reverse().toString());
    }
}
