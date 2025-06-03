package implementation;

import java.util.*;
import java.io.*;

public class BOJ17413 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        Stack<Character> stk = new Stack<>();
        String ret = "";
        String temp = "";

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '<') {
                // temp를 뒤집에서 ret에 더한다
                for(int j = temp.length()-1; j >= 0; j--) {
                    ret += temp.charAt(j);
                }
                temp = "";

                stk.push(s.charAt(i));
                ret += s.charAt(i);
                continue;
            }
            else if(s.charAt(i) == '>') {
                stk.pop();
                ret += s.charAt(i);
                continue;
            }

            // 비어있을떄는 괄호 밖
            if(stk.isEmpty()) {
                if(s.charAt(i) == ' ') {
                    // temp를 뒤집에서 ret에 더한다
                    for(int j = temp.length()-1; j >= 0; j--) {
                        ret += temp.charAt(j);
                    }
                    ret += ' ';
                    temp = "";
                }
                else {
                    temp += s.charAt(i);
                }
            }
            // 괄호 안
            else {
                ret += s.charAt(i);
            }
        }

        if(!temp.isEmpty()) {
            for(int j = temp.length()-1; j >= 0; j--) {
                ret += temp.charAt(j);
            }
        }


        System.out.println(ret);

    }
}

// 괄호에 포함되면 안되집는데
// 뛰어쓰기 되있으면 뒤집는다

// temp를 더할때는 괄호 밖에서 " "를 만날때, '<'를 만날때
