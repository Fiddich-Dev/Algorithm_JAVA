package two_pointer;

import java.util.*;

public class BOJ2018 {

    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        int l = 1;
        int r = 1;
        int sum = 1;

        int ret = 0;

        while(r <= n) {
            if(sum < n) {
                r++;
                sum += r;
            }
            else if(sum > n) {
                sum -= l;
                l++;
            }
            else {
                ret++;
                sum -= l;
                l++;
            }
        }

        System.out.println(ret);
    }
}

