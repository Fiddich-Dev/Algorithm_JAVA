package sweeping;

import java.util.*;

public class BOJ13334 {

    static int n, d;
    static List<Pair> a = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            a.add(new Pair(s, e));
        }
        d = sc.nextInt();

        a.sort((p1, p2) -> {
            return p1.e - p2.e;
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int max = -987654321;

        for(Pair p : a) {
            int start = p.s;
            int end = p.e;

            if(end - start > d) {
                continue;
            }

            pq.add(start);

            while(!pq.isEmpty() && pq.peek() < end-d) {
                pq.poll();
            }

            max = Math.max(max, pq.size());

        }

        System.out.println(max);
    }

    static class Pair {
        int s;
        int e;

        public Pair(int s, int e) {
            this.s = Math.min(s, e);
            this.e = Math.max(s, e);
        }
    }
}


// 10 : 20
// 10 : 25
// 25 : 30
// 25 : 35
// 5 : 40
// 30 : 50
// 50 : 60
// 80 : 100