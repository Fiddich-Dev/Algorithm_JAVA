package greedy;

import java.util.*;

public class BOJ2217 {

    static int n;
    static int ret = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        List<Integer> a = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int temp = sc.nextInt();
            a.add(temp);
        }

        Collections.sort(a);

        for(int i = 0; i < a.size(); i++) {
            ret = Math.max(ret, a.get(i) * (a.size() - i));
        }

        System.out.println(ret);
    }
}

