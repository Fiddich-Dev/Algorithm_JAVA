package baaarkingDog.queue;

import java.util.*;

public class BOJ10845 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Queue<Integer> q = new LinkedList<>();
        int last = -1;
        for(int i = 0; i < n; i++) {
            String cmd = sc.next();
            if(cmd.equals("push")) {
                int num = sc.nextInt();
                q.add(num);
                last = num;
            }
            else if(cmd.equals("pop")) {
                if(q.isEmpty()) {
                    System.out.println(-1);
                }
                else {
                    System.out.println(q.poll());
                }

            }
            else if(cmd.equals("size")) {
                System.out.println(q.size());
            }
            else if(cmd.equals("empty")) {
                if(q.isEmpty()) {
                    System.out.println(1);
                }
                else {
                    System.out.println(0);
                }
            }
            else if(cmd.equals("front")) {
                if(q.isEmpty()) {
                    System.out.println(-1);
                }
                else {
                    System.out.println(q.peek());
                }
            }
            else if(cmd.equals("back")) {
                if(q.isEmpty()) {
                    System.out.println(-1);
                }
                else {
                    System.out.println(last);
                }
            }
        }
    }
}

//push X: 정수 X를 큐에 넣는 연산이다.
//        pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
//size: 큐에 들어있는 정수의 개수를 출력한다.
//        empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
//front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
//back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
