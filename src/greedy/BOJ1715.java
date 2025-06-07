package greedy;

import java.util.*;

public class BOJ1715 {

    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < n; i++) {
            int temp = sc.nextInt();
            pq.add(temp);
        }

        int sum = 0;

        while(pq.size() > 1) {
            int temp1 = pq.poll();
            int temp2 = pq.poll();
            sum += temp1 + temp2;
            pq.add(temp1 + temp2);

        }

        System.out.println(sum);
    }
}