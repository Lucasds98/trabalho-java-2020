package br.com.vendas.model.domain;

public class ProdutoFornecedor {

	private String nomeProduto;
	private String nomeFornecedor;
	private String razaoSocial;
	
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	public String getNomeFornecedor() {
		return nomeFornecedor;
	}
	public void setNomeFornecedor(String nomeFornecedor) {
		this.nomeFornecedor = nomeFornecedor;
	}
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public ProdutoFornecedor(String nomeProduto, String nomeFornecedor, String razaoSocial) {
		super();
		this.nomeProduto = nomeProduto;
		this.nomeFornecedor = nomeFornecedor;
		this.razaoSocial = razaoSocial;
	}
	public ProdutoFornecedor() {
		super();
	}
	
	
}
