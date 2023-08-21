package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import controller.FuncionarioService;
import model.FuncionarioModel;

public class CadastrarFuncionarioFrame extends JFrame{
	private JLabel jLabelTitulo;
	private JLabel codigo;
	private JTextField inputCodigo;
	private JLabel nome;
	private JTextField inputNome;
	private JLabel cargo;
	private JTextField inputCargo;
	private JLabel tipo;
	private JTextField inputTipo;
	private JLabel usuario;
	private JTextField inputUsuario;
	private JLabel senha;
	private JPasswordField inputSenha;
	private JLabel confirmarSenha;
	private JPasswordField inputConfirmarSenha;
	private JButton cadastrar;
	private FuncionarioModel funcionario;
	
	public CadastrarFuncionarioFrame(FuncionarioModel funcionario) {
		this.funcionario = funcionario;
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	    this.getContentPane().setBackground(new Color(50, 50, 50));
	    this.setLayout(new GridBagLayout());
	    
	    this.renderizarComponentes();
	    
	    this.setVisible(true);
	    
	}
	
    private void renderizarComponentes() {
    	GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        
        jLabelTitulo = new JLabel("Cadastro de Funcionários");
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
        
        codigo = new JLabel("Código do Funcionário:");
        codigo.setForeground(new Color(255, 255, 255));
        codigo.setFont(codigo.getFont().deriveFont(15f));
        
        inputCodigo = new JTextField();
        
        JPanel panelCodigo = new JPanel();
        panelCodigo.setLayout(new BoxLayout(panelCodigo, BoxLayout.Y_AXIS));
        panelCodigo.setPreferredSize(new Dimension(300, 50));
        panelCodigo.setBackground(new Color(50, 50, 50));
        panelCodigo.add(codigo);
        panelCodigo.add(inputCodigo);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(panelCodigo, gbc);
        
        nome = new JLabel("Nome do Funcionário:");
        nome.setForeground(new Color(255, 255, 255));
        nome.setFont(nome.getFont().deriveFont(15f));
        
        inputNome = new JTextField();

        
        JPanel panelNome = new JPanel();
        panelNome.setLayout(new BoxLayout(panelNome, BoxLayout.Y_AXIS));
        panelNome.setPreferredSize(new Dimension(200, 50));
        panelNome.setBackground(new Color(50, 50, 50));
        panelNome.add(nome);
        panelNome.add(inputNome);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(panelNome, gbc);
        
        cargo = new JLabel("Cargo do Funcionário:");
        cargo.setForeground(new Color(255, 255, 255));
        cargo.setFont(cargo.getFont().deriveFont(15f));
        
        inputCargo = new JTextField();
        
        JPanel panelMarca = new JPanel();
        panelMarca.setLayout(new BoxLayout(panelMarca, BoxLayout.Y_AXIS));
        panelMarca.setPreferredSize(new Dimension(200, 50));
        panelMarca.setBackground(new Color(50, 50, 50));
        panelMarca.add(cargo);
        panelMarca.add(inputCargo);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(panelMarca, gbc);
        
        tipo = new JLabel("Tipo do Funcionário:");
        tipo.setForeground(new Color(255, 255, 255));
        tipo.setFont(tipo.getFont().deriveFont(15f));
        
        inputTipo = new JTextField();
        
        JPanel panelTipo = new JPanel();
        panelTipo.setLayout(new BoxLayout(panelTipo, BoxLayout.Y_AXIS));
        panelTipo.setPreferredSize(new Dimension(200, 50));
        panelTipo.setBackground(new Color(50, 50, 50));
        panelTipo.add(tipo);
        panelTipo.add(inputTipo);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(panelTipo, gbc);
        
        usuario = new JLabel("Usuário:");
        usuario.setForeground(new Color(255, 255, 255));
        usuario.setFont(usuario.getFont().deriveFont(15f));
        
        inputUsuario = new JTextField();
        
        JPanel panelUsuario = new JPanel();
        panelUsuario.setLayout(new BoxLayout(panelUsuario, BoxLayout.Y_AXIS));
        panelUsuario.setPreferredSize(new Dimension(200, 50));
        panelUsuario.setBackground(new Color(50, 50, 50));
        panelUsuario.add(usuario);
        panelUsuario.add(inputUsuario);
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(panelUsuario, gbc);
        
        senha = new JLabel("Senha:");
        senha.setForeground(new Color(255, 255, 255));
        senha.setFont(senha.getFont().deriveFont(15f));
        
        inputSenha = new JPasswordField();
        
        JPanel panelSenha = new JPanel();
        panelSenha.setLayout(new BoxLayout(panelSenha, BoxLayout.Y_AXIS));
        panelSenha.setPreferredSize(new Dimension(200, 50));
        panelSenha.setBackground(new Color(50, 50, 50));
        panelSenha.add(senha);
        panelSenha.add(inputSenha);
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(panelSenha, gbc);
        
        confirmarSenha = new JLabel("Confirmar Senha:");
        confirmarSenha.setForeground(new Color(255, 255, 255));
        confirmarSenha.setFont(confirmarSenha.getFont().deriveFont(15f));
        
        inputConfirmarSenha = new JPasswordField();
        
        JPanel panelConfirmarSenha = new JPanel();
        panelConfirmarSenha.setLayout(new BoxLayout(panelConfirmarSenha, BoxLayout.Y_AXIS));
        panelConfirmarSenha.setPreferredSize(new Dimension(200, 50));
        panelConfirmarSenha.setBackground(new Color(50, 50, 50));
        panelConfirmarSenha.add(confirmarSenha);
        panelConfirmarSenha.add(inputConfirmarSenha);
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(panelConfirmarSenha, gbc);
        
        cadastrar = new JButton("Cadastrar");
        cadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if(inputSenha.getText().equals(inputConfirmarSenha.getText())) {
            		FuncionarioModel funcionario = new FuncionarioModel(inputCodigo.getText(), inputNome.getText(), inputCargo.getText(), inputTipo.getText(), inputUsuario.getText(), inputSenha.getText());
            		cadastrar(funcionario);
            	}else {
            		JOptionPane.showMessageDialog(null, "As senhas devem ser iguais");
            	}
            	
            }
        });
        cadastrar.setPreferredSize(new Dimension(200, 30));
        cadastrar.setBackground(new Color(130, 87, 229));
        cadastrar.setForeground(new Color(255, 255, 255));
        cadastrar.setBorder(null);
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(cadastrar, gbc);
        
        JButton voltar = new JButton("Voltar ao Menu");
        voltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                goToMenu();
            }
        });
    	voltar.setBackground(new Color(130, 87, 229));
    	voltar.setPreferredSize(new Dimension(300, 30));
    	voltar.setForeground(new Color(255, 255, 255));
    	voltar.setBorder(null);
    	gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(voltar, gbc);
        
    }
    
    private void goToMenu() {
    	this.dispose();
    	SwingUtilities.invokeLater(() -> new MenuFrame(this.funcionario));
    }

	private void cadastrar(FuncionarioModel funcionario) {
		FuncionarioService s = new FuncionarioService();
		boolean status = s.insertFuncionario(funcionario);
		if(status) {
			JOptionPane.showMessageDialog(null, "Funcionário cadastrado");
		}else{
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar funcionário");
		}
	}
}
