package baaarkingDog.binarysearch;

import java.util.*;
import java.io.*;

public class BOJ18869 {

    static int m, n;
    static int[][] a;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        a = new int[m][n];

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            Set<Integer> set = new HashSet<>();

            for(int j = 0; j < n; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
                set.add(a[i][j]);
            }

            List<Integer> list = new ArrayList<>(set);
            Collections.sort(list);

            for(int j = 0; j < n; j++) {
                a[i][j] = binarySearch(a[i][j], list);
            }
        }

        int ret = 0;
        for(int i = 0; i < m; i++) {
            for(int j = i + 1; j < m; j++) {
                if(isValid(a[i], a[j])) {
                    ret++;
                }
            }
        }

        System.out.println(ret);
    }

    static boolean isValid(int[] temp1, int[] temp2) {
        for(int i = 0; i < n; i++) {
            if(temp1[i] != temp2[i]) {
                return false;
            }
        }
        return true;
    }

    static int binarySearch(int target, List<Integer> temp) {
        int l = 0;
        int r = temp.size() - 1;
        int ret = -1;

        while(l <= r) {
            int mid = (l + r) / 2;
            if(temp.get(mid) == target) {
                ret = mid;
                return ret;
            }
            else if(temp.get(mid) < target) {
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }
        return ret;
    }

}
