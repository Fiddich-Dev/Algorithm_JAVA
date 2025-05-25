package week3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ15649 {
    static int n, m;

    static void combi(int[] visited, List<Integer> b) {
        if(b.size() == m) {

            for(int i : b) {
                System.out.print(i + " ");
            }
            System.out.println();

            return;
        }
        for(int i = 1; i <= n; i++) {
            if(visited[i] == 0) {
                b.add(i);
                visited[i] = 1;
                combi(visited, b);
                b.remove(b.size()-1);
                visited[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        List<Integer> v = new ArrayList<>();
        int[] visited = new int[11];
        combi(visited, v);

    }
}
