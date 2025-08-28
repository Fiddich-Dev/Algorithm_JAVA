package two_pointer;

import java.util.*;

public class BOJ2470 {

    static int n;
    static List<Integer> a = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            int temp = sc.nextInt();
            a.add(temp);
        }

        int dis = Integer.MAX_VALUE;

        Collections.sort(a);

        int retL = Integer.MAX_VALUE;
        int retR = Integer.MIN_VALUE;

        int l = 0;
        int r = n-1;

        while(l < r) {
            int now = a.get(r) + a.get(l);

            if(Math.abs(now) < dis) {
                dis = Math.abs(now);
                retL = l;
                retR = r;
            }

            if(now < 0) {
                l++;
            }
            else {
                r--;
            }


        }

        System.out.println(a.get(retL) + " " + a.get(retR));

    }
}


// -99 -2 -1 4 98