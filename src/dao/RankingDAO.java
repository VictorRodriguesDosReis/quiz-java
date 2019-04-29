package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Ranking;

public class RankingDAO {
    private Conexao conexaoBanco;
    private String comandoSQL;

    public RankingDAO() throws ClassNotFoundException, SQLException {
        this.conexaoBanco = new Conexao();
        this.conexaoBanco.conectar();
    }
    
    // Seleciona todos os jogadores do ranking
    public ArrayList<Ranking> getRanking() throws SQLException {
        this.comandoSQL = "call p_S_RankingCompleto()";

        ResultSet registrosBanco = this.conexaoBanco.consultar(this.comandoSQL);
        
        ArrayList<Ranking> lista = new ArrayList<Ranking>();
        
        while (registrosBanco.next()) {
            Ranking ranking = new Ranking();
            
            ranking.setNome(registrosBanco.getString("nm_jogador"));
            ranking.setPontuacao(registrosBanco.getString("vl_pontuacao"));
            ranking.setDataCriacao(registrosBanco.getString("dt_criacao"));
            
            lista.add(ranking);
        }

        return lista;
    }
    
    // Seleciona os 10 jogadores com maior pontuação no ranking
    public ArrayList<Ranking> getRankingParcial() throws SQLException
        {
            this.comandoSQL = "call p_S_RankingParcial()";

            ResultSet registrosBanco = this.conexaoBanco.consultar(this.comandoSQL);

            ArrayList<Ranking> lista = new ArrayList<Ranking>();

            while (registrosBanco.next()){
                Ranking ranking = new Ranking();

                ranking.setNome(registrosBanco.getString("nm_jogador"));
                ranking.setPontuacao(registrosBanco.getString("vl_pontuacao"));
                ranking.setDataCriacao(registrosBanco.getString("dt_criacao"));
                
                lista.add(ranking);
            }

            return lista;
        }
}
