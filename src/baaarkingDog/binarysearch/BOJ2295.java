package baaarkingDog.binarysearch;

import java.util.*;
import java.io.*;

public class BOJ2295 {

    static int n;
    static int[] a;
    static List<Integer> two = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Map<Integer, Integer> map = new HashMap<>();

        n = Integer.parseInt(st.nextToken());
        a = new int[n];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            a[i] = Integer.parseInt(st.nextToken());
            map.put(a[i], map.getOrDefault(a[i], 0) + 1);
        }

        Arrays.sort(a);
        int ret = 0;

        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                int sum = a[i] + a[j];
                two.add(sum);
            }
        }

        Collections.sort(two);


        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                int target = a[j] - a[i];
                if(binarySearch(two.size(), target)) {
                    ret = Math.max(ret, a[j]);
                }
            }
        }


        System.out.println(ret);
    }

    static boolean binarySearch(int len, int target) {
        int l = 0;
        int r = len-1;
        while(l <= r) {
            int mid = (l + r) / 2;
            if(two.get(mid) == target) {
                return true;
            }
            else if(two.get(mid) < target) {
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }
        return false;
    }
}
