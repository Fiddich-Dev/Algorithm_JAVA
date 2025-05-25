package week4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ1541 {
    
    static String s = "";

    static List<String> num = new ArrayList<>();
    static List<Character> op = new ArrayList<>();

    static int oper(String num1, char o, String num2) {
        if(o == '+') {
            return Integer.parseInt(num1) + Integer.parseInt(num2);
        }
        else if(o == '*') {
            return Integer.parseInt(num1) * Integer.parseInt(num2);
        }
        else {
            return Integer.parseInt(num1) - Integer.parseInt(num2);
        }
    }

    static int ret = -987654321;

    static void go(int idx, int sum) {
        if(idx == op.size()) {
            ret = Math.max(ret, sum);
            return;
        }


        int sum1 = oper(String.valueOf(sum), op.get(idx), num.get(idx+1));
        go(idx+1, sum1);


        if(idx+1 < op.size()) {
            int sum2 = oper(num.get(idx+1), op.get(idx+1), num.get(idx+2));
            sum2 = oper(String.valueOf(sum), op.get(idx), String.valueOf(sum2));
            go(idx+2, sum2);
        }


    }

    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        s = sc.next();

        String temp = "";
        for(char c : s.toCharArray()) {
            if(c == '-' || c == '+' || c == '*') {
                num.add(temp);
                op.add(c);
                temp = "";
            }
            else {
                temp += c;
            }
        }
        num.add(temp);

        go(0, Integer.parseInt(num.get(0)));

        System.out.println(ret);

    }
}
// 최솟값 구하기
// -기준 오른쪽이 커야함
// -가 나오면 다음 -가 나오기전까지 먼저 연산
