package com.example.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BuildingsWithAnOceanView {
    public static void main(String[] args) {
        BuildingsWithAnOceanView buildingsWithAnOceanView = new BuildingsWithAnOceanView();
//        TC : O(n) SC : O(n)
//        int[] arr = {4,2,3,1};
//        OP : [0, 2, 3]
//        int[] arr = {4,3,2,1};
//        OP : [0, 1, 2, 3]
        int[] arr = {1,3,2,4};
//        OP : [3]
        System.out.println(Arrays.toString(buildingsWithAnOceanView.findBuildings(arr)));
    }

    private int[] findBuildings(int[] arr) {
        int max=arr[arr.length-1];
        List<Integer> result = new ArrayList<>();
        result.add(arr.length-1);
        for(int i = arr.length-2;i>=0;i--){
            if(arr[i]>max){
                max = arr[i];
                result.add(i);
            }
        }
        Collections.reverse(result);
        return result.stream().mapToInt(i->i).toArray();
    }
}
