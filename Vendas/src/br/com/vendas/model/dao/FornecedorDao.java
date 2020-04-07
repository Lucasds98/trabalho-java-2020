package br.com.vendas.model.dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sun.corba.se.pept.transport.Connection;

import br.com.vendas.model.domain.Fornecedor;

public class FornecedorDao {

	
	
		public List<Fornecedor> getFornecedores() throws SQLException, ClassNotFoundException {
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection conexao = DriverManager.getConnection(
				//	"jdbc:mysql://localhost:3307/db_vendas","root", "Luc@show1998s");
			"jdbc:mysql://localhost:3307/db_vendas?useTimezone=true&serverTimezone=UTC","root", "Luc@show1998s");
		
			
			PreparedStatement ps = conexao.prepareStatement("SELECT CD_FORNECEDOR,NM_FORNECEDOR,"
					+ "DS_RAZAO_SOCIAL,DS_EMAIL,DS_CNPJ FROM TB_FORNECEDOR");
			
			ResultSet rs = ps.executeQuery();
			List<Fornecedor> fornecedores = new ArrayList<>();
			while(rs.next()) {
				fornecedores.add(new Fornecedor(rs.getInt(1),rs.getString(4),rs.getString(2),rs.getString(3),rs.getString(5)));
			}
			return fornecedores;
		}

		public void salvar(Fornecedor fornecedor) throws SQLException, ClassNotFoundException {
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection conexao = DriverManager.getConnection(
				//	"jdbc:mysql://localhost:3307/db_vendas","root", "Luc@show1998s");
			"jdbc:mysql://localhost:3307/db_vendas?useTimezone=true&serverTimezone=UTC","root", "Luc@show1998s");
			
			PreparedStatement statement = conexao.prepareStatement(
					"INSERT INTO TB_FORNECEDOR(NM_FORNECEDOR,DS_RAZAO_SOCIAL,DS_CNPJ,DS_EMAIL) VALUES (?,?,?,?)");
					statement.setString(1,fornecedor.getNome());
					statement.setString(2,fornecedor.getRazaoSocial());
					statement.setString(3,fornecedor.getCnpj());
					statement.setString(4,fornecedor.getEmail());
					statement.execute();
		}

		public void excluir(Integer codFornecedor) throws SQLException, ClassNotFoundException {
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection conexao = DriverManager.getConnection(
				//	"jdbc:mysql://localhost:3307/db_vendas","root", "Luc@show1998s");
			"jdbc:mysql://localhost:3307/db_vendas?useTimezone=true&serverTimezone=UTC","root", "Luc@show1998s");
			
			PreparedStatement statement = conexao.prepareStatement(
					"DELETE FROM TB_FORNECEDOR WHERE CD_FORNECEDOR = ?");
					statement.setInt(1,codFornecedor);
					statement.execute();
			
		}
	
		public void editar(Fornecedor fornecedor) throws SQLException, ClassNotFoundException {
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection conexao = DriverManager.getConnection(
				//	"jdbc:mysql://localhost:3307/db_vendas","root", "Luc@show1998s");
			"jdbc:mysql://localhost:3307/db_vendas?useTimezone=true&serverTimezone=UTC","root", "Luc@show1998s");
			
			PreparedStatement ps = conexao.prepareStatement("UPDATE TB_FORNECEDOR SET NM_FORNECEDOR=? WHERE CD_FORNECEDOR=?");
            ps.setString(1, fornecedor.getNome());
            ps.setInt(2, fornecedor.getCodigo());
            ps.execute();
			
		}
	
}
