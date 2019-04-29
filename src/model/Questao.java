package model;

import bll.QuestaoBLL;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Questao {
    private QuestaoBLL bll;
    private int codigo;
    private String questao;
    private String alternativa1;
    private String alternativa2;
    private String alternativa3;
    private String alternativa4;
    private String alternativaCorreta;
    
    public Questao() {
        this.iniciaBLL();
    }
    
    public Questao(int codigo, String questao, String alternativa1, String alternativa2, String alternativa3, String alternativa4, String alternativaCorreta) {
        this.codigo = codigo;
        this.questao = questao;
        this.alternativa1 = alternativa1;
        this.alternativa2 = alternativa2;
        this.alternativa3 = alternativa3;
        this.alternativa4 = alternativa4;
        this.alternativaCorreta = alternativaCorreta;
        this.iniciaBLL();
    }
    
    public void iniciaBLL() {
        try {
            this.bll = new QuestaoBLL();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Questao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Questao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int getCodigo() {
        return this.codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getQuestao() {
        return this.questao;
    }

    public void setQuestao(String questao) {
        this.questao = questao;
    }

    public String getAlternativa1() {
        return this.alternativa1;
    }

    public void setAlternativa1(String alternativa1) {
        this.alternativa1 = alternativa1;
    }

    public String getAlternativa2() {
        return this.alternativa2;
    }

    public void setAlternativa2(String alternativa2) {
        this.alternativa2 = alternativa2;
    }

    public String getAlternativa3() {
        return this.alternativa3;
    }

    public void setAlternativa3(String alternativa3) {
        this.alternativa3 = alternativa3;
    }
    
    public String getAlternativa4() {
        return this.alternativa4;
    }

    public void setAlternativa4(String alternativa4) {
        this.alternativa4 = alternativa4;
    }

    public String getAlternativaCorreta() {
        return this.alternativaCorreta;
    }

    public void setAlternativaCorreta(String alternativaCorreta) {
        this.alternativaCorreta = alternativaCorreta;
    }
    
    public Questao getDadosDaQuestao(int codigo) {
        return this.bll.getQuestao(codigo);
    }
    
    public int getQuantidadeQuestoes() {
        return this.bll.getQuantidadeQuestoes();
    }
    
}
