package controller.home;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.HibernateUtil;
import model.Language;
import model.User;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.*;
import javax.servlet.http.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class Home extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException{
		
		
		RequestDispatcher dispatch = request.getRequestDispatcher("WEB-INF/src/view/home/home.jsp");
		dispatch.forward(request, response);		
		
	}	
}

