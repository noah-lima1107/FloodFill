public class FloodFill {
    public void impressao(int[][] matriz) {
        for (int l = 0; l < matriz.length; l++)  {
            for (int c = 0; c < matriz[0].length; c++)  {
                System.out.print(matriz[l][c] + " ");
            }
            System.out.println(" ");
        }
    }
    public int[][] floodFill(int[][] matriz, int linhaInicial, int colunaInicial,int cor, int novaCor) {
        GenericStack<int[]> pilha = new GenericStack<>(100);
        GenericFila<int[][]> fila = new GenericFila<>(100);

        int m = matriz.length;
        int n = matriz[0].length;

        int coordenadasAtuais = matriz[linhaInicial][colunaInicial];

        pilha.push(new int[]{linhaInicial, colunaInicial});

        while(!pilha.isEmpty()) {
            int[] curr = pilha.top();
            int i = curr[0];
            int j = curr[1];
            pilha.pop();
            if (matriz[i][j] == coordenadasAtuais) {
                matriz[i][j] = novaCor;
                if (i + 1 < m & matriz[i][j] != cor)
                    pilha.push(new int[]{i + 1, j});
                if (i - 1 >= 0 & matriz[i][j] != cor)
                    pilha.push(new int[]{i - 1, j});
                if (j + 1 < n & matriz[i][j] != cor)
                    pilha.push(new int[]{i, j + 1});
                if (j - 1 >= 0 & matriz[i][j] != cor)
                    pilha.push(new int[]{i, j - 1});
                fila.insert(matriz);
                int[][] value;
                value = fila.remove();
                impressao(value);
                System.out.println("---------------------");
                }

        }



        return matriz;
        }
    }

