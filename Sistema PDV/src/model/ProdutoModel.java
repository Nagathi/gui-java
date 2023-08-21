package model;

public class ProdutoModel {
	private int id;
    private String codigo;
    private String nome;
    private String marca;
    private float preco;
    
    public ProdutoModel(String codigo, String nome, String marca, float preco) {
    	this.codigo = codigo;
    	this.nome = nome;
    	this.marca = marca;
    	this.preco = preco;
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
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
}
