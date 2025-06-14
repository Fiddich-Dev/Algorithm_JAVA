package lis;

import java.util.*;
import java.io.*;

public class BOJ18353 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> arr = new ArrayList<>();
        int[] a = new int[n];
        int[] lis = new int[n];

        for(int i = 0; i < n; i++) {
            int temp = sc.nextInt();
            arr.add(temp);
        }

        Collections.reverse(arr);
        for(int i = 0; i < n; i++) {
            a[i] = arr.get(i);
        }

        int len = 0;
        for(int i = 0; i < n; i++) {
           int pos = lower_bound(a[i], len, lis);
           if(pos == len) {
               len++;
           }
           lis[pos] = a[i];
        }

        System.out.println(n - len);
    }

    // 타겟이상의 값읋 찾느거
    static int lower_bound(int target, int len, int[] lis) {
        int l = 0;
        int r = len;

        while(l < r) {
            int mid = (l + r) / 2;
            if(target > lis[mid]) {
                l = mid + 1;
            }
            else if(target <= lis[mid]) {
                r = mid;
            }
        }
        return r;
    }
}
