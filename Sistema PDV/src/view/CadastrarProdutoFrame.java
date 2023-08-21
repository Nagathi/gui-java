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

import controller.ProdutoService;
import model.ProdutoModel;

public class CadastrarProdutoFrame extends JFrame{
	private JLabel jLabelTitulo;
	private JLabel codigo;
	private JTextField inputCodigo;
	private JLabel nome;
	private JTextField inputNome;
	private JLabel marca;
	private JTextField inputMarca;
	private JLabel preco;
	private JTextField inputPreco;
	private JButton cadastrar;
	
	public CadastrarProdutoFrame() {
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	    this.getContentPane().setBackground(new Color(50, 50, 50));
	    this.setLayout(new GridBagLayout());
	    
	    this.renderizarComponentes();
	    
	    this.setVisible(true);
	    
	}
	
    private void renderizarComponentes() {
    	GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 15, 15, 15);
        
        jLabelTitulo = new JLabel("Menu de Cadastro");
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
        
        codigo = new JLabel("Código do Produto:");
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
        
        nome = new JLabel("Nome do Produto:");
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
        
        marca = new JLabel("Marca do Produto:");
        marca.setForeground(new Color(255, 255, 255));
        marca.setFont(codigo.getFont().deriveFont(15f));
        
        inputMarca = new JTextField();
        
        JPanel panelMarca = new JPanel();
        panelMarca.setLayout(new BoxLayout(panelMarca, BoxLayout.Y_AXIS));
        panelMarca.setPreferredSize(new Dimension(200, 50));
        panelMarca.setBackground(new Color(50, 50, 50));
        panelMarca.add(marca);
        panelMarca.add(inputMarca);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(panelMarca, gbc);
        
        preco = new JLabel("Preço do Produto:");
        preco.setForeground(new Color(255, 255, 255));
        preco.setFont(codigo.getFont().deriveFont(15f));
        
        inputPreco = new JTextField();
        
        JPanel panelPreco = new JPanel();
        panelPreco.setLayout(new BoxLayout(panelPreco, BoxLayout.Y_AXIS));
        panelPreco.setPreferredSize(new Dimension(200, 50));
        panelPreco.setBackground(new Color(50, 50, 50));
        panelPreco.add(preco);
        panelPreco.add(inputPreco);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(panelPreco, gbc);
        
        cadastrar = new JButton("Cadastrar");
        cadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	ProdutoModel produto = new ProdutoModel(inputCodigo.getText(), inputNome.getText(), inputMarca.getText(), Float.parseFloat(inputPreco.getText()));
            	cadastrar(produto);
            }
        });
        cadastrar.setPreferredSize(new Dimension(200, 30));
        cadastrar.setBackground(new Color(130, 87, 229));
        cadastrar.setForeground(new Color(255, 255, 255));
        cadastrar.setBorder(null);
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(cadastrar, gbc);
        
    }

	protected void cadastrar(ProdutoModel produto) {
		ProdutoService s = new ProdutoService();
		boolean status = s.insertProduto(produto);
		
		if(status) {
			JOptionPane.showMessageDialog(null, "Cadastro concluído");
		}else {
			JOptionPane.showMessageDialog(null, "Erro a cadastrar");
		}
	}
}
