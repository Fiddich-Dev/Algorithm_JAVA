package implementation;

import java.util.*;
import java.io.*;

public class BOJ12904 {

    static String s = "";
    static String t = "";
    static int ret = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        s = sc.next();
        t = sc.next();

        while(true) {
            if(t.charAt(t.length() - 1) == 'A') {
                t = t.substring(0, t.length()-1);
            }
            else {
                t = t.substring(0, t.length()-1);
                StringBuffer sb = new StringBuffer(t);
                t = sb.reverse().toString();
            }

            if(s.length() == t.length()) {
                if(s.equals(t)) {
                    ret = 1;
                }
                break;
            }
        }

        System.out.println(ret);
    }

}


// ABBA
// ABB
// BA
// B

