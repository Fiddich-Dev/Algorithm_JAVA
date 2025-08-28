package implementation;

import java.util.*;
import java.io.*;


public class BOJ1138 {

    static int n;
    static int[] a = new int[12];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = i;
        }

        permutation(arr, 0, n, n);

    }

    static boolean check(int[] arr) {
        for(int i = 0; i < n; i++) {
            int cnt = 0;
            int now = arr[i];
            for(int j = 0; j < i; j++) {
                if(arr[j] > now) {
                    cnt++;
                }
            }

            if(a[now] != cnt) {
                return false;
            }

        }
        return true;
    }

    static void permutation(int[] arr, int depth, int n, int r) {
        if(depth == r) {
            if(check(arr)) {
                for(int i = 0; i < r; i++) {
                    System.out.print(arr[i]+1 + " ");
                }
                System.out.println();
            }
            return;
        }
        for(int i = depth; i < n; i++) {
            swap(arr, depth, i);
            permutation(arr, depth+1, n, r);
            swap(arr, depth, i);
        }
    }

    static void swap(int[] arr, int depth, int i) {
        int temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }
}



