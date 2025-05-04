package implementation;

import java.util.*;

public class BOJ10866 {

    static int n;
    static String s = "";
    static int k;

    static Deque<Integer> dq = new ArrayDeque<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for(int i = 0; i < n; i++) {
            s = sc.next();

            if(s.equals("push_front")) {
                k = sc.nextInt();
                dq.addFirst(k);
            }
            else if(s.equals("push_back")) {
                k = sc.nextInt();
                dq.addLast(k);
            }
            else if(s.equals("pop_front")) {
                if(dq.size() != 0) {
                    System.out.println(dq.removeFirst());
                }
                else {
                    System.out.println(-1);
                }
            }
            else if(s.equals("pop_back")) {
                if(dq.size() != 0) {
                    System.out.println(dq.removeLast());
                }
                else {
                    System.out.println(-1);
                }
            }
            else if(s.equals("size")) {
                System.out.println(dq.size());
            }
            else if(s.equals("empty")) {
                if(dq.isEmpty()) {
                    System.out.println(1);
                }
                else {
                    System.out.println(0);
                }
            }
            else if(s.equals("front")) {
                if(dq.isEmpty()) {
                    System.out.println(-1);
                }
                else {
                    System.out.println(dq.getFirst());
                }
            }
            else if(s.equals("back")) {
                if(dq.isEmpty()) {
                    System.out.println(-1);
                }
                else {
                    System.out.println(dq.getLast());
                }
            }

        }
        
    }
}
