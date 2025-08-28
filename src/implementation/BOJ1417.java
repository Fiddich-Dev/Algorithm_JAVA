package implementation;

import java.util.*;

// 다솜이를 제외한 후보중에 가장 지지자가 많은사람의 지지자를 매수하면 된다
public class BOJ1417 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int a = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 1; i < n; i++) {
            pq.add(sc.nextInt());
        }

        int ret = 0;

        while(true) {
            if(!pq.isEmpty()) {
                int temp = pq.poll();
                if(temp >= a) {
                    temp--;
                    a++;
                    ret++;
                    pq.add(temp);
                }
                else {
                    break;
                }
            }
            else {
                break;
            }
        }

        System.out.println(ret);
    }
}

