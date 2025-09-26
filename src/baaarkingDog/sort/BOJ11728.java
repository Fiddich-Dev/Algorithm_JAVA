package baaarkingDog.sort;

import java.util.*;

public class BOJ11728 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
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

        int now1 = 0;
        int now2 = 0;
        while(now1 < n && now2 < m) {
            if(a[now1] < b[now2]) {
                sb.append(a[now1]).append(" ");
                now1++;
            }
            else {
                sb.append(b[now2]).append(" ");
                now2++;
            }
        }

        for(int i = now1; i < n; i++) {
            sb.append(a[i]).append(" ");
        }
        for(int i = now2; i < m; i++) {
            sb.append(b[i]).append(" ");
        }

        System.out.println(sb);
    }
}
