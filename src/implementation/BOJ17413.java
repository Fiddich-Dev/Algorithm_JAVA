package implementation;

import java.util.*;
import java.io.*;

public class BOJ17413 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        Stack<Character> stk = new Stack<>();
        String ret = "";
        String temp = "";

        for(char c : s.toCharArray()) {
            if(c == '<') {
                for(int i = temp.length()-1; i >= 0; i--) {
                    ret += temp.charAt(i);
                }
                temp = "";

                stk.push(c);
                ret += c;
                continue;
            }
            else if(c == '>') {
                stk.pop();
                ret += c;
                continue;
            }

            // 괄호안
            if(!stk.isEmpty()) {
                ret += c;
            }
            // 괄호밖
            else {
                // 빈칸 일떄
                if(c == ' ') {
                    for(int i = temp.length()-1; i >= 0; i--) {
                        ret += temp.charAt(i);
                    }
                    ret += " ";
                    temp = "";
                }
                // 빈칸 아닐떄
                else {
                    temp += c;
                }
            }
        }

        for(int i = temp.length()-1; i >= 0; i--) {
            ret += temp.charAt(i);
        }

        System.out.println(ret);
    }
}

// 괄호에 포함되면 안되집는데
// 뛰어쓰기 되있으면 뒤집는다

// temp를 더할때는 괄호 밖에서 " "를 만날때, '<'를 만날때
