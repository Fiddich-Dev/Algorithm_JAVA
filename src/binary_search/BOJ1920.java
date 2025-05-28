package binary_search;

import java.util.*;
import java.io.*;

public class BOJ1920 {

    static int n = 0;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        List<Integer> a = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int temp = sc.nextInt();
            a.add(temp);
        }

        Collections.sort(a);

        int m = sc.nextInt();
        for(int i = 0; i < m; i++) {
            int num = sc.nextInt();
            if(binary_search(a, num) == true) {
                System.out.println(1);
            }
            else {
                System.out.println(0);
            }
        }
    }

    static boolean binary_search(List<Integer> a, int num) {
        int l = 0;
        int r = n-1;
        int mid;

        while(l <= r) {
            mid = (l + r) / 2;
            if(a.get(mid) < num) {
                l = mid + 1;
            }
            else if(a.get(mid) > num) {
                r = mid - 1;
            }
            else if(a.get(mid) == num) {
                return true;
            }
        }
        return false;
    }
}

