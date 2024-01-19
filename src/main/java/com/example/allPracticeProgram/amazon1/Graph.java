package com.example.allPracticeProgram.amazon1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph {

	private int V; // No. of vertices
	private LinkedList<Integer> adj[]; // Adjacency Lists

	// Constructor
	Graph(int v) {
		V = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; ++i)
			adj[i] = new LinkedList();
	}

	void addEdge(int v, int w) {
		adj[v].add(w);
	}

	void BFS(int s) {
		// Mark all the vertices as not visited(By default set as false)
		boolean visited[] = new boolean[V];
		// Create a queue for BFS
		LinkedList<Integer> queue = new LinkedList<Integer>();
		// Mark the current node as visited and enqueue it
		visited[s] = true;
		queue.add(s);
		while (queue.size() != 0) {
			// Dequeue a vertex from queue and print it
			s = queue.poll();
			System.out.print(s + " ");
// Get all adjacent vertices of the dequeued vertex s If a adjacent has not been visited, then mark it
			// visited and enqueue it
			Iterator<Integer> i = adj[s].listIterator();
			while (i.hasNext()) {
				int n = i.next();
				if (!visited[n]) {
					visited[n] = true;
					queue.add(n);
				}
			}
		}
	}

	void DFSUtil(int v, boolean visited[]) {
		// Mark the current node as visited and print it
		visited[v] = true;
		System.out.print(v + " ");
		// Recur for all the vertices adjacent to this vertex
		Iterator<Integer> i = adj[v].listIterator();
		while (i.hasNext()) {
			int n = i.next();
			if (!visited[n])
				DFSUtil(n, visited);
		}
	}

	// The function to do DFS traversal. It uses recursive DFSUtil()
	void DFS(int v) {
		// Mark all the vertices as not visited(set as false by default in java)
		boolean visited[] = new boolean[V];
		// Call the recursive helper function to print DFS traversal
		DFSUtil(v, visited);
	}

	int countNodesAtLevel(int s, int l) {
		// Mark all the vertices as not visited
		boolean[] visited = new boolean[V];
		int[] level = new int[V];
		for (int i = 0; i < V; i++) {
			visited[i] = false;
			level[i] = 0;
		}
		// Create a queue for BFS
		Queue<Integer> queue = new LinkedList<>();
		// Mark the current node as visited and enqueue it
		visited[s] = true;
		queue.add(s);
		level[s] = 0;
		int count = 0;
		while (!queue.isEmpty()) {
			// Dequeue a vertex from queue and print it
			s = queue.peek();
			queue.poll();
			LinkedList<Integer> list = adj[s];
// Get all adjacent vertices of the dequeued vertex s. If a adjacent has not been visited, then mark it
			// visited and enqueue it
			for (int i : list) {
				if (!visited[i]) {
					visited[i] = true;
					level[i] = level[s] + 1;
					queue.add(i);
				}
			}
			count = 0;
			for (int i = 0; i < V; i++)
				if (level[i] == l)
					count++;
		}
		return count;
	}

	// Prints all paths from 's' to 'd'
	public void printAllPaths(int s, int d) {
		boolean[] isVisited = new boolean[V];
		ArrayList<Integer> pathList = new ArrayList<>();
		// add source to path[]
		pathList.add(s);
		// Call recursive utility
		printAllPathsUtil(s, d, isVisited, pathList);
	}

	// A recursive function to print all paths from 'u' to 'd'. isVisited[] keeps track of
	// vertices in current path. localPathList<> stores actual vertices in the current path
	private void printAllPathsUtil(Integer u, Integer d, boolean[] isVisited, List<Integer> localPathList) {
		if (u.equals(d)) {
			System.out.println(localPathList);
			// if match found then no need to traverse more till depth
			return;
		}
		// Mark the current node
		isVisited[u] = true;
		// Recur for all the vertices adjacent to current vertex
		for (Integer i : adj[u]) {
			if (!isVisited[i]) {
				// store current node in path[]
				localPathList.add(i);
				printAllPathsUtil(i, d, isVisited, localPathList);
				// remove current node in path[]
				localPathList.remove(i);
			}
		}
		// Mark the current node
		isVisited[u] = false;
	}

	void connectedComponents() {
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

	void delEdge(int u, int v) {
// Traversing through the first vector list and removing the second element from it
		for (int i = 0; i < adj[u].size(); i++) {
			if (adj[u].get(i) == v) {
				adj[u].remove(i);
				break;
			}
		}
// Traversing through the second vector list and removing the first element from it
		for (int i = 0; i < adj[v].size(); i++) {
			if (adj[v].get(i) == u) {
				adj[v].remove(i);
				break;
			}
		}
	}

	public static void main(String[] args) {
		Graph g = new Graph(4);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);
		System.out.println("Following is Breadth First Traversal " + "(starting from vertex 2)");
		g.BFS(2);
		System.out.println();
		g.DFS(2);
		System.out.println();
		int level = 2;
		System.out.println(g.countNodesAtLevel(0, level));
		int s = 0;// arbitrary source
		int d = 3;// arbitrary destination
		System.out.println("Following are all different paths from " + s + " to " + d);
		g.printAllPaths(s, d);
		g.connectedComponents();
		g.delEdge(0, 1);
	}
}
