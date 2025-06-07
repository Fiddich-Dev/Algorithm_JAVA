package backtracking;

import java.io.*;
import java.util.*;

public class BOJ15652 {

    static int n, m;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        List<Integer> v = new ArrayList<>();
        go(1, v);

        System.out.print(sb);

    }

    static void go(int start, List<Integer> b) {
        if(b.size() == m) {
            for(int i : b) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = start; i <= n; i++) {
            b.add(i);
            go(i, b);
            b.remove(b.size()-1);
        }
    }

}
