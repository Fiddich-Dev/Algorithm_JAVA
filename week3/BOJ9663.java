package week3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class BOJ9663 {

    static int[] arr;
    static int n;
    static int cnt = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];

        nQueen(0);
        System.out.println(cnt);
    }

    static boolean check(int col) {
        for(int i = 0; i < col; i++) {
            if(arr[col] == arr[i]) {
                return false;
            }
        }
    }
}
