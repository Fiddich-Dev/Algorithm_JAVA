package bitmask;

import java.util.*;
import java.io.*;

public class BOJ1740 {

    static long n;
    static long ret = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextLong();

        for(long i = 0; i < 40; i++) {
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

// 00000
// 00001
// 00010
// 00011
// 00100