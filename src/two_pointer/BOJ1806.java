package two_pointer;

import java.util.*;

public class BOJ1806 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        List<Integer> a = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int temp = sc.nextInt();
            a.add(temp);
        }

        int[] psum = new int[100004];
        int sum = 0;
        for(int i = 0; i < n; i++) {
            sum += a.get(i);
            psum[i+1] = sum;
        }

        int ret = Integer.MAX_VALUE;

        int start = 0;
        int end = 0;
        while(true) {
            sum = psum[end] - psum[start];
            if(sum < s) {
                end++;
            }
            else {
                ret = Math.min(ret, end - start);
                start++;
            }

            if(end > n) {
                break;
            }
        }
        if(ret == Integer.MAX_VALUE) {
            System.out.println(0);
        }
        else {
            System.out.println(ret);
        }
    }

}
