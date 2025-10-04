package baaarkingDog.greedy;

import java.util.*;

public class BOJ11047 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        Integer[] a = new Integer[n];
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
//        Arrays.sort(a, Collections.reverseOrder());

        int cnt = 0;
        int now = n-1;
        while(now >= 0) {

            if(a[now] <= k) {
                k -= a[now];
                cnt++;
            }
            else {
                now--;
            }
        }

        System.out.println(cnt);
    }
}
