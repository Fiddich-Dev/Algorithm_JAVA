package baaarkingDog.binarysearch;

import java.util.*;

public class BOJ1253 {

    static int n;
    static int[] a;
    static int[] visited;
    static List<Integer> arr = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a = new int[n];
        visited = new int[n];

        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            map.put(a[i], map.getOrDefault(a[i], 0) + 1);
        }

        Arrays.sort(a);
        int ret = 0;

        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                int target = a[i] + a[j];
                int start = lowerBound(n, target);
                int end = upperBound(n, target);
                for(int k = start; k < end; k++) {
                    visited[k] = 1;
                }
            }
        }

        for(int i = 0; i < n; i++) {
            if(visited[i] == 1) {
                ret++;
            }
        }

        System.out.println(ret);


    }

    static int lowerBound(int len, int target) {
        int l = 0;
        int r = len;
        while(l < r) {
            int mid = (l + r) / 2;
            if(a[mid] >= target) {
                r = mid;
            }
            else {
                l = mid + 1;
            }
        }
        return l;
    }

    static int upperBound(int len, int target) {
        int l = 0;
        int r = len;
        while(l < r) {
            int mid = (l + r) / 2;
            if(a[mid] > target) {
                r = mid;
            }
            else {
                l = mid + 1;
            }
        }
        return l;
    }
}
