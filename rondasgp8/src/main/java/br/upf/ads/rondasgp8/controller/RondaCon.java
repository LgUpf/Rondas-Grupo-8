package br.upf.ads.rondasgp8.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.upf.ads.rondasgp8.jpa.JpaUtil;
import br.upf.ads.rondasgp8.model.Locomocao;
import br.upf.ads.rondasgp8.model.Pessoa;
import br.upf.ads.rondasgp8.model.Ronda;
import br.upf.ads.uteis.Upload;
import net.iamvegan.multipartrequest.HttpServletMultipartRequest;

/**
 * Servlet implementation class RondaCon
 */
@WebServlet("/Privada/Ronda/RondaCon")
public class RondaCon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RondaCon() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request = new HttpServletMultipartRequest(
				request,
				HttpServletMultipartRequest.MAX_CONTENT_LENGTH,
				HttpServletMultipartRequest.SAVE_TO_TMPDIR,
				HttpServletMultipartRequest.IGNORE_ON_MAX_LENGTH,
				HttpServletMultipartRequest.DEFAULT_ENCODING);		
		
		
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
			
			
		} else if (request.getParameter("vigilantes") != null) {
			vigilantes(request, response);				
			
		} else if (request.getParameter("incluirVigilante") != null) {
			incluirVigilante(request, response);
			
		} else if (request.getParameter("excluirVigilante") != null) {
			excluirVigilante(request, response);
			
		} else {
			listar(request, response);
		}
		
	}
	
	
	private void vigilantes(HttpServletRequest request, HttpServletResponse response) {
		listarVigilantes(request, response, Long.parseLong(request.getParameter("vigilantes")));
	}
	
	
	private void listarVigilantes(HttpServletRequest request, HttpServletResponse response, Long idRonda) {
		try {
			EntityManager em = JpaUtil.getEntityManager();
			Ronda obj = em.find(Ronda.class, idRonda);
			request.setAttribute("obj", obj);
			List<Pessoa> pessoas = em.createQuery("from Pessoa order by nome").getResultList();
			request.setAttribute("pessoas", pessoas);
			em.close();
			request.getRequestDispatcher("RondaVigilantes.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}	
	
	
	private void incluirVigilante(HttpServletRequest request, HttpServletResponse response) {
		EntityManager em = JpaUtil.getEntityManager();
		em.getTransaction().begin(); 	
		Ronda r = em.find(Ronda.class, Long.parseLong(request.getParameter("idRonda")));
		Pessoa p = em.find(Pessoa.class, Integer.parseInt(request.getParameter("vigilante")));
		r.getVigilantes().add(p);
		em.merge(r);
		em.getTransaction().commit(); 	
		em.close();
		listarVigilantes(request, response, r.getId());
		
	}	
	private void excluirVigilante(HttpServletRequest request, HttpServletResponse response) {
		EntityManager em = JpaUtil.getEntityManager(); 
		em.getTransaction().begin(); 	
		Ronda r = em.find(Ronda.class, Long.parseLong(request.getParameter("idRonda")));
		Pessoa p = em.find(Pessoa.class, Integer.parseInt(request.getParameter("excluirVigilante")));
		r.getVigilantes().remove(p);
		em.merge(r); 
		em.getTransaction().commit(); 	
		em.close();
		listarVigilantes(request, response, r.getId());
		
	}		
	
	
	

	private void listar(HttpServletRequest request, HttpServletResponse response) {
		try {
			EntityManager em = JpaUtil.getEntityManager();
			List<Ronda> lista = em.createQuery("from Ronda").getResultList(); // recuperamos as pessoas do BD
			request.setAttribute("lista", lista);
			em.close();
			request.getRequestDispatcher("RondaList.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	private void cancelar(HttpServletRequest request, HttpServletResponse response) {
		listar(request, response);		
	}

	private void gravar(HttpServletRequest request, HttpServletResponse response) {
		EntityManager em = JpaUtil.getEntityManager();


		//	// converter 212010 para 21:20:10
		//	DateTimeFormatter parserHora= DateTimeFormatter.ofPattern("HHmmss");
		//		LocalTime hora = LocalTime.parse("212010", parserHora);
		//	DateTimeFormatter formatterHora = DateTimeFormatter.ofPattern("HH:mm:ss");
		//	String horaFormatada = formatterHora.format(hora); // 21:20:10
		//Date d = null;
		//try {
		//	d = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dataHoraInicio"));
		//} catch (ParseException e) {
		//		e.printStackTrace();
		//	}
		//	Date h = null;
		//try {
		//	d = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dataHoraFim"));
		//} catch (ParseException e) {
		//		e.printStackTrace();
		//	}
		// converter 23062021 para 23/06/2021
		//DateTimeFormatter parserData = DateTimeFormatter.ofPattern("ddMMuuuu");
		//LocalDate data = LocalDate.parse("c", parserData);
		//DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("dd/MM/uuuu");
		//String dataFormatada = formatterData.format(data);
		
		Date d = null;
		try {
			d = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dataHoraInicio"));
		} catch (ParseException e) {
			e.printStackTrace();
		}try {
			d = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dataHoraFim"));
		} catch (ParseException e) {
			e.printStackTrace();
		}try {
			d = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dataHoraUltima"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Ronda p = new Ronda(
				    Long.parseLong(request.getParameter("id")),
					d, d, Float.parseFloat(request.getParameter("latUltima")),
					Float.parseFloat(request.getParameter("lonUltima")),
					d, new ArrayList(), null);


		
		// ----------------------------------------------------------------------------------
		em.getTransaction().begin(); 	
		em.merge(p); 					
		em.getTransaction().commit(); 	
		em.close();
		listar(request, response);
		
		DateTimeFormatter parserData = DateTimeFormatter.ofPattern("ddMMuuuu");
		LocalDate data = LocalDate.parse("dataHoraInicio", parserData);
		DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("dd/MM/uuuu");
		String dataFormatada = formatterData.format(data); // 23/06/2021
	}
	private void excluir(HttpServletRequest request, HttpServletResponse response) {
		EntityManager em = JpaUtil.getEntityManager(); 
		em.getTransaction().begin(); 	
		em.remove(em.find(Ronda.class, Long.parseLong(request.getParameter("excluir"))));
		em.getTransaction().commit(); 	
		em.close();
		listar(request, response);
	}

	
	
	
	private void alterar(HttpServletRequest request, HttpServletResponse response) {
		try {
			EntityManager em = JpaUtil.getEntityManager();
			Ronda obj = em.find(Ronda.class, Long.parseLong(request.getParameter("alterar")));
			request.setAttribute("obj", obj);
			em.close();
			request.getRequestDispatcher("RondaForm.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	private void incluir(HttpServletRequest request, HttpServletResponse response) {
		try {
			Ronda obj = new Ronda();
			request.setAttribute("obj", obj);
			request.getRequestDispatcher("RondaForm.jsp").forward(request, response);
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
