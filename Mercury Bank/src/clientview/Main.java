package clientview;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Panel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import clientdata.Cliente;
import clientdata.Corrente;
import clientdata.Poupanca;
import database.ClientesDAO;
import database.Connect;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Main {

	private JFrame home, cadastro, login, menu;
	private JTextField jtxtNome, jtxtAno, jtxtCpf, jtxtUsuario, jtxtSenha, jtxtConfirmarSenha;
	private ArrayList<Cliente> lista_clientes = new ArrayList();
	ImageIcon minato_front = new ImageIcon(getClass().getResource("minato_front.png"));
	ImageIcon minato_back = new ImageIcon(getClass().getResource("minato_back.png"));
	ImageIcon minato_right = new ImageIcon(getClass().getResource("minato_right.png"));
	ImageIcon minato_left = new ImageIcon(getClass().getResource("minato_left.png"));
	private JLabel labelMinato = new JLabel(minato_front);
	
	JButton btnVoltar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.home.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		Connect javaDatabaseConnect = new Connect();
		javaDatabaseConnect.connectDB();
		
		home = new JFrame();
		home.setBounds(100, 100, 450, 350);
		home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		home.getContentPane().setLayout(null);
		home.setLocationRelativeTo(null);
		
		cadastro = new JFrame();
		cadastro.setBounds(100, 100, 450, 350);
		cadastro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cadastro.getContentPane().setLayout(null);
		cadastro.setLocationRelativeTo(null);
		
		login = new JFrame();
		login.setBounds(100, 100, 450, 350);
		login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		login.getContentPane().setLayout(null);
		login.setLocationRelativeTo(null);
		
		menu = new JFrame();
		menu.setBounds(100, 100, 1366, 768);
		menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menu.getContentPane().setLayout(null);
		menu.setLocationRelativeTo(null);
		menu.getContentPane().setBackground(new Color(0, 128, 128));
		
		Panel panelHome = new Panel();
		panelHome.setBackground(new Color(0, 128, 128));
		panelHome.setBounds(0, 0, 434, 82);
		home.getContentPane().add(panelHome);
		panelHome.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel labelLogo = new JLabel("Mercury Bank");
		labelLogo.setFont(new Font("Yu Gothic UI", Font.PLAIN, 40));
		labelLogo.setForeground(new Color(240, 248, 255));
		panelHome.add(labelLogo);
		
		JButton btnCadastro = new JButton("Cadastro");
		btnCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				home.setVisible(false);
				cadastro.setVisible(true);
				
				JLabel lblNome = new JLabel("Nome: ");
				lblNome.setBounds(100, 60, 100, 20);
				jtxtNome = new JTextField();
				jtxtNome.setBounds(200, 60, 100, 20);
				cadastro.getContentPane().add(lblNome);
				cadastro.getContentPane().add(jtxtNome);
				
				JLabel lblAno = new JLabel("Data de Nasc.: ");
				lblAno.setBounds(100, 90, 100, 20);
				jtxtAno = new JTextField();
				jtxtAno.setBounds(200, 90, 100, 20);
				cadastro.getContentPane().add(lblAno);
				cadastro.getContentPane().add(jtxtAno);
				
				JLabel lblCpf = new JLabel("CPF: ");
				lblCpf.setBounds(100, 120, 100, 20);
				jtxtCpf = new JTextField();
				jtxtCpf.setBounds(200, 120, 100, 20);
				cadastro.getContentPane().add(lblCpf);
				cadastro.getContentPane().add(jtxtCpf);
				
				JLabel lblUsuario = new JLabel("Usuário: ");
				lblUsuario.setBounds(100, 150, 100, 20);
				jtxtUsuario = new JTextField();
				jtxtUsuario.setBounds(200, 150, 100, 20);
				cadastro.getContentPane().add(lblUsuario);
				cadastro.getContentPane().add(jtxtUsuario);
				
				JLabel lblSenha = new JLabel("Senha: ");
				lblSenha.setBounds(100, 180, 100, 20);
				jtxtSenha = new JTextField();
				jtxtSenha.setBounds(200, 180, 100, 20);
				cadastro.getContentPane().add(lblSenha);
				cadastro.getContentPane().add(jtxtSenha);
				
				JLabel lblConfirmarSenha = new JLabel("Confirmar: ");
				lblConfirmarSenha.setBounds(100, 210, 100, 20);
				jtxtConfirmarSenha = new JTextField();
				jtxtConfirmarSenha.setBounds(200, 210, 100, 20);
				cadastro.getContentPane().add(lblConfirmarSenha);
				cadastro.getContentPane().add(jtxtConfirmarSenha);
				
				JButton btnConfirmar = new JButton("Confirmar");
				btnConfirmar.setBounds(200, 240, 100, 25);
				btnConfirmar.setBackground(new Color(0, 128, 128));
				btnConfirmar.setForeground(new Color(240, 248, 255));
				btnConfirmar.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
				cadastro.getContentPane().add(btnConfirmar);
				
				btnVoltar = new JButton("<-");
				btnVoltar.setBounds(10, 10, 50, 30);
				btnVoltar.setBackground(new Color(0, 128, 128));
				btnVoltar.setForeground(new Color(240, 248, 255));
				btnVoltar.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
				cadastro.getContentPane().add(btnVoltar);
				btnVoltar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						jtxtUsuario.setText(null);
						jtxtSenha.setText(null);
						cadastro.setVisible(false);
						home.setVisible(true);
					}
				});
				
				btnConfirmar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						jtxtUsuario.setText(null);
						jtxtSenha.setText(null);
						cadastrar();
					}
				});
				
			}
		});
		
		btnCadastro.setBackground(new Color(0, 128, 128));
		btnCadastro.setForeground(new Color(240, 248, 255));
		btnCadastro.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		btnCadastro.setBounds(158, 107, 110, 23);
		home.getContentPane().add(btnCadastro);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				home.setVisible(false);
				login.setVisible(true);
				
				JLabel lblUsuario = new JLabel("Usuário: ");
				lblUsuario.setBounds(100, 50, 100, 20);
				jtxtUsuario = new JTextField();
				jtxtUsuario.setBounds(200, 50, 100, 20);
				login.getContentPane().add(lblUsuario);
				login.getContentPane().add(jtxtUsuario);
				
				JLabel lblSenha = new JLabel("Senha: ");
				lblSenha.setBounds(100, 80, 100, 20);
				jtxtSenha = new JTextField();
				jtxtSenha.setBounds(200, 80, 100, 20);
				login.getContentPane().add(lblSenha);
				login.getContentPane().add(jtxtSenha);
			
				JButton btnConfirmar = new JButton("Login");
				btnConfirmar.setBounds(200, 110, 100, 25);
				btnConfirmar.setBackground(new Color(0, 128, 128));
				btnConfirmar.setForeground(new Color(240, 248, 255));
				btnConfirmar.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
				login.getContentPane().add(btnConfirmar);

				btnVoltar = new JButton("<-");
				btnVoltar.setBounds(10, 10, 50, 30);
				btnVoltar.setBackground(new Color(0, 128, 128));
				btnVoltar.setForeground(new Color(240, 248, 255));
				btnVoltar.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
				login.getContentPane().add(btnVoltar);
				btnVoltar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						jtxtUsuario.setText(null);
						jtxtSenha.setText(null);
						login.setVisible(false);
						home.setVisible(true);
						
					}
				});
				
				btnConfirmar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						jtxtUsuario.setText(null);
						jtxtSenha.setText(null);
						logar();
					}
				});
			}
		});
		
		btnLogin.setBackground(new Color(0, 128, 128));
		btnLogin.setForeground(new Color(240, 248, 255));
		btnLogin.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		btnLogin.setBounds(158, 137, 110, 23);
		home.getContentPane().add(btnLogin);
		
		Panel panelMenu = new Panel();
		panelMenu.setBackground(new Color(255, 255, 255));
		panelMenu.setBounds(0, 0, 1366, 80);
		panelMenu.setLayout(null);
		menu.getContentPane().add(panelMenu);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu.setVisible(false);
				home.setVisible(true);
			}
		});
		btnSair.setBackground(new Color(0, 128, 128));
		btnSair.setForeground(new Color(240, 248, 255));
		btnSair.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		btnSair.setBounds(600, 10, 110, 23);
		panelMenu.add(btnSair);
		
		JButton btnSacar = new JButton("Sacar");
		btnSacar.setBackground(new Color(0, 128, 128));
		btnSacar.setForeground(new Color(240, 248, 255));
		btnSacar.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		btnSacar.setBounds(750, 10, 110, 23);
		panelMenu.add(btnSacar);
		
		JButton btnDepositar = new JButton("Depositar");
		btnDepositar.setBackground(new Color(0, 128, 128));
		btnDepositar.setForeground(new Color(240, 248, 255));
		btnDepositar.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		btnDepositar.setBounds(900, 10, 110, 23);
		panelMenu.add(btnDepositar);
		
		JButton btnEmprestar = new JButton("Emprestar");
		btnEmprestar.setBackground(new Color(0, 128, 128));
		btnEmprestar.setForeground(new Color(240, 248, 255));
		btnEmprestar.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		btnEmprestar.setBounds(1050, 10, 110, 23);
		panelMenu.add(btnEmprestar);
		
		JButton btnPagar = new JButton("Pagar");
		btnPagar.setBackground(new Color(0, 128, 128));
		btnPagar.setForeground(new Color(240, 248, 255));
		btnPagar.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		btnPagar.setBounds(1200, 10, 110, 23);
		panelMenu.add(btnPagar);
		
		labelMinato.setBounds(10, 10, 250, 100);
		panelMenu.add(labelMinato);
		
	}
	
	public void cadastrar() {
		
		String getTxtNome = jtxtNome.getText();
		String getTxtAno = jtxtAno.getText();
		String getTxtCpf = jtxtCpf.getText();
		String getTxtUsuario = jtxtUsuario.getText();
		String getTxtSenha = jtxtSenha.getText();
		String getTxtConfirmarSenha = jtxtConfirmarSenha.getText();
		
		boolean verificado = false;
		
		if(getTxtSenha.equals(getTxtConfirmarSenha)) {
			verificado = true;
		}
		
		if(verificado) {
			
			ClientesDAO dbCliente = new ClientesDAO();
			lista_clientes = dbCliente.listar_cliente();
			
			java.util.Iterator<Cliente> it = lista_clientes.iterator();
			
			boolean aprovado = true;
			
			while(it.hasNext()) {
				Cliente c = (Cliente) it.next();
				
				if(getTxtUsuario.equals(c.getUsuario())) {
					aprovado = false;
				}
				
				
			}
			
			if(aprovado) {
				
				Cliente cli = new Cliente();
				Corrente cc = new Corrente();
				Poupanca cp = new Poupanca();
				cli.cadastrar(getTxtNome, getTxtAno, getTxtCpf, getTxtUsuario, getTxtSenha, cc, cp);
				dbCliente.cadastrar_cliente(cli);
				
				JOptionPane.showMessageDialog(null, "Cadastrado. Login automático");
				login.setVisible(false);
				menu.setVisible(true);
				
			}else {
				JOptionPane.showMessageDialog(null, "Usuário já existe. Tente outro");
			}
			
			
		}else {
			JOptionPane.showMessageDialog(null, "Senhas não coincidem");
		}
	}
	
	public void logar() {
		
		String getTxtUsuario = jtxtUsuario.getText();
		String getTxtSenha = jtxtSenha.getText();
		
		ClientesDAO dbCliente = new ClientesDAO();
		lista_clientes = dbCliente.listar_cliente();
		
		java.util.Iterator<Cliente> it = lista_clientes.iterator();
		
		boolean aprovado = false;
		
		while(it.hasNext()) {
			Cliente c = (Cliente) it.next();
			
			if(getTxtUsuario.equals(c.getUsuario()) && getTxtSenha.equals(c.getSenha())) {
				aprovado = true;
			}
			
		}
		
		if(aprovado) {
			
			login.setVisible(false);
			menu.setVisible(true);
			
		}else {
			JOptionPane.showMessageDialog(null, "Usuário não existe ou senha inválida");
		}
		
	}
	
}
