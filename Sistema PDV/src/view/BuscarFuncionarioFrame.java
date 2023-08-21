package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import controller.FuncionarioService;
import model.FuncionarioModel;

public class BuscarFuncionarioFrame extends JFrame{
	private JTextField inputCodigo;
    private JTextField inputNome;
    private JTextField inputCargo;
    private JTextField inputTipo;
    private JTextField inputUsuario;
    private JTextField inputSenha;
    private JTextField inputConfirmarSenha;
    private JButton buscar;
    private JButton editar;
    private FuncionarioModel funcionario;
    
	public BuscarFuncionarioFrame(FuncionarioModel funcionario) {
		this.funcionario = funcionario;
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setTitle("Sistema PDV");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.getContentPane().setBackground(new Color(50, 50, 50));
        this.setLayout(new GridBagLayout());

        this.renderizarComponentes();

        this.setVisible(true);
	}
	
	private void renderizarComponentes() {
		GridBagConstraints gbc = new GridBagConstraints();
	    gbc.insets = new Insets(10, 10, 10, 10);
	
	    JLabel codigoLabel = new JLabel("Código do Funcionário:");
	    codigoLabel.setForeground(new Color(255, 255, 255));
	
	    inputCodigo = new JTextField();
	    inputCodigo.setPreferredSize(new Dimension(150, 30));
	
	    gbc.gridx = 0;
	    gbc.gridy = 0;
	    gbc.fill = GridBagConstraints.NONE;
	    this.add(codigoLabel, gbc);
	    gbc.gridx = 1;
	    gbc.fill = GridBagConstraints.HORIZONTAL;
	    this.add(inputCodigo, gbc);
	
	    buscar = new JButton("Buscar");
	    buscar.setPreferredSize(new Dimension(300, 30));
	    buscar.setBackground(new Color(130, 87, 229));
	    buscar.setForeground(new Color(255, 255, 255));
	    buscar.setBorder(null);
	    buscar.addActionListener(e -> buscarFuncionario(inputCodigo.getText()));
	
	    gbc.gridx = 0;
	    gbc.gridy = 1;
	    gbc.gridwidth = 2;
	    gbc.fill = GridBagConstraints.NONE;
	    gbc.anchor = GridBagConstraints.CENTER;
	    this.add(buscar, gbc);
	
	    JLabel nomeLabel = new JLabel("Nome:");
	    nomeLabel.setForeground(new Color(255, 255, 255));
	    inputNome = new JTextField();
	    inputNome.setPreferredSize(new Dimension(150, 30));
	    
	    JLabel cargoLabel = new JLabel("Cargo:");
	    cargoLabel.setForeground(new Color(255, 255, 255));
	    inputCargo = new JTextField();
	    inputCargo.setPreferredSize(new Dimension(150, 30));
	
	    JLabel tipoLabel = new JLabel("Tipo:");
	    tipoLabel.setForeground(new Color(255, 255, 255));
	    inputTipo = new JTextField();
	    inputTipo.setPreferredSize(new Dimension(150, 30));
	
	    JLabel usuarioLabel = new JLabel("Usuario:");
	    usuarioLabel.setForeground(new Color(255, 255, 255));
	    inputUsuario = new JTextField();
	    inputUsuario.setPreferredSize(new Dimension(150, 30));
	
	    JLabel senhaLabel = new JLabel("Senha:");
	    senhaLabel.setForeground(new Color(255, 255, 255));
	    inputSenha = new JTextField();
	    inputSenha.setPreferredSize(new Dimension(150, 30));
	
	    JLabel confirmarSenhaLabel = new JLabel("Confirmar Senha:");
	    confirmarSenhaLabel.setForeground(new Color(255, 255, 255));
	    inputConfirmarSenha = new JTextField();
	    inputConfirmarSenha.setPreferredSize(new Dimension(150, 30));
	    
	    editar = new JButton("Editar");
	    editar.setPreferredSize(new Dimension(300, 30));
	    editar.setBackground(new Color(130, 87, 229));
	    editar.setForeground(new Color(255, 255, 255));
	    editar.setBorder(null);
	    editar.addActionListener(e -> editarFuncionario());
	    
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
	    gbc.gridy = 2;
	    gbc.gridwidth = 1;
	    gbc.fill = GridBagConstraints.NONE;
	    gbc.anchor = GridBagConstraints.CENTER;
	    this.add(nomeLabel, gbc);
	    gbc.gridx = 1;
	    gbc.fill = GridBagConstraints.HORIZONTAL;
	    this.add(inputNome, gbc);
	
	    gbc.gridx = 0;
	    gbc.gridy = 3;
	    gbc.fill = GridBagConstraints.NONE;
	    gbc.anchor = GridBagConstraints.CENTER;
	    this.add(cargoLabel, gbc);
	    gbc.gridx = 1;
	    gbc.fill = GridBagConstraints.HORIZONTAL;
	    this.add(inputCargo, gbc);
	    
	    gbc.gridx = 0;
	    gbc.gridy = 4;
	    gbc.fill = GridBagConstraints.NONE;
	    gbc.anchor = GridBagConstraints.CENTER;
	    this.add(usuarioLabel, gbc);
	    gbc.gridx = 1;
	    gbc.fill = GridBagConstraints.HORIZONTAL;
	    this.add(inputUsuario, gbc);
	    
	    gbc.gridx = 0;
	    gbc.gridy = 5;
	    gbc.fill = GridBagConstraints.NONE;
	    gbc.anchor = GridBagConstraints.CENTER;
	    this.add(senhaLabel, gbc);
	    gbc.gridx = 1;
	    gbc.fill = GridBagConstraints.HORIZONTAL;
	    this.add(inputSenha, gbc);
	    
	    gbc.gridx = 0;
	    gbc.gridy = 6;
	    gbc.fill = GridBagConstraints.NONE;
	    gbc.anchor = GridBagConstraints.CENTER;
	    this.add(confirmarSenhaLabel, gbc);
	    gbc.gridx = 1;
	    gbc.fill = GridBagConstraints.HORIZONTAL;
	    this.add(inputConfirmarSenha, gbc);
	
	    gbc.gridx = 0;
	    gbc.gridy = 7;
	    gbc.fill = GridBagConstraints.NONE;
	    gbc.anchor = GridBagConstraints.CENTER;
	    this.add(tipoLabel, gbc);
	    gbc.gridx = 1;
	    gbc.fill = GridBagConstraints.HORIZONTAL;
	    this.add(inputTipo, gbc);
	
	    gbc.gridx = 0;
	    gbc.gridy = 8;
	    gbc.gridwidth = 2;
	    gbc.fill = GridBagConstraints.NONE;
	    gbc.anchor = GridBagConstraints.CENTER;
	    this.add(editar, gbc);
	    
	    gbc.gridx = 0;
	    gbc.gridy = 9;
	    gbc.gridwidth = 2;
	    gbc.fill = GridBagConstraints.NONE;
	    gbc.anchor = GridBagConstraints.CENTER;
	    this.add(voltar, gbc);
	 }
	
