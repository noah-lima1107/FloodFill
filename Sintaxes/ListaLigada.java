package listaligada;

public class ListaLigada {

    //Atributos para a primeira célula da lista
    //Null porque numa lista vazia não tem uma primeira Celula
    private Celula primeira = null;

    //Null porque numa lista vazia não tem uma ultima Celula
    private Celula ultima = null;

    //Atributo para contar a quantidades de células na lista
    private int totalElementos = 0;

    //Método para adicionar uma Célula no começo da lista, indicando o elemento
    public void adicionaComeco(Object elemento){
        //Verificação se caso a lista estar vazia, é criado uma nova célula e indica
        //que ela eh a primeira e a última, obviamente
        if (this.totalElementos == 0){
            Celula nova = new Celula(elemento);
            this.primeira = nova;
            this.ultima = nova;

        //Verificação para que se já existe Células na lista, é criada uma nova Célula
        } else {
            Celula nova = new Celula(elemento);

            //Setando que o próximo dessa nova célula criada, era a Célula que estava
            //como primeira
            nova.setProximo(this.primeira);

            //Setando que da Célula, que ainda está como primeira, que a seta anterior
            //a ela, é a a Célula "nova" adicionada no começo
            this.primeira.setAnterior(nova);

            //Finalmente attribuindo que a Célula "nova" agora é a primeira
            this.primeira = nova;
        }

        //Uma Célula foi adicionada, logo o tamanho aumentou +1
        this.totalElementos++;
    }

    //Override do Método existente no Java toString(), para mostrar na tela de uma forma
    //mais clara (toString puro é todo zuado)
    @Override
    public String toString() {

        //Aqui mostrando que caso seja uma lista vazia, que ele mostre apenas os colchetes
        if (this.totalElementos == 0){
            return "[]";
        }

        //Aqui é criado uma referência "atual" para apontar para a primeira Célula da lista
        Celula atual = primeira;

        //Método para construir a representação da lista como String
        StringBuilder builder = new StringBuilder("[");

        //Loop que faça com que seja iterado dee todas as células da lista, obtendo o
        //elemento de cada célula e adicionando ao "StringBuilder"
        for (int i = 0; i < totalElementos; i++){
            builder.append(atual.getElemento());
            builder.append(" , ");
            atual = atual.getProximo();
        }

        //Colchete no final
        builder.append("]");

        //Retorna a string feita
        return builder.toString();
    }

    //Método com que seja adicionado um elemento no final da lista
    public void adicionaFim(Object elemento) {

        //Verificação para caso a lista esteja vazia, apenas chama o método de
        //adicionar no começo
        if (this.totalElementos == 0){
            adicionaComeco(elemento);
        } else {

            //Caso tenha itens, criamos uma nova Célula
            Celula nova = new Celula(elemento);

            //Pegamos a Célula atual como a última, e setamos sua referência de próximo
            //para a "nova" Célula criada (que queremos colocar em ultimo)
            this.ultima.setProximo(nova);

            //Setamos que o anterior da "nova" última célula, era a antiga última Célula
            // (agora penúltima)
            nova.setAnterior(this.ultima);

            //Setamos a "nova" Célula criada como última
            this.ultima = nova;

            //Incrementação
            this.totalElementos++;
        }

    }


    //Método privado que verifica se uma posição está ocupada
    private boolean posOcupada(int posicao){

        //retorna um falso ou verdadeira, caso a posição escrita for maior que 0
        //e menor que o total da lista
        return posicao >= 0 && posicao < this.totalElementos;
    }

    //Método privado que obtém a célula em uma posição específica da lista
    //, dada sua posição
    private Celula pegaCelula(int pos){
        //Verificação que a posição escrita está ocupada, mandando um erro,
        //caso digite uma posição impossível
        if (!posOcupada(pos)){
            throw new IllegalArgumentException("NAO!");
        }

        //Cria uma refêrencia "atual" da primeira Célula
        Celula atual = primeira;

        //Loop para iterar cada célula, percorrendo desde o inicio até a posição (pos)
        //que foi indicada a ele
        for (int i = 0; i < pos; i++){
            atual = atual.getProximo();
        }

        //Quando achar a Célula, ou seja, chegar até o final do loop, ele retorna a Célula
        return atual;
    }

