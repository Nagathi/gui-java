package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import controller.ProdutoService;
import model.FuncionarioModel;
import model.ProdutoModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComprasSectionFrame extends JFrame {
	ProdutoService produtoService = new ProdutoService();
	FuncionarioModel funcionario;
    private DefaultTableModel tableModel;
    private JTable table;
    private JLabel totalLabel;
    private JLabel codigo;
    private JTextField codigoField;
    private JTextField nomeField;
    private JTextField precoField;

    public ComprasSectionFrame(FuncionarioModel funcionario) {
    	this.funcionario = funcionario;
    	this.setTitle("Registro de Compras");
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.getContentPane().setBackground(new Color(50, 50, 50));
        this.setLayout(new GridBagLayout());

        JPanel panel = new JPanel(new BorderLayout());

        tableModel = new DefaultTableModel();
        tableModel.addColumn("Código");
        tableModel.addColumn("Nome");
        tableModel.addColumn("Preço");

        table = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane, BorderLayout.CENTER);

        JPanel inputPanel = new JPanel(new FlowLayout());
        inputPanel.setBackground(new Color(50, 50, 50));

        codigoField = new JTextField(10);
        nomeField = new JTextField(20);
        precoField = new JTextField(10);
        
        codigo = new JLabel("Código:");
        codigo.setForeground(new Color(255, 255, 255));

        inputPanel.add(codigo);
        inputPanel.add(codigoField);

        JButton addButton = new JButton("Adicionar Produto");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addProduto(codigoField.getText());
            }
        });
        inputPanel.add(addButton);

        totalLabel = new JLabel("Total: R$ 0.00");
        totalLabel.setForeground(new Color(255, 255, 255));
        panel.add(totalLabel, BorderLayout.SOUTH);
        panel.setBackground(new Color(50, 50, 50));
        
        JButton realizarCompraButton = new JButton("Realizar Compra");
        realizarCompraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarCompra();
            }
        });

        inputPanel.add(realizarCompraButton);
        
        panel.add(inputPanel, BorderLayout.NORTH);
        
        this.add(panel);
        setVisible(true);
    }
    
    private void realizarCompra() {
        
        String totalCompra = totalLabel.getText().replace("Total: R$ ", "");
 
        boolean compraInserida = produtoService.insertCompra(totalCompra, funcionario.getNome());

        if (compraInserida) {
            int compraId = produtoService.obterUltimoId();
            for (int row = 0; row < tableModel.getRowCount(); row++) {
                String nomeProduto = (String) tableModel.getValueAt(row, 1);
                String precoProduto = (String) tableModel.getValueAt(row, 2);
                produtoService.insertDescricao(compraId, nomeProduto, precoProduto);
            }
            
            JOptionPane.showMessageDialog(null, "Compra realizada com sucesso");
            tableModel.setRowCount(0);
            totalLabel.setText("Total: R$ 0.00");
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao realizar a compra");
        }
    }

    private void addProduto(String codigo) {
        if (!codigo.isEmpty()) {
        	
        	ProdutoModel produto = produtoService.buscarProdutoPorCodigo(codigo);
        	if(produto != null) {
        		tableModel.addRow(new String[]{produto.getCodigo(), produto.getNome(), ""+ produto.getPreco()});
                calcularTotal();
        	}else {
        		JOptionPane.showMessageDialog(null, "Produto não encontrado");
        	}
        }
        codigoField.setText("");
        nomeField.setText("");
        precoField.setText("");
    }

    private void calcularTotal() {
        float total = 0;
        for (int row = 0; row < tableModel.getRowCount(); row++) {
            String preco = (String) tableModel.getValueAt(row, 2);
            total += Float.parseFloat(preco);
        }
        totalLabel.setText("Total: R$ " + total);
    }
}
