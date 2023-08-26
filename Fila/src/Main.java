
public class Main {
    public static void main(String[] args) {
        Pilha p = new Pilha();
        Fila  f = new Fila();
        FloodFill flood = new FloodFill();
        int[][] matriz = {
                {1,1,1,1,1,1,1,1,1,0},
                {1,1,1,1,1,1,1,1,0,1},
                {1,1,1,1,1,1,1,0,1,1},
                {1,1,1,1,1,1,0,1,1,1},
                {1,1,1,1,1,0,1,1,1,1},
                {1,1,1,1,0,1,1,1,1,1},
                {1,1,1,0,1,1,1,1,1,1},
                {1,1,0,1,1,1,1,1,1,1},
                {1,0,1,1,1,1,1,1,1,1},
                {0,1,1,1,1,1,1,1,1,1}
        };

        flood.floodFill(matriz, 2,2,1,2);

    }
}