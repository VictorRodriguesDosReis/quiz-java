package bll;

import dao.QuestaoDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Questao;

public class QuestaoBLL {
    private QuestaoDAO dao;
    private String mensagemDeErro;
    
    public QuestaoBLL() throws ClassNotFoundException, SQLException {
        this.dao = new QuestaoDAO();
    }
    
    public String getMensagemDeErro() {
        return this.mensagemDeErro;
    }
    
    public Questao getQuestao(int codigoQuestao) {
        try {
            return this.dao.getQuestao(codigoQuestao);
        } catch (SQLException ex) {
            Logger.getLogger(QuestaoBLL.class.getName()).log(Level.SEVERE, null, ex);
            this.mensagemDeErro = "Classe:" + QuestaoBLL.class.getName() + " | Erro:" + ex.getMessage();
        }
        return null;
    }
    
    public int getQuantidadeQuestoes() {
        try {
            return this.dao.getQuantidadeQuestoes();
        } catch (SQLException ex) {
            Logger.getLogger(QuestaoBLL.class.getName()).log(Level.SEVERE, null, ex);
            this.mensagemDeErro = "Classe:" + QuestaoBLL.class.getName() + " | Erro:" + ex.getMessage();
        }
        
        return 0;
    }
    
}
