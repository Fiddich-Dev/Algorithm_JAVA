package dp;

import java.util.*;

public class BOJ1351 {

    static Map<Long, Long> dp = new HashMap<>();
    static long n, p, q;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextLong();
        p = sc.nextLong();
        q = sc.nextLong();

        long ret = go(n);

        System.out.println(ret);
    }

    static long go(long num) {
        if(num == 0) {
            return 1;
        }



        if(dp.get(num) != null) {
            return dp.get(num);
        }

        dp.put(num, go(num / p) + go(num / q));

        return dp.get(num);

    }
}

// 1000,000,000,000