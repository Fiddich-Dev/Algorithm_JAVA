package week3;

import java.util.ArrayList;
import java.util.Scanner;

class Pair {
    int y;
    int x;

    Pair(int y, int x) {
        this.y = y;
        this.x = x;
    }
}   

public class BOJ15686 {
    
    static int n, m;
    static int[][] a = new int[54][54];
    static int[][] visited = new int[54][54];

    static ArrayList<Pair> h = new ArrayList<>();
    static ArrayList<Pair> c = new ArrayList<>();

    static int ret = 987654321;

    static void combi(int start, ArrayList<Pair> b) {
        if(b.size() == m) {
            // 남은 치킨집에서 도시의 치킨거리는 sum
            int sum = 0;
            for(Pair ph : h) {
                int mn = 987654321;
                for(Pair pc : b) {
                    int temp = Math.abs(ph.y - pc.y) + Math.abs(ph.x - pc.x);
                    mn = Math.min(mn, temp);
                }
                sum += mn;
            }

            ret = Math.min(ret, sum);
            return;
        }

        for(int i = start+1; i < c.size(); i++) {
            b.add(c.get(i));
            combi(i, b);
            b.remove(b.size() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
                if(a[i][j] == 1) {
                    h.add(new Pair(i, j));
                }
                else if(a[i][j] == 2) {
                    c.add(new Pair(i, j));
                }
            }
        }

        // m개의 치킨집 고르기
        ArrayList<Pair> v = new ArrayList<>();
        combi(-1, v);

        System.out.println(ret);

    }

}
