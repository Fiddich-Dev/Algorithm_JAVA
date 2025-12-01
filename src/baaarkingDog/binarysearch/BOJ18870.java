package baaarkingDog.binarysearch;

import java.util.*;

public class BOJ18870 {

    static List<Integer> temp = new ArrayList<>();
    static List<Integer> a = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            temp.add(arr[i]);
        }

        Collections.sort(temp);
        int now = temp.get(0);
        a.add(now);
        for(int i = 1; i < n; i++) {
            int next = temp.get(i);
            if(now == next) {
                continue;
            }
            a.add(next);
            now = next;
        }

        for(int i = 0; i < n; i++) {
            sb.append(lowerBound(a.size(), arr[i])).append(" ");
        }

        System.out.println(sb);

    }

    static int lowerBound(int len, int target) {
        int l = 0;
        int r = len;

        while(l < r) {
            int mid = (l + r) / 2;
            if(a.get(mid) >= target) {
                r = mid;
            }
            else {
                l = mid + 1;
            }
        }
        return l;
    }

}
