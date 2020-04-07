package br.com.vendas.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.vendas.model.dao.FornecedorDao;
import br.com.vendas.model.domain.Fornecedor;
import util.ValidacaoException;

/**
 * Servlet implementation class FornecedorServlet
 */
@WebServlet("/fornecedorServlet")
public class FornecedorServlet extends HttpServlet {
	
	private FornecedorDao fornecedorDao = new FornecedorDao();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FornecedorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
  
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		String codigo = request.getParameter("codigo");

		try {
			if(acao != null && acao.equals("excluir")) {
				Integer codFornecedor = Integer.parseInt(codigo);
				fornecedorDao.excluir(codFornecedor);
				request.setAttribute("mensagem","Fornecedor excluido");
			}
			
			request.setAttribute("fornecedores", fornecedorDao.getFornecedores());

		} catch (SQLException e) {
			request.setAttribute("mensagem","Erro de Banco de dados:" + e.getMessage());
		} catch (ClassNotFoundException e) {
			request.setAttribute("mensagem","Erro de Driver:" + e.getMessage());
		}
		javax.servlet.RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/paginas/fornecedores.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String razaoSocial = request.getParameter("razaoSocial");
		String email = request.getParameter("email");
		String cnpj = request.getParameter("cnpj");
		Fornecedor fornecedor = new Fornecedor(null,email, nome, razaoSocial ,cnpj);
		
		try {
			fornecedor.valida();
			 fornecedorDao.salvar(fornecedor);
				request.setAttribute("mensagem","Fornecedor salvo com sucesso");


		} catch (SQLException e) {
			request.setAttribute("mensagem","Erro de Banco de dados:" + e.getMessage());
			request.setAttribute("fornecedor",fornecedor);
		} catch (ClassNotFoundException e) {
			request.setAttribute("mensagem","Erro de Driver:" + e.getMessage());
			request.setAttribute("fornecedor",fornecedor);
		} catch (ValidacaoException e) {
			request.setAttribute("mensagem","Erro de Validação dos campos:" + e.getMessage());
			request.setAttribute("fornecedor",fornecedor);
		}
		try {
			request.setAttribute("fornecedores",fornecedorDao.getFornecedores());
		}  catch (ClassNotFoundException e) {
				request.setAttribute("mensagem","Erro de Driver:" + e.getMessage());
				request.setAttribute("fornecedor",fornecedor);
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		javax.servlet.RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/paginas/fornecedores.jsp");
		dispatcher.forward(request, response);
	}
	

}
