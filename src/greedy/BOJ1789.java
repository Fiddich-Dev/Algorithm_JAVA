package greedy;

import java.util.*;

public class BOJ1789 {

    static long s;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        s = sc.nextLong();

        long cnt = 0;
        while(true) {
            cnt++;
            long temp = cnt * (cnt+1) / 2;
            if(temp > s) {
                cnt--;
                break;
            }
        }

        System.out.println(cnt);
    }
}




