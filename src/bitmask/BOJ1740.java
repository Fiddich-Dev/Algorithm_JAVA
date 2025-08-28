package bitmask;

import java.util.*;
import java.io.*;

public class BOJ1740 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long ret = 0;
        for(int i = 0; i < 64; i++) {
            if((n & (1L << i)) != 0) {
                long sum = 1;
                for(int j = 0; j < i; j++) {
                    sum *= 3;
                }
                ret += sum;
            }
        }

        System.out.println(ret);

    }
}