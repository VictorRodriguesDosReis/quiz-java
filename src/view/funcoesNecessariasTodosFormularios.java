package view;

import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class funcoesNecessariasTodosFormularios {
    private JFrame formulario;

    public funcoesNecessariasTodosFormularios(JFrame formulario) {
        this.formulario = formulario;
    }
    
    // Estabelece o ícone do formulário
    public void setIconeFormulario() {
        URL iconURL = getClass().getResource("/imagens/icone.png");
        ImageIcon icon = new ImageIcon(iconURL);
        formulario.setIconImage(icon.getImage());
    }
    
    // Estabelece a cor de background do formulário
    public void setCorBackgroundFormulario() {
        formulario.getContentPane().setBackground(new java.awt.Color(6, 86, 119));
    }
}