package com.example.cache;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUcache1 {

    int capacity;
    Map<Integer, Integer> map = new LinkedHashMap<>();

    public LRUcache1(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Integer val = map.get(key);
            map.remove(key);

            map.put(key, val);
            return map.get(key);
        } else return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.remove(key);
            map.put(key, value);
        } else {
            if (map.size() < capacity) {
                map.put(key, value);
            } else {
                // removing first element in the map.
                Iterator<Integer> iterator = map.keySet().iterator();
                map.remove(iterator.next());
                map.put(key, value);
            }
        }
    }

    public void print() {
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            System.out.println(e.getValue());
        }
    }

    public static void main(String[] args) {
        LRUcache1 lrUcache = null;
        String[] strArr = {"LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"};
        int[][] value = {{1}, {1, 1}, {2, 2}, {1}, {3, 3}, {2}, {4, 4}, {2}, {3}, {4}};
        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i].equals("LRUCache")) {
                lrUcache = new LRUcache1(value[i][0]);
            } else if (strArr[i].equals("get")) {
                lrUcache.get(value[i][0]);
            } else {
                lrUcache.put(value[i][0], value[i][1]);
            }
        }
        lrUcache.print();
    }

}
