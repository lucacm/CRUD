package br.edu.insper.mvc.controller;


import java.io.IOException;
import java.sql.SQLException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.insper.mvc.model.*;


/**
 * Servlet implementation class Cria
 */
@WebServlet("/Cria")
public class Cria extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cria() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    
    @Override
    protected void doGet(HttpServletRequest request, 
    		HttpServletResponse response) 
    				throws ServletException, IOException {
    }
    
    @Override
    protected void doPost(HttpServletRequest request,
    		HttpServletResponse response)
    				throws ServletException, IOException {
    	
    	DAO dao;
    	try {
    		dao = new DAO();
    		
    		Integer id = (Integer) request.getSession().getAttribute("id");
    		Tarefa tarefa = new Tarefa();
    		tarefa.setTarefa(request.getParameter("tarefa"));
    		tarefa.setCadastroId(id);
      		dao.adicionaTarefa(tarefa);
    		dao.close();
    		response.sendRedirect("Lista");
	    
    	} catch (SQLException | ClassNotFoundException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    	
    }
}

