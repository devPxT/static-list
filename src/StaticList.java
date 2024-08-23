import java.util.Arrays;

public class StaticList<T> {
    private T[] data;
    private int size;
    private int capacity;

    public StaticList(int capacity) {
        this.capacity = capacity;
        this.data = (T[]) new Object[capacity];
        this.size = 0;
    }

    public void clear() {
        // for (int i = 0; i < size; i++) {
        //     data[i] = null;
        // }
        Arrays.fill(data, null);
        size = 0;
    }

    public void add(T data) {
        if (isFull()) {
            throw new IllegalStateException("List is full");
        }
        this.data[size] = data;
        size++;
    }

    public void add(T data, int pos) {
        if (isFull()) {
            throw new IllegalStateException("List is full");
        }
        if (pos < 0 || pos > size) {
            throw new IndexOutOfBoundsException("Invalid position");
        }
        for (int i = size; i > pos; i--) {
            this.data[i] = this.data[i - 1];
        }
        this.data[pos] = data;
        size++;
    }

    public T remove(int pos) {
        if (pos < 0 || pos >= size) {
            throw new IndexOutOfBoundsException("Invalid position");
        }
        T removedData = this.data[pos];
        for (int i = pos; i < size - 1; i++) {
            this.data[i] = this.data[i + 1];
        }
        this.data[size - 1] = null;
        size--;
        return removedData;
    }

    public int remove(T data) {
        int index = find(data);
        if (index != -1) {
            remove(index);
        }
        return index;
    }

    public Boolean isEmpty() {
        return size == 0;
    }

    public Boolean isFull() {
        return size == capacity;
    }

    public void setData(T data, int pos) {
        if (pos < 0 || pos >= size) {
            throw new IndexOutOfBoundsException("Invalid position");
        }
        this.data[pos] = data;
    }

    public T getData(int pos) {
        if (pos < 0 || pos >= size) {
            throw new IndexOutOfBoundsException("Invalid position");
        }
        return this.data[pos];
    }

    public int getSize() {
        return this.size;
    }

    public int find(T data) {
        for (int i = 0; i < size; i++) {
            if (this.data[i].equals(data)) {
                return i;
            }
        }
        return -1; // Not found
    }
}
