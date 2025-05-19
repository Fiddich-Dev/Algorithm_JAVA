package week4;

import java.util.Scanner;

public class BOJ2003 {
    static int n, m;
    static int[] a;
    static int[] psum;
    static int ret;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        a = new int[n];
        psum = new int[n];

        for(int i = 0; i < n; i++) {
            int temp = sc.nextInt();
            a[i] = temp;
        }

        int s = 0;
        int e = 0;
        int sum = 0;
        
        // e는 최대 n
        // 

        while(true) {
            if(sum < m) {
                if(e == n) {
                    break;
                }

                sum += a[e];
                e++;
            }
            else if(sum > m) {
                sum -= a[s];
                s++;
            }
            else {
                ret++;
                sum -= a[s];
                s++;
            }
        }
        
        System.out.println(ret);
    }
}