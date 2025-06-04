package backtracking;

import java.util.*;
import java.io.*;

public class BOJ15650 {

    static int n, m;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        List<Integer> v = new ArrayList<>();
        combi(-1, v);
    }

    static void combi(int start, List<Integer> b) {
        if(b.size() == m) {
            for(int i : b) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for(int i = start+1; i < n; i++) {
            b.add(i+1);
            combi(i, b);
            b.remove(b.size() - 1);
        }
    }
}
