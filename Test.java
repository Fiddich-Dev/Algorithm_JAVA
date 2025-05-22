

import java.util.*;

public class Test {
    public static void main(String[] args) {

        List<Integer> arr = new ArrayList<>();

        for(int i = 1; i <= 5; i++) {
            arr.add(i);
        }

        Collections.rotate(arr, -1);

        for(int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();

    }
}
