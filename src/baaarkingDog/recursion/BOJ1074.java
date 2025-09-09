package baaarkingDog.recursion;

import java.util.*;

public class BOJ1074 {

    static int n, r, c;
    static int ret = 0;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        r = sc.nextInt();
        c = sc.nextInt();

        go((1 << n), 0, 0);

    }

    static void go(int num, int y, int x) {
        if(num == 1) {
            if(y == r && x == c) {
                System.out.println(ret);
            }
            return;
        }

        if(r < y + num/2 && c < x + num/2) {
            ret += 0;
            go(num/2, y, x);
        }
        else if(r < y + num/2 && c >= x + num/2) {
            ret += num/2 * num/2;
            go(num/2, y, x + num/2);
        }
        else if(r >= y + num/2 && c < x + num/2) {
            ret += num/2 * num/2 * 2;
            go(num/2, y + num/2, x);
        }
        else if(r >= y + num/2 && c >= x + num/2) {
            ret += num/2 * num/2 * 3;
            go(num/2, y + num/2, x + num/2);
        }
    }
}
