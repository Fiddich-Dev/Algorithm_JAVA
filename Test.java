

import java.util.*;


public class Test {


    public static void main(String[] args) {

        int[][] a = {
            {1, 2, 3, 4},
            {1, 2, 3, 4}
        };
        int[][] a1 = a;

        a[0][0] = 100;

        for(int[] i : a) {
            for(int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println();

        for(int[] i : a1) {
            for(int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

        System.out.println(a);
        System.out.println(a1);

    }
}
