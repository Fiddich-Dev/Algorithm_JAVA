package greedy;

import java.util.*;

public class BOJ1715 {

    static int n;
    static long[] dp = new long[100004];


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        PriorityQueue<Long> pq = new PriorityQueue<>();

        for(int i = 0; i < n; i++) {
            Long temp = sc.nextLong();
            pq.add(temp);
        }

        int cnt = 0;

        while(pq.size() >= 2) {
            long a = pq.poll();
            long b = pq.poll();



            pq.add(a + b);

            dp[cnt] = a + b;
            cnt++;
        }

        long sum = 0;
        for(int i = 0; i < cnt; i++) {
            sum += dp[i];
        }

        System.out.println(sum);

    }
}