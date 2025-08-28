package implementation;

import java.util.*;

public class BOJ10973 {

//    static int n;
    static int[] arr = {1, 2, 3};


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int i = n-1;
        int j = n-1;

        while(i > 0 && a[i-1] < a[i]) {
            i--;
        }

        if(i <= 0) {
            System.out.println(-1);
            return;
        }

        while(a[i-1] < a[j]) {
            j--;
        }

        swap(a, i-1, j);

        List<Integer> temp = new ArrayList<>();
        for(int q = i; q < n; q++) {
            temp.add(a[q]);
        }
        Collections.sort(temp, Collections.reverseOrder());
        for(int q = i; q < n; q++) {
            a[q] = temp.get(q-i);
        }


        for(int q = 0; q < n; q++) {
            System.out.print(a[q] + " ");
        }
        System.out.println();

    }

    static void swap(int[] a, int depth, int i) {
        int temp = a[depth];
        a[depth] = a[i];
        a[i] = temp;
    }
}
