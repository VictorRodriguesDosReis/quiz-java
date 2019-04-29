package dao;

import java.sql.SQLException;
import model.Jogador;

public class JogadorDAO {
    private Conexao conexaoBanco;
    private String comandoSQL;
    
    public JogadorDAO() throws ClassNotFoundException, SQLException {
        this.conexaoBanco = new Conexao();
        this.conexaoBanco.conectar();
    }
    
    // Inserer o jogador e a sua pontuação no banco de dados
    public void inserirJogador(Jogador jogador) throws SQLException {
        this.comandoSQL = "call p_I_Jogador('"+jogador.getNome()+"', "+jogador.getPontuacao()+")";
        this.conexaoBanco.executar(this.comandoSQL);
    }
}
