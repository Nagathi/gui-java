package model;

public class FuncionarioModel {
	private int id;
	private String codigo;
    private String nome;
    private String cargo;
    private String tipo;
    private String usuario;
    private String senha;
    
    public FuncionarioModel(String codigo, String nome, String cargo, String tipo, String usuario, String senha) {
    	this.codigo = codigo;
    	this.nome = nome;
    	this.cargo = cargo;
    	this.tipo = tipo;
    	this.setUsuario(usuario);
    	this.setSenha(senha);
    	
    }
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
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
