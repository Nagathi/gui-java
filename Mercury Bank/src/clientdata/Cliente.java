package clientdata;

import java.util.ArrayList;

public class Cliente {
	private String nome, ano, cpf, usuario, senha;
	private ArrayList<Conta> contas = new ArrayList<Conta>();
	
	public void cadastrar(String nome, String ano, String cpf, String usuario, String senha, Conta corrente, Conta poupanca) {
		
		this.nome = nome;
		this.ano = ano;
		this.cpf = cpf;
		this.usuario = usuario;
		this.senha = senha;
		this.contas.add(corrente);
		this.contas.add(poupanca);
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
