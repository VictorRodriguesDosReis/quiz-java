# Quiz Java
##### Quiz desenvolvido em java.

## Telas
### Menu
No menu do Quiz é apresentado 3 opções sendo elas, iniciar o jogo, ver as instruções e visualizar o ranking.

### Jogo
Na tela do jogo apresenta a questão e as 3 alternativas além das 3 dicas. A cada acerto é acrescido 100 na pontuação, quando o jogador erra ou as perguntas acabam o jogo encerra, apresentando assim uma nova tela onde mostrará a pontuação e um campo onde o jogador pode inserir seu nome, desta forma colocando-se no ranking.

### Instruções
Na tela de instruções é mostrado as 3 dicas que o jogador pode usar durante o jogo e a função de cada uma.

### Ranking
Na tela de ranking são apresentados os 10 jogadores com maior pontuação. Há também a opção de visualizar o ranking completo e de salva-lo em um arquivo.


## Banco
Os dados do quiz, como por exemplo, as questões, alternativas e o ranking são guardados no banco de dados, por conta disso é necessário subir o banco antes de executar o quiz.
- O script da criação do banco se encontra no arquivo [banco-de-dados.sql](./banco-de-dados.sql).

**Dependendo da configuração do banco será necessário mudar as propriedades de porta, servidor, usuário ou senha no arquivo [src/dao/Conexao.java](./src/dao/Conexao.java) para que o quiz se conecte corretamente ao banco.**

