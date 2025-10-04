package baaarkingDog.simulation;

import java.util.*;

public class BOJ14888 {

    static int n;
    static int[] a;
    static List<Integer> op = new ArrayList<>();

    static int mx = Integer.MIN_VALUE;
    static int mn = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        for(int i = 0; i < 4; i++) {
            int temp = sc.nextInt();
            for(int j = 0; j < temp; j++) {
                op.add(i);
            }
        }

        permutation(0, n-1);

        System.out.println(mx);
        System.out.println(mn);
    }

    static void permutation(int depth, int r) {
        if(depth == r) {
            int now = a[0];
            for(int i = 1; i < n; i++) {
                if(op.get(i-1) == 0) {
                    now = now + a[i];
                }
                else if(op.get(i-1) == 1) {
                    now = now - a[i];
                }
                else if(op.get(i-1) == 2) {
                    now = now * a[i];
                }
                else if(op.get(i-1) == 3) {
                    now = now / a[i];
                }
            }
            mx = Math.max(mx, now);
            mn = Math.min(mn, now);
            return;
        }
        for(int i = depth; i < op.size(); i++) {
            swap(depth, i);
            permutation(depth+1, r);
            swap(depth, i);
        }
    }

    static void swap(int a, int b) {
        int temp = op.get(a);
        op.set(a, op.get(b));
        op.set(b, temp);
    }
}
