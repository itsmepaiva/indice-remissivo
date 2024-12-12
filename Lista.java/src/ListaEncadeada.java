public class ListaEncadeada<T extends Conteudo> {
    private No<T> inicio;
    private No<T> ultimo;
    private int tamanho;
    private final int NAO_ENCONTRADO = -1;

        // METODOS DE ADICIONAR
    public void adicionarInicio(T elemento) {
        No<T> celula = new No<T>(elemento);
        celula.proximo = inicio;
        this.inicio = celula;
        this.tamanho ++;
    }
    public void adicionarNoFim(T elemento) {
        No<T> celula = new No<T>(elemento);
        if(this.tamanho == 0){
            this.inicio = celula;
        } else{
            this.ultimo.setProximo(celula);
        }
        this.ultimo = celula;
        this.tamanho ++;
    }

    // METODOS DE REMOÇAO
    public void retirarInicio(){
        if(this.tamanho == 0){
            throw new RuntimeException("Lista está vazia");
        }
        No<T> noLocal = inicio.getProximo();
        this.inicio.setElemento(null);
        this.inicio = noLocal;
        this.tamanho --;
    }

    public void removerDaPosicao(T elemento){       
        int posicao = buscarPorElemento(elemento);
        if (posicao < 0 || posicao >= tamanho) {
            throw new IndexOutOfBoundsException("Índice fora dos limites da lista.");
        }
        No<T> atual = inicio;
        No<T> anterior = null;
        for (int i = 0; i < posicao; i++) {
            anterior = atual;
            atual = atual.getProximo();
        }
        if (anterior == null) {
            inicio = atual.getProximo();
        } else {
            anterior.setProximo(atual.getProximo());
        tamanho--;
    }
    }

    public void limparLista(){
        for(No<T> atual = this.inicio; atual != null;){
            No<T> proximo = atual.getProximo();
            atual.setElemento(null);
            atual.setProximo(null);
            atual = proximo;
        }
        this.inicio = null;
        this.ultimo = null;
        this.tamanho = 0;
    }

    // TRANFORMAR EM STRING
    public String toString() {
        String str =  "Tamanho: " + tamanho + "/ elementos: ";
        No<T> local = inicio;
        while (local != null) {
            str += local.getElemento() + "; ";
            local = local.proximo;
        }
        return str;
    }

        // METODOS DE BUSCAS
    private No<T> buscaNo(int posicao){
        if (!(posicao >= 0 && posicao < this.tamanho)){
            throw new IllegalArgumentException("Posição nao existe.");
        }

        No<T> noAtual = this.inicio;
        for (int i = 0; i < posicao; i++) {
            noAtual = noAtual.getProximo();
        }
        return noAtual;
    }
    // BUSCAR: INSERE A POSIÇAO E RETORNA O ELEMENTO
    public T buscarPorPosicao(int posicao){
        return this.buscaNo(posicao).getElemento();
    }

    // RETORNA SE O ELEMENTO EXISTE OU NAO
    public boolean existe(int posicao){
        if (!(posicao >= 0 && posicao <= this.tamanho)){
            return false;
        } else{
            return true;
        }
    }
    //BUSCAR: INSERE O ELEMENTO E RETORNA A POSICAO
    public int buscarPorElemento(T elemento){
        No<T> noAtual = this.inicio;
        int pos = 0;
        
        while(noAtual != null){
            if (noAtual.getElemento().equals(elemento)){
                return pos;
            }
            pos++;
            noAtual = noAtual.getProximo();
        }

        return NAO_ENCONTRADO;
    }

    public boolean existeElemento(T elemento) {
        No<T> noAtual = this.inicio;
    
        while (noAtual != null) {
            if (noAtual.getElemento().getConteudo().equals(elemento.getConteudo())) {
                return true;
            }
            noAtual = noAtual.getProximo();
        }
    
        return false;
    }


    public String buscarUnicaPalavra(T elemento){
        int posicao = buscarPorElemento(elemento);
        if (posicao < 0 || posicao >= tamanho) {
            throw new IndexOutOfBoundsException("Índice fora dos limites da lista.");
        }
        No<T> atual = inicio;
        for (int i = 0; i < posicao; i++) {
            atual = atual.getProximo();        
        }String info = atual.getElemento().getConteudo(); 
        return info;
    }

    // GETTER
    public No<T> getInicio() {
        return inicio;
    }
    public int getTamanho() {
        return tamanho;
    }

    
}
