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
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import controller.ProdutoService;
import model.FuncionarioModel;
import model.ProdutoModel;

public class BuscarProdutoFrame extends JFrame{
	private JTextField inputCodigo;
    private JTextField inputNome;
    private JTextField inputMarca;
    private JTextField inputPreco;
    private JButton buscar;
    private JButton editar;
    private ProdutoModel produto;
    FuncionarioModel funcionario;
    
    public BuscarProdutoFrame(FuncionarioModel funcionario) {
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
    	if(funcionario.getTipo().equals("gerente")) {
    		showFullFrame();
    	}else {
    		showPartialFrame();
    	}
    }
    
    public void showPartialFrame() {
    	GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 15, 15, 15);
        
        JLabel jLabelTitulo = new JLabel("Buscar Produto por Código");
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
        
        JLabel codigo = new JLabel("Código do Produto:");
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
        
        buscar = new JButton("Buscar");
        buscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarProdutoOption(inputCodigo.getText());
            }
        });
        buscar.setPreferredSize(new Dimension(200, 30));
        buscar.setBackground(new Color(130, 87, 229));
        buscar.setForeground(new Color(255, 255, 255));
        buscar.setBorder(null);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(buscar, gbc);
        
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
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(voltar, gbc);
    }
    
    public void showFullFrame(){
    	GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel codigoLabel = new JLabel("Código do Produto:");
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
        buscar.addActionListener(e -> buscarProduto(inputCodigo.getText()));

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

        JLabel marcaLabel = new JLabel("Marca:");
        marcaLabel.setForeground(new Color(255, 255, 255));
        inputMarca = new JTextField();
        inputMarca.setPreferredSize(new Dimension(150, 30));

        JLabel precoLabel = new JLabel("Preço:");
        precoLabel.setForeground(new Color(255, 255, 255));
        inputPreco = new JTextField();
        inputPreco.setPreferredSize(new Dimension(150, 30));

        editar = new JButton("Editar");
        editar.setPreferredSize(new Dimension(300, 30));
        editar.setBackground(new Color(130, 87, 229));
        editar.setForeground(new Color(255, 255, 255));
        editar.setBorder(null);
        editar.addActionListener(e -> editarProduto());
        
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
        this.add(marcaLabel, gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(inputMarca, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        this.add(precoLabel, gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(inputPreco, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        this.add(editar, gbc);
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        this.add(voltar, gbc);
    }

    private void buscarProduto(String codigo) {
        ProdutoService s = new ProdutoService();
        produto = s.buscarProdutoPorCodigo(codigo);

        if (produto != null) {
            inputNome.setText(produto.getNome());
            inputMarca.setText(produto.getMarca());
            inputPreco.setText(String.valueOf(produto.getPreco()));
        } else {
            JOptionPane.showMessageDialog(null, "Produto não encontrado");
        }
    }
    
    private void goToMenu() {
    	this.dispose();
    	SwingUtilities.invokeLater(() -> new MenuFrame(this.funcionario));
    }
    
    private void buscarProdutoOption(String codigo) {
    	 ProdutoService s = new ProdutoService();
         ProdutoModel produto = s.buscarProdutoPorCodigo(codigo);
         
         if (produto != null) {
             JOptionPane.showMessageDialog(null, "Produto Encontrado:\n" +
                     "Código: " + produto.getCodigo() + "\n" +
                     "Nome: " + produto.getNome() + "\n" +
                     "Marca: " + produto.getMarca() + "\n" +
                     "Preço: " + produto.getPreco());
         } else {
             JOptionPane.showMessageDialog(null, "Produto não encontrado");
         }
    }

    private void editarProduto() {
        if (produto != null) {
        	produto.setCodigo(inputCodigo.getText());
            produto.setNome(inputNome.getText());
            produto.setMarca(inputMarca.getText());
            produto.setPreco(Float.parseFloat(inputPreco.getText()));

            ProdutoService s = new ProdutoService();
            boolean status = s.editarProduto(produto);

            if (status) {
                JOptionPane.showMessageDialog(null, "Produto editado com sucesso");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao editar o produto");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Produto não encontrado");
        }
    }
}
