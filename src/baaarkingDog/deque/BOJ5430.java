package baaarkingDog.deque;

import java.util.*;
import java.io.*;

public class BOJ5430 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int q = 0; q < t; q++) {
            String s = sc.next();
            int n = sc.nextInt();
            String arr = sc.next();
//            arr = arr.substring(1, arr.length()-1);
            String[] numbers = arr.split(",");

            Deque<Integer> dq = new ArrayDeque<>();

            int cur = 0;
            for(int i = 1; i < arr.length()-1; i++) {
                if(arr.charAt(i) == ',') {
                    dq.addLast(cur);
                    cur = 0;
                }
                else {
                    cur = cur * 10 + (arr.charAt(i) - '0');
                }
            }

            if(cur != 0) { // "[]"가 아닌 경우
                dq.addLast(cur);
            }

//            for(int i = 0; i < n; i++) {
//                dq.addLast(Integer.parseInt(numbers[i]));
//            }

            int flag = 0;
            boolean isError = false;

            for(char c : s.toCharArray()) {
                if(c == 'R') {
                    flag ^= 1;
                }
                else {
                    if(dq.isEmpty()) {
                        System.out.println("error");
                        isError = true;
                        break;
                    }

                    if(flag == 0) {
                        dq.pollFirst();
                    }
                    else {
                        dq.pollLast();
                    }
                }
            }

            StringBuilder sb = new StringBuilder();
            sb.append("[");

            if(flag == 0) {
                while(!dq.isEmpty()) {
                    sb.append(dq.pollFirst()).append(",");
                }
            }
            else {
                while(!dq.isEmpty()) {
                    sb.append(dq.pollLast()).append(",");
                }
            }
            if(!sb.toString().equals("[")) {
                sb.deleteCharAt(sb.length()-1);
            }
            sb.append("]");
            if(!isError) {
                System.out.println(sb);
            }
        }
    }
}
