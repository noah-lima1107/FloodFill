public class Pilha {
    int stackValues[];
    int top;
    public Pilha() {
        stackValues = new int[10];
        top = -1;
    }

    //empilhar
    public void push(int e) {
        if (isFull()) {
            throw new RuntimeException("Stack Overflow");
        }
        top++;
        stackValues[top] = e;

    }
    //desempilhar
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Empty Stack");
        }
        int e;
        e = stackValues[top];
        top--;
        return e;
    }

    public boolean isEmpty() {
        return (top == -1);
    }
    public boolean isFull() {
        return (top == stackValues.length - 1);
    }

    //retorna quem esta no topo
    public int top() {
        if (isEmpty()) {
            throw new RuntimeException("Empty Stack");
        }
        return stackValues[top];
    }
 }
