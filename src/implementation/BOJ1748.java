package implementation;

import java.util.*;

public class BOJ1748 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        long ret = 0;

        for(int i = 1; i <= n; i++) {
            int cnt = 0;
            int now = i;
            while(now > 0) {
                now /= 10;
                cnt++;
            }

            ret += cnt;
        }

        System.out.println(ret);
    }
}
