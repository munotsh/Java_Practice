package com.example.customImplementation;

public class CustomArrayList<E> {

	private Object[] array;
	public static final int DEFAULT_SIZE = 10;
	private int size = 0;

	public CustomArrayList() {
		this(DEFAULT_SIZE);
	}

	public CustomArrayList(int size) {
		array = new Object[size];
	}

	public void add(E element) {
		ensureCapacity();
		array[size++] = element;
	}

	public E remove(int index) {
		if (index >= size || index < 0) {
			throw new RuntimeException("Invalid index");
		}
		E element = (E) array[index];
		array[index] = null;
		--size;
		compress();
		return element;
	}

	public E get(int index) {
		if (index > size) {
			throw new RuntimeException("Invalid index");
		}
		E element = (E) array[index];
		return element;
	}

	public int size() {
		return this.size;
	}

	private void ensureCapacity() {
		if (size < array.length) {
			return;
		}
		resize();
	}

	private void resize() {
		Object[] temp = new Object[array.length * 2];
		copy(array, temp);
		array = temp;
	}

	private void copy(Object[] src, Object[] dest) {
		if (dest.length < src.length) {
			throw new RuntimeException(src + " cannot be copied into " + dest);
		}
		for (int i = 0; i < src.length; i++) {
			dest[i] = src[i];
		}
	}

	private void compress() {
		int skipCount = 0;
		for (int i = 0; i < size && i < array.length; i++) {
			if (array[i] == null) {
				++skipCount;
			}
			array[i] = array[i + skipCount];
		}
	}
	 public String toString() {
	        if (this.array.length == 0)
	            return "[]";

	        StringBuilder sb = new StringBuilder();
	        sb.append('[');
	        for (int i = 0; i< this.array.length;i++) {
	        	if(this.array[i] != null) {
	            sb.append(this.array[i] == this ? "(this Collection)" : this.array[i]);
	            sb.append(',').append(' ');
	        	}
	            if (this.array.length-1 == i) {
	            	String result = sb.substring(0, sb.length()-2); 
	                return result+']';
	            }
	        }
	        return sb.toString();
	    }
	 
	public static void main(String args[]) {
		CustomArrayList<Integer> list = new CustomArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		System.out.println(list);
	}
}
