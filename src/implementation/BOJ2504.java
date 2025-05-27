package implementation;

import java.util.*;

public class BOJ2504 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        int ret = 0;
        int value = 1;

        Stack<Character> stk = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '(') {
                stk.push(ch);
                value *= 2;
            }
            else if(ch == '[') {
                stk.push(ch);
                value *= 3;
            }
            else if(ch == ')') {

                if(stk.isEmpty() || stk.peek() != '(') {
                    System.out.println(0);
                    return;
                }
                if(s.charAt(i-1) == '(') {
                    ret += value;
                }
                stk.pop();
                value /= 2;

            }
            else if(ch == ']') {
                if(stk.isEmpty() || stk.peek() != '[') {
                    System.out.println(0);
                    return;
                }
                if(s.charAt(i-1) == '[') {
                    ret += value;
                }
                stk.pop();
                value /= 3;
            }
        }

        if(stk.isEmpty()) {
            System.out.println(ret);
            return;
        }

        System.out.println(0);
    }
}


//2*(2 + 3*3) + 2*3