package baaarkingDog.backtracking;

import java.util.*;

public class BOJ9663 {

    static int n;
    static int[] visited1;
    static int[] visited2;
    static int[] visited3;
    static int ret = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        visited1 = new int[n];
        visited2 = new int[2*n - 1];
        visited3 = new int[2*n - 1];

        go(0);

        System.out.println(ret);
    }

    static void go(int num) {
        if(num == n) {
            ret++;
            return;
        }

        for(int i = 0; i < n; i++) {
            if(visited1[i] == 0 && visited2[i+num] == 0 && visited3[num-i+(n-1)] == 0) {
                visited1[i] = 1;
                visited2[num+i] = 1;
                visited3[num-i+(n-1)] = 1;

                go(num+1);

                visited1[i] = 0;
                visited2[num+i] = 0;
                visited3[num-i+(n-1)] = 0;
            }


        }
    }
}
