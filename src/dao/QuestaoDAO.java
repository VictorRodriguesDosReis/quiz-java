package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import model.Questao;

public class QuestaoDAO {
    private Conexao conexaoBanco;
    private String comandoSQL;

    public QuestaoDAO() throws ClassNotFoundException, SQLException {
        this.conexaoBanco = new Conexao();
        this.conexaoBanco.conectar();
    }
    
    // Obtém os dados da questão solicitada
    public Questao getQuestao(int codigoQuestao) throws SQLException {
        this.comandoSQL = "call p_S_Questao("+codigoQuestao+")";

        ResultSet registrosBanco = this.conexaoBanco.consultar(this.comandoSQL);
        
        Questao questao = new Questao();
        
        while (registrosBanco.next()) {
            questao.setCodigo(registrosBanco.getInt("cd_questao"));
            questao.setQuestao(registrosBanco.getString("ds_questao"));
            questao.setAlternativa1(registrosBanco.getString("nm_alternativa1"));
            questao.setAlternativa2(registrosBanco.getString("nm_alternativa2"));
            questao.setAlternativa3(registrosBanco.getString("nm_alternativa3"));
            questao.setAlternativa4(registrosBanco.getString("nm_alternativa_correta"));
            questao.setAlternativaCorreta(registrosBanco.getString("nm_alternativa_correta"));
        }

        return questao;
    }
    
    // Obtém a quantidades de quetões que contém no banco de dados
    public int getQuantidadeQuestoes() throws SQLException {
        int quantidadeQuestoes = 0;
        this.comandoSQL = "call p_S_QuantidadeQuestoes()";
        
        ResultSet registrosBanco = this.conexaoBanco.consultar(this.comandoSQL);
        
        while (registrosBanco.next())
            quantidadeQuestoes = registrosBanco.getInt("quantidadeQuestoes");
        
        return quantidadeQuestoes;
    }

}
