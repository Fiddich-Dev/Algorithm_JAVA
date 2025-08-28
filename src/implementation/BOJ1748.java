package implementation;

import java.util.*;

public class BOJ1748 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ret = 0;
        int now = 0;
        int start = 1;
        for(int i = 1; i <= n; i++) {
            if(i % start == 0) {
                now++;
                start *= 10;
            }
            ret += now;
        }

        System.out.println(ret);
    }
}
