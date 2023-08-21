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
import javax.swing.SwingUtilities;

import controller.ProdutoService;
import model.FuncionarioModel;

public class MenuFrame extends JFrame{
	private JLabel jLabelTitulo;
	private JButton cadastrarProduto;
	private JButton cadastrarFuncionario;
	private JButton buscarProduto;
	private JButton buscarFuncionario;
	private JButton comprar;
	private JButton relatorio;
	private JButton sair;
	private FuncionarioModel funcionario;
	
	
	public MenuFrame(FuncionarioModel funcionario) {
		this.funcionario = funcionario;
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.getContentPane().setBackground(new Color(50, 50, 50));
        this.setLayout(new GridBagLayout());
        
        this.renderizarComponentes();
        
        this.setVisible(true);
	}
	
	public void renderizarComponentes() {
		if(funcionario.getTipo().equals("gerente")) {
			showFullFrame(funcionario);
		}else{
			showPartialFrame(funcionario);
		}
	}
	
	public void showPartialFrame(FuncionarioModel funcionario) {
		GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 15, 15, 15);
        
        jLabelTitulo = new JLabel("Olá, " + funcionario.getNome());
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
        
        buscarProduto = new JButton("Buscar um Produto");
        buscarProduto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	goToBuscarProdutoFrame();
            }
        });
        buscarProduto.setBackground(new Color(130, 87, 229));
        buscarProduto.setForeground(new Color(255, 255, 255));
        buscarProduto.setPreferredSize(new Dimension(300, 30));
        buscarProduto.setBorder(null);
        gbc.gridx = 0;
        gbc.gridy = 1;
        this.add(buscarProduto, gbc);
		
        comprar = new JButton("Seção de Compras");
        comprar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	goToComprasFrame();
            }
        });
        comprar.setBackground(new Color(130, 87, 229));
        comprar.setForeground(new Color(255, 255, 255));
        comprar.setPreferredSize(new Dimension(300, 30));
        comprar.setBorder(null);
        gbc.gridx = 0;
        gbc.gridy = 2;
        this.add(comprar, gbc);
        
        sair = new JButton("Encerrar Sessão");
        sair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	sair();
            }
        });
        sair.setBackground(new Color(130, 87, 229));
        sair.setForeground(new Color(255, 255, 255));
        sair.setPreferredSize(new Dimension(300, 30));
        sair.setBorder(null);
        gbc.gridx = 0;
        gbc.gridy = 3;
        this.add(sair, gbc);
	}
	
	public void showFullFrame(FuncionarioModel funcionario) {
		GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 15, 15, 15);
        
        jLabelTitulo = new JLabel("Olá, " + funcionario.getNome());
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
		
        cadastrarProduto = new JButton("Cadastrar Produto");
        cadastrarProduto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	goToProdutoFrame();
            }
        });
        cadastrarProduto.setBackground(new Color(130, 87, 229));
        cadastrarProduto.setForeground(new Color(255, 255, 255));
        cadastrarProduto.setPreferredSize(new Dimension(300, 30));
        cadastrarProduto.setBorder(null);
        gbc.gridx = 0;
        gbc.gridy = 1;
        this.add(cadastrarProduto, gbc);

        cadastrarFuncionario = new JButton("Cadastrar Funcionário");
        cadastrarFuncionario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	goToFuncionarioFrame();
            }
        });
        cadastrarFuncionario.setBackground(new Color(130, 87, 229));
        cadastrarFuncionario.setForeground(new Color(255, 255, 255));
        cadastrarFuncionario.setPreferredSize(new Dimension(300, 30));
        cadastrarFuncionario.setBorder(null);
        gbc.gridx = 0;
        gbc.gridy = 2;
        this.add(cadastrarFuncionario, gbc);
        
        buscarProduto = new JButton("Buscar um Produto");
        buscarProduto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	goToBuscarProdutoFrame();
            }
        });
        buscarProduto.setBackground(new Color(130, 87, 229));
        buscarProduto.setForeground(new Color(255, 255, 255));
        buscarProduto.setPreferredSize(new Dimension(300, 30));
        buscarProduto.setBorder(null);
        gbc.gridx = 0;
        gbc.gridy = 3;
        this.add(buscarProduto, gbc);
        
        buscarFuncionario = new JButton("Buscar um Funcionário");
        buscarFuncionario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	goToBuscarFuncionarioFrame();
            }
        });
        buscarFuncionario.setBackground(new Color(130, 87, 229));
        buscarFuncionario.setForeground(new Color(255, 255, 255));
        buscarFuncionario.setPreferredSize(new Dimension(300, 30));
        buscarFuncionario.setBorder(null);
        gbc.gridx = 0;
        gbc.gridy = 4;
        this.add(buscarFuncionario, gbc);

        comprar = new JButton("Seção de Compras");
        comprar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	goToComprasFrame();
            }
        });
        comprar.setBackground(new Color(130, 87, 229));
        comprar.setForeground(new Color(255, 255, 255));
        comprar.setPreferredSize(new Dimension(300, 30));
        comprar.setBorder(null);
        gbc.gridx = 0;
        gbc.gridy = 5;
        this.add(comprar, gbc);
        
        relatorio = new JButton("Gerar Relatório");
        relatorio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	gerarPDF();
            }
        });
        relatorio.setBackground(new Color(130, 87, 229));
        relatorio.setForeground(new Color(255, 255, 255));
        relatorio.setPreferredSize(new Dimension(300, 30));
        relatorio.setBorder(null);
        gbc.gridx = 0;
        gbc.gridy = 6;
        this.add(relatorio, gbc);
        
        sair = new JButton("Encerrar Sessão");
        sair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	sair();
            }
        });
        sair.setBackground(new Color(130, 87, 229));
        sair.setForeground(new Color(255, 255, 255));
        sair.setPreferredSize(new Dimension(300, 30));
        sair.setBorder(null);
        gbc.gridx = 0;
        gbc.gridy = 7;
        this.add(sair, gbc);
	}
	
	private void goToProdutoFrame(){
		this.dispose();
		SwingUtilities.invokeLater(() -> new CadastrarProdutoFrame(funcionario));
	}
	
	private void goToFuncionarioFrame(){
		this.dispose();
		SwingUtilities.invokeLater(() -> new CadastrarFuncionarioFrame(funcionario));
	}
	
	private void goToBuscarProdutoFrame(){
		this.dispose();
		SwingUtilities.invokeLater(() -> new BuscarProdutoFrame(funcionario));
	}
	
	private void goToBuscarFuncionarioFrame(){
		this.dispose();
		SwingUtilities.invokeLater(() -> new BuscarFuncionarioFrame(funcionario));
	}
	
	private void goToComprasFrame(){
		this.dispose();
		SwingUtilities.invokeLater(() -> new ComprasSectionFrame(funcionario));
	}
	
	private void gerarPDF(){
		ProdutoService produto = new ProdutoService();
		produto.generatePDF();
        JOptionPane.showMessageDialog(null, "PDF gerado com sucesso!");
	}
	
	private void sair() {
		this.dispose();
		SwingUtilities.invokeLater(() -> new AuthFrame());
	}
}