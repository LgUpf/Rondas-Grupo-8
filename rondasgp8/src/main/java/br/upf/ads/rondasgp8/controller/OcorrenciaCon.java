package br.upf.ads.rondasgp8.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.upf.ads.rondasgp8.jpa.JpaUtil;
import br.upf.ads.rondasgp8.model.Ocorrencia;
import net.iamvegan.multipartrequest.HttpServletMultipartRequest;
import br.upf.ads.uteis.Upload;



/**
 * Servlet implementation class OcorrenciaCon
 */
@WebServlet("/Privada/Ocorrencia/OcorrenciaCon")
public class OcorrenciaCon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public OcorrenciaCon() {
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
		} else if (request.getParameter("alterarFoto") != null) {
			alterarFoto(request, response);
		} else if (request.getParameter("gravarFoto") != null) {
			gravarFoto(request, response);	
		} else {
			listar(request, response);
		}
		
	}
	
	private void alterarFoto(HttpServletRequest request, HttpServletResponse response) {
		try {
			EntityManager em = JpaUtil.getEntityManager();
			Ocorrencia obj = em.find(Ocorrencia.class, Integer.parseInt(request.getParameter("alterarFoto")));
			request.setAttribute("obj", obj);
			em.close();
			request.getRequestDispatcher("OcorrenciaFoto.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	private void gravarFoto(HttpServletRequest request, HttpServletResponse response) {
		EntityManager em = JpaUtil.getEntityManager(); 
		em.getTransaction().begin();
		Ocorrencia obj = em.find(Ocorrencia.class, Integer.parseInt(request.getParameter("id")));
		if (request.getParameter("foto") != null) {
			String nomeArquivo = "Foto"+request.getParameter("id")+".jpg";
			String caminho = getServletConfig().getServletContext().getRealPath("/") + "Privada/Ocorrencia/uploads";
			Upload.copiarArquivo((HttpServletMultipartRequest) request, "foto", caminho, nomeArquivo);
			obj.setFoto( Upload.getBytesArquivo((HttpServletMultipartRequest) request, "foto") );
			
		}		
		
			em.merge(obj); 	
			em.getTransaction().commit(); 
			em.close();
			listar(request, response);
		}	
	private void listar(HttpServletRequest request, HttpServletResponse response) {
		try {
			EntityManager em = JpaUtil.getEntityManager();
			List<Ocorrencia> lista = em.createQuery("from Ocorrencia").getResultList(); // recuperamos as Ocorrencias do BD
			request.setAttribute("lista", lista);
			em.close();
			request.getRequestDispatcher("OcorrenciaList.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	private void cancelar(HttpServletRequest request, HttpServletResponse response) {
		listar(request, response);		
	}


	private void gravar(HttpServletRequest request, HttpServletResponse response) {
			EntityManager em = JpaUtil.getEntityManager();
			
			Date d = null;
			try {
				d = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dataHora").replaceAll("T", " "));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			Ocorrencia p = new Ocorrencia(
						Integer.parseInt(request.getParameter("id")),
						request.getParameter("titulo"), 
						request.getParameter("descricao"), 
						d, Float.parseFloat(request.getParameter("latitude")), 
						Float.parseFloat(request.getParameter("longitude")));
			
		em.getTransaction().begin(); 
		em.merge(p); 					
		em.getTransaction().commit(); 
		em.close();
		listar(request, response);
		
	}

	
	private void excluir(HttpServletRequest request, HttpServletResponse response) {
		EntityManager em = JpaUtil.getEntityManager(); 
		em.getTransaction().begin(); 
		em.remove(em.find(Ocorrencia.class, Integer.parseInt(request.getParameter("excluir"))));	
		em.getTransaction().commit(); 	
		em.close();
		listar(request, response);
	}

	private void alterar(HttpServletRequest request, HttpServletResponse response) {
		try {
			EntityManager em = JpaUtil.getEntityManager();
			Ocorrencia obj = em.find(Ocorrencia.class, Integer.parseInt(request.getParameter("alterar")));
			request.setAttribute("obj", obj);
			em.close();
			request.getRequestDispatcher("OcorrenciaForm.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	private void incluir(HttpServletRequest request, HttpServletResponse response) {
		try {
			Ocorrencia obj = new Ocorrencia();
			request.setAttribute("obj", obj);
			request.getRequestDispatcher("OcorrenciaForm.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		} 		
	}

	/**

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
