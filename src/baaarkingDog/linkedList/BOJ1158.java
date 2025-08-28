package baaarkingDog.linkedList;

import java.util.*;;
import java.io.*;

public class BOJ1158 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        Queue<Integer> q = new LinkedList<>();

        for(int i = 1; i <= n; i++) {
            q.add(i);
        }

        StringBuilder sb = new StringBuilder();

        sb.append('<');

        for(int i = 1; i <= n; i++) {
            for(int j = 0; j < k-1; j++) {
                q.add(q.poll());
            }
            sb.append(q.poll()).append(", ");
        }

        sb = new StringBuilder(sb.substring(0, sb.length() - 2));
        sb.append('>');

        System.out.println(sb);
    }
}
