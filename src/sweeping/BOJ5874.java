package sweeping;

import java.util.*;

public class BOJ5874 {

    static int[] front = new int[50004];

    // a[n] = 현재위치까지의 다리 누적합

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        int frontSum = 0;

        for(int i = 1; i < s.length(); i++) {
            char a = s.charAt(i-1);
            char b = s.charAt(i);

            if(a == ')' && b == ')') {
                frontSum++;
            }
            front[i] = frontSum;
        }

        int ret = 0;

        for(int i = 1; i < s.length(); i++) {
            char a = s.charAt(i-1);
            char b = s.charAt(i);
            if(a == '(' && b == '(') {
                ret += front[s.length()-1] - front[i];
            }

        }

        System.out.println(ret);

    }
}



