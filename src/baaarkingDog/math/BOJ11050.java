package baaarkingDog.math;

import java.util.*;

public class BOJ11050 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int cnt = Math.min(k, n-k);



        int ret = 1;
        for(int i = 0; i < cnt; i++) {
            ret *= n;
            n--;
        }

        while(cnt > 1) {
            ret /= cnt;
            cnt--;
        }

        System.out.println(ret);

    }
}
