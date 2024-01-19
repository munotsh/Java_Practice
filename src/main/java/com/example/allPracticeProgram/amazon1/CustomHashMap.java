package com.example.allPracticeProgram.amazon1;

public class CustomHashMap<K, V> {

	private Entry<K, V>[] table;

	static class Entry<K, V> {
		K key;
		V value;
		Entry<K, V> next;

		Entry(K key, V value) {
			this.key = key;
			this.value = value;
		}

		Entry(K key, V value, Entry<K, V> next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}

	private static int DEFAULT_CAPACITY = 16;
	private int capacity;

	CustomHashMap() {
		this(DEFAULT_CAPACITY);
	}

	CustomHashMap(int capacity) {
		this.capacity = capacity;
		this.table = new Entry[capacity];
	}

	public void put(K key, V value) {
		if (key == null) {
			return;
		}

		Entry<K, V> newEntry = new Entry<>(key, value);
		int hash = hash(key);
		if (table[hash] == null) {
			table[hash] = newEntry;
		} else {
			Entry<K, V> current = table[hash];
			Entry<K, V> previous = null;
			while (current != null) {
				if (current.key.equals(key)) {
					current.value = newEntry.value;
					return;
				}
				previous = current;
				current = current.next;
			}
			previous.next = newEntry;
		}
	}

	public V get(K key) {
		if (key == null) {
			return null;
		}
		int hash = hash(key);
		if (table[hash] == null) {
			return null;
		} else {
			Entry<K, V> current = table[hash];
			while (current != null) {
				if (current.key.equals(key)) {
					return current.value;
				}
				current = current.next;
			}
		}
		return null;
	}

	private int hash(K key) {
		return Math.abs(key.hashCode()) % capacity;
	}
	
	
	public boolean remove(K deleteKey){
	       
	       int hash=hash(deleteKey);
	              
	      if(table[hash] == null){
	            return false;
	      }else{
	        Entry<K,V> previous = null;
	        Entry<K,V> current = table[hash];
	        
	        while(current != null){ //we have reached last entry node of bucket.
	           if(current.key.equals(deleteKey)){               
	               if(previous==null){  //delete first entry node.
	                     table[hash]=table[hash].next;
	                     return true;
	               }
	               else{
	                     previous.next=current.next;
	                   return true;
	               }
	           }
	           previous=current;
	             current = current.next;
	          }
	        return false;
	      }
	    
	    }
	
	
	 public K contains(K key){
	        int hash = hash(key);
	        if(table[hash] == null){
	         return null;
	        }else{
	         Entry<K,V> temp = table[hash];
	         while(temp!= null){
	             if(temp.key.equals(key))
	                 return key;
	             temp = temp.next; //return value corresponding to key.
	         }         
	         return null;   //returns null if key is not found.
	        }
	    }

	 
	 public void displaySet(){
	       
	       for(int i=0;i<capacity;i++){
	           if(table[i]!=null){
	                  Entry<K, V> entry=table[i];
	                  while(entry!=null){
	                        System.out.print(entry.key+" ");
	                        entry=entry.next;
	                  }
	           }
	       }             
	    
	    }
	 
	 
	 
	public static void main(String[] args) {
		CustomHashMap<String, Integer> likesPerPost = new CustomHashMap<String, Integer>();
		likesPerPost.put("Learning Hash Map", 5);
		System.out.println(likesPerPost.get("Learning Hash Map"));
		System.out.println(likesPerPost.remove("Learning Hash Map"));
	}
}
