package implementation;

import java.util.*;
import java.io.*;

public class BOJ20055 {

    static int n, k;
    static int[] a;
    static int[] r;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        a = new int[2*n];
        r = new int[n];

        for(int i = 0; i < 2*n; i++) {
            a[i] = sc.nextInt();
        }
        int step = 0;
        while(true) {
            step++;

            // 벨트와 로봇 함꼐 회전
            roll();

            move();

            if(a[0] > 0) {
                r[0] = 1;
                a[0]--;
            }

            int cnt = 0;
            for(int i = 0; i < 2*n; i++) {
                if(a[i] == 0) {
                    cnt++;
                }
            }
            if(cnt >= k) {
                break;
            }

        }

        System.out.println(step);
    }

    static void roll() {
        int temp = a[2*n - 1];
        for(int i = 2*n-2; i >= 0; i--) {
            a[i+1] = a[i];
        }
        a[0] = temp;

        for(int i = n-2; i >= 0; i--) {
            r[i+1] = r[i];
        }
        r[n-1] = 0;
        r[0] = 0;
    }

    static void move() {
        for(int i = n-2; i >= 0; i--) {
            if(r[i] == 1 && r[i+1] == 0 && a[i+1] > 0) {
                r[i] = 0;
                r[i+1] = 1;
                a[i+1]--;
            }
        }
        r[n-1] = 0;
    }

}




