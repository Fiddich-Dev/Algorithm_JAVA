package week1;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ2309_1 {
    public static void main(String[] args) {
        int[] a = new int[9];

        Scanner sc = new Scanner(System.in);

        int sum = 0;

        for(int i = 0; i < 9; i++) {
            a[i] = sc.nextInt();
            sum += a[i];
        }

        for(int i = 0; i < 9; i++) {
            for(int j = i+1; j < 9; j++) {
                if(sum - a[i] - a[j] == 100) {
                    a[i] = 0;
                    a[j] = 0;

                    Arrays.sort(a);

                    for(int k = 2; k < 9; k++) {
                        System.out.println(a[k]);
                    }
                    return;
                }
            }
        }
    }
}
