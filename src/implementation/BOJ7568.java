package implementation;

import java.util.*;

public class BOJ7568 {
    static int n;
   static List<Pair> a = new ArrayList<>();

   public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            int y = sc.nextInt();
            int x = sc.nextInt();
            a.add(new Pair(y, x));
        }

        // 본인
        for(int i = 0; i < n; i++) {
            int cnt = 0;
            // 검사 상대
            for(int j = 0; j < n; j++) {
                if(i == j) {
                    continue;
                }
                if(a.get(j).y > a.get(i).y && a.get(j).x > a.get(i).x) {
                    cnt++;
                } 
            }

            System.out.print(cnt+1 + " ");
        }

        System.out.println();

    }
}
