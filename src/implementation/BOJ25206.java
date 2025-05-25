package implementation;

import java.util.HashMap;
import java.util.Scanner;

public class BOJ25206 {
    static String s;
    static double n;
    static String a;
    static HashMap<String, Double> map = new HashMap<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        map.put("A+", 4.5);
        map.put("A0", 4.0);
        map.put("B+", 3.5);
        map.put("B0", 3.0);
        map.put("C+", 2.5);
        map.put("C0", 2.0);
        map.put("D+", 1.5);
        map.put("D0", 1.0);
        map.put("F", 0.0);

        double sum = 0.0;
        double cnt = 0.0;

        for(int i = 0; i < 20; i++) {
            s = sc.next();
            n = sc.nextDouble();
            a = sc.next();

            if(a.equals("P")) {
                continue;
            }

            sum += n * map.get(a);
            cnt += n;
        }

        String ret = String.format("%.6f", sum / cnt);
        System.out.println(ret);
    }
}
