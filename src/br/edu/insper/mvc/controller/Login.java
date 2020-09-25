package br.edu.insper.mvc.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.insper.mvc.model.*;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/login.html");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DAO dao;
		try {
			dao = new DAO();
		
		List<Cadastro> cadastros = dao.getListaCadastros();
		dao.close();

		Cadastro cadastro = new Cadastro();

		cadastro.setLogin(request.getParameter("login"));
		cadastro.setSenha(request.getParameter("senha"));
		boolean answer = false;
		Cadastro parameter = null;
				
		for (Cadastro iterator : cadastros) {
			if (cadastro.getLogin().equals(iterator.getLogin()) && 
					cadastro.getSenha().equals(iterator.getSenha())) {
				answer = true;
				parameter = iterator;
				break;
			}
		}
		
		if (answer) {
			request.getSession().setAttribute("id", parameter.getId());
			request.getSession().setAttribute("nome", parameter.getNome());
			RequestDispatcher dispatcher = request.getRequestDispatcher("Lista");
			dispatcher.forward(request, response);
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/login.html");
			dispatcher.forward(request, response);	
		}
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
