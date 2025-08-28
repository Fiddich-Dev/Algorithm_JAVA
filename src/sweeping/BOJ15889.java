package sweeping;

import java.util.*;

public class BOJ15889 {

    static int n;
    static int[] a = new int[30004];
    static int[] b = new int[30004];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for(int i = 0; i < n-1; i++) {
            b[i] = sc.nextInt();
        }

        int max = 0;
        for(int i = 0; i < n; i++) {

            if(max < a[i]) {
                System.out.println("엄마 나 전역 늦어질 것 같아");
                return;
            }

            max = Math.max(max, a[i] + b[i]);
        }

        System.out.println("권병장님, 중대장님이 찾으십니다");
    }
}

//
//
