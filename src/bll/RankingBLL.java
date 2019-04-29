package bll;

import dao.RankingDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Ranking;

public class RankingBLL {
    private RankingDAO dao;
    private String mensagemDeErro;
    
    public RankingBLL() throws ClassNotFoundException, SQLException {
        this.dao = new RankingDAO();
    }
    
    public String getMensagemDeErro() {
        return this.mensagemDeErro;
    }
    
    public ArrayList<Ranking> getRanking() {
        try {
            return this.dao.getRanking();
        } catch (SQLException ex) {
            Logger.getLogger(RankingBLL.class.getName()).log(Level.SEVERE, null, ex);
            this.mensagemDeErro = "Classe:" + RankingBLL.class.getName() + " | Erro:" + ex.getMessage();
        }
        
        return null;
    }
    
    public ArrayList<Ranking> getRankingParcial() {
        try {
            return this.dao.getRankingParcial();
        } catch (SQLException ex) {
            Logger.getLogger(RankingBLL.class.getName()).log(Level.SEVERE, null, ex);
            this.mensagemDeErro = "Classe:" + RankingBLL.class.getName() + " | Erro:" + ex.getMessage();
        }
        
        return null;
    }
}
