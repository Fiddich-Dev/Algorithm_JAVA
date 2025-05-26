package sweeping;

import java.util.*;

public class BOJ15889 {

    static int n;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        int[] a = new int[n];
        int[] b = new int[n];

        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for(int i = 0; i < n-1; i++) {
            b[i] = sc.nextInt();
        }

        // 던질 수 있는 최대거리
        int maxReach = 0;

        for(int i = 0; i < n-1; i++) {
            // 줄 수 없을때
            if(a[i] > maxReach) {
                break;
            }
            maxReach = Math.max(maxReach, a[i] + b[i]);
        }

        if(maxReach >= a[n-1]) {
            System.out.println("권병장님, 중대장님이 찾으십니다");
        }
        else {
            System.out.println("엄마 나 전역 늦어질 것 같아");
        }

    }
}


