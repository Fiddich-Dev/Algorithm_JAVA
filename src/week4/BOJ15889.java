package week4;

import java.util.*;

public class BOJ15889 {
    
    static int n;
    // 위치
    static List<Integer> a = new ArrayList<>();
    // 마지막 사람 제외 사거리
    static List<Integer> b = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for(int i = 0; i < n; i++) {
            int temp = sc.nextInt();
            a.add(temp);
        }

        for(int i = 0; i < n-1; i++) {
            int temp = sc.nextInt();
            b.add(temp);
        }

        int e = 0;

        for(int i = 0; i < n-2; i++) {
            e += b.get(i);
            if(e >= a.get(i+1)) {
                e = Math.max(e, a.get(i+1) + b.get(i+1));
            }
            else {
                System.out.println("엄마 나 전역 늦어질 것 같아");
                return;
            }
        }

        System.out.println("권병장님, 중대장님이 찾으십니다");
    }
}


// 위치에서 시작해서 사거리 만큼 라인을 그리며 라인 스위핑
