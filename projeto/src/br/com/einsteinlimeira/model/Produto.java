package br.com.einsteinlimeira.model;

public class Produto {

	private String nome;
	private String codigo;
	private String tipo;
	private String marca;
	
	public Produto (String nome, String codigo, String tipo, String marca) {
		this.setNome(nome);
		this.setCodigo(codigo);
		this.setTipo(tipo);
		this.setMarca(marca);
}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
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
}