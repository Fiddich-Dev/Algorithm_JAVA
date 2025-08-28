package baaarkingDog.stack;

import java.util.*;

public class BOJ10828 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Stack<Integer> stk = new Stack<>();

        for(int i = 0; i < n; i++) {
            String cmd = sc.next();

            if(cmd.equals("push")) {
                int num = sc.nextInt();
                stk.push(num);
            }
            else if(cmd.equals("top")) {
                if(!stk.isEmpty()) {
                    System.out.println(stk.peek());
                }
                else {
                    System.out.println(-1);
                }
            }
            else if(cmd.equals("size")) {
                System.out.println(stk.size());
            }
            else if(cmd.equals("empty")) {
                if(stk.isEmpty()) {
                    System.out.println(1);
                }
                else {
                    System.out.println(0);
                }
            }
            else if(cmd.equals("pop")) {
                if(!stk.isEmpty()) {
                    System.out.println(stk.pop());
                }
                else {
                    System.out.println(-1);
                }
            }
        }
    }
}
