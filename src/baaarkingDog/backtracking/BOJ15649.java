package baaarkingDog.backtracking;

import java.util.*;

public class BOJ15649 {

    static int n, m;
    static int[] visited = new int[10];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        List<Integer> v = new ArrayList<>();
        combi(-1, v);
    }

    static void combi(int start, List<Integer> b) {
        if(b.size() == m) {
            for(int i : b) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for(int i = 1; i <= n; i++) {
            if(visited[i] == 1) {
                continue;
            }

            b.add(i);
            visited[i] = 1;

            combi(i, b);

            b.remove(b.size()-1);
            visited[i] = 0;
        }
    }
}
