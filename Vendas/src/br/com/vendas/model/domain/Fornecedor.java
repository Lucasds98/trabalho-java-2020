package br.com.vendas.model.domain;

import util.ValidacaoException;

public class Fornecedor extends Pessoa {

	private String razaoSocial;
	
	private String cnpj;

	public Fornecedor(Integer codigo, String email, String nome, String razaoSocial, String cnpj) {
		super(codigo, email, nome);
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
	}

	public void valida() throws ValidacaoException {
		super.valida();
		if (razaoSocial == null || razaoSocial.equals("")) {
			throw new ValidacaoException("o campo razao social é obrigatorio");
		}
		if (cnpj == null || cnpj.equals("")) {
			throw new ValidacaoException("o campo cnpj é obrigatorio");
		}
	}

	public Fornecedor() {
		super();
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	
}
