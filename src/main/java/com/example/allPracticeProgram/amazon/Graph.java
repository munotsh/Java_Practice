package com.example.allPracticeProgram.amazon;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Graph {
	
	private int V; // No. of vertices

    // Array  of lists for
    // Adjacency List Representation
    private LinkedList<Integer> adj[];

    // Constructor
    @SuppressWarnings("unchecked") Graph(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList<Integer>();
    }

    // Function to add an edge into the graph
    void addEdge(int v, int w)
    {
        adj[v].add(w); // Add w to v's list.
    }

    // A function used by DFS
    void DFSUtil(int v, boolean visited[])
    {
        // Mark the current node as visited and print it
        visited[v] = true;
        System.out.print(v + " ");

        // Recur for all the vertices adjacent to this
        // vertex
        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }

    // The function to do DFS traversal.
    // It uses recursive
    // DFSUtil()
    void DFS(int v)
    {
        // Mark all the vertices as
        // not visited(set as
        // false by default in java)
        boolean visited[] = new boolean[V];

        // Call the recursive helper
        // function to print DFS
        // traversal
        DFSUtil(v, visited);
    }
    
 // Prints all paths from
    // 's' to 'd'
    public void printAllPaths(int s, int d)
    {
        boolean[] isVisited = new boolean[V];
        ArrayList<Integer> pathList = new ArrayList<>();

        // add source to path[]
        pathList.add(s);

        // Call recursive utility
        printAllPathsUtil(s, d, isVisited, pathList);
    }
    
 // A recursive function to print
    // all paths from 'u' to 'd'.
    // isVisited[] keeps track of
    // vertices in current path.
    // localPathList<> stores actual
    // vertices in the current path
    
    private void printAllPathsUtil(Integer u, Integer d,
            boolean[] isVisited,
            List<Integer> localPathList)
{

if (u.equals(d)) {
System.out.println(localPathList);
// if match found then no need to traverse more till depth
return;
}

// Mark the current node
isVisited[u] = true;

// Recur for all the vertices
// adjacent to current vertex
for (Integer i : adj[u]) {
if (!isVisited[i]) {
// store current node
// in path[]
localPathList.add(i);
printAllPathsUtil(i, d, isVisited, localPathList);

// remove current node
// in path[]
localPathList.remove(i);
}
}

// Mark the current node
isVisited[u] = false;
}
    
    void connectedComponents()
    {
        // Mark all the vertices as not visited
        boolean[] visited = new boolean[V];
        for (int v = 0; v < V; ++v) {
            if (!visited[v]) {
                // print all reachable vertices
                // from v
                DFSUtil(v, visited);
                System.out.println();
            }
        }
    }

    // Driver Code
    public static void main(String args[])
    {
        Graph g = new Graph(4);

		/*
		 * g.addEdge(0, 1); g.addEdge(0, 2); g.addEdge(1, 2); g.addEdge(2, 0);
		 * g.addEdge(2, 3); g.addEdge(3, 3);
		 */

		/*
		 * g.addEdge(2, 0); g.addEdge(0, 2); g.addEdge(1, 2); g.addEdge(0, 1);
		 * g.addEdge(3, 3); g.addEdge(1, 3);
		 */
        
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(2, 0);
        g.addEdge(2, 1);
        g.addEdge(1, 3);
        
     // arbitrary source
        int s = 2;

        // arbitrary destination
        int d = 3;
        
        System.out.println(
                "Following are all different paths from "
                + s + " to " + d);
            g.printAllPaths(s, d);
        
//        System.out.println(
//            "Following is Depth First Traversal "
//            + "(starting from vertex 2)");
//
//        g.DFS(2);
            
            System.out.println(
                    "Following are connected components");
                g.connectedComponents();
    }

}
