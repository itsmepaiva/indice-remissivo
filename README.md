
# Indice Remissivo

Desenvolvimentos de estruturas próprias em Java como listas encadeadas e tabelas hash para a criação de um indice remissivo a partir de um texto e de palavras-chave fornecidas

### Linguagem
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)


## Funcionamento
O texto inserido terá cada cada palavra armazenada em uma tabela, que terá a chave definida pela primeira letra da palavra,

    1. Para o tratamento de colisões, será utilizado as lista encadeadas para armazenar as palavras iniciadas com a mesma letra juntas, sem admitir palavras duplicadas.

    2. Na lista encadeada, cada palavra é igual a um Nó, e nesse nó fica armazenada, além da palavra, as linhas de ocorrência da palavra.

As palavras chaves de busca do indice ficam primeiramente armazenada em uma lista encadeada e então sao usadas para buscar e comparar sua existencia na tabela hash do texto.

Após a busca e comparação, é gerado um texto com as palavras chaves e a linha de ocorrência de cada uma.

