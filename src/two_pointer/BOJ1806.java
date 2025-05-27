package two_pointer;

import java.util.*;

public class BOJ1806 {

    static int n, goal;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        goal = sc.nextInt();

        int[] a = new int[n+4];
        int[] psum = new int[n+4];

        int sum = 0;
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            sum += a[i];
            psum[i+1] = sum;
        }

        int s = 0;
        int e = 0;

        int ret = Integer.MAX_VALUE;

        while(s <= e) {
            // 충분히 클떄
            if(calc(s, e, psum) >= goal) {
                // e-s+1이 길이
                ret = Math.min(ret, e-s+1);
                s++;
            }
            // 부족할때
            else {
                e++;

                if(e == n) {
                    break;
                }
            }
        }
        if(ret == Integer.MAX_VALUE) {
            System.out.println(0);
        }
        else {
            System.out.println(ret);
        }


    }

    // a의 s부터 e번째 까지의 합
    // 3, 1
    static int calc(int s, int e, int[] psum) {
        return psum[e+1] - psum[s];
    }
}
