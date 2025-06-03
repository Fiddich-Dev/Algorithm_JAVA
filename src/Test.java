
import java.util.*;
import java.io.*;

public class Test {

    static int n;
    static String ret = "";
    static char[] a = new char[104];
    static char[] b = new char[104];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        ret = sc.next();

        for(int i = 0; i < n; i++) {
            a[i] = sc.next().charAt(0);
            b[i] = sc.next().charAt(0);
        }

        go(0, 0, ret);
    }

    static void go(int now, int cnt, String temp) {
        if(cnt == n) {
            System.out.println(temp);
            return;
        }

        if(a[cnt] == 'L') {
            temp = solve1(now, b[cnt], temp);
            go(now, cnt+1, temp);
        }
        else if(a[cnt] == 'R') {
            temp = solve2(now, b[cnt], temp);
            go(now+1, cnt+1, temp);
        }
    }

    // 왼쪽에 넣기
    static String solve1(int now, char c, String temp) {
        String front = temp.substring(0, now);
        String back = temp.substring(now);
        return front + c + back;
    }

    // 오른쪽에 넣기
    static String solve2(int now, char c, String temp) {
        String front = temp.substring(0, now+1);
        String back = temp.substring(now+1);
        return front + c + back;
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

