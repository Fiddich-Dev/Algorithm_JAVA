package baaarkingDog.stack;

import java.util.*;

public class BOJ6198 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Stack<Pair> stk = new Stack<>();
        List<Integer> arr = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            int temp = sc.nextInt();
            arr.add(temp);
        }

        long ret = 0;

        for(int i = arr.size()-1; i >= 0; i--) {
            int now = arr.get(i);
            int cnt = 0;

            while(!stk.isEmpty() && stk.peek().num < now) {
                cnt += stk.peek().cnt + 1;
                stk.pop();
            }

            ret += cnt;
            stk.push(new Pair(now, cnt));
        }


//        while(!stk.isEmpty()) {
//            System.out.println(stk.peek().num + " : "  + stk.peek().cnt);
//            ret += stk.pop().cnt;
//        }

        System.out.println(ret);
    }

    static class Pair {
        int num;
        int cnt;

        public Pair(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }
    }
}
