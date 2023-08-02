package clientside;

public class Poupanca extends Conta{
	
	public Poupanca(String nome, String nascimento, String cpf, String usuario, String senha){
		this.setNome(nome);
		this.setNascimento(nascimento);
		this.setCpf(cpf);
		this.setUsuario(usuario);
		this.setSenha(senha);
		this.setTipo("Conta Poupança");
		this.setDinheiro(1000);
		this.setMensal(150f);
		this.setEmprestimo(false);
	}
}
