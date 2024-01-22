package com.example.systemDesign.inMemoryKeyValueDataStore;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class TransactionKVStore {

    // get -> just return from the store
    // begin -> just adds a new hashMap to the stack
    // Commit -> take all the stuff in transactional Stack and dump it into store
    // Rollback -> clears transactional stack
    // Set -> updates the transactional stack but not the store.
    // delete -> remove from store if not part of transaction, else remove the key from curr transaction.

    Map<String, String> store;
    Stack<Map<String, String>> transactionalStack;

    public TransactionKVStore() {
        store = new HashMap<>();
        transactionalStack = new Stack<>();
    }

    void begin() {
        transactionalStack.push(new HashMap<>());
    }


    String get(String key) {
//        String value = "value doesnt exist";
//        if (store.containsKey(key)) {
//            value = store.get(key);
//        } else if (!transactionalStack.empty()) {
//            value = transactionalStack.stream().filter(e -> e.containsKey(key))
//                    .peek(e -> e.get(key)).findFirst().get().get(key);
//        }
//        return value;
        return store.get(key);
    }

    void set(String key, String val) {
        if (transactionalStack.isEmpty()) {
            store.put(key, val);
            return;
        }

        Map<String, String> curr = transactionalStack.peek();
        curr.put(key, val);
    }

    void commit() {
        if (transactionalStack.isEmpty()) {
            throw new RuntimeException("Stack is empty nothing to commit");
        }
        Map<String, String> curr = transactionalStack.pop();
        store.putAll(curr);
    }

    void rollback() {
        if (transactionalStack.isEmpty()) {
            throw new RuntimeException("Nothing to rollback");
        }
        transactionalStack.pop();

    }

    void delete(String key) {
        if (!transactionalStack.isEmpty()) {
            store.remove(key);
        }
        transactionalStack.peek().remove(key);
    }


    public static void main(String[] arg) {
        TransactionKVStore obj = new TransactionKVStore();
        obj.begin();
        obj.set("Shailesh", "Shailesh");
        obj.commit();
        obj.begin();
        obj.set("Neha", "Neha");
        obj.commit();
        System.out.println("get : " + obj.get("Shailesh"));
        System.out.println("get : " + obj.get("Neha"));
    }
}
