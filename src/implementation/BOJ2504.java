package implementation;

import java.util.*;

public class BOJ2504 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        Stack<Character> stk = new Stack<>();

        int ret = 0;
        int value = 1;

        for(int i = 0; i < s.length(); i++) {
            char now = s.charAt(i);

            if(now == '(') {
                stk.push(now);
                value *= 2;
            }
            else if(now == '[') {
                stk.push(now);
                value *= 3;
            }
            else if(now == ')') {
                if(!stk.isEmpty() && stk.peek().equals('(')) {
                    stk.pop();
                    char prev = s.charAt(i-1);
                    if(prev == '(') {
                        ret += value;
                    }
                    value /= 2;
                }
                else {
                    System.out.println(0);
                    return;
                }
            }
            else if(now == ']') {
                if(!stk.isEmpty() && stk.peek().equals('[')) {
                    stk.pop();
                    char prev = s.charAt(i-1);
                    if(prev == '[') {
                        ret += value;
                    }
                    value /= 3;
                }
                else {
                    System.out.println(0);
                    return;
                }
            }
        }

        if(!stk.isEmpty()) {
            System.out.println(0);
            return;
        }

        System.out.println(ret);
    }
}


// (()[[]])([])