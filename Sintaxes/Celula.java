package listaligada;

//Criação da classe Célila (Nó)
public class Celula {

    //Criação do atributo elemento, ou seja, o dado guardado no nó
    private Object elemento;

    //Criação da refêrencia do Nó posterior ao Nó atual
    private Celula proximo;

    //Criação da refêrencia do Nó anterior ao Nó atual
    private Celula anterior;


    //Método construtor, o Nó, que instancia o elemento que será guardado
    // e o Nó posterior
    public Celula(Object elemento, Celula proximo) {

        //adição do this para dar os dados aos atributos
        this.elemento = elemento;
        this.proximo = proximo;
    }

    //Outro método construtor, que aceita apenas o elemento, e deixa automaticamente o
    //proximo e anterior como null, usado para quando se cria uma célula que ainda
    //não está vinculada com as outras células
    public Celula(Object elemento){
        this.elemento = elemento;
        this.proximo = null;
        this.anterior = null;
    }

    //Get do atributo elemento
    public Object getElemento() {
        return elemento;
    }

    //Get do atributo próximo
    public Celula getProximo() {
        return proximo;
    }

    //Set do atributo próximo
    public void setProximo(Celula proximo) {
        this.proximo = proximo;
    }
    //Get do atributo anterior
    public Celula getAnterior() {
        return anterior;
    }

    //Set do atributo anterior
    public void setAnterior(Celula anterior) {
        this.anterior = anterior;
    }
}
