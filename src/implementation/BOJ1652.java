package implementation;

import java.util.*;

public class BOJ1652 {

    static int n;
    static char[][] a = new char[104][104];
    static char[][] a_temp = new char[104][104];


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            String s = sc.next();
            for(int j = 0; j < n; j++) {
                a[i][j] = s.charAt(j);
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                a_temp[i][j] = a[j][n-1-i];
            }
        }

        int ret1 = 0;
        for(int i = 0; i < n; i++) {
            int cnt = 0;
            int l = 0;
            for(int j = 0; j < n; j++) {
                if(a[i][j] == '.') {
                    l++;
                }
                else {
                    if(l >= 2) {
                        cnt++;
                    }
                    l = 0;
                }
            }
            if(l >= 2) {
                cnt++;
            }
            ret1 += cnt;
        }


        int ret2 = 0;
        for(int i = 0; i < n; i++) {
            int cnt = 0;
            int l = 0;
            for(int j = 0; j < n; j++) {
                if(a_temp[i][j] == '.') {
                    l++;
                }
                else {
                    if(l >= 2) {
                        cnt++;
                    }
                    l = 0;
                }
            }
            if(l >= 2) {
                cnt++;
            }
            ret2 += cnt;
        }

        System.out.println(ret1 + " " + ret2);

    }

}
