package week1;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ1159 {
    
    static int n;
    static ArrayList<String> v = new ArrayList<>();
    static String ret = "";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        String s;

        for(int i = 0; i < n; i++) {
            s = sc.next();
            v.add(s);
        }

        for(int i = 0; i < 26; i++) {
            int cnt = 0;
            for(int j = 0; j < v.size(); j++) {
                if(v.get(j).charAt(0) == 'a' + i) {
                    cnt++;
                }
            }

            if(cnt >= 5) {
                ret += (char)('a'+i);
            }
        }

        if(ret.length() == 0) {
            System.out.println("PREDAJA");
        }
        else {
            System.out.println(ret);
        }
    }
}
