package controller;

import java.io.IOException;
import java.util.ArrayList;
//import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO;
import model.JavaBeans;
/**
 * Servlet implementation class Controller
 */
@WebServlet(urlPatterns = {"/Controller","/main","/inserir", "/select", "/update", "/delete"})
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	DAO dao = new DAO();
	JavaBeans contato = new JavaBeans();
	

    /**
     * Default constructor. 
     */
    public Controller() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//Teste Conexão
		//DAO dao = new DAO();
		//dao.testeConexao();
		String action = request.getServletPath();
		System.out.println(action);
		if (action.equals("/main")){
			contatos(request, response);
		} else
			if (action.equals("/inserir")) {
				novoContato(request,response);
			} else if (action.equals("/select")) {
				listarContato(request,response);
			} else if (action.equals("/update")) {
				editarContato(request,response);
			//} else if (action.equals("/delete")) {
				//removerContato(request,response);
				
				
				
			//}  else if (action.equals("/update")) {
			//	editarContato(request,response);
				
			}else 
				response.sendRedirect("index.html");
				
		//dao.testeConexao();
		}
	
	protected void contatos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.sendRedirect("agenda.jsp");
		// receber dados da intância JavaBeans
		ArrayList<JavaBeans> lista = dao.listaContatos();
		
		//Teste
		/*
		for(int i = 0; i < lista.size(); i++) {
			System.out.println(lista.get(i).getIdcon());
			System.out.println(lista.get(i).getNome());
			System.out.println(lista.get(i).getFone());
			System.out.println(lista.get(i).getEmail());
			System.out.println(lista.get(i).getObsPath());
		}
		*/
		request.setAttribute("contatos", lista);
		RequestDispatcher rd = request.getRequestDispatcher("agenda.jsp");
		rd.forward(request, response);
	}
	
	protected void novoContato(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println(request.getParameter("nome"));
		//System.out.println(request.getParameter("fone"));
		//System.out.println(request.getParameter("email"));
		
		this.contato.setNome(request.getParameter("nome"));
		this.contato.setFone(request.getParameter("fone"));
		this.contato.setEmail(request.getParameter("email"));
	//	this.contato.setObsPath(request.getParameter("obsPath"));
		//"C:/java/testeimagem.png"
		
		dao.inserirContato(contato);
		
		response.sendRedirect("main");
		
	} 
	protected void listarContato(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//recebe o parametro idcon
		String idcon = request.getParameter("idcon");
		//testa o envio do parametro
		System.out.println(idcon);
		// configura o parametro no objeto
		this.contato.setIdcon(idcon);
		//selecionar contato
		this.dao.selecionarContato(contato);
		//teste
		
		request.setAttribute(idcon, contato.getIdcon());
		request.setAttribute("nome", contato.getIdcon());
		request.setAttribute("email", contato.getIdcon());
		request.setAttribute("fone", contato.getIdcon());
		RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
		rd.forward(request, response);
	}
	
	protected void editarContato(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		response.sendRedirect("agenda.jsp");
	
		this.contato.setNome(request.getParameter("idcon"));
		this.contato.setNome(request.getParameter("nome"));
		this.contato.setFone(request.getParameter("fone"));
		this.contato.setEmail(request.getParameter("email"));
		this.dao.inserirContato(this.contato);
		response.sendRedirect("main");
	}
	
	/* protected void  removerContato(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		response.sendRedirect("agenda.jsp");
	
		this.contato.setNome(request.getParameter("idcon"));
		this.contato.setNome(request.getParameter("nome"));
		this.contato.setFone(request.getParameter("fone"));
		this.contato.setEmail(request.getParameter("email"));
		//this.dao.inserirContato(this.contato);
		response.sendRedirect("main");
	} */
}
