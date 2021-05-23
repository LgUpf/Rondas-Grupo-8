package br.upf.ads.rondasgp8;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet01
 */
@WebServlet("/Servlet01")
public class Servlet01 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Servlet01() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		response.getWriter().append("A minha Servlet está rodando em : ").append(request.getContextPath());
		response.getWriter().append("<br>");
		response.getWriter().append("<h1>Teste de cabeçalho</h1>");
		
		response.getWriter().append("<h5>Segue a lista de produtos</h5>");
		response.getWriter().append("<p>Uma tabela com código, nome e preço, usando "
				+ "dados fictícios.</p>");
		response.getWriter().append("<table border='1'>");
		response.getWriter().append("<tr><td>111</td><td>produto um</td></tr>");
		
		response.getWriter().append("</table>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
