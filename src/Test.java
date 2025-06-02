
import java.util.*;
import java.io.*;

public class Test {

    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(10);
        pq.add(7);
        pq.add(15);

        while(!pq.isEmpty()) {
            System.out.println(pq.poll());
        }

        List<Integer> arr = new ArrayList<>();
        arr.add(10);
        arr.add(7);
        arr.add(15);

        Collections.sort(arr, Collections.reverseOrder());

        for(int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i));
        }

        List<Pair> pairs = new ArrayList<>();
        pairs.add(new Pair(1, 3));
        pairs.add(new Pair(1, 9));
        pairs.add(new Pair(5, 3));

        pairs.sort((p1, p2) -> {
            if(p1.y == p2.y) {
                return p2.x - p1.x;
            }
            return p1.y - p2.y;
        });

        for (Pair p : pairs) {
            System.out.println("(" + p.y + ", " + p.x + ")");
        }

    }

    static class Pair {
        int y;
        int x;

        public Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
