package sweeping;

import java.util.*;

public class BOJ5874 {

    static String s = "";
    static List<Integer> back = new ArrayList<>();
    static List<Integer> front = new ArrayList<>();


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        s = sc.next();

        for(int i = 0; i < s.length()-1; i++) {
            if(s.charAt(i) == '(' && s.charAt(i+1) == '(') {
                back.add(i);
            }
            else if(s.charAt(i) == ')' && s.charAt(i+1) == ')') {
                front.add(i);
            }
        }

        int ret = 0;

        for(int i = 0; i < back.size(); i++) {
            for(int j = 0; j < front.size(); j++) {
//                back.get(i)보다 front.get(j)가 크면됨
                if(back.get(i) < front.get(j)) {
                    ret += front.size() - j;
                    break;
                }
            }
        }

        System.out.println(ret);
    }
}


