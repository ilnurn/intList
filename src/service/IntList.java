package service;

public interface IntList {

    int add(int item);

    int add(int index, int item);

    int set(int index, int item);

    int removeByValue(int item);

    int removeByIndex(int index);

    boolean contains(int item);

    int indexOf(int item);

    int lastIndexOf(int item);

    int get(int index);

    boolean equals(Object target, Object element);

    int size();

    boolean isEmpty();

    void clear();

    int[] toArray();

    String toString();
}
