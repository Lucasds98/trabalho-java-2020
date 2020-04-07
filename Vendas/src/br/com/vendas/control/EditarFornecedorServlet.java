package br.com.vendas.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.vendas.model.dao.FornecedorDao;
import br.com.vendas.model.domain.Fornecedor;

/**
 * Servlet implementation class EditarForncedorServlet
 */
@WebServlet("/EditarFornecedorServlet")
public class EditarFornecedorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private FornecedorDao fornecedorDao = new FornecedorDao();
    public EditarFornecedorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setAttribute("fornecedor", fornecedorDao.getFornecedores());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/paginas/editar.jsp");
        dispatcher.forward(request, response);
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			int codigo = Integer.parseInt(request.getParameter("codigo"));
	        String nome = request.getParameter("nome");
	        Fornecedor fornecedor = new Fornecedor();
	        fornecedor.setCodigo(codigo);
	        fornecedor.setNome(nome);
			request.setAttribute("fornecedor", fornecedorDao.getFornecedores());
	        fornecedorDao.editar(fornecedor);
	        request.setAttribute("mensagem", "<b style=\"\r\n" + 
					"		    color: green;\r\n" + 
					"		    font-family: cursive;\r\n" + 
					"		    font-style: oblique;\r\n" + 
					"		    font-size: 25px;\r\n" + 
					"		\">Editado com sucesso</b>");
			request.setAttribute("fornecedor", fornecedorDao.getFornecedores());
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/paginas/editar.jsp");
			dispatcher.forward(request, response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


