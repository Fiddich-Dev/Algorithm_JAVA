package baaarkingDog.deque;

import java.util.*;

public class BOJ10866 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Deque<Integer> dq = new ArrayDeque<>();

        for(int i = 0; i < n; i++) {
            String cmd = sc.next();
            if(cmd.equals("push_front")) {
                int num = sc.nextInt();
                dq.addFirst(num);
            }
            else if(cmd.equals("push_back")) {
                int num = sc.nextInt();
                dq.addLast(num);
            }
            else if(cmd.equals("pop_front")) {
                if(!dq.isEmpty()) {
                    System.out.println(dq.pollFirst());
                }
                else {
                    System.out.println(-1);
                }

            }
            else if(cmd.equals("pop_back")) {
                if(!dq.isEmpty()) {
                    System.out.println(dq.removeLast());
                }
                else {
                    System.out.println(-1);
                }
            }
            else if(cmd.equals("size")) {
                System.out.println(dq.size());
            }
            else if(cmd.equals("empty")) {
                if(!dq.isEmpty()) {
                    System.out.println(0);
                }
                else {
                    System.out.println(1);
                }
            }
            else if(cmd.equals("front")) {
                if(!dq.isEmpty()) {
                    System.out.println(dq.peekFirst());
                }
                else {
                    System.out.println(-1);
                }
            }
            else if(cmd.equals("back")) {
                if(!dq.isEmpty()) {
                    System.out.println(dq.peekLast());
                }
                else {
                    System.out.println(-1);
                }
            }
        }
    }
}

//push_front X: 정수 X를 덱의 앞에 넣는다.
//push_back X: 정수 X를 덱의 뒤에 넣는다.
//pop_front: 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
//pop_back: 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
//size: 덱에 들어있는 정수의 개수를 출력한다.
//empty: 덱이 비어있으면 1을, 아니면 0을 출력한다.
//front: 덱의 가장 앞에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
//back: 덱의 가장 뒤에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.