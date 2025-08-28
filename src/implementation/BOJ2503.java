package implementation;

import java.util.*;

public class BOJ2503 {

    static int[] a = new int[1004];


    public static void main(String[] args) {

        for(int i = 100; i < 1000; i++) {
            if(check(i) == true) {
                a[i] = i;
//                System.out.println(i);
            }
        }


        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            int num = sc.nextInt();
            int s = sc.nextInt();
            int b = sc.nextInt();

            for(int j = 100; j < 1000; j++) {
                if(a[j] != 0) {
                    if(isValid(a[j], num, s, b)) {

                    }
                    else {
                        a[j] = 0;
                    }
                }
            }
        }

        int ret = 0;
        for(int i = 100; i < 1000; i++) {
            if(a[i] != 0) {
                ret++;
            }
        }
        System.out.println(ret);

    }

    static boolean isValid(int value, int num, int s, int b) {
        int v1 = value % 10;
        int v2 = (value / 10) % 10;
        int v3 = (value / 100) % 10;

        int n1 = num % 10;
        int n2 = (num / 10) % 10;
        int n3 = (num / 100) % 10;

        int[] v = {v1, v2, v3};
        int[] nu = {n1, n2, n3};

        int retS = 0;
        int retB = 0;

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(i == j) {
                    if(v[i] == nu[j]) {
                        retS++;
                        break;
                    }
                }
                else {
                    if(v[i] == nu[j]) {
                        retB++;
                        break;
                    }
                }
            }
        }

        if(s == retS && b == retB) {
            return true;
        }
        else {
            return false;
        }
    }


    static boolean check(int num) {
        int q = num % 10;
        int w = (num / 10) % 10;
        int e = (num / 100) % 10;

        if(q == 0 || w == 0 || e == 0) {
            return false;
        }

        if(q == w || w == e || q == e) {
            return false;
        }
        else {
            return true;
        }
    }

}


// 100 ~ 999까지
// 애초에 중복되는 건 제외
// s, b조건에 안 맞는거 제외