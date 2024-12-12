import java.util.ArrayList;

public class Palavra implements Conteudo {
    private String conteudo;
    public ArrayList<Integer> ocorrencia = new ArrayList<>();

    //metodo toString
    @Override
    public String toString() {
        return "Palavra [palavra=" + conteudo + ", ocorrencia=" + ocorrencia + "]";
    }


    //metodos acessores
    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    //metodos do array
    public void adicionarOcorrencia(int a){
        if(this.ocorrencia.contains(a) != true){
            this.ocorrencia.add(a);
        }else{
            System.out.println("Ja existente");
        }
    }

    public void listarOcorrencias(){
        System.out.print(this.conteudo + ": ");
    for (int i = 0; i < ocorrencia.size(); i++) {
        System.out.print(this.ocorrencia.get(i) + ", ");
        }
        System.out.println("");
    }

    //construtor
    public Palavra(String conteudo) {
        this.conteudo = conteudo;
    }
    
    
}
