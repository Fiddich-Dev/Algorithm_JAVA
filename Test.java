

import java.util.*;

class Pair {
    int y;
    int x;
    
    Pair(int y, int x) {
        this.y = y;
        this.x = x;
    }
}


public class Test {
    public static void main(String[] args) {
        ArrayList<Pair> pairs = new ArrayList<>();
        pairs.add(new Pair(1, 6));
        pairs.add(new Pair(2, 5));
        pairs.add(new Pair(3, 2));
        pairs.add(new Pair(3, 3));
        pairs.add(new Pair(3, 4));
        pairs.add(new Pair(6, 1));
        
        Integer[] a = {1, 2, 3, 4, 5, 6};

        ArrayList<Integer> b = new ArrayList<>();
        b.add(1);
        b.add(2);
        b.add(3);
        b.add(4);
        b.add(5);
        b.add(6);

        // pairs를 y에 대해서 오름차순, y가 같으면 x에 대해서 내림차순
        Collections.sort(pairs, (p1, p2) -> {
            if(p1.y != p2.y) {
                return p1.y - p2.y;
            }
            return p2.x - p1.x;
        });

        for(Pair p : pairs) {
            System.out.println("y : " + p.y + ", x : " + p.x);
        }
        // 출력
        // y : 1, x : 6
        // y : 2, x : 5
        // y : 3, x : 4
        // y : 3, x : 3
        // y : 3, x : 2
        // y : 6, x : 1    

        System.out.println();

        // 오름차순 정렬
        Arrays.sort(a, Comparator.naturalOrder());
        for(int i : a) {
            System.out.print(i + " ");
        }
        // 출력
        // 1 2 3 4 5 6 

        System.out.println();

        // 내림차순 정렬
        Arrays.sort(a, Comparator.reverseOrder());
        for(int i : a) {
            System.out.print(i + " ");
        }
        // 출력
        // 6 5 4 3 2 1 

        System.out.println();

        // 오름차순 정렬
        Collections.sort(b, Comparator.naturalOrder());
        for(int i : b) {
            System.out.print(i + " ");
        }
        // 출력
        // 1 2 3 4 5 6 

        System.out.println();

        // 내림차순 정렬
        Collections.sort(b, Comparator.reverseOrder());
        for(int i : b) {
            System.out.print(i + " ");
        }
        // 출력
        // 6 5 4 3 2 1 

    }
}
