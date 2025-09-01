package baaarkingDog.deque;

import java.util.*;

public class BOJ1021 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        Deque<Integer> dq = new ArrayDeque<>();

        for(int i = 1; i <= n; i++) {
            dq.addLast(i);
        }

        int ret = 0;

        for(int i = 0; i < m; i++) {
            int num = sc.nextInt();
            int cnt = 0;
            int size = dq.size();

            while(true) {
                int now = dq.pollFirst();

                if(now == num) {
                    break;
                }
                else {
                    dq.addLast(now);
                    cnt++;
                }
            }

            cnt = Math.min(cnt, size - cnt);
            ret += cnt;

        }

        System.out.println(ret);
    }
}
