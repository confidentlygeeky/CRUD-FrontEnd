package com.niit.servletcontroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.CRUD.PersonImpl.PersonImpl;
import com.CRUD.model.Person;


@WebServlet("/logincontroller")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		
		try
		{
			Person person=new Person();
			person.setEmail(request.getParameter("email"));
			person.setPassword(request.getParameter("password"));
		
			RequestDispatcher dispatcher=null;
			
			if(person.getPassword().equals("pass@123") && person.getEmail().equals("admin@gmail.com"))
			{
				HttpSession session=request.getSession();
				session.setAttribute("user", "admin");
				response.sendRedirect(request.getContextPath()+"/getuser");
				
			}
			
			PersonImpl personImpl=new PersonImpl();
			Person personToCheck=null;
			if(personImpl.readPersonByEmail(person)!=null)
			{
				personToCheck=personImpl.readPersonByEmail(person);
			
			if(personToCheck.getPassword().equals(person.getPassword()))
			{	
				HttpSession session=request.getSession();
				session.setAttribute("user", personToCheck.getName());
				session.setAttribute("id", personToCheck.getId());
				response.sendRedirect(request.getContextPath()+"/getuser");
			}
			
			else
			{
				dispatcher=request.getRequestDispatcher("/WEB-INF/views/error.jsp");
			}
			}
			else
			{
				dispatcher=request.getRequestDispatcher("/WEB-INF/views/error.jsp");
			}
			dispatcher.forward(request, response);
		}
		catch(Exception e)
		{
			out.println(e);
		}
	}
	}


