package baaarkingDog.stack;

import java.util.*;

public class BOJ1874 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Stack<Integer> stk = new Stack<>();

        StringBuilder sb = new StringBuilder();

        int now = 1;

        for(int i = 0; i < n; i++) {
            int temp = sc.nextInt();

            // temp가 들어갈때 까지 push
            while(now <= temp) {
                stk.push(now);
                sb.append("+").append("\n");
                now++;
            }

            if(temp != stk.peek()) {
                System.out.println("NO");
                return;
            }

            // 그 다음 pop
            stk.pop();
            sb.append("-").append("\n");
        }

        System.out.println(sb);
    }
}
