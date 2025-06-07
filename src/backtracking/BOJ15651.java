package backtracking;

import java.util.*;
import java.io.*;

public class BOJ15651 {

    static int n, m;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        List<Integer> v = new ArrayList<>();
        go(v);

        System.out.print(sb);

    }

    static void go(List<Integer> b) {
        if(b.size() == m) {
            for(int i : b) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 1; i <= n; i++) {
            b.add(i);
            go(b);
            b.remove(b.size()-1);
        }
    }
}
