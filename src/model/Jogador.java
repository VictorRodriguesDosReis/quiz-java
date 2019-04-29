package model;

import bll.JogadorBLL;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Jogador {
    private JogadorBLL bll;
    private String nome;
    private int pontuacao;
        
    public void iniciaBLL() {
        try {
            this.bll = new JogadorBLL();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Jogador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Jogador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Jogador() {
        this("");
        this.iniciaBLL();
    }
    
    public Jogador(String nome) {
        this.nome = nome;
        this.iniciaBLL();
    }
    
    public Jogador(String nome, int pontuacao) {
        this.nome = nome;
        this.pontuacao = pontuacao;
        this.iniciaBLL();
    }
    
    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public int getPontuacao(){
        return this.pontuacao;
    }
    public void setPontuacao(int pontuacao){
        this.pontuacao = pontuacao;
    }
    
    public String getMensagemDeErro() {
        return this.bll.getMensagemDeErro();
    }
    
    public boolean inserir() {
        boolean feito = this.bll.inserir(this);
        
        return feito;
    }
    
}
