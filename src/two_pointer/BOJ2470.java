package two_pointer;

import java.util.*;

public class BOJ2470 {

    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        List<Integer> a = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int temp = sc.nextInt();
            a.add(temp);
        }

        Collections.sort(a);

        // 절댓값이 가장 작을떄
        int ret = Integer.MAX_VALUE;

        int num1 = a.get(0);
        int num2 = a.get(n-1);


        int l = 0;
        int r = n-1;
        while(l < r) {
            int temp = a.get(l) + a.get(r);

            if(Math.abs(temp) < ret) {
                num1 = a.get(l);
                num2 = a.get(r);
                ret = Math.abs(temp);
            }

            if(temp >= 0) {
                r--;
            }
            else {
                l++;
            }
        }

        System.out.println(num1 + " " + num2);
    }
}


// -99 -2 -1 4 98