package baaarkingDog.stack;

import java.util.*;
import java.io.*;

public class BOJ2493 {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        Stack<Pair> stk = new Stack<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            int temp = Integer.parseInt(st.nextToken());
            Pair p = new Pair(temp, i);

            while(!stk.isEmpty() && stk.peek().num < temp) {
                stk.pop();
            }

            if(stk.isEmpty()) {
                sb.append("0 ");
            }
            else {
                sb.append(stk.peek().idx).append(" ");
            }

            stk.add(p);
        }

        System.out.println(sb);
    }

    static class Pair {
        int num;
        int idx;

        public Pair(int num, int idx) {
            this.num = num;
            this.idx = idx;
        }
    }
}
