package baaarkingDog.sort;

import java.util.*;

public class BOJ7795 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- != 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] a = new int[n];
            int[] b = new int[m];
            for(int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            for(int i = 0; i < m; i++) {
                b[i] = sc.nextInt();
            }

            Arrays.sort(a);
            Arrays.sort(b);

            int ret = 0;
            int now = 0;
            for(int i = 0; i < n; i++) {
                while(true) {
                    if(now < m && a[i] > b[now]) {
                        now++;
                    }
                    else {
                        break;
                    }
                }
                ret += now;
            }


            System.out.println(ret);
        }
    }
}
// 400,000,000
