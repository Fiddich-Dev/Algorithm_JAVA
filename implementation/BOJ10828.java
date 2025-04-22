package implementation;

import java.util.Scanner;
import java.util.Stack;

public class BOJ10828 {
    static int n;
    static String s = "";
    static int num;

    static Stack<Integer> stk = new Stack<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for(int i = 0; i < n; i++) {
            s = sc.next();
            if(s.equals("push")) {
                num = sc.nextInt();
                stk.push(num);
            }

            else if(s.equals("top")) {
                if(stk.empty()) {
                    System.out.println(-1);
                }
                else {
                    System.out.println(stk.peek());
                }
            }

            else if(s.equals("size")) {
                System.out.println(stk.size());
            }

            else if(s.equals("pop")) {
                if(stk.size() == 0) {
                    System.out.println(-1);
                }
                else {
                    System.out.println(stk.pop());
                }
            }

            else if(s.equals("empty")) {
                if(stk.empty()) {
                    System.out.println(1);
                }
                else{
                    System.out.println(0);
                }
            }

        }
    }
}
