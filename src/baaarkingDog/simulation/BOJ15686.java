package baaarkingDog.simulation;

import java.util.*;

public class BOJ15686 {

    static int n, m;
    static int[][] a;
    static List<Pair> chickens = new ArrayList<>();
    static List<Pair> homes = new ArrayList<>();
    static int ret = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a = new int[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
                if(a[i][j] == 2) {
                    chickens.add(new Pair(i, j));
                }
                else if(a[i][j] == 1) {
                    homes.add(new Pair(i, j));
                }
            }
        }

        List<Pair> v = new ArrayList<>();
        combi(-1, v);

        System.out.println(ret);
    }

    static void combi(int start, List<Pair> b) {
        if(b.size() == m) {
            int sum = 0;
            // 집 -> 치킨집
            for(Pair home : homes) {
                int mn = Integer.MAX_VALUE;
                for(Pair chicken : b) {
                    int dis = Math.abs(home.y - chicken.y) + Math.abs(home.x - chicken.x);
                    mn = Math.min(mn, dis);
                }
                sum += mn;
            }
            ret = Math.min(ret, sum);
            return;
        }
        for(int i = start+1; i < chickens.size(); i++) {
            b.add(chickens.get(i));
            combi(i, b);
            b.remove(b.size() - 1);
        }
    }

    static class Pair {
        int y;
        int x;

        public Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

}


// 13Cm * 100 * m