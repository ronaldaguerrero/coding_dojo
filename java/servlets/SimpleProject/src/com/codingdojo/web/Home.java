package com.codingdojo.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Home
 */
@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String fName = request.getParameter("fn");
		String lName = request.getParameter("ln");
		String lang = request.getParameter("lang");
		String hTown = request.getParameter("ht");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		if (fName == null) {
			fName = "unknown";
		}
		if (lName == null) {
			lName = "unknown";
		}
		if (lang == null) {
			lang = "unknown";
		}
		if (hTown == null) {
			hTown = "unknown";
		}
		out.write("<h1>Welcome, from " + fName + " " + lName + "</h1>");
		out.write("<h3>Your favorite langauge is: " + lang + "</h3>");
		out.write("<h3>Your hometown is: " + hTown + "</h3>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
