package implementation;

import java.util.Scanner;
import java.util.Stack;

public class BOJ10773 {
    static int k;
    static Stack<Integer> stk = new Stack<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();

        for(int i = 0; i < k; i++) {
            int temp = sc.nextInt();

            if(temp == 0) {
                stk.pop();
            }
            else {
                stk.push(temp);
            }
        }
        int s = stk.size();
        int ret = 0;
        for(int i = 0; i < s; i++) {
            ret += stk.pop();
        }

        System.out.println(ret);
    }
}
