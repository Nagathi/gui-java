package clientside;


public class Corrente extends Conta {
	
	public Corrente(String nome, String nascimento, String cpf, String usuario, String senha){
		this.setNome(nome);
		this.setNascimento(nascimento);
		this.setCpf(cpf);
		this.setUsuario(usuario);
		this.setSenha(senha);
		this.setTipo("Conta Corrente");
		this.setDinheiro(500);
		this.setMensal(50f);
		this.setEmprestimo(false);
	}
	

}
