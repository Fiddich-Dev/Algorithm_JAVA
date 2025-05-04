package implementation;

import java.util.*;

class Pair {
    int y;
    int x;

    Pair(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class BOJ1966 {
    static int t;
    static int n, m;
    static Queue<Pair> q = new LinkedList<>();
    static ArrayList<Integer> a = new ArrayList<>();

    static void solve() {
        int mxIdx = 0;
        while(true) {
            if(q.peek().y == a.get(mxIdx)) {
                Pair p = q.remove();
                mxIdx++;
                if(p.x == 1) {
                    System.out.println(mxIdx);
                    return;
                }
            }
            else {
                q.add(q.remove());
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();

        while(t-- != 0) {
            q.clear();
            a.clear();
            
            n = sc.nextInt();
            m = sc.nextInt();
            for(int i = 0; i < n; i++) {
                int temp = sc.nextInt();
                int goal = 0;
                if(i == m) {
                    goal = 1;
                }
                q.add(new Pair(temp, goal));
                a.add(temp);
            }

            Collections.sort(a, Comparator.reverseOrder());

            solve();
        }
    }
}
