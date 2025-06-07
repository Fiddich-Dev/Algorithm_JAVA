package bitmask;

import java.util.*;
import java.io.*;

public class BOJ1052 {

    static int n, k;
    static int ret = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        // now만큼 물이 들어있음
        int now = 1;
        while(true) {

            // n으로 만들수 있는 최소 물병 수
            int cnt = 0;
            for(int i = 0; i < 25; i++) {
                if((n & (1 << i)) != 0) {
                    cnt++;
                }
            }

//            System.out.println(cnt);

            if(cnt <= k) {
                break;
            }

            n++;
            ret++;

        }

        System.out.println(ret);
    }
}
