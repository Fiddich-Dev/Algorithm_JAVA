package implementation;

import java.util.*;

public class BOJ1244 {

    static int n, m;
    static int[] a = new int[104];


    static void solve(int gender, int num) {
        if(gender == 1) {
            int temp = num;
            while(true) {
                a[temp] ^= 1;
                temp += num;

                if(temp > n) {
                    break;
                }
            }
        }
        else {

            int l = num;
            int r = num;

            while(true) {
                int nl = l-1;
                int nr = r+1;

                if(nl < 1 || nr > n) {
                    break;
                }
                if(a[nl] == a[nr]) {
                    l = nl;
                    r = nr;
                }
                else {
                    break;
                }
            }

            for(int i = l; i <= r; i++) {
                a[i] ^= 1;
            }
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for(int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }
        m = sc.nextInt();
        for(int i = 0; i < m; i++) {
            int gender = sc.nextInt();
            int num = sc.nextInt();

            solve(gender, num);

//            for(int j = 1; j <= n; j++) {
//                System.out.print(a[j] + " ");
//            }
//            System.out.println();
        }

        int cnt = 0;
        for(int i = 1; i <= n; i++) {
            System.out.print(a[i] + " ");
            cnt++;
            if(cnt == 20) {
                System.out.println();
                cnt = 0;
            }
        }
    }
}

