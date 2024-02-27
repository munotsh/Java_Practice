package com.example.cache;

import java.util.HashMap;
import java.util.LinkedList;

public class LRUCacheImpl {
    // Hash map to store the cache data
    // key as Integer and Value as String
    HashMap<Integer, String> map = new HashMap<Integer, String>();
    // Linked list to store the order of cache access
    LinkedList<Integer> linkedList = new LinkedList<Integer>();
    // size of the cache
    int capacity;

    LRUCacheImpl(int capacity) {
        this.capacity = capacity; // assigning the size of the cache while creating
    }

    // put - for adding new cache
    void put(int key, String val) {

        // Check if the cache is full by comparing the size of the list with capacity
        if (linkedList.size() >= capacity) {
            // if the cache is full, then remove the last element from the order list and
            // also from the data
            // so we will get room for new cache
            int keyRemoved = linkedList.removeLast(); // remove from order
            map.remove(keyRemoved);// remove from data
        }

        // add the new cache to top of the list and also to data
        linkedList.addFirst(key);// add to top of the list
        map.put(key, val);// add to data

    }

    // get
    String get(int key) {
        String res = map.get(key); //get the value from map using the key
        if(res != null) {
            //if the data is present then we need to update the access order
            //move the current key to top of the access list
            //to move to top of the list first remove it and re-add it
            linkedList.remove((Object) key);
            linkedList.addFirst(key);
        }else {
            //if value is not present in the cache then its a cache miss
            //and we will return null
            res = null;
        }

        return res;

    }

    // display method
    public void display() {

        for (int i = 0; i < linkedList.size(); i++) {
            int key = linkedList.get(i);
            System.out.println(key + " => " + map.get(key));
        }
    }

    public static void main(String[] args) {
        LRUCacheImpl cache = new LRUCacheImpl(3);
        cache.put(1, "one");
        cache.put(2, "two");
        cache.put(3, "three");
        cache.put(4, "four"); // putting new cache when full. 1 will be removed
        cache.get(3); // accessing 3, it will be moved to top
        cache.get(2);// accessing 2, it will be moved to top
        cache.put(1, "one"); // putting new cache when full. 4 will be removed
        cache.get(3);// accessing 3, it will be moved to top
        cache.get(1);// accessing 1, it will be moved to top
        cache.display(); // 1 should be on top
        /*
         * output
         * 1 => one
         * 3 => three
         * 2 => two
         *
         **/
    }

}
