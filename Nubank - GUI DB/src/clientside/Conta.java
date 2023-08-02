package clientside;

public class Conta{
	
	private String nome;
	private String nascimento;
	private String cpf;
	private String usuario;
	private String senha;
	private String tipo;
	private boolean emprestimo;
	
	private float dinheiro;
	private float mensal;
	public int contaMensal = 0;
	private int id;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNascimento() {
		return nascimento;
	}
	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
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
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public float getDinheiro() {
		return dinheiro;
	}
	public void setDinheiro(float dinheiro) {
		this.dinheiro = dinheiro;
	}
	public float getMensal() {
		return mensal;
	}
	public void setMensal(float mensal) {
		this.mensal = mensal;
	}
	public boolean getEmprestimo() {
		return emprestimo;
	}
	public void setEmprestimo(boolean emprestimo) {
		this.emprestimo = emprestimo;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public void sacar(float valor) {
		this.setDinheiro(this.getDinheiro() - valor);
	}

	public void depositar(float valor) {
		this.setDinheiro(this.getDinheiro() + valor);
	}
	public void emprestar(float valor) {
		
		this.setEmprestimo(true);
		this.setDinheiro(this.getDinheiro() + valor);
		this.setMensal(this.getMensal() + valor/5);
		
	}
	
	public void pagarMensal() {
		
		this.setDinheiro(this.getDinheiro() - this.getMensal());
		
		if(this.getEmprestimo()) {
			contaMensal++;
			System.out.println(contaMensal);
			if(contaMensal >= 5) {
				
				contaMensal = 0;
				this.setMensal(50);
				this.setEmprestimo(false);
				
			}
		}
	}
}
