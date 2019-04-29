package bll;

import dao.JogadorDAO;
import model.Jogador;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JogadorBLL {
    
    private JogadorDAO dao;
    private String mensagemDeErro;
    
    public JogadorBLL() throws ClassNotFoundException, SQLException {
        this.dao = new JogadorDAO();
    }
    
    public String getMensagemDeErro() {
        return mensagemDeErro;
    }
    
    public boolean inserir(Jogador jogador) {
        try {
            if (jogador.getNome().trim().length() > 0) {
                this.dao.inserirJogador(jogador);
                return true;
                
            } else {
                this.mensagemDeErro = "Preencha o campo com seu nome!";
            }

        } catch (SQLException ex) {
            Logger.getLogger(JogadorBLL.class.getName()).log(Level.SEVERE, null, ex);
            this.mensagemDeErro = "Classe:" + JogadorBLL.class.getName() + " | Erro:" + ex.getMessage();

        }
        
        return false;
    }
        
}
