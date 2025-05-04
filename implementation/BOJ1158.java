package implementation;

import java.util.*;

public class BOJ1158 {
    static int n, k;
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        for(int i = 1; i <= n; i++) {
            q.add(i);
        }

        System.out.print("<");

        while (q.size() != 1) {
            
            for(int i = 0; i < k-1; i++) {
                int temp = q.remove();
                q.add(temp);
            }
            System.out.print(q.remove() + ", ");
        }

        System.out.println(q.peek() + ">");
    }
}
