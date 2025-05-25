package week1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

class Pair {
    int y;
    int x;

    public Pair(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class BOJ2309_2 {


    static ArrayList<Integer> arr = new ArrayList<>();
    static int sum = 0;
    static ArrayList<Integer> ret = new ArrayList<>();

    static Pair p = new Pair(0, 0);

    static void combi(int start, ArrayList<Integer> b) {
        if(b.size() == 2) {
            int temp = 0;
            for(int n : b) {
                temp += n;
            }

            if(sum - temp == 100) {
                p.y = b.get(0);
                p.x = b.get(1);
            }
            return;
        }

        for(int i = start+1; i < 9; i++) {
            b.add(arr.get(i));
            combi(i, b);
            b.remove(b.size() - 1);

        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int i = 0; i < 9; i++) {
            arr.add(sc.nextInt());
            sum += arr.get(i);
        }

        ArrayList<Integer> v = new ArrayList<>();
        combi(-1, v);


        for(int i : arr) {
            if(i == p.y || i == p.x) {
                continue;
            }
            ret.add(i);
        }


        Collections.sort(ret);

        for(int i : ret) {
            System.out.println(i);
        }
    }
}
