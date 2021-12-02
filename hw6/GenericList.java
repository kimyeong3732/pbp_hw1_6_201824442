package edu.pnu.collection;

public class GenericList<T> {
    private static final int DEFAULT_SIZE = 10;
    private Object[] data;
    private int size = 0;

    public GenericList() {
        data = new Object[DEFAULT_SIZE];
    }
    
    public GenericList(int size) {
        data = new Object[size];
    }

    public void add(T value) {
        data[size++] = value;
    }

    public T getValue(int index) {
        return (T) data[index];
    }

    public void clear() {
        for(; size>0; size--) {
            data[size-1] = null;
        }
    }

    public int getSize() {
        return size;
    }
}
