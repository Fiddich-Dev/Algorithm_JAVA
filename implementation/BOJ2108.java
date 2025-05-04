package implementation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BOJ2108 {
    static int n;
    static ArrayList<Integer> a = new ArrayList<>();
    // static int[] cnt = new int[4004];
    static HashMap<Integer, Integer> mp = new HashMap<>();

    // 가장 많이 등장한 횟수
    static int cnt = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        double sum = 0;
        for(int i = 0; i < n; i++) {
            int temp = sc.nextInt();
            if(mp.get(temp) == null) {
                mp.put(temp, 1);
                cnt = Math.max(cnt, mp.get(temp));
            }
            else {
                mp.put(temp, mp.get(temp) + 1);
                cnt = Math.max(cnt, mp.get(temp));
            }
            sum += temp;
            a.add(temp);
        }
        // 산술 평균
        System.out.println(Math.round(sum / n));
        // 중앙값
        Collections.sort(a);
        System.out.println(a.get(n / 2));

        // 최빈값
        Set<Integer> set = new HashSet<>();
        for(int i : a) {
            if(mp.get(i) == cnt) {
                set.add(i);
                // aa.add(i);
            }
        }
        ArrayList<Integer> aa = new ArrayList<>(set);

        if(aa.size() == 1) {
            System.out.println(aa.get(0));
        }
        else {
            Collections.sort(aa);

            System.out.println(aa.get(1));
        }
        
        
        // 범위
        System.out.println(a.get(a.size() - 1) - a.get(0));


    }

}
