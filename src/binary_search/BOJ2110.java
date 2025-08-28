package binary_search;

import java.util.*;

public class BOJ2110 {

    static int n, c;
    static List<Integer> a = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        c = sc.nextInt();
        for(int i = 0; i < n; i++) {
            int temp = sc.nextInt();
            a.add(temp);
        }

        Collections.sort(a);

        int l = 1;
        int r = a.get(n-1) - a.get(0);

        int ret = Integer.MIN_VALUE;

        while(l <= r) {
            int mid = (l + r) / 2;

            if(check(mid) == true) {
                l = mid + 1;
                ret = Math.max(ret, mid);
            }
            else {
                r = mid - 1;
            }
        }

        System.out.println(ret);
    }

    static boolean check(int mid) {
        int cnt = 1; // mid이상의 간격으로 놓은 공유기 개수
        int now = a.get(0); // 마지막으로 놓은 공유기의 위치
        for(int i = 1; i < n; i++) {
            if(a.get(i) - now >= mid) {
                cnt++;
                now = a.get(i);
            }
        }

        if(cnt >= c) {
            return true;
        }
        else {
            return false;
        }
    }
}
// mid는 공유기사이의 최소거리
// mid보다 크거나 같으면 가능
// mid보다 작으면 안됨
