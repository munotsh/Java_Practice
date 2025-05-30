package com.example.meta;

public class OpenRotaryLockWithPasscode {
    public static long getMinCodeEntryTime(int N, int M, int[] C) {
        int start = 1;
        int ans = 0;

        for(int num:C){
//            int dis = Math.abs(start-num);
//            ans +=Math.min(dis,N-dis);
//            start = num;
//            ans += Math.min(Math.abs(start-num), Math.min(N-start+num, N-num+start);
//            start = num;
            if (Math.abs(num - start) > N/2){
                ans+= ((Math.min(num,start) + N) - Math.max(num,start));
            }
            else{
                ans+=Math.abs(num-start);
            }

            start = num;


        }
        return ans;
    }
//    private static int getTime(int from, int to, int N){
//        return Math.min(Math.abs(from-to), Math.min(N-from+to, N-to+from) );
//    }
    public static void main(String[] args){
        int[] C = {1, 2, 3};
        System.out.println(getMinCodeEntryTime(3,3,C));
//        int[] C = {9, 4, 4, 8};
//        System.out.println(getMinCodeEntryTime(10,4,C));
//        int[] C = {7,3,9};
//        System.out.println(getMinCodeEntryTime(10,3,C));
    }
}
