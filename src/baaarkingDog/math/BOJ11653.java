package baaarkingDog.math;

import java.util.*;

public class BOJ11653 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        int i = 2;

//        if(n == 1) {
//            return;
//        }

        while(i*i <= n) {
            if(n % i == 0) {
                sb.append(i).append("\n");
                n /= i;
            }
            else {
                i++;
            }
        }
        sb.append(n).append("\n");

        System.out.println(sb);
    }
}
