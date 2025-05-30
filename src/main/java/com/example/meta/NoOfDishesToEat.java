package com.example.meta;

import java.util.ArrayList;
import java.util.List;

public class NoOfDishesToEat {
//    Kaitenzushi
    public static int getMaximumEatenDishCount(int N, int[] D, int K) {

        int count =1;
        List<Integer> kList = new ArrayList<>();
        kList.add(D[0]);
        for(int i=1;i<N;i++){
            if(!kList.contains(D[i])){
                count++;
                if(kList.size()>=K){
                    kList.remove(0);
                }
                kList.add(D[i]);
            }
        }
        return count;
    }
    public static void main(String[] args){
//        int[] D = {1,2,3,3,2,1};
        int[] D = {1, 2, 1, 2, 1, 2, 1};
        System.out.println(getMaximumEatenDishCount(7,D,2));
    }
}
