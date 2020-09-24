package br.edu.insper.mvc.controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
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
    	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/cria-tarefa.html");
		dispatcher.forward(request, response);

    }
    
    @Override
    protected void doPost(HttpServletRequest request,
    		HttpServletResponse response)
    				throws ServletException, IOException {
    	
    	DAO dao;
    	try {
    		dao = new DAO();

    		Tarefa tarefa = new Tarefa();
    		tarefa.setTarefa(request.getParameter("tarefa"));
      		dao.adicionaTarefa(tarefa);
    		dao.close();
    		response.sendRedirect("Lista");
	    
    	} catch (SQLException | ClassNotFoundException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    	
    }
}

