package baaarkingDog.queue;

import java.util.*;
import java.io.*;

public class BOJ18258 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        Queue<Integer> q = new LinkedList<>();
        int last = -1;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            if(cmd.equals("push")) {
                int num = Integer.parseInt(st.nextToken());
                q.add(num);
                last = num;
            }
            else if(cmd.equals("pop")) {
                if(q.isEmpty()) {
                    sb.append(-1).append("\n");
                }
                else {
                    sb.append(q.poll()).append("\n");
                }

            }
            else if(cmd.equals("size")) {
                sb.append(q.size()).append("\n");
            }
            else if(cmd.equals("empty")) {
                if(q.isEmpty()) {
                    sb.append(1).append("\n");
                }
                else {
                    sb.append(0).append("\n");
                }
            }
            else if(cmd.equals("front")) {
                if(q.isEmpty()) {
                    sb.append(-1).append("\n");
                }
                else {
                    sb.append(q.peek()).append("\n");
                }
            }
            else if(cmd.equals("back")) {
                if(q.isEmpty()) {
                    sb.append(-1).append("\n");
                }
                else {
                    sb.append(last).append("\n");
                }
            }
        }

        System.out.println(sb);
    }
}
