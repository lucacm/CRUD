package br.edu.insper.mvc.controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.insper.mvc.model.*;

/**
 * Servlet implementation class Remove
 */
@WebServlet("/Remove")
public class Remove extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Remove() {
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
	   try {
		   DAO dao = new DAO();
		   dao.remove(Integer.valueOf(request.getParameter("id")));
		   dao.close();
		   RequestDispatcher dispatcher = request.getRequestDispatcher("Lista");
		   dispatcher.forward(request, response);

	   } catch (NumberFormatException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
	   } catch (SQLException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
	   } catch (ClassNotFoundException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
	   }
   }
}
