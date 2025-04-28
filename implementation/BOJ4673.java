package implementation;

import java.util.ArrayList;
import java.util.Comparator;

public class BOJ4673 {
    
    static int[] visited = new int[10004];

    static ArrayList<Integer> ret = new ArrayList<>();

    static int solve(int n) {
        String ns = Integer.toString(n);
        int sum = n;
        for(char c : ns.toCharArray()) {
            int temp = Character.getNumericValue(c);
            sum += temp;
        }
        return sum;
    }
    public static void main(String[] args) {

        for(int i = 1; i <= 10000; i++) {

            int next = solve(i);

            if(next <= 10000) {
                visited[solve(i)] = 1;    
            }

        }

        for(int i = 1; i <= 10000; i++) {
            if(visited[i] == 0) {
                ret.add(i);
            }
        }

        for(int i : ret) {
            System.out.println(i);
        }
        
    }
}
