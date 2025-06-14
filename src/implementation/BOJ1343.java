package implementation;

import java.util.*;

public class BOJ1343 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        int cntA = 0;
        int cntB = 0;
        int temp = 0;
        String ret = "";

        for(char c : s.toCharArray()) {
            if(c == 'X') {
                temp++;
            }
            else if(c == '.') {
                if(temp % 2 == 1) {
                    System.out.println(-1);
                    return;
                }

                int a = temp / 4;
                for(int i = 0; i < 4*a; i++) {
                    ret += 'A';
                }
                int b = temp % 4;
                for(int i = 0; i < b; i++) {
                    ret += 'B';
                }
                ret += '.';
                temp = 0;
            }
        }

        if(temp % 2 == 1) {
            System.out.println(-1);
            return;
        }

        int a = temp / 4;
        for(int i = 0; i < 4*a; i++) {
            ret += 'A';
        }
        int b = temp % 4;
        for(int i = 0; i < b; i++) {
            ret += 'B';
        }

        System.out.println(ret);
    }

}
