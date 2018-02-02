package com.imageshare.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InitController
 */
@WebServlet("/InitController")
public class InitController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InitController() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * Processa a requisição
     * 
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException {
 
        String action = request.getParameter("action");
 
        if (action == null) {
        	throw new ServletException("No action specified.");
        } else if (action.equals("register_account")) {
            showCreateAccount(request, response);
        }
    }
    
    /**
     * Mostra a tela de criação de conta
     * 
     * @param request
     * @param response
     */
    private void showCreateAccount(HttpServletRequest request, HttpServletResponse response){
        
        RequestDispatcher rd = null;
        rd = request.getRequestDispatcher("publish/create_account.jsp");
         
        try {
            rd.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}
}
