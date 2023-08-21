package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controller.FuncionarioService;
import model.FuncionarioModel;

public class AlterarSenhaFrame extends JFrame {
    private JLabel jLabelTitulo;
    private JLabel codigo;
    private JTextField inputCodigo;
    private JLabel senha;
    private JPasswordField inputSenha;
    private JLabel confirmarSenha;
    private JPasswordField inputConfirmarSenha;
    private JButton alterar;

    public AlterarSenhaFrame() {
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.getContentPane().setBackground(new Color(50, 50, 50));
        this.setLayout(new GridBagLayout());

        this.renderizarComponentes();

        this.setVisible(true);
    }

    private void renderizarComponentes() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        jLabelTitulo = new JLabel("Alterar Senha");
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

        senha = new JLabel("Nova Senha:");
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
        gbc.gridy = 2;
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
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(panelConfirmarSenha, gbc);

        alterar = new JButton("Alterar");
        alterar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (inputSenha.getText().equals(inputConfirmarSenha.getText())) {
                    FuncionarioModel funcionario = new FuncionarioModel(inputCodigo.getText(), "", "", "", "", inputSenha.getText());
                    alterarSenha(funcionario);
                } else {
                    JOptionPane.showMessageDialog(null, "As senhas devem ser iguais");
                }

            }
        });
        alterar.setPreferredSize(new Dimension(200, 30));
        alterar.setBackground(new Color(130, 87, 229));
        alterar.setForeground(new Color(255, 255, 255));
        alterar.setBorder(null);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(alterar, gbc);
        
        JButton voltar = new JButton("Voltar ao Menu");
        voltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	goToAuth();
            }
        });
    	voltar.setBackground(new Color(130, 87, 229));
    	voltar.setPreferredSize(new Dimension(300, 30));
    	voltar.setForeground(new Color(255, 255, 255));
    	voltar.setBorder(null);
    	gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(voltar, gbc);

    }
    
    private void goToAuth() {
    	this.dispose();
    	SwingUtilities.invokeLater(() -> new AuthFrame());
    }

    protected void alterarSenha(FuncionarioModel funcionario) {
        FuncionarioService s = new FuncionarioService();
        boolean status = s.alterarSenha(funcionario);
        if (status) {
            JOptionPane.showMessageDialog(null, "Senha alterada com sucesso");
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao alterar senha");
        }
    }
}
