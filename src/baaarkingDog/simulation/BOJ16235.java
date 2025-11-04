package baaarkingDog.simulation;

import java.util.*;

public class BOJ16235 {

    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int[][] a = new int[n][n];
        int[][] energy = new int[n][n];
        List<Integer>[][] treeMap = new ArrayList[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
                treeMap[i][j] = new ArrayList<>();
                energy[i][j] = 5;
            }
        }
        for(int i = 0; i < m; i++) {
            int y = sc.nextInt() - 1;
            int x = sc.nextInt() - 1;
            int age = sc.nextInt();
            treeMap[y][x].add(age);
        }

        while(k-- != 0) {



            // 봄
            List<Tree> death = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    Collections.sort(treeMap[i][j]);
                    List<Integer> temp = new ArrayList<>(); // 산 나무
                    for(int l = 0; l < treeMap[i][j].size(); l++) {
                        if(energy[i][j] >= treeMap[i][j].get(l)) {
                            energy[i][j] -= treeMap[i][j].get(l);
                            temp.add(treeMap[i][j].get(l) + 1);
//                            treeMap[i][j].set(l, treeMap[i][j].get(l)+1);
                        }
                        else {
                            death.add(new Tree(i, j, treeMap[i][j].get(l)));
                        }
                    }
                    treeMap[i][j] = temp;
                }
            }

            // 여름
            for(Tree tree : death) {
                energy[tree.y][tree.x] += tree.age / 2;
            }

            // 가을
            for(int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (int l = 0; l < treeMap[i][j].size(); l++) {
                        if(treeMap[i][j].get(l) % 5 == 0) {
                            for(int o = 0; o < 8; o++) {
                                int ny = i + dy[o];
                                int nx = j + dx[o];
                                if(ny < 0 || nx < 0 || ny >= n || nx >= n) {
                                    continue;
                                }
                                treeMap[ny][nx].add(1);
                            }
                        }
                    }
                }
            }

//            for(int i = 0; i < n; i++) {
//                for (int j = 0; j < n; j++) {
//                    System.out.print(energy[i][j] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println();

            // 겨울
            for(int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    energy[i][j] += a[i][j];
                }
            }
        }

        int ret = 0;
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ret += treeMap[i][j].size();
            }
        }

        System.out.println(ret);


    }

    static class Tree {
        int y;
        int x;
        int age;

        public Tree(int y, int x, int age) {
            this.y = y;
            this.x = x;
            this.age = age;
        }
    }
}
