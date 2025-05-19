package week3;

import java.util.Scanner;

public class BOJ1065 {

    static boolean check(int num) {
        if(num < 100) {
            return true;
        }

        String s = String.valueOf(num);
        int gap = 0;

        for(int i = 0; i < s.length()-1; i++) {
            if(i == 0) {
                gap = s.charAt(1) - s.charAt(0);
                continue;
            }

            if(s.charAt(i+1) - s.charAt(i) != gap) {
                return false;
            }
        }

        return true;
    }
    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // 1부터 n까지

        int ret = 0;

        for(int i = 1; i <= n; i++) {
            if(check(i) == true) {
                ret++;
            }
        }
        System.out.println(ret);

    }
}
