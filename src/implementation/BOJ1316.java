package implementation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class BOJ1316 {
    static int n;
    static Set<Character> st = new HashSet<>();
    static int ret = 0;

    static boolean solve(String s) {
        Map<Character, Integer> mp = new HashMap<>();
        char prev = 'A';
        for(char c : s.toCharArray()) {
            // 첫 문자면 그냥 확인
            if(prev == 'A') {
                mp.put(c, 1);
                prev = c;
            }
            // 아니면 이전 문자와 같으면 패스, 이미 map에 있으면 안됨
            else {
                if(c == prev) {
                    continue;
                }
                // 이미 나왔던 문자
                if(mp.getOrDefault(c, 0) != 0) {
                    return false;
                }
                // 안나왔던 문자
                else {
                    mp.put(c, 1);
                    prev = c;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for(int i = 0; i < n; i++) {
            String s = sc.next();
            if(solve(s) == true) {
                ret++;
            }
        }

        System.out.println(ret);


    }
}
