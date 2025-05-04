package implementation;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ1475 {
    static String s;
    static int[] arr = new int[10];

    static int ret = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        s = sc.next();

        for(char c : s.toCharArray()) {
            arr[Integer.parseInt(String.valueOf(c))]++;
        }

        arr[6] += arr[9];
        arr[9] = 0;

        arr[6] = (arr[6] + 1) / 2;

        for(int i = 0; i < 10; i++) {
            ret = Math.max(ret, arr[i]);
        }
        
        
        System.out.println(ret);
    }
    
}
