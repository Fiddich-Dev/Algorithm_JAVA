package baaarkingDog.dp;

import java.util.*;

public class BOJ14002 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int[] cnt = new int[n];
        int[] prev = new int[n];
        Arrays.fill(cnt, 1);
        Arrays.fill(prev, -1);

        int mx = 0;
        int s = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(a[j] < a[i]) {
                    if(cnt[j]+1 > cnt[i]) {
                        cnt[i] = cnt[j] + 1;
                        prev[i] = j;
                    }
                }
            }
            if(mx < cnt[i]) {
                mx = cnt[i];
                s = i;
            }
        }

        System.out.println(mx);
        List<Integer> temp = new ArrayList<>();
        while(true) {
            temp.add(a[s]);
            s = prev[s];
            if(s == -1) {
                break;
            }
        }

        Collections.reverse(temp);
        for(int i : temp) {
            System.out.print(i + " ");
        }

    }
}
