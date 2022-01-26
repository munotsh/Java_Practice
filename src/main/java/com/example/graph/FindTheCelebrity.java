package com.example.graph;

public class FindTheCelebrity {


    private static final int[][] MATRIX = { {1, 0, 1},
                                            {0, 1, 1},
                                            {0, 0, 1}};

    public static void main(String[] args) {
        FindTheCelebrity findTheCelebrity = new FindTheCelebrity();
//        System.out.println(findTheCelebrity.findCelebrityWithBrutForce(3));
        System.out.println(findTheCelebrity.findCelebrity(3));
    }

    private int findCelebrity(int n) {
        int celebrity = 0;
        for(int i =1;i<n;i++){
            if(knows(celebrity,i)){
                celebrity = i;
            }
        }
        for(int i=0;i<n;i++){
            if(i != celebrity && knows(celebrity,i) && !knows(i,celebrity)){
                return  -1;
            }
        }
        return celebrity;
    }

    static boolean knows(int i, int j) {
        boolean res = (MATRIX[i][j] == 1) ? true :
                false;
        return res;
    }


//    public int findCelebrityWithBrutForce(int n) {
//        int celeb = 0;
//        for (int i = 0; i < n; i++) {
//            boolean flag = true;
//            for (int j = 0; j < n; j++) {
//                if (j != i) {
//                    if (knows(i, j) || !knows(j,i)) {
//                        flag = false;
//                        break;
//                    }
//                }
//            }
//            if(flag){
//                return i;
//            }
//        }
//        return -1;
//    }
}
