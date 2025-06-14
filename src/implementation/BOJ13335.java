package implementation;

import java.util.*;

public class BOJ13335 {

    static int n, w, l;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        w = sc.nextInt();
        l = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        Queue<Integer> q = new LinkedList<>();
        int[] b = new int[w];

        int cnt = 0;
        int nowCar = 0;
        int sum = 0;

        while(true) {
            cnt++;

            // 다리위의 차 움직임
            sum -= b[0];
            move(a, b);
            // 차가 더 올라다도되면
            if(sum + a[nowCar] <= l) {
                b[w-1] = a[nowCar];
                sum += a[nowCar];
                nowCar++;
            }
            else {
                b[w-1] = 0;
            }

            if(nowCar == n) {
                cnt += w;
                break;
            }

        }

        System.out.println(cnt);

    }

    static void move(int[] a, int[] b) {
        for(int i = 1; i <= w-1; i++) {
            b[i-1] = b[i];
        }
    }
}

// 큐를 만든다
// 큐의 크기가 w가 넘으면 안된다, 큐의 합이 l이 넘으면 안된다
