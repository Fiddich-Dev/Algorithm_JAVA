
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
    }
}
