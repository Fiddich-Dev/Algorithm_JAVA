package baaarkingDog.simulation;

import java.util.*;

public class BOJ14889 {

    static int n;
    static int[][] a;
    static int ret = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        List<Integer> v = new ArrayList<>();
        combi(-1, v);

        System.out.println(ret);

    }

    static void calc(List<Integer> s, List<Integer> l) {
        int valueS = 0;
        int valueL = 0;

        for(int i = 0; i < n/2; i++) {
            for(int j = 0; j < n/2; j++) {
                valueS += a[s.get(i)][s.get(j)];
                valueL += a[l.get(i)][l.get(j)];
            }
        }

        ret = Math.min(ret, Math.abs(valueS - valueL));
    }

    static void combi(int start, List<Integer> b) {
        if(b.size() == n/2) {
            List<Integer> s = new ArrayList<>();
            List<Integer> l = new ArrayList<>();

            int[] visited = new int[n];
            for(int i : b) {
                visited[i] = 1;
            }
            for(int i = 0; i < n; i++) {
                if(visited[i] == 0) {
                    s.add(i);
                }
                else {
                    l.add(i);
                }
            }
            calc(s, l);
            return;
        }
        for(int i = start+1; i < n; i++) {
            b.add(i);
            combi(i, b);
            b.remove(b.size()-1);
        }
    }
}

// 20 C 10 * 10!
