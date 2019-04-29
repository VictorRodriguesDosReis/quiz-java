package model;

import bll.RankingBLL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ranking {
    private RankingBLL bll;
    private String nome;
    private String pontuacao;
    private String dataCriacao;

    public Ranking() {
        this.iniciaBLL();
    }

    public Ranking(String nome, String pontuacao, String dataCriacao) {
        this.nome = nome;
        this.pontuacao = pontuacao;
        this.dataCriacao = dataCriacao;
        this.iniciaBLL();
    }
    
    public void iniciaBLL() {
        try {
            this.bll = new RankingBLL();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Ranking.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Ranking.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPontuacao() {
        return this.pontuacao;
    }

    public void setPontuacao(String pontuacao) {
        this.pontuacao = pontuacao;
    }

    public String getDataCriacao() {
        return this.dataCriacao;
    }

    public void setDataCriacao(String dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
    
    public ArrayList<Ranking> getRanking() {
        return this.bll.getRanking();
    }
    
    public ArrayList<Ranking> getRankingParcial() {
        return this.bll.getRankingParcial();
    }
}
