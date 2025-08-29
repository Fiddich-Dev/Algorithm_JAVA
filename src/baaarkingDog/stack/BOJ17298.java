package baaarkingDog.stack;

import java.util.*;
import java.io.*;

public class BOJ17298 {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] a = new int[1000004];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stk = new Stack<>();
        int[] ret = new int[1000004];

        for(int i = n-1; i >= 0; i--) {
            int now = a[i];

            while(!stk.isEmpty() && stk.peek() <= now) {
                stk.pop();
            }

            if(stk.isEmpty()) {
                ret[i] = -1;
            }
            else {
                ret[i] = stk.peek();
            }

            stk.push(now);
        }

        for(int i = 0; i < n; i++) {
            sb.append(ret[i]).append(" ");
        }

        System.out.println(sb);
    }
}
