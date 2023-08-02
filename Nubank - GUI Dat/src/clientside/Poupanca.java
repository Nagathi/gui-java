package clientside;
import java.io.Serializable;

public class Poupanca extends Conta
implements Serializable{
	
	public float valor;
	public int contaMensal = 0;
	
	public Poupanca(){
		this.setNome(null);
		this.setNascimento(null);
		this.setCpf(null);
		this.setUsuario(null);
		this.setSenha(null);
		this.setTipo("Conta Poupança");
		this.setDinheiro(1000);
		this.setMensal(150f);
	}
	public void fecharConta() {
		this.setNome(null);
		this.setNascimento(null);
		this.setCpf(null);
		this.setUsuario(null);
		this.setSenha(null);
		this.setTipo("Conta Poupança");
	}
	public void abrirConta(String nome, String nascimento, String cpf, String usuario, String senha, String tipo) {
		this.setNome(nome);
		this.setNascimento(nascimento);
		this.setCpf(cpf);
		this.setUsuario(usuario);
		this.setSenha(senha);
		this.setEmprestimo(false);
	}
	public void sacar(float valor) {
		this.setDinheiro(this.getDinheiro() - valor);
	}
	public void depositar(float valor) {
		this.setDinheiro(this.getDinheiro() + valor);
	}
	public void emprestar(float valor) {
		this.setDinheiro(this.getDinheiro() + valor);
		this.setMensal(this.getMensal() + valor/12);
	}
	public void pagarMensal() {
		this.setDinheiro(this.getDinheiro() - this.getMensal());
		if(this.getEmprestimo()) {
			contaMensal++;
			if(contaMensal >= 12) {
				contaMensal = 0;
				this.setMensal(150);
				this.setEmprestimo(false);
			}
		}
	}
}