    //Método para adicionar uma Célula no meio da lista, dando sua posição
    public void adicionaMeio(int posicao, Object elemento){

        //Verificando caso queira adicionar na primeira posição
        //simplesmente é só chamar o método adicionarComeco
        if (posicao == 0){
            adicionaComeco(elemento);

        //Verificando caso queria adicionar na última posição
        //simplesmente é só chamar o método adicionarFim
        } else if (posicao == this.totalElementos){
            adicionaFim(elemento);

        //Caso a posição dada nao for a primeira nem a última da lista
        } else {

            //Você obtém a célula anterior à posição desejada, ou seja,
            //a célula na posição (posicao - 1) chamando o método pegaCelula.
            //Isso é feito porque você deseja inserir a nova célula
            //entre a célula atual na posição posicao e a célula anterior a ela.
            Celula anterior = this.pegaCelula(posicao - 1);

            //E a referenciamos a célula para próximo, sendo com a próxima da que
            // pegamos como anterior, resumindo estamos abrindo um espaço no meio
            //de 2 células para adicionar a próxima
            Celula proxima = anterior.getProximo();

            //Aqui, você cria uma nova célula (nova) com o elemento fornecido
            //e define o próximo da nova célula
            //como a célula que estava na posição "6", ou seja,
            //a célula que originalmente estava na posição "6"
            //agora se torna o próximo da nova célula.
            Celula nova = new Celula(elemento, anterior.getProximo());

            //Setamos que a "nova" Célula vai ter o anterior, sendo a anterior que
            //indicamos acima
            nova.setAnterior(anterior);

            //Atirbuindo que agora na Célula anterior a essa adicionada, o próximo,
            //é a própria Célula adicionada
            anterior.setProximo(nova);

            //E que da Célula posterior a dessa adiocionada, sua referencia de anterior
            // e a nossa "nova" Célula
            proxima.setAnterior(nova);

            //Incrementação do contador pois foi adicinado uma célula
            this.totalElementos++;
        }

    }

    //Método para pegar o atributo elemento da Célula
    public Object pega(int posicao){

        //Retorna o elemento (getElemento), usando o método que pega uma célula
        //com a posição fornecida (this.pegaCelula(posicao))
        return this.pegaCelula(posicao).getElemento();
    }

    //Método para remover uma Célula do começo (Inicio de FIlas)
    public void removeComeco(){

        //Verificando para que se a lista estiver vazia, não seja possível realizar a ação
        if (this.totalElementos == 0){
            throw new IllegalArgumentException("Não!");
        }

        //Removendo de tal jeito, ele pega qual a primeira Célula da lista,
        //e indica que agora, a primeira na verdade é a próxima Célula de this.primeira
        //fazendo com a que era, incialmente, a primeira, seja jogada no VACUO
        this.primeira = this.primeira.getProximo();

        //Redução do contador pois foi removido uma célula
        this.totalElementos--;

        //Verificação para caso, depois dessa remoção, a lista ficar vazia, ou seja,
        //a lista tinha apenas uma Célula e acabamos de tirar esta Célula, a última Célula
        //não exista
        if (this.totalElementos == 0){
            this.ultima = null;
        }

    }

    //Método que remove a última Célula
    public void removeFim(){

        //Verificação de que se existe apenas um item na lista, apenas chamamos o
        //método de remover o começo
        if (this.totalElementos == 1){
            removeComeco();
        } else {

            //Caso tenha mais itens, primeiro pegamos a penúltima Célula
            Celula penultima = this.ultima.getAnterior();

            //Setamos que agora a penúltima não tem referencia da próxima Célula,
            //ou seja, foi pro VÁCUO
            penultima.setProximo(null);

            //Atribuimos que a última agora é a penúltima
            this.ultima = penultima;

            //Redução pelo removimento
            this.totalElementos--;
        }
    }

    //Método para remover, sendo forneceido a posição para qual Célula remover
    public void remove(int posicao){

        //Verificação para que se a posição indicada seja a primeira, ela remove do começo
        if (posicao == 0){
            this.removeComeco();

        //Mesma coisa que antes mas para a última posição
        } else if (posicao == this.totalElementos -1){
            this.removeFim();
        } else {

            //Caso deseje remover alguma Célula do meio, primeiro precisamos referenciar,
            //uma célula anterior, pegando a célula anterior a da que queremos remover
            Celula anterior = this.pegaCelula(posicao - 1);

            //Indicamos a célula que queremos remover
            Celula atual = anterior.getProximo();

            //Indicamos a célula próxima, ou seja, estamos abrindo esse meio
            Celula proxima = atual.getProximo();

            //Agora, vamos jogar no vácuo a Célula atual, indicando que o próximo da
            //anterior é o próximo da removida e que o anterior da próxima e o anterior
            //da que queremos remover
            anterior.setProximo(proxima);
            proxima.setAnterior(anterior);

            //Redução
            this.totalElementos--;
        }
    }

    //Método para pegar o tamanho da lista
    public int tamanho(){
        return this.totalElementos;
    }

    //Método para ver se contém o elemento, tipo "pesquisar" o elemento na lista
    public boolean contem(Object elemento){

        //Indicamos uma Célula atual como a primeira
        Celula atual = this.primeira;

        //Loop para percorrer a lista toda
        while (atual != null){

            //Verificação do elemento
            if (atual.getElemento().equals(elemento)){
                return true;
            }

            atual = atual.getProximo();
        }
        return false;
    }

}
