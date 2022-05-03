package com.example.Array;

import java.util.ArrayList;
import java.util.List;

public class NestedListWeightSumII {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        int height = getHeight(nestedList);
        return ds(nestedList, height);
    }
    private int getHeight(List<NestedInteger> nestedList) {
        int height = 1;
        for (NestedInteger ni:nestedList) {
            if (!ni.isInteger()) {
                int tmp = getHeight(ni.getList());
                height = Math.max(height, tmp + 1);
            }
        }
        return height;
    }
    private int ds(List<NestedInteger> nestedList, int level) {
        int sum = 0;
        for (NestedInteger ni:nestedList) {
            if (ni.isInteger()) {
                sum += level * ni.getInteger();
            }
            else {
                sum += ds(ni.getList(), level - 1);
            }
        }
        return sum;
    }


    class NestedInteger{
        List<NestedListWeightSum.NestedInteger> list;
        public NestedInteger(){
            list = new ArrayList<>();
        }
        public boolean isInteger(){
            return true;
        }
        public int getInteger() {
            return 0;
        }
        public List<NestedInteger> getList() {
            return null;
        }
    }
}
