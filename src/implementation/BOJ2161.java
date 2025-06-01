package implementation;

import java.util.*;
import java.io.*;

public class BOJ2161 {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder st = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Integer> a = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= n; i++) {
            a.add(i);
            q.add(i);
        }

//        String ret = "";


        while(q.size() > 1) {
            st.append(solve(q)).append(" ");
        }
        st.append(q.peek()).append(" ");

        bw.write(st.toString());
        bw.close();
    }


    static int solve(Queue<Integer> q) {
        int ret = q.poll();
        int temp = q.peek();
        q.add(temp);
        q.poll();
        return ret;
    }
}
