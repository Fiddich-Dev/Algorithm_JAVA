package baaarkingDog.queue;

import java.util.*;

public class BOJ2164 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= n; i++) {
            q.add(i);
        }

        int ret = 1;

        while(true) {


            if(!q.isEmpty()) {
                q.poll();
            }
            else {
                break;
            }

            if(!q.isEmpty()) {
                int temp = q.poll();
                q.add(temp);
                ret = temp;
            }
        }

        System.out.println(ret);
    }
}
