package implementation;

import java.util.*;

public class BOJ17413 {

    static String solve(Stack<Character> stk) {
        String ret = "";

        while(!stk.isEmpty()) {
            ret += stk.pop();
        }
        
        return ret;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        Stack<Character> stk = new Stack<>();
        String ret = "";
        String temp = "";
        // 0이면 괄호 밖, 1이면 괄호 안
        int flag = 0;


        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '<') {
                ret += solve(stk);
                ret += s.charAt(i);
                flag = 1;
                continue;
            }
            else if(s.charAt(i) == '>') {
                ret += s.charAt(i);
                flag = 0;
                continue;
            }

            if(flag == 1) {
                ret += s.charAt(i);
            }
            else if(flag == 0) {
                if(s.charAt(i) == ' ') {
                    ret += solve(stk);
                    ret += s.charAt(i);
                }
                else {
                    stk.push(s.charAt(i));
                }

            }
        }

        ret += solve(stk);
        
        System.out.println(ret);

    }
}
// 스택에 담으며
// 괄호 짝이 맞으면 그대로 빼냄
// 괄호가 시작하면 이전 껄 뒤집어서 꺼냄
// 괄호 안에 ' '를 만나면 그대로 넣음
// 괄호 밖이면 꺼냄