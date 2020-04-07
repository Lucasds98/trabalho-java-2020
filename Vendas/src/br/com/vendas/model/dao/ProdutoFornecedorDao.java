package br.com.vendas.model.dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.vendas.model.domain.Fornecedor;
import br.com.vendas.model.domain.ProdutoFornecedor;

public class ProdutoFornecedorDao {

	public ArrayList<ProdutoFornecedor> getProdutosFornecedores() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		java.sql.Connection conexao = DriverManager.getConnection(
		"jdbc:mysql://localhost:3307/db_vendas?useTimezone=true&serverTimezone=UTC","root", "Luc@show1998s");
	
		
		PreparedStatement ps = conexao.prepareStatement("SELECT TB_PRODUTO.NM_PRODUTO, TB_FORNECEDOR.NM_FORNECEDOR, TB_FORNECEDOR.DS_RAZAO_SOCIAL  FROM TB_PRODUTO \r\n" + 
				"INNER JOIN TB_FORNECEDOR ON TB_FORNECEDOR.CD_FORNECEDOR = TB_PRODUTO.CD_FORNECEDOR");
		
		ResultSet rs = ps.executeQuery();
		ArrayList<ProdutoFornecedor> produtosFornecedores = new ArrayList<ProdutoFornecedor>();

        while(rs.next()) {
        	produtosFornecedores.add(new ProdutoFornecedor(rs.getString(1), rs.getString(2), rs.getString(3)));
        }

        return produtosFornecedores;
	}
	
}
