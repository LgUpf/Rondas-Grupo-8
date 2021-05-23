package br.upf.ads.rondasgp8.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.upf.ads.rondasgp8.jpa.JpaUtil;
import br.upf.ads.rondasgp8.model.Pessoa;

/**
 * Servlet implementation class PessoaCon
 */
@WebServlet("/Privada/Pessoa/PessoaCon")
public class PessoaCon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PessoaCon() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if (request.getParameter("incluir") != null) {
			incluir(request, response);
		} else if (request.getParameter("alterar") != null) {
			alterar(request, response);
		} else if (request.getParameter("excluir") != null) {
            excluir(request, response);			
		} else if (request.getParameter("gravar") != null) {
			gravar(request, response);			
		} else if (request.getParameter("cancelar") != null) {
			cancelar(request, response);			
		} else {
			listar(request, response);
		}
		
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) {
		try {
			EntityManager em = JpaUtil.getEntityManager();
			List<Pessoa> lista = em.createQuery("from Pessoa").getResultList(); // recuperamos as pessoas do BD
			request.setAttribute("lista", lista);
			em.close();
			request.getRequestDispatcher("PessoaList.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	private void cancelar(HttpServletRequest request, HttpServletResponse response) {
		listar(request, response);		
	}

	private void gravar(HttpServletRequest request, HttpServletResponse response) {
		EntityManager em = JpaUtil.getEntityManager(); // pega a entitymanager para persistir
		Pessoa p = new Pessoa(
					Integer.parseInt(request.getParameter("id")), 
					request.getParameter("nome"), 
					Integer.parseInt(request.getParameter("idade")));
		// ----------------------------------------------------------------------------------
		em.getTransaction().begin(); 	// inicia a transação
		em.merge(p); 					// incluir ou alterar o objeto no BD
		em.getTransaction().commit(); 	// commit na transação
		em.close();
		listar(request, response);
	}

	private void excluir(HttpServletRequest request, HttpServletResponse response) {
		EntityManager em = JpaUtil.getEntityManager(); // pega a entitymanager para persistir
		em.getTransaction().begin(); 	// inicia a transação
		em.remove(em.find(Pessoa.class, Integer.parseInt(request.getParameter("excluir"))));	// excluir o objeto no BD
		em.getTransaction().commit(); 	// commit na transação
		em.close();
		listar(request, response);
	}

	private void alterar(HttpServletRequest request, HttpServletResponse response) {
		try {
			EntityManager em = JpaUtil.getEntityManager();
			Pessoa obj = em.find(Pessoa.class, Integer.parseInt(request.getParameter("alterar")));
			request.setAttribute("obj", obj);
			em.close();
			request.getRequestDispatcher("PessoaForm.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	private void incluir(HttpServletRequest request, HttpServletResponse response) {
		try {
			Pessoa obj = new Pessoa();
			request.setAttribute("obj", obj);
			request.getRequestDispatcher("PessoaForm.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		} 		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
