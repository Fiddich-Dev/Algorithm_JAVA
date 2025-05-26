package sweeping;

import java.util.*;

public class BOJ13334 {

    static class Pair {
        int s;
        int e;

        public Pair(int s, int e) {
            this.s = Math.min(s, e);
            this.e = Math.max(s, e);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Pair> arr = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            int temp1 = sc.nextInt();
            int temp2 = sc.nextInt();
            arr.add(new Pair(temp1, temp2));
        }

        int d = sc.nextInt();

        Collections.sort(arr, (p1, p2) -> {
            if(p1.e == p2.e) {
                return p1.s - p2.s;
            }
            return p1.e - p2.e;
        });

        for(Pair p : arr) {
            System.out.println(p.s + " : " + p.e);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int max = 0;

        for(Pair p : arr) {
            int start = p.s;
            int end = p.e;

            // 너무 김
            if(end - start > d) {
                continue;
            }

            pq.add(start);

            while(!pq.isEmpty() && pq.peek() < end - d) {
                pq.poll();
            }

            max = Math.max(max, pq.size());

        }

        System.out.println(max);

    }
}

// 시간 복잡도 : n번 줄을 그어서 n개의 라인중 몇개가 포함되어있는지 구하기 n*n

// s에서부터 l을 긋는다
// s+l보다 e가 작은게 몇개인지 센다
