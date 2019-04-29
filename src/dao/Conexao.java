package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class Conexao {

    private Connection conexaoBanco;
    private Statement ponteStatement;
    private ResultSet colecaoRegistros;
    private String driverBanco;
    private String servidor;
    private String porta;
    private String bancoDeDados;
    private String usuario;
    private String senha;

    public Conexao() throws ClassNotFoundException {
        this.driverBanco = "com.mysql.jdbc.Driver";
        this.servidor = "localhost";
        this.porta = "3306";
        this.bancoDeDados = "db_quiz";
        this.usuario = "root";
        this.senha = "root";
        
        // Inicializa o driver 
        Class.forName(driverBanco);
    }
    
    public Connection getConexaoBanco() {
        return conexaoBanco;
    }

    public void setConexaoBanco(Connection conexaoBanco) {
        this.conexaoBanco = conexaoBanco;
    }

    public Statement getPonteStatement() {
        return ponteStatement;
    }

    public void setPonteStatement(Statement ponteStatement) {
        this.ponteStatement = ponteStatement;
    }

    public ResultSet getColecaoRegistros() {
        return colecaoRegistros;
    }

    public void setColecaoRegistros(ResultSet colecaoRegistros) {
        this.colecaoRegistros = colecaoRegistros;
    }

    public String getDriverBanco() {
        return driverBanco;
    }

    public void setDriverBanco(String driverBanco) {
        this.driverBanco = driverBanco;
    }

    public String getServidor() {
        return servidor;
    }

    public void setServidor(String servidor) {
        this.servidor = servidor;
    }

    public String getPort() {
        return porta;
    }

    public void setPorta(String porta) {
        this.porta = porta;
    }

    public String getBancoDeDados() {
        return bancoDeDados;
    }

    public void setBancoDeDados(String bancoDeDados) {
        this.bancoDeDados = bancoDeDados;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    // Cria a conexão com o banco de dados
    public void conectar() throws SQLException {
        conexaoBanco = (Connection) DriverManager.getConnection(
                "jdbc:MySQL://" + this.servidor + ":" + this.porta + "/"
                + this.bancoDeDados + "?user=" + this.usuario + "&password=" + this.senha);
    }
    
    // Executa comandos sem retorno no banco de dados (INSERT/ UPDATE/ DELETE)
    public void executar(String comandoSQL) throws SQLException {
        this.ponteStatement = (Statement) this.conexaoBanco.createStatement();
        this.ponteStatement.executeUpdate(comandoSQL);
    }
    
    // Executa comandos com retorno no banco de dados (SELECT)
    public ResultSet consultar(String comandoSQL) throws SQLException {
        this.ponteStatement = (Statement) this.conexaoBanco.createStatement();
        this.colecaoRegistros = this.ponteStatement.executeQuery(comandoSQL);
        
        return this.colecaoRegistros;
    }
}
