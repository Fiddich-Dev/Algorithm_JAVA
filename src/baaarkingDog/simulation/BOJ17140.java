package baaarkingDog.simulation;

import java.util.*;

public class BOJ17140 {

    static int r, c, k;
    static int[][] a = new int[104][104];
    static int n = 3;
    static int m = 3;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        r = sc.nextInt() - 1;
        c = sc.nextInt() - 1;
        k = sc.nextInt();
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        int cnt = 0;

        while(true) {
            if(a[r][c] == k) {
                break;
            }
            if(cnt == 100) {
                System.out.println(-1);
                return;
            }

//            System.out.println(n + " : " + m);

            if(n >= m) {
                solveR();
            }
            else {
                solveC();
            }

//            for(int i = 0; i < 50; i++) {
//                for(int j = 0; j < 50; j++) {
//                    System.out.print(a[i][j] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println();

            cnt++;

        }

        System.out.println(cnt);

    }

    static void solveR() {
        int maxC = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            maxC = Math.max(maxC, solve(a[i]));
        }
        m = maxC;
    }

    static void solveC() {
        int maxR = Integer.MIN_VALUE;

        for(int i = 0; i < m; i++) {
            int[] temp = new int[104];
            for(int j = 0; j < 104; j++) {
                temp[j] = a[j][i];
                a[j][i] = 0;
            }

            maxR = Math.max(maxR, solve(temp));

            for(int j = 0; j < 104; j++) {
                a[j][i] = temp[j];
            }
        }
        n = maxR;
    }

    static int solve(int[] a) {
        int[] cnt = new int[104];
        for(int i = 0; i < 104; i++) {
            int num = a[i];
            cnt[num]++;
        }

        List<Pair> arr = new ArrayList<>();
        for(int i = 1; i < 104; i++) {
            if(cnt[i] == 0) {
                continue;
            }
            arr.add(new Pair(i, cnt[i]));
        }

        Collections.sort(arr, (p1, p2) -> {
            if(p1.cnt == p2.cnt) {
                return p1.num - p2.num;
            }
            return p1.cnt - p2.cnt;
        });

        Arrays.fill(a, 0);

        int now = 0;
        for(Pair p : arr) {
            a[now] = p.num;
            now++;
            a[now] = p.cnt;
            now++;
        }

        return now;
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
