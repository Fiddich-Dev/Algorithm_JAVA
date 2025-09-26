package baaarkingDog.simulation;

import java.util.*;

public class BOJ13335 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int w = sc.nextInt();
        int l = sc.nextInt();

        Queue<Integer> truck = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            int temp = sc.nextInt();
            truck.add(temp);
        }

        int[] bridge = new int[w];
        int t = 0;
        int sum = 0;
        while(true) {
            t++;
            // 이동
            sum -= bridge[w-1];
            for(int i = w-2; i >= 0; i--) {
                bridge[i+1] = bridge[i];
            }
            bridge[0] = 0;

            // 만약 트럭이 올라갈 수 있으면
            if(!truck.isEmpty() && sum + truck.peek() <= l) {
                bridge[0] = truck.poll();
                sum += bridge[0];
            }

            if(truck.isEmpty() && sum == 0) {
                break;
            }
        }

        System.out.println(t);
    }
}
