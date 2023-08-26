public class GenericStack<T> {
    private T[] data;
    private int topIndexLocation;
    public GenericStack(int defaultCapacity) {
        data = (T[]) new Object[defaultCapacity];
        topIndexLocation = -1;
    }
    public boolean isEmpty() {
        return (topIndexLocation == -1);
    }
    public boolean isFull() {
        return (topIndexLocation == data.length-1);
    }

    public void push(T value) {
        if (!isFull()) {
            topIndexLocation++;
            data[topIndexLocation] = value;
        } else {
            throw new IndexOutOfBoundsException("Stack is full");
        }

    }
    public int[] pop() {
        if (!isEmpty()) {
            data[topIndexLocation] = null;
            topIndexLocation--;
        } else {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        return new int[0];
    }
    public T top() {
        if (isEmpty()) return null;
        return data[topIndexLocation];
    }
    public int size() {
        return topIndexLocation+1;
    }
}
