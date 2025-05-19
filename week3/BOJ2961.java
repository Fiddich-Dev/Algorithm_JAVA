package week3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ2961 {
    static int n;
    // 신맛 곱
    static List<Integer> v1 = new ArrayList<>();
    // 쓴맛 합
    static List<Integer> v2 = new ArrayList<>();

    static int mn = 987654321;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for(int i = 0; i < n; i++) {
            int temp1 = sc.nextInt();
            int temp2 = sc.nextInt();

            v1.add(temp1);
            v2.add(temp2);
        }


        for(int i = 1; i < (1 << n); i++) {
            int sum1 = 1;
            int sum2 = 0;

            for(int j = 0; j < n; j++) {
                if((i & (1 << j)) != 0) {
                    sum1 *= v1.get(j);
                    sum2 += v2.get(j);
                }
            }
            mn = Math.min(mn, Math.abs(sum1 - sum2));
        }

        System.out.println(mn);
        
    }
}

// 비트 켜기
// num | (1 << n)

