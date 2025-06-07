package greedy;

import java.util.*;

public class BOJ1339 {

    static int n;
    static int[] a = new int[30];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for(int i = 0; i < n; i++) {
            int cnt = 1;
            String s = sc.next();
            for(int j = s.length()-1; j >= 0; j--) {
                char c = s.charAt(j);
                a[c - 'A'] += cnt;
                cnt *= 10;
            }
        }

//        for(int i= 0; i < 30; i++) {
//            System.out.println(a[i]);
//        }

        List<Pair> arr = new ArrayList<>();

        for(int i = 0; i < 30; i++) {
            if(a[i] != 0) {
                arr.add(new Pair(a[i], i));
            }
        }

        arr.sort((p1, p2) ->  {
            return p2.value - p1.value;
        });

        int now = 9;
        int ret = 0;
        for(Pair p : arr) {
//            System.out.println(p.value);
            ret += p.value * now;
            now--;
        }

        System.out.println(ret);

    }

    static class Pair {
        int value;
        int alpha;

        public Pair(int value, int alpha) {
            this.value = value;
            this.alpha = alpha;
        }
    }
}
// 자릿수가 높은 수에 큰수를 부여
// 만약 같은 자릿수에 다른 알파벳이 있으면