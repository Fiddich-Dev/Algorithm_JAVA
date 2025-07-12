package implementation;

import java.util.*;

public class BOJ1417 {

    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int a = sc.nextInt();

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 1; i < n; i++) {
            pq.add(sc.nextInt());
        }

        if(pq.isEmpty()) {
            System.out.println(0);
            return;
        }

        int ret = 0;

        while(true) {
            if(a > pq.peek()) {
                break;
            }

            int temp = pq.poll();
            temp--;
            pq.add(temp);

            a++;

            ret++;
        }

        System.out.println(ret);
    }
}

