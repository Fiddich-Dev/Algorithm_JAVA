package implementation;

import java.util.*;
import java.io.*;

public class BOJ2161 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= n; i++) {
            q.add(i);
        }

        while(q.size() > 1) {
            sb.append(q.poll()).append(" ");
            int temp = q.poll();
            q.add(temp);
        }

        sb.append(q.poll());

        System.out.println(sb.toString());


    }
}
