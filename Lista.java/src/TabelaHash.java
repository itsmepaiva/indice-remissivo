import java.util.ArrayList;

public class TabelaHash {
    private int posicao;
    private ArrayList<ListaEncadeada<Palavra>> tabela;
    public int tamanho;
    private int quantidadeItens;


    // CONSTRUTOR
     public TabelaHash(int capacidade) {
        tabela = new ArrayList<>(capacidade);
        for (int i = 0; i < capacidade; i++) {
            tabela.add(new ListaEncadeada<>());
        }
        this.tamanho = capacidade;
        quantidadeItens = 0;
    }

    // FUNCAO HASH BASEADA NO ALFABETO 
    public int funcaoHash(Palavra palavra){
        String texto = palavra.getConteudo().toLowerCase();
        posicao = texto.charAt(0);
        posicao = (posicao - 97);
        return posicao;
    }

    //ADICIONAR NOVO ELEMENTO
    public void adicionar(Palavra palavra, int ocorrenciaLocal) {
        int indice = funcaoHash(palavra);
        ListaEncadeada<Palavra> lista = tabela.get(indice);
        if (!(lista.existeElemento(palavra))) { // Verifica se a palavra já está na lista
            lista.adicionarInicio(palavra);
            quantidadeItens++;
        }else {
            interarOcorrencia(palavra, ocorrenciaLocal);
        }
    }

    // BUSCA E RETORNA A LISTA INTEIRA DA CHAVE 
    public String buscar(Palavra palavra) {
        int indice = funcaoHash(palavra);
        ListaEncadeada<Palavra> lista = tabela.get(indice);
        return lista.toString();
    }

    //RETORNA APENAS A PALAVRA ESPECIFICA
    public String buscarUnico(Palavra palavra) {
        int indice = funcaoHash(palavra);
        ListaEncadeada<Palavra> lista = tabela.get(indice);
        return lista.buscarUnicaPalavra(palavra);
    }
 

    //REMOVE A PALAVRA
    public void remover(Palavra palavra) {
        int indice = funcaoHash(palavra);
        ListaEncadeada<Palavra> lista = tabela.get(indice);
        if (lista.existeElemento(palavra)) { // Remove a palavra se ela estiver na lista
            lista.removerDaPosicao(palavra);
            quantidadeItens--;
        } else {
            throw new IllegalArgumentException("Objeto nao existe.");
        }
    }

    //FUNCAO PARA INTERAR A LISTA DE OCORRENCIA
    public void interarOcorrencia(Palavra palavra, int ocorrenciaLocal){
        int indice = funcaoHash(palavra);
        ListaEncadeada<Palavra> lista = tabela.get(indice);
        No<Palavra> noAtual = lista.getInicio();
        while (noAtual != null) {
            if (noAtual.getElemento().getConteudo().equals(palavra.getConteudo())){
                break;
            }
            noAtual = noAtual.getProximo(); 
        }
        Palavra noLocal = noAtual.getElemento();
        if (!(noLocal.ocorrencia.contains(ocorrenciaLocal))){
            noLocal.ocorrencia.add(ocorrenciaLocal);
        }   
    }

    public String verificarOcorrencia(Palavra palavra){
        int indice = funcaoHash(palavra);
        ListaEncadeada<Palavra> lista = tabela.get(indice);
        No<Palavra> noAtual = lista.getInicio();
        while (noAtual != null) {
            if (noAtual.getElemento().getConteudo().equals(palavra.getConteudo())){
                break;
            }
            noAtual = noAtual.getProximo(); 
        }
        Palavra noLocal = noAtual.getElemento();
        return (palavra.getConteudo() + ": " + noLocal.ocorrencia);
    }

    //GETTERS
    public int getQuantidadeItens() {
        return quantidadeItens;
    }

}
