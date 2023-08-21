package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import controller.FuncionarioService;
import model.FuncionarioModel;

public class AuthFrame extends JFrame{
	private JLabel jLabelTitulo;
	private JLabel jLabelUsuario;
	private JTextField jTextUsuario;
	private JLabel jLabelSenha;
	private JPasswordField jTextSenha;
	private JButton jButtonEntrar;
	private JButton jButtonEsqueceuSenha;
	
	public AuthFrame() {
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.getContentPane().setBackground(new Color(50, 50, 50));
        this.setLayout(new GridBagLayout());
        
        this.renderizarComponentes();
        
        this.setVisible(true);
	}
	
	private void renderizarComponentes() {
		GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
    
        jLabelTitulo = new JLabel("Controle de Produção");
        jLabelTitulo.setForeground(new Color(255, 255, 255));
        jLabelTitulo.setFont(jLabelTitulo.getFont().deriveFont(20f));
        jLabelTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);
       
        JPanel panelTitulo = new JPanel();
        panelTitulo.setLayout(new BoxLayout(panelTitulo, BoxLayout.Y_AXIS));
        panelTitulo.setBackground(new Color(50, 50, 50));
        panelTitulo.setPreferredSize(new Dimension(300, 30));
        panelTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelTitulo.add(jLabelTitulo);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        this.add(panelTitulo, gbc);

        jLabelUsuario = new JLabel("Usuário:");
        jLabelUsuario.setForeground(new Color(255, 255, 255));
        jLabelUsuario.setFont(jLabelUsuario.getFont().deriveFont(15f));
        
        jTextUsuario = new JTextField();
        
        JPanel panelUsuario = new JPanel();
        panelUsuario.setLayout(new BoxLayout(panelUsuario, BoxLayout.Y_AXIS));
        panelUsuario.setPreferredSize(new Dimension(300, 50));
        panelUsuario.setBackground(new Color(50, 50, 50));
        panelUsuario.add(jLabelUsuario);
        panelUsuario.add(jTextUsuario);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(panelUsuario, gbc);
        
        jLabelSenha = new JLabel("Senha:");
        jLabelSenha.setForeground(new Color(255, 255, 255));
        jLabelSenha.setFont(jLabelSenha.getFont().deriveFont(15f));
        
        jTextSenha = new JPasswordField();

        
        JPanel panelSenha = new JPanel();
        panelSenha.setLayout(new BoxLayout(panelSenha, BoxLayout.Y_AXIS));
        panelSenha.setPreferredSize(new Dimension(200, 50));
        panelSenha.setBackground(new Color(50, 50, 50));
        panelSenha.add(jLabelSenha);
        panelSenha.add(jTextSenha);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(panelSenha, gbc);

        jButtonEntrar = new JButton("Entrar");
        jButtonEntrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	autenticar(jTextUsuario.getText(), jTextSenha.getText());
            }
        });
        jButtonEntrar.setBackground(new Color(0, 120, 0));
        jButtonEntrar.setForeground(new Color(255, 255, 255));
        jButtonEntrar.setPreferredSize(new Dimension(300, 30));
        jButtonEntrar.setBorder(null);
        gbc.gridx = 0;
        gbc.gridy = 5;
        this.add(jButtonEntrar, gbc);

        jButtonEsqueceuSenha = new JButton("Esqueci a Senha");
        jButtonEsqueceuSenha.setBackground(new Color(180, 0, 0));
        jButtonEsqueceuSenha.setForeground(new Color(255, 255, 255));
        jButtonEsqueceuSenha.setPreferredSize(new Dimension(200, 30));
        jButtonEsqueceuSenha.setBorder(null);
        gbc.gridx = 0;
        gbc.gridy = 6;
        this.add(jButtonEsqueceuSenha, gbc);
	}
	
	private void autenticar(String usuario, String senha){
		
		FuncionarioService f = new FuncionarioService();
		FuncionarioModel funcionario = f.buscarFuncionarioPorUsuarioESenha(usuario, senha);
		
		if(funcionario != null) {

			this.dispose();
			SwingUtilities.invokeLater(() -> new MenuFrame(funcionario));
		}else {
			JOptionPane.showMessageDialog(null, "Usuário ou senha incorretas");
		}
		
	}
}
