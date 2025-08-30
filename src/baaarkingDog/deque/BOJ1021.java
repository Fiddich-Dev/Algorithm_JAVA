package baaarkingDog.deque;

import java.util.*;

public class BOJ1021 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        Deque<Integer> dq = new ArrayDeque<>();

        for(int i = 1; i <= n; i++) {
            dq.addFirst(i);
        }

        for(int i = 0; i < m; i++) {
            int num = sc.nextInt();
        }
    }
}
