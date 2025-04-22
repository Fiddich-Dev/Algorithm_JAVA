package week1;

import java.util.Scanner;

public class BOJ2979 {
    static int a, b, c;
    static int[] arr = new int[104];
    static int ret = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();

        for(int i = 0; i < 3; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();

            for(int j = start; j < end; j++) {
                arr[j]++;
            }
        }

        for(int i = 0; i < 104; i++) {
            if(arr[i] == 1) {
                ret += arr[i] * a;
            }
            else if(arr[i] == 2) {
                ret += arr[i] * b;
            }
            else if(arr[i] == 3) {
                ret += arr[i] * c;
            }
            else {
                continue;
            }
        }

        System.out.println(ret);
    }
}
