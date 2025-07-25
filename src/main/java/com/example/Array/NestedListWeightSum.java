package com.example.Array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NestedListWeightSum {
    public int depthSum(List<NestedInteger> nestedList) {
        return recursive(nestedList, 1);
//      return iterative(nestedList, 1)
    }

    public int recursive(List<NestedInteger> nestedList, int depth){
        if(nestedList==null||nestedList.size()==0)
            return 0;
        int sum=0;
        for(NestedInteger ni: nestedList){
            if(ni.isInteger()){
                sum += ni.getInteger() * depth;
            }else{
                sum += recursive(ni.getList(), depth+1);
            }
        }
        return sum;
    }

    public int iterative(List<NestedInteger> nestedList) {
        int sum=0;
        LinkedList<NestedInteger> queue = new LinkedList<NestedInteger>();
        LinkedList<Integer> depth = new LinkedList<Integer>();
        for(NestedInteger ni: nestedList){
            queue.offer(ni);
            depth.offer(1);
        }
        while(!queue.isEmpty()){
            NestedInteger top = queue.poll();
            int dep = depth.poll();

            if(top.isInteger()){
                sum += dep*top.getInteger();
            }else{
                for(NestedInteger ni: top.getList()){
                    queue.offer(ni);
                    depth.offer(dep+1);
                }
            }
        }
        return sum;
    }


    class NestedInteger{
        List<NestedInteger> list;
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
