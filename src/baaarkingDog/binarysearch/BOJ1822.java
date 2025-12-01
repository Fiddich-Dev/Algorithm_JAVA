package baaarkingDog.binarysearch;

import java.util.*;

public class BOJ1822 {

    static int[] a;
    static int[] b;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int na = sc.nextInt();
        int nb = sc.nextInt();
        a = new int[na];
        b = new int[nb];

        for(int i = 0; i < na; i++) {
            a[i] = sc.nextInt();
        }
        for(int i = 0; i < nb; i++) {
            b[i] = sc.nextInt();
        }

        Arrays.sort(a);
        Arrays.sort(b);

        int cnt = 0;
        List<Integer> ret = new ArrayList<>();

        for(int i = 0; i < na; i++) {
            int temp = binarySearch(0, nb-1, a[i]);
            if(temp == 0) {
                cnt++;
                ret.add(a[i]);
            }
        }
        System.out.println(cnt);
        for(int i : ret) {
            System.out.print(i + " ");
        }
    }

    // a의 요소로 b에서 탐색했을때 없으면 저장
    static int binarySearch(int l, int r, int target) {
        while(l <= r) {
            int mid = (l + r) / 2;
            if(b[mid] == target) {
                return 1;
            }
            else if(b[mid] < target) {
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }
        return 0;
    }
}
