package bitmask;

import java.util.*;
import java.io.*;

public class BOJ1052 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int ret = 0;

        while(true) {
            // n이 비트가 몇개 켜져있는지
            int bits = count(n);
            if(bits <= k) {
                break;
            }
            else {
                n++;
                ret++;
            }

        }

        System.out.println(ret);



    }

    static int count(int n) {
        int cnt = 0;
        for(int i = 0; i < 32; i++) {
            if((n & (1 << i)) != 0) {
                cnt++;
            }
        }
        return cnt;
    }

}
