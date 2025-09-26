package baaarkingDog.sort;

import java.util.*;

public class BOJ11652 {


        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            long[] a = new long[n];
            Map<Long, Integer> map = new HashMap<>();

            for(int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
            }

            Arrays.sort(a);

            for (int i = 0; i < n; i++) {
                long num = a[i];
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

            int mx = -1;
            long ret = 0;

            for(Map.Entry<Long, Integer> entry : map.entrySet()) {
                if(entry.getValue() > mx) {
                    mx = entry.getValue();
                    ret = entry.getKey();
                }
            }

            System.out.println(ret);

        }


//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        long[] a = new long[n];
//        for(int i = 0; i < n; i++) {
//            a[i] = sc.nextLong();
//        }
//
//        Arrays.sort(a);
//
//        long prev = 0;
//        long ret = 0;
//        int cnt = 0;
//        int mx = 0;
//
//        for(int i = 0; i < n; i++) {
//            if(prev != a[i]) {
//                if(cnt > mx) {
//                    mx = cnt;
//                    ret = prev;
//                }
//                cnt = 1;
//                prev = a[i];
//            }
//            else {
//                cnt++;
//            }
//        }
//
//        if(cnt > mx) {
//            ret = prev;
//        }
//
//        System.out.println(ret);
//
//    }
}
