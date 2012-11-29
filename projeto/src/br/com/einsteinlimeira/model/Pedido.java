package br.com.einsteinlimeira.model;

/**
 * Representação do pedido no sistema.
 * 
 * @author Ricardo
 */
public class Pedido {

	private String nomeCliente;
	private String codeCompra;
	private String codeProduto;
	private String qtd;
	private String valor;
	
	public Pedido (String nomeCliente, String codeCompra, String codeProduto, String qtd, String valor) {
		this.setNomeCliente(nomeCliente);
		this.setCodeCompra(codeCompra);
		this.setCodeProduto(codeProduto);
		this.setQtd(qtd);
		this.setValor(valor);
}

	public String getQtd() {
		return qtd;
	}

	public void setQtd(String qtd) {
		this.qtd = qtd;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getCodeProduto() {
		return codeProduto;
	}

	public void setCodeProduto(String codeProduto) {
		this.codeProduto = codeProduto;
	}

	public String getCodeCompra() {
		return codeCompra;
	}

	public void setCodeCompra(String codeCompra) {
		this.codeCompra = codeCompra;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
}