package week4;

import java.util.*;

class A {
    int p, f, s, v, c;

    A(int p, int f, int s, int v, int c) {
        this.p = p;
        this.f = f;
        this.s = s;
        this.v = v;
        this.c = c;
    }
}

public class BOJ19942 {
    static int n = 0;
    static int mp, mf, ms, mv;
    static int p, f, s, v, c;
    static ArrayList<A> a = new ArrayList<>();

    static int ret = 987654321;
    static ArrayList<Integer> ret2 = new ArrayList<>();
    

    static int count(ArrayList<A> b) {
        int sum = 0;

        for(A temp : b) {
            sum += temp.c;
        }
        return sum;
    }


    static boolean check(ArrayList<A> b) {
        int sumP = 0;
        int sumF = 0;
        int sumS = 0;
        int sumV = 0;

        for(A temp : b) {
            sumP += temp.p;
            sumF += temp.f;
            sumS += temp.s;
            sumV += temp.v;
        }

        if(sumP >= mp && sumF >= mf && sumS >= ms && sumV >= mv) {
            return true;
        }
        return false;
    }

    static void go(int start, ArrayList<A> b, ArrayList<Integer> bb) {
        if(check(b) == true) {

            int sumC = count(b);

            if(ret > sumC) {
                ret = sumC;
                ret2 = new ArrayList<>(bb);
            }

            return;
        }

        for(int i = start+1; i < n; i++) {
            b.add(a.get(i));
            bb.add(i+1);

            go(i, b, bb);

            b.remove(b.size() - 1);
            bb.remove(bb.size() - 1);
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        mp = sc.nextInt();
        mf = sc.nextInt();
        ms = sc.nextInt();
        mv = sc.nextInt();

        for(int i = 0; i < n; i++) {
            a.add(new A(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }

        ArrayList<A> v = new ArrayList<>();
        ArrayList<Integer> vv = new ArrayList<>();
        go(-1, v, vv);

        if(ret == 987654321) {
            System.out.println(-1);
            return;
        }
        
        System.out.println(ret);

        for(int i : ret2) {
            System.out.print(i + " ");
        }
        System.out.println();

    }

}

// 몇개를 골라서 조건에 충족하면 코스트을 최솟값으로 갱신
