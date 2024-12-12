//integrantes: Savio Paiva - 2323767; Filipe Victor - 2326345; Nicolas de Oliveira - 2323763; Rodolfo Pacheco - 2327314; Savio Almeida - 2326279; Yan Levi - 2326248

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class App {
    public static void main(String[] args) throws IOException {
    
    // CRIANDO A TABELA COM AS PALAVRAS DO TEXTO
        String caminhoArquivo = "Lista.java\\src\\textoEntrada.txt";
            
        List<Palavra> listaPalavras = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            int ocorrenciaLocal = 0; 
                
            // Ler o arquivo linha por linha
            while ((linha = br.readLine()) != null) {
                ocorrenciaLocal ++;
                // Dividir a linha em palavras, ignorando símbolos de pontuação
                String[] palavras = linha.toLowerCase().replaceAll("[^a-zA-Z0-9\\s]", "").split("\\s+");

                // Criar um objeto Palavra para cada palavra e adicionar à lista
                for (String p : palavras) {
                    if (!p.isEmpty()) {
                        Palavra palavra = new Palavra(p);
                        listaPalavras.add(palavra);
                        palavra.ocorrencia.add(ocorrenciaLocal);
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        TabelaHash t1 = new TabelaHash(26);
        if (!listaPalavras.isEmpty()) {
            for (Palavra palavra : listaPalavras) {
                int ocorrenciaLocal = palavra.ocorrencia.get(0);
                t1.adicionar(palavra, ocorrenciaLocal);  // Cada palavra chama o método toString da classe Palavra
            }
        } else {
            System.out.println("A lista está vazia.");
        }

        // CRIANDO A TABELA DE PALAVRA CHAVES
        String caminhoArquivoChave = "Lista.java\\src\\textoChave.txt";
            
        List<Palavra> listaChaves = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivoChave))) {
            String linha;
            int ocorrenciaLocal = 0;
            while ((linha = br.readLine()) != null) {
                String[] chaves = linha.toLowerCase().replaceAll("[^a-zA-Z0-9\\s]", "").split("\\s+");
                for (String p : chaves) {
                    if (!p.isEmpty()) {
                        Palavra chave = new Palavra(p);
                        listaChaves.add(chave);
                        chave.ocorrencia.add(ocorrenciaLocal);
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        
    //GRAVAR O INDICE NO ARQUIVO TXT
        FileWriter fileWriter = new FileWriter("Lista.java\\src\\indiceRemissivo.txt");
        BufferedWriter escritor = new BufferedWriter(fileWriter);

        for (int i = 0; i < listaChaves.size(); i++){
            escritor.write(t1.verificarOcorrencia(listaChaves.get(i)) + "\n");
        }
        
        escritor.close();

    }
}