	private void goToMenu() {
    	this.dispose();
    	SwingUtilities.invokeLater(() -> new MenuFrame(this.funcionario));
    }
	
	private void buscarFuncionario(String codigo) {
		FuncionarioService s = new FuncionarioService();
	    funcionario = s.buscarFuncionarioPorCodigo(codigo);
	    if (funcionario != null) {
	       inputNome.setText(funcionario.getNome());
	       inputCargo.setText(funcionario.getCargo());
	       inputTipo.setText(String.valueOf(funcionario.getTipo()));
	       inputUsuario.setText(String.valueOf(funcionario.getUsuario()));
	    } else {
	       JOptionPane.showMessageDialog(null, "Funcionário não encontrado");
	    }
    }
	
	private void editarFuncionario() {
		if(inputSenha.getText().equals(inputConfirmarSenha.getText())) {
	        if (funcionario != null) {
	        	funcionario.setCodigo(inputCodigo.getText());
	        	funcionario.setNome(inputNome.getText());
	        	funcionario.setCargo(inputCargo.getText());
	        	funcionario.setTipo(inputTipo.getText());
	        	funcionario.setUsuario(inputUsuario.getText());
	        	funcionario.setSenha(inputSenha.getText());
	 
	            FuncionarioService s = new FuncionarioService();
	            boolean status = s.editarFuncionario(funcionario);
	
	            if (status) {
	                JOptionPane.showMessageDialog(null, "Funcionário editado com sucesso");
	            } else {
	                JOptionPane.showMessageDialog(null, "Erro ao editar o Funcionário");
	            }
	        } else {
	            JOptionPane.showMessageDialog(null, "Funcionário não encontrado");
	        }
		}else {
			JOptionPane.showMessageDialog(null, "Senhas não coincidem");
		}
    }
	
}
