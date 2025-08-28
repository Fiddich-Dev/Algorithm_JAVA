package backtracking;

import java.util.*;
import java.io.*;

public class BOJ15650 {

    static int n, m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        List<Integer> v = new ArrayList<>();
        combi(-1, v);
    }

    static void combi(int start, List<Integer> b) {
        if(b.size() == m) {
            for(int i : b) {
                System.out.print(i+1 + " ");
            }
            System.out.println();
            return;
        }
        for(int i = start+1; i < n; i++) {
            b.add(i);
            combi(i, b);
            b.remove(b.size() - 1);
        }
    }
}
