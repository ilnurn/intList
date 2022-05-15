package service;

import exceptions.NotFoundException;

import java.util.Arrays;
import java.util.Objects;

public class IntListImpl implements IntList {

    private int[] array = new int[10];
    private int size = 0;

    @Override
    public int add(int item) {
        if (size >= array.length) {
            grow();
        }
        array[size] = item;
        size++;
        return item;
    }

    private void grow() {
        int[] extended = new int[array.length + array.length / 2];
        System.arraycopy(array, 0, extended, 0, array.length);
        array = extended;
    }

    @Override
    public int add(int index, int item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        increaseList();
        for (int i = size - 1; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = item;
        return item;
    }

    @Override
    public int set(int index, int item) {
        int old = get(index);
        array[index] = item;
        return old;
    }

    @Override
    public int removeByValue(int item) {
        int a = -1;
        for (int i = 0; i < size; i++) {
            if (item == array[i]) {
                a = i;
                break;
            }
        }
        if (a != -1) {
            removeByIndex(a);
        } else {
            throw new NotFoundException("Not found");
        }
        return item;
    }

    @Override
    public int removeByIndex(int index) {
        int element = get(index);
        for (int i = index; i < (size - 1); i++) {
            array[i] = array[i + 1];
        }
        size--;
        return element;
    }

    @Override
    public boolean contains(int item) {
        sortList(array);
        int min = 0;
        int max = this.size - 1;
        while (min <= max) {
            int middle = (min + max) / 2;
            if (item == this.get(middle)) {
                return true;
            }
            if (item < this.get(middle)) {
                max = middle - 1;
            } else {
                min = middle + 1;
            }
        }
        return false;
    }

    @Override
    public int indexOf(int item) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(item, array[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(int item) {
        int result = -1;
        for (int i = size - 1; i >= 0; i--) {
            if (array[i] == item) {
                result = i;
                break;
            }
        }
        return result;
    }

    @Override
    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }

    @Override
    public boolean equals(Object target, Object element) {
        if (target == null) {
            return element == null;
        } else {
            return target.equals(element);
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public void clear() {
        array = new int[10];
        size = 0;
    }

    @Override
    public int[] toArray() {
        int[] newArray = new int[this.size];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = this.get(i);
        }
        return newArray;
    }

    private void sortList(int[] arr) {
        if (arr.length < 2) {
            return;
        }
        int mid = arr.length / 2;
        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];

        for (int i = 0; i < left.length; i++) {
            left[i] = arr[i];
        }

        for (int i = 0; i < right.length; i++) {
            right[i] = arr[mid + i];
        }

        sortList(left);
        sortList(right);

        merge(arr, left, right);
    }

    private void merge(int[] arr, int[] left, int[] right) {

        int mainP = 0;
        int leftP = 0;
        int rightP = 0;
        while (leftP < left.length && rightP < right.length) {
            if (left[leftP] <= right[rightP]) {
                arr[mainP++] = left[leftP++];
            } else {
                arr[mainP++] = right[rightP++];
            }
        }
        while (leftP < left.length) {
            arr[mainP++] = left[leftP++];
        }
        while (rightP < right.length) {
            arr[mainP++] = right[rightP++];
        }
    }

    private void increaseList() {
        if (size == array.length) {
            int[] newList = new int[array.length + array.length/2];
            for (int i = 0; i < array.length; i++) {
                newList[i] = array[i];
            }
            array = newList;
        }
    }

    @Override
    public String toString() {
        return "elements=" + Arrays.toString(array) + ", size=" + size;
    }
}
