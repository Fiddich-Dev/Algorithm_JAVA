package saffy;

import java.util.*;

public class SWEA2072 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int q = 1; q <= t; q++) {
            int sum = 0;
            for(int i = 0; i < 10; i++) {
                int n = sc.nextInt();
                if(n % 2 != 0) {
                    sum += n;
                }
            }

            System.out.println("#" + q + " " + sum);
        }
    }
}
