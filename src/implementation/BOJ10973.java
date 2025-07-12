package implementation;

import java.util.*;

public class BOJ10973 {

    public static void main(String[] args) {
        int[] a = {1, 2, 3};

        makePermutation(a, 0);

    }

    static void makePermutation(int[] a, int depth) {
        if(depth == a.length) {
            for(int i : a) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }
        for(int i = depth; i < a.length; i++) {
            swap(a, depth, i);
            makePermutation(a, depth+1);
            swap(a, depth, i);

        }
    }

    static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
