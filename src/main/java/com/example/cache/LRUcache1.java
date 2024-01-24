package com.example.cache;

import java.util.HashMap;
import java.util.Map;

public class LRUcache1 {
	class Node {
	    public int key;
	    public int val;
	    public Node next;
	    public Node prev;

	    public Node(int key, int val) {
	        this.key = key;
	        this.val = val;
	        next = null;
	        prev = null;
	    }
	}
	 private Map<Integer, Node> cache;
	    private Node head;
	    private Node tail;
	    private int capacity;

	    public LRUcache1(int capacity) {
	        this.capacity = capacity;
	        cache = new HashMap<>();
	        head = new Node(-1, -1);
	        tail = new Node(-1, -1);
	        head.next = tail;
	        tail.prev = head;
	    }

	    private void deleteNode(Node node) {
	        Node prev = node.prev;
	        Node next = node.next;
	        prev.next = next;
	        next.prev = prev;
	    }

	    private void addNode(Node newNode) {
	        Node temp = head.next;
	        head.next = newNode;
	        newNode.prev = head;
	        newNode.next = temp;
	        temp.prev = newNode;
	    }

	    public int get(int key) {
	        if (!cache.containsKey(key))
	            return -1;

	        Node node = cache.get(key);
	        deleteNode(node);
	        addNode(node);
	        cache.put(key, head.next);
	        return head.next.val;
	    }

	    public void put(int key, int value) {
	        if (cache.containsKey(key)) {
	            Node node = cache.get(key);
	            deleteNode(node);
	            node.val = value;
	            addNode(node);
	            cache.put(key, head.next);
	        } else {
	            if (cache.size() == capacity) {
	                Node prev = tail.prev;
	                deleteNode(prev);
	                cache.remove(prev.key);
	                Node newNode = new Node(key, value);
	                addNode(newNode);
	                cache.put(key, head.next);
	            } else {
	                Node newNode = new Node(key, value);
	                addNode(newNode);
	                cache.put(key, head.next);
	            }
	        }
	    }
	    
	    public static void main(String[] args) {
	    	LRUcache1 lrUcache = null;
	    	String[] strArr = {"LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"};
	    	int[][] value = {{1},{1,1},{2,2},{1},{3,3},{2},{4,4},{2},{3},{4}};
	    	for(int i=0;i<strArr.length;i++) {
	    		if(strArr[i].equals("LRUCache")) {
	    			lrUcache = new LRUcache1(value[i][0]);
	    		}
	    		else if(strArr[i].equals("get")) {
	    			lrUcache.get(value[i][0]);
	    		}
	    		else {
	    			lrUcache.put(value[i][0], value[i][1]);
	    		}
	    	}
	    	System.out.println(value);
	    }

}
