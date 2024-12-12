public class No<T extends Conteudo> {
    private T elemento;
    public No<T> proximo;
    
    //metodos acessores
    public T getElemento() {
        return elemento;
    }
    public void setElemento(T elemento) {
        this.elemento = elemento;
    }
    public No<T> getProximo() {
        return proximo;
    }
    public void setProximo(No<T> proximo) {
        this.proximo = proximo;
    }
    
    //construtor
    public No(T elemento) {
        this.elemento = elemento;
        this.proximo = null;
    }
    @Override
    public String toString() {
        return "No [elemento=" + elemento + ", proximo=" + proximo + "]";
    }

    
}
