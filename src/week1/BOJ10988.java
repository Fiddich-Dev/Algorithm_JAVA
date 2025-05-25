package week1;

import java.util.Scanner;

public class BOJ10988 {
    static String s;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        s = sc.next();
        
        StringBuffer sb = new StringBuffer(s);


        if(s.equals(sb.reverse().toString())) {
            System.out.println(1);
        }
        else {
            System.out.println(0);
        }
    }
}
