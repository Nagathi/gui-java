package graphical;
import java.awt.EventQueue;
import java.util.*;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import clientside.*;

import java.awt.event.ActionListener;
import java.io.*;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPanel;

public class Main{

	private JFrame menu;
	private JFrame cadastro;
	private JFrame fechar;
	private JFrame sacar;
	private JFrame depositar;
	private JFrame emprestar;
	private JFrame mensal;
	private JFrame buscar;
	
	private JTextField recNome, recAno, recCpf, recUser, recPass;
	private JTextField recBuscarFechar, recBuscarSacar, recBuscarDepositar, recBuscarEmprestar, recBuscarMensal, recBuscarConta;
	private JTextField recValorSacar, recValorDepositar, recValorEmprestar; 
	List lista_contas = new ArrayList<Conta>();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.menu.setVisible(true);
				}catch(Exception e) {
					e.setStackTrace(null);
				}
				
			}
		});
	}

	/**
	 * Create the application. 
	 */
	public Main(){
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 *  
	 */
	private void initialize(){
		
		// Criando todas as janelas do programa
		menu = new JFrame();
		menu.getContentPane().setBackground(new Color(230, 230, 250));
		menu.setBackground(new Color(255, 255, 255));
		menu.setBounds(100, 100, 450, 300);
		menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		cadastro = new JFrame();
		cadastro.setBounds(100, 100, 450, 300);
		cadastro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		fechar = new JFrame();
		fechar.setBounds(100, 100, 450, 300);
		fechar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		sacar = new JFrame();
		sacar.setBounds(100, 100, 450, 300);
		sacar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		depositar = new JFrame();
		depositar.setBounds(100, 100, 450, 300);
		depositar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		emprestar = new JFrame();
		emprestar.setBounds(100, 100, 450, 300);
		emprestar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mensal = new JFrame();
		mensal.setBounds(100, 100, 450, 300);
		mensal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		buscar = new JFrame();
		buscar.setBounds(100, 100, 450, 300);
		buscar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		//Menu principal
		JButton btnAbrirConta 	= new JButton("Abrir Conta");
		btnAbrirConta.setForeground(new Color(230, 230, 250));
		btnAbrirConta.setToolTipText("");
		btnAbrirConta.setFont(new Font("Courier New", Font.BOLD, 14));
		btnAbrirConta.setBackground(new Color(148, 0, 211));
		btnAbrirConta.setBounds(168, 73, 130, 23);
		JButton btnFecharConta 	= new JButton("Fechar Conta");
		btnFecharConta.setForeground(new Color(230, 230, 250));
		btnFecharConta.setFont(new Font("Courier New", Font.BOLD, 14));
		btnFecharConta.setBackground(new Color(148, 0, 211));
		btnFecharConta.setBounds(168, 93, 130, 23);
		JButton btnSacar 		= new JButton("Sacar");
		btnSacar.setForeground(new Color(230, 230, 250));
		btnSacar.setBackground(new Color(148, 0, 211));
		btnSacar.setFont(new Font("Courier New", Font.BOLD, 14));
		btnSacar.setBounds(168, 113, 130, 23);
		JButton btnDepositar 	= new JButton("Depositar");
		btnDepositar.setForeground(new Color(230, 230, 250));
		btnDepositar.setFont(new Font("Courier New", Font.BOLD, 14));
		btnDepositar.setBackground(new Color(148, 0, 211));
		btnDepositar.setBounds(168, 133, 130, 23);
		JButton btnEmprestar 	= new JButton("Emprestar");
		btnEmprestar.setForeground(new Color(230, 230, 250));
		btnEmprestar.setBackground(new Color(148, 0, 211));
		btnEmprestar.setFont(new Font("Courier New", Font.BOLD, 14));
		btnEmprestar.setBounds(168, 153, 130, 23);
		JButton btnPagarMensal 	= new JButton("Pagar Mensalidade");
		btnPagarMensal.setForeground(new Color(230, 230, 250));
		btnPagarMensal.setBackground(new Color(148, 0, 211));
		btnPagarMensal.setFont(new Font("Courier New", Font.BOLD, 14));
		btnPagarMensal.setBounds(168, 173, 130, 23);
		JButton btnBuscarConta 	= new JButton("Buscar Conta");
		btnBuscarConta.setForeground(new Color(230, 230, 250));
		btnBuscarConta.setBackground(new Color(148, 0, 211));
		btnBuscarConta.setFont(new Font("Courier New", Font.BOLD, 14));
		btnBuscarConta.setBounds(168, 193, 130, 23);
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setForeground(new Color(230, 230, 250));
		btnSalvar.setBackground(new Color(148, 0, 211));
		btnSalvar.setFont(new Font("Courier New", Font.BOLD, 14));
		btnSalvar.setBounds(335, 62, 89, 23);
		
		menu.getContentPane().setLayout(null);
		
		menu.getContentPane().add(btnAbrirConta);
		menu.getContentPane().add(btnFecharConta);
		menu.getContentPane().add(btnSacar);
		menu.getContentPane().add(btnDepositar);
		menu.getContentPane().add(btnEmprestar);
		menu.getContentPane().add(btnBuscarConta);
		menu.getContentPane().add(btnPagarMensal);
		menu.getContentPane().add(btnSalvar);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(148, 0, 211));
		panel.setBounds(0, 0, 434, 62);
		menu.getContentPane().add(panel);
		
		JLabel labelTtile = new JLabel("Nubank");
		labelTtile.setForeground(new Color(230, 230, 250));
		labelTtile.setFont(new Font("Courier New", Font.PLAIN, 40));
		panel.add(labelTtile);
		
		//Eventos
		
		recNome= new JTextField();
		recAno= new JTextField();
		recCpf= new JTextField();
		recUser = new JTextField();
		recPass= new JTextField();
		recBuscarFechar = new JTextField();
		recBuscarSacar = new JTextField();
		recBuscarDepositar = new JTextField();
		recBuscarEmprestar = new JTextField();
		recBuscarMensal = new JTextField();
		recValorSacar = new JTextField();
		recValorDepositar = new JTextField();
		recValorEmprestar = new JTextField();
		
		JButton btnVoltar = new JButton("<-");
		btnVoltar.setForeground(new Color(230, 230, 250));
		btnVoltar.setBackground(new Color(148, 0, 211));
		btnVoltar.setFont(new Font("Courier New", Font.BOLD, 14));
		btnVoltar.setBounds(10, 10, 50, 23);
		
		try {
			FileInputStream read_contas = new FileInputStream("contas.dat");
			lista_contas = (List) new ObjectInputStream(read_contas).readObject();
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e);
		}
		
		btnAbrirConta.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				menu.setVisible(false);
				cadastro.setVisible(true);
				cadastro.getContentPane().setLayout(null);
				
				JLabel labelNome = new JLabel("Nome:");
				labelNome.setBounds(78, 19, 130, 23);
				recNome.setBounds(168, 19, 130, 23);
				
				JLabel labelAno = new JLabel("Data de Nasc.:");
				labelAno.setBounds(78, 49, 130, 23);
				recAno.setBounds(168, 49, 130, 23);
				
				JLabel labelCpf = new JLabel("CPF:");
				labelCpf.setBounds(78, 79, 130, 23);
				recCpf.setBounds(168, 79, 130, 23);
				
				JLabel labelUser = new JLabel("Usuário:");
				labelUser.setBounds(78, 109, 130, 23);
				recUser.setBounds(168, 109, 130, 23);
				
				JLabel labelPass = new JLabel("Senha:");
				labelPass.setBounds(78, 139, 130, 23);
				recPass.setBounds(168, 139, 130, 23);
				
				JCheckBox checkCorrente = new JCheckBox("Corrente");
				JCheckBox checkPoupanca = new JCheckBox("Poupança");
				
				checkCorrente.setBounds(108, 169, 130, 23);
				checkPoupanca.setBounds(248, 169, 130, 23);
				
				
				cadastro.getContentPane().add(labelNome);
				cadastro.getContentPane().add(recNome);
				
				cadastro.getContentPane().add(labelAno);
				cadastro.getContentPane().add(recAno);
				
				cadastro.getContentPane().add(labelCpf);
				cadastro.getContentPane().add(recCpf);
				
				cadastro.getContentPane().add(labelUser);
				cadastro.getContentPane().add(recUser);
				
				cadastro.getContentPane().add(labelPass);
				cadastro.getContentPane().add(recPass);
				
				cadastro.getContentPane().add(checkCorrente);
				cadastro.getContentPane().add(checkPoupanca);
				
				JButton btnOk = new JButton("OK");
				btnOk.setBounds(158, 229, 130, 23);
				btnOk.setForeground(new Color(230, 230, 250));
				btnOk.setFont(new Font("Courier New", Font.BOLD, 14));
				btnOk.setBackground(new Color(148, 0, 211));
				
				cadastro.getContentPane().add(btnOk);
				cadastro.getContentPane().add(btnVoltar);
				
				
				btnVoltar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						cadastro.dispose();
						menu.setVisible(true);
					}
				});
				
				btnOk.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						String nome 	= recNome.getText();
						String ano 		= recAno.getText();
						String cpf 		= recCpf.getText();
						String user 	= recUser.getText();
						String pass 	= recPass.getText();
						
						boolean autorizar = true;
							
						if(checkCorrente.isSelected() && checkPoupanca.isSelected()) {
							JOptionPane.showMessageDialog(null, "Selecione apenas um tipo de conta");
						}else {
							try {
								FileInputStream read_contas = new FileInputStream("contas.dat");
								ObjectInputStream in = new ObjectInputStream(read_contas);
								lista_contas = (List) in.readObject();
							}catch(Exception e1) {
								JOptionPane.showMessageDialog(null, "Erro: " + e);
							}
							Iterator it = lista_contas.iterator();
							while(it.hasNext()) {
								Conta c = (Conta) it.next();
								
								if(pass.equals(c.getUsuario())) {
									autorizar = false;
								}
							}
							if(checkCorrente.isSelected() && autorizar) {
								Conta cc = new Corrente();
								cc.abrirConta(nome, ano, cpf, user, pass, "CC");
								lista_contas.add(cc);
								JOptionPane.showMessageDialog(null, "Conta cadastrada!");
								checkCorrente.setSelected(false);
								cadastro.dispose();
								menu.setVisible(true);
								
							}else if(checkPoupanca.isSelected() && autorizar) {
								Conta cp = new Poupanca();
								cp.abrirConta(nome, ano, cpf, user, pass, "CP");
								lista_contas.add(cp);
								JOptionPane.showMessageDialog(null, "Conta cadastrada!");
								checkPoupanca.setSelected(false);
								cadastro.dispose();
								menu.setVisible(true);
								
							}else{
								if(!autorizar) {
									JOptionPane.showMessageDialog(null, "Conta já cadastrada!");
								}else {
									JOptionPane.showMessageDialog(null, "Algo deu errado, nos desculpe! Usuário pode já ");
								}
							}
							recNome.setText(null);
							recAno.setText(null);
							recCpf.setText(null);
							recUser.setText(null);
							recPass.setText(null);
						}
					}
				});	
			}
		});
		
		btnFecharConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu.setVisible(false);
				fechar.setVisible(true);
				fechar.getContentPane().setLayout(null);
				
				JLabel labelBuscar = new JLabel("Usuário:");;
				labelBuscar.setBounds(58, 79, 130, 23);
				recBuscarFechar.setBounds(158, 79, 130, 23);
				
				fechar.getContentPane().add(labelBuscar);
				fechar.getContentPane().add(recBuscarFechar);
				
				JButton btnPesquisar = new JButton("Fechar");
				btnPesquisar.setBounds(158, 109, 130, 23);
				btnPesquisar.setForeground(new Color(230, 230, 250));
				btnPesquisar.setFont(new Font("Courier New", Font.BOLD, 14));
				btnPesquisar.setBackground(new Color(148, 0, 211));
				
				fechar.getContentPane().add(btnPesquisar);
				fechar.getContentPane().add(btnVoltar);
				
				btnVoltar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						fechar.dispose();
						menu.setVisible(true);
					}
				});
				
				btnPesquisar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {		
						
						String getTextBuscar = recBuscarFechar.getText();
						Iterator it = lista_contas.iterator();
						boolean verify = false;
						
						while(it.hasNext()) {
							Conta c = (Conta) it.next();
							
							if(getTextBuscar.equals(c.getUsuario()) && c.getDinheiro() <= 0f) {
								
								c.fecharConta();
								recBuscarFechar.setText(null);
								verify = true;
								fechar.dispose();
								menu.setVisible(true);
								
							}
 						}
						if(!verify) {
							JOptionPane.showMessageDialog(null, "OPS! Algo deu errado.");
						}
					}
				});
			}
		});
		btnSacar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu.setVisible(false);
				sacar.setVisible(true);
				sacar.getContentPane().setLayout(null);
				
				JLabel labelBuscar = new JLabel("Usuário:");
				labelBuscar.setBounds(58, 79, 130, 23);
				recBuscarSacar.setBounds(158, 79, 130, 23);
				
				JLabel labelValor = new JLabel("Valor:");
				labelValor.setBounds(58, 109, 130, 23);
				recValorSacar.setBounds(158, 109, 130, 23);
				
				JButton btnPesquisar = new JButton("Sacar");
				btnPesquisar.setBounds(158, 139, 130, 23);
				btnPesquisar.setForeground(new Color(230, 230, 250));
				btnPesquisar.setFont(new Font("Courier New", Font.BOLD, 14));
				btnPesquisar.setBackground(new Color(148, 0, 211));
				
				sacar.getContentPane().add(labelBuscar);
				sacar.getContentPane().add(recBuscarSacar);
				sacar.getContentPane().add(labelValor);
				sacar.getContentPane().add(recValorSacar);
				sacar.getContentPane().add(btnPesquisar);
				sacar.getContentPane().add(btnVoltar);
				
				btnVoltar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						sacar.dispose();
						menu.setVisible(true);
					}
				});
				
				btnPesquisar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String getTextBuscar = recBuscarSacar.getText();
						float getValor = Float.parseFloat(recValorSacar.getText());
						Iterator it = lista_contas.iterator();
						boolean verify = false;
						while(it.hasNext()) {
							Conta c = (Conta) it.next();
							
							if(getTextBuscar.equals(c.getUsuario())) {
								
								if(c.getDinheiro() >= getValor) {
									c.sacar(getValor);
									JOptionPane.showMessageDialog(null, "Saque efetuado!");
									recBuscarSacar.setText(null);
									recValorSacar.setText(null);
									sacar.dispose();
									menu.setVisible(true);
									verify = true;
								}			
							}
 						}
						if(!verify) {
							JOptionPane.showMessageDialog(null, "OPS! Algo deu errado.");
						}
					}
				});
			}
		});
		
		btnDepositar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				menu.setVisible(false);
				depositar.setVisible(true);
				depositar.getContentPane().setLayout(null);
				
				JLabel labelBuscar = new JLabel("Usuário:");
				labelBuscar.setBounds(58, 79, 130, 23);
				recBuscarDepositar.setBounds(158, 79, 130, 23);
				
				JLabel labelValor = new JLabel("Valor:");
				labelValor.setBounds(58, 109, 130, 23);
				recValorDepositar.setBounds(158, 109, 130, 23);
				
				JButton btnPesquisar = new JButton("Depositar");
				btnPesquisar.setBounds(158, 139, 130, 23);
				btnPesquisar.setForeground(new Color(230, 230, 250));
				btnPesquisar.setFont(new Font("Courier New", Font.BOLD, 14));
				btnPesquisar.setBackground(new Color(148, 0, 211));
				
				depositar.getContentPane().add(labelBuscar);
				depositar.getContentPane().add(recBuscarDepositar);
				depositar.getContentPane().add(labelValor);
				depositar.getContentPane().add(recValorDepositar);
				depositar.getContentPane().add(btnPesquisar);
				depositar.getContentPane().add(btnVoltar);
				
				btnVoltar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						depositar.dispose();
						menu.setVisible(true);
					}
				});
				
				btnPesquisar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String getTextBuscar = recBuscarDepositar.getText();
						float getValor = Float.parseFloat(recValorDepositar.getText());
						Iterator it = lista_contas.iterator();
						
						while(it.hasNext()) {
							Conta c = (Conta) it.next();
							
							if(getTextBuscar.equals(c.getUsuario())) {
								
								c.depositar(getValor);
								JOptionPane.showMessageDialog(null, "Depósito efetuado!");
								recBuscarDepositar.setText(null);
								recValorDepositar.setText(null);
								depositar.dispose();
								menu.setVisible(true);
							}
 						}
					}
				});
				
			}
		});
		btnEmprestar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu.setVisible(false);
				emprestar.setVisible(true);
				emprestar.getContentPane().setLayout(null);
				
				JLabel labelBuscar = new JLabel("Usuário:");
				labelBuscar.setBounds(58, 79, 130, 23);
				recBuscarEmprestar.setBounds(158, 79, 130, 23);
				
				JLabel labelValor = new JLabel("Valor:");
				labelValor.setBounds(58, 109, 130, 23);
				recValorEmprestar.setBounds(158, 109, 130, 23);
				
				JButton btnPesquisar = new JButton("Emprestar");
				btnPesquisar.setBounds(158, 139, 130, 23);
				btnPesquisar.setForeground(new Color(230, 230, 250));
				btnPesquisar.setFont(new Font("Courier New", Font.BOLD, 14));
				btnPesquisar.setBackground(new Color(148, 0, 211));
				
				emprestar.getContentPane().add(labelBuscar);
				emprestar.getContentPane().add(recBuscarEmprestar);
				emprestar.getContentPane().add(labelValor);
				emprestar.getContentPane().add(recValorEmprestar);
				emprestar.getContentPane().add(btnPesquisar);
				emprestar.getContentPane().add(btnVoltar);
				
				btnVoltar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						emprestar.dispose();
						menu.setVisible(true);
					}
				});
				
				btnPesquisar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String getTextBuscar = recBuscarEmprestar.getText();
						float getValor = Float.parseFloat(recValorEmprestar.getText());
						Iterator it = lista_contas.iterator();
						boolean verify = false;
						while(it.hasNext()) {
							Conta c = (Conta) it.next();
							
							if(getTextBuscar.equals(c.getUsuario()) && !c.getEmprestimo()) {
								
								c.emprestar(getValor);
								JOptionPane.showMessageDialog(null, "Empréstimo efetuado!");
								recBuscarEmprestar.setText(null);
								recValorEmprestar.setText(null);
								emprestar.dispose();	
								menu.setVisible(true);
								c.setEmprestimo(true);
								verify = true;
							}
 						}
						if(!verify) {
							JOptionPane.showMessageDialog(null, "OPS! Algo deu errado.");
						}
					}
				});
			}
		});
		btnPagarMensal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu.setVisible(false);
				mensal.setVisible(true);
				mensal.getContentPane().setLayout(null);
				
				JLabel labelBuscar = new JLabel("Usuário:");
				labelBuscar.setBounds(58, 79, 130, 23);
				recBuscarMensal.setBounds(158, 79, 130, 23);
				
				JButton btnPesquisar = new JButton("Pagar");
				btnPesquisar.setBounds(158, 109, 130, 23);
				btnPesquisar.setForeground(new Color(230, 230, 250));
				btnPesquisar.setFont(new Font("Courier New", Font.BOLD, 14));
				btnPesquisar.setBackground(new Color(148, 0, 211));
				
				mensal.getContentPane().add(labelBuscar);
				mensal.getContentPane().add(recBuscarMensal);
				mensal.getContentPane().add(btnPesquisar);
				mensal.getContentPane().add(btnVoltar);
				
				btnVoltar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						mensal.dispose();
						menu.setVisible(true);
					}
				});
				
				btnPesquisar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String getTextBuscar = recBuscarMensal.getText();
						Iterator it = lista_contas.iterator();
						
						while(it.hasNext()) {
							Conta c = (Conta) it.next();
							
							if(getTextBuscar.equals(c.getUsuario()) && c.getDinheiro() >= c.getMensal()) {
								
								c.pagarMensal();
								JOptionPane.showMessageDialog(null, "Mensalidade paga!");
								recBuscarMensal.setText(null);
								mensal.dispose();
								menu.setVisible(true);
							}
 						}
					}
				});
				
			}
		});
		
		recBuscarConta = new JTextField();
		btnBuscarConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu.setVisible(false);
				buscar.setVisible(true);
				buscar.getContentPane().setLayout(null);
				
				JLabel labelBuscarConta = new JLabel("Usuário:");
				labelBuscarConta.setBounds(58, 79, 130, 23);
				recBuscarConta.setBounds(158, 79, 130, 23);
				
				JButton btnBuscar = new JButton("Pesquisar");
				btnBuscar.setBounds(158, 109, 130, 23);
				btnBuscar.setForeground(new Color(230, 230, 250));
				btnBuscar.setFont(new Font("Courier New", Font.BOLD, 14));
				btnBuscar.setBackground(new Color(148, 0, 211));
				
				buscar.getContentPane().add(labelBuscarConta);
				buscar.getContentPane().add(recBuscarConta);
				buscar.getContentPane().add(btnBuscar);
				buscar.getContentPane().add(btnVoltar);
				
				btnVoltar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						buscar.dispose();
						menu.setVisible(true);
					}
				});
				
				btnBuscar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						boolean verificar = false;
						String getTextBuscarConta = recBuscarConta.getText();
						Iterator it = lista_contas.iterator();
						
						while(it.hasNext()) {
							Conta c = (Conta) it.next();
							if(getTextBuscarConta.equals(c.getUsuario())) {
								JOptionPane.showMessageDialog(null, 
										
										"\n Nome: " 				+ c.getNome() 			+
										"\n Data de Nascimento: " 	+ c.getNascimento() 	+
										"\n Dinheiro: " 			+ c.getDinheiro() 		+
										"\n Usuário: " 				+ c.getUsuario() 		+
										"\n Senha: " 				+ c.getSenha() 			+
										"\n CPF: " 					+ c.getCpf() 			+
										"\n Tipo: " 				+ c.getTipo() 			+
										"\n Mensalidade: " 			+ c.getMensal() 		+
										"\n Empréstimo: " 			+ c.getEmprestimo()
										
								);
								
								verificar = true;
								recBuscarConta.setText("");
								buscar.dispose();
								menu.setVisible(true);
								
							}
 						}
						if(!verificar) {
							JOptionPane.showMessageDialog(null, "Algo deu errado");
						}
					}
				});
			}
		});
		
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					FileOutputStream write_contas = new FileOutputStream("contas.dat");
					ObjectOutputStream out = new ObjectOutputStream(write_contas);
					out.writeObject(lista_contas);
					JOptionPane.showMessageDialog(null, "Informações salvas!");
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Erro!" + e1.getStackTrace());
				}
			}
		});
	}
}
