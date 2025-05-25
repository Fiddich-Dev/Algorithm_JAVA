package greedy;

import java.util.*;

public class BOJ2217 {

    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        List<Integer> a = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            int temp = sc.nextInt();
            a.add(temp);
        }

        Collections.sort(a);
        Collections.reverse(a);

        int ret = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++) {
            // i+1개를 고르는 거임
            ret = Math.max(ret, a.get(i) * (i+1));
        }

        System.out.println(ret);

    }
}

// n개 중에 q개를 골라서 사용한다고 치자
// 그러면 q개중 가장 약한 로프의 값 * q가 들수있는 최대 중량