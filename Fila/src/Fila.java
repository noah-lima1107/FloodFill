public class Fila {
    private int[] values;
    private int   first;
    private int   reference;
    private int   last;
    private int   total;
    public Fila() {
        values = new int[100];
        first  = 0;
        last   = 0;
        total  = 0;
        reference = 0;
    }
    public void insert(int e) {
        if (isFull()) {
            throw new RuntimeException("Fila cheia");
        }
        values[last] = e;
        last++;
        reference = last;
        total++;
    }
    public int remove() {
        if (isEmpty()) {
            throw new RuntimeException("Fila vazia");
        }
        int e = values[first];
        int i = 0;
        while (reference != 0) {
            values[first + i] = values[first + 1 + i];
            reference--;
            i++;
        }
        last--;
        reference = last;
        total--;
        return e;
    }
    public boolean isEmpty() {
        return (total == 0);
    }
    public boolean isFull() {
        return total == values.length;
    }
}
