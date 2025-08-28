package implementation;

import java.util.*;

public class BOJ1343 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int ret = 0;

        long l = 1;
        long r = 1;

        while(true) {
            long sum = (r * (r+1) / 2) - ((l-1) * l / 2);

            if(sum < n) {
                r++;
            }
            else if(sum == n) {
                ret++;
                l++;
            }
            else {
                l++;
            }

            if(r == n+1) {
                break;
            }
        }

        System.out.println(ret);

    }

}
