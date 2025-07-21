package com.example.marqeta;

public class SetUsingArray {
    private static final int INITIAL_CAPACITY = 10;
    private Object[] elements;
    private int size;

    public SetUsingArray() {
        elements = new Object[INITIAL_CAPACITY];
        size = 0;
    }

    public void add(Object element) {
        if (!contains(element)) {
            ensureCapacity();
            elements[size++] = element;
        }
    }

    public void remove(Object element) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(element)) {
                // Shift elements left
                for (int j = i; j < size - 1; j++) {
                    elements[j] = elements[j + 1];
                }
                elements[--size] = null;
                return;
            }
        }
        throw new RuntimeException("Element not found: " + element);
    }

    public boolean contains(Object element) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(element)) return true;
        }
        return false;
    }

    public int size() {
        return size;
    }

    private void ensureCapacity() {
        if (size == elements.length) {
            Object[] newArray = new Object[elements.length * 2];
            System.arraycopy(elements, 0, newArray, 0, size);
            elements = newArray;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{ ");
        for (int i = 0; i < size; i++) {
            sb.append(elements[i]);
            if (i < size - 1) sb.append(", ");
        }
        sb.append(" }");
        return sb.toString();
    }


    public static void main(String[] args) {
        SetUsingArray set = new SetUsingArray();
        set.add("apple");
        set.add("banana");
        set.add("apple"); // duplicate ignored
        System.out.println(set.contains("banana")); // true
        set.remove("apple");
        System.out.println(set); // { banana }
        System.out.println("Size: " + set.size()); // 1
    }

}
