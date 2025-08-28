package baaarkingDog.stack;

import java.util.*;

public class BOJ10773 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Stack<Integer> stk = new Stack<>();

        for(int i = 0; i < n; i++) {
            int temp = sc.nextInt();
            if(temp == 0) {
                 if(!stk.isEmpty()) {
                     stk.pop();
                 }
            }
            else {
                stk.push(temp);
            }
        }

        int ret = 0;
        while(!stk.isEmpty()) {
            ret += stk.pop();
        }
        System.out.println(ret);
    }
}
