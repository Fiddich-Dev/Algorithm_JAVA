

import java.util.*;

public class Test {
    public static void main(String[] args) {
        // 선언
        Stack<Integer> stk = new Stack<>();
        Queue<Integer> q = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> pqReverse = new PriorityQueue<>(Comparator.reverseOrder());
        Deque<Integer> dq = new ArrayDeque<>();


        // 스택
        // 삽입
        stk.push(1); // 1 대입
        // 조회
        stk.peek(); // 가장 늦게 들어온 요소인 1 리턴
        stk.search(1); // 앞에서부터 1의 인덱스인 0리턴
        // 삭제
        stk.pop(); // 가장 늦게 들어온 요소 제거, 리턴
        stk.clear(); // 스택 초기화


        // 큐
        // 삽입
        pq.add(1); // 1대입, 큐가 꽉 차면 예외발생
        pq.offer(1); // 1대입, 큐가 꽉 차면 false 리턴
        // 조회
        pq.peek(); // 가장 먼저 들어온 요소 리턴
        pq.element(); // 가장 먼저 들어온 요소 리턴
        // 삭제
        pq.remove(); // 가장 먼저 들어온 요소 제거, 큐가 비어있으면 예외발생
        pq.poll(); // 가장 먼저 들어온 요소 제거, 큐가 비어있으면 null 리턴
        pq.clear(); // 큐 초기화

        // 우선순위 큐
        // 삽입
        pq.add(1); // 1대입, 큐가 꽉 차면 예외발생
        pq.offer(1); // 1대입, 큐가 꽉 차면 false 리턴
        // 조회
        pq.peek(); // 가장 먼저 들어온 요소 리턴
        pq.element(); // 가장 먼저 들어온 요소 리턴
        // 삭제
        pq.remove(); // 가장 먼저 들어온 요소 제거, 큐가 비어있으면 예외발생
        pq.poll(); // 가장 먼저 들어온 요소 제거, 큐가 비어있으면 null 리턴
        pq.clear(); // 큐 초기화

        
        // 디큐
        // 삽입
        dq.addFirst(1);
        dq.offerFirst(1);
        dq.addLast(2);
        dq.offerLast(2);
        // 조회
        dq.getFirst();
        dq.peekFirst();
        dq.getLast();
        dq.peekLast();
        // 삭제
        dq.removeFirst();
        dq.pollFirst();
        dq.removeLast();
        dq.pollLast();
        dq.clear();
               
        System.out.println(5/2);

        int num = 1515;
        System.out.println(Math.round(num)); // 1515를 소수점 아래 첫번째 자리에서 반올림
        System.out.println(Math.round(num / 10.0) * 10); // 151.5를 소수점 아래 첫번째 자리에서 반올림
        System.out.println(Math.round(num / 100.0) * 100); // 15.15를 소수점 아래 첫번째 자리에서 반올림
        System.out.println(Math.round(num / 1000.0) * 1000); // 1.515를 소수점 아래 첫번째 자리에서 반올림
        
        double pi = 3.14159;
        System.out.println(Math.round(pi)); // 3.14159를 소수점 아래 첫번째 자리에서 반올림
        System.out.println(Math.round(pi * 10) / 10.0); // 31.4159를 소수점 아래 첫번째 자리에서 반올림
        System.out.println(Math.round(pi * 100) / 100.0); // 314.159를 소수점 아래 첫번째 자리에서 반올림
        System.out.println(Math.round(pi * 1000) / 1000.0); // 3141.59를 소수점 아래 첫번째 자리에서 반올림
    }
}
