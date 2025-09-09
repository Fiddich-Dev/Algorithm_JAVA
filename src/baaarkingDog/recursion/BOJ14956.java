package baaarkingDog.recursion;

import java.util.*;

public class BOJ14956 {

    static int n, m;
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        go(1, 1, 0);

    }

    static void go(int num, int y, int x) {


        go(num/2, y, x);
        go(num/2, y+num/2, x);
        go(num/2, y+num/2, x+num/2);
        go(num/2, y+num/2-1, )

    }
}
