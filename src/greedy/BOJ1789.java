package greedy;

import java.util.*;

public class BOJ1789 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long s = sc.nextLong();

        long now = 0;
        long i = 1;
        while(true) {

            now += i;

            if(now > s) {
                i--;
                break;
            }
            else if(now == s) {
                break;
            }


            i++;
        }

        System.out.println(i);
    }
}





