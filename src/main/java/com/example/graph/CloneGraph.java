package com.example.graph;

import java.util.*;

public class CloneGraph {
    public  static void main(String[] args){
         /*
            Note : All the edges are Undirected
            Given Graph:
            1--2
            |  |
            4--3
        */
        CloneGraph cloneGraph = new CloneGraph();
        GraphNode node1 = new GraphNode(1);
        GraphNode node2 = new GraphNode(2);
        GraphNode node3 = new GraphNode(3);
        GraphNode node4 = new GraphNode(4);
        List<GraphNode> v = new ArrayList<>();
        v.add(node2);
        v.add(node4);
        node1.neighbors = v;
        v = new ArrayList<>();
        v.add(node1);
        v.add(node3);
        node2.neighbors = v;
        v = new ArrayList<>();
        v.add(node2);
        v.add(node4);
        node3.neighbors = v;
        v = new ArrayList<>();
        v.add(node3);
        v.add(node1);
        node4.neighbors = v;
        GraphNode root1 = cloneGraph.clone(node1);
    }
    Map<Integer,GraphNode> map = new HashMap<>();

    private GraphNode clone(GraphNode root) {
        if(root==null)return null;
        HashMap<Integer,GraphNode> hm =new HashMap<>();
        dfs(root,hm);

        return hm.get(1);
    }

    private void dfs(GraphNode root,HashMap<Integer,GraphNode> hm)
    {
        hm.put(root.val,new GraphNode(root.val));

        for(GraphNode nbr : root.neighbors)
        {
            if(!hm.containsKey(nbr.val))
                dfs(nbr,hm);

            hm.get(root.val).neighbors.add(hm.get(nbr.val));
        }
    }
}
