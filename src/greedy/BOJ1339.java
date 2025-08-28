package greedy;

import java.util.*;

public class BOJ1339 {

    static int[] a = new int[26];
    static List<Integer> arr = new ArrayList<>();


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i = 0; i < n; i++) {
            String s = sc.next();
            int cnt = 1;
            for(int j = s.length()-1; j >= 0; j--) {
                a[s.charAt(j) - 'A'] += cnt;
                cnt *= 10;
            }
        }

        for(int i = 0; i < 26; i++) {
            if(a[i] != 0) {
                arr.add(a[i]);
            }
        }

        Collections.sort(arr, Collections.reverseOrder());

        int ret = 0;
        int start = 9;
        for(int i : arr) {
            ret += i * start;
            start--;
        }

        System.out.println(ret);
    }
}
