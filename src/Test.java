
import java.util.*;
import java.io.*;

public class Test {

    static List<Integer> a = new ArrayList<>();
    static int[] visited = new int[10];

    public static void main(String[] args) {
        List<Integer> v = new ArrayList<>();
        go(v);
        for(int i : a) {
            System.out.println(i);
        }
    }

    // 1 ~ 9까지 중에 순서 있게 뽑는법

    static void go(List<Integer> b) {
        if(b.size() == 3) {
            int temp = 0;
            temp += b.get(0) * 100;
            temp += b.get(1) * 10;
            temp += b.get(2);

            a.add(temp);
            return;
        }
        for(int i = 1; i < 10; i++) {
            if(visited[i] == 0) {
                visited[i] = 1;
                b.add(i);

                go(b);

                visited[i] = 0;
                b.remove(b.size()-1);
            }
        }
    }

}


//4 m
//L g
//R o
//R r
//L o

// m
// gm
// gom
// gorm
// goorm

