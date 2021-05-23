package br.upf.ads.rondasgp8;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.upf.ads.rondasgp8.model.Pessoa;

/**
 * Servlet implementation class PessoaIdade
 */
@WebServlet("/PessoaIdade")
public class PessoaIdade extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PessoaIdade() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.append("<form>");
		out.append("   Digite seu nome: ");
		out.append("   <input type='text' name='nome' required>");
		out.append("   <br> ");
		out.append("   Digite sua idade: ");
		out.append("   <input type='number' name='idade' required>");
		out.append("   <br> ");
		out.append("   <button type='submit'>Enviar</button> ");
		out.append("</form>");

		// a partir daqui vamos pegar os dados digitados pelo usuário
		if (request.getParameter("nome") != null) {
			String nome = request.getParameter("nome");
			String idade = request.getParameter("idade");
			int idadeInt = Integer.parseInt(idade);
			out.append("<h4>O nome digitado foi:</h4> " + nome);
			out.append("<h5>A idade digitada foi:</h5> " + idade);
			out.append("<h2>Você viveu aproximadamente:</h2> " + (idadeInt * 365) + " dias.");

			// Instanciar uma pessoa com os dados que vieram
			Pessoa p = new Pessoa(nome, idadeInt);
			// Adicionar o objeto numa coleção
			// Manter a coleção de objetos na sessão do usuário.
			List<Pessoa> lista = (List<Pessoa>) request.getSession().getAttribute("lista");
			if (lista == null) // na primeira requisição ainda não tem a lista na sessão = null
				lista = new ArrayList<Pessoa>();
			lista.add(p);
			request.getSession().setAttribute("lista", lista);
			// Mostar todos os objetos numa tabela.
			out.append("<br>");
			out.append("<br>");
			for (Pessoa p2 : lista) {
				out.append(p2.getNome() + " " + p2.getIdade() + "<br>");
			}

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
