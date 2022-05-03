package com.example.Array;

import java.util.HashMap;
import java.util.Map;

public class DotProductOfTwoSparseVectors {

    public static void main(String[] args) {
        int[] arr1 = {1, 0, 0, 2, 3};
        DotProductOfTwoSparseVectors d1 = new DotProductOfTwoSparseVectors(arr1);
        int[] arr2 = {0, 3, 0, 4, 0};
        DotProductOfTwoSparseVectors d2 = new DotProductOfTwoSparseVectors(arr2);
        System.out.println(d1.dotProduct(d2));
    }

    Map<Integer, Integer> indexValueMap;

    public DotProductOfTwoSparseVectors(int[] inputArray) {
        indexValueMap = new HashMap<>();
        for (int i = 0; i < inputArray.length; i++) {
            this.indexValueMap.put(i, inputArray[i]);
        }
    }

    public int dotProduct(DotProductOfTwoSparseVectors vec) {
        int product = 0;
        for (int key : indexValueMap.keySet()) {
            if (vec.indexValueMap.containsKey(key)) {
                product += vec.indexValueMap.get(key) * this.indexValueMap.get(key);
            }
        }
        return product;
    }
}
