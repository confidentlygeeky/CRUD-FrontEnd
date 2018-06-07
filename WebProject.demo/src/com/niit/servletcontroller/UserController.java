package com.niit.servletcontroller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.CRUD.PersonImpl.PersonImpl;
import com.CRUD.model.Person;

	@WebServlet("/")
	public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	PersonImpl personImpl = new PersonImpl();

	
 
    public UserController() {
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
		String action = request.getServletPath();
		
		RequestDispatcher dispatcher=null;
		
		switch(action) {
		case "/adduser":
			addUser(request, response);
			break;
			
		case "/login":
			dispatcher=request.getRequestDispatcher("/WEB-INF/views/Login.jsp");
			break;
			
		case "/edituser":
			editUser(request, response);
			break;
			
		case "/updateuser":
			updateUser(request,response);
			break;
			
		case "/deleteuser":
			deleteUser(request, response);
			break;
		case "/getuser":
			getUserList(request, response);
			break;
		default:
			dispatcher=request.getRequestDispatcher("/WEB-INF/views/Login.jsp");
		}
		dispatcher.forward(request, response);
		
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	//Get User List
	private void getUserList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Person> list = personImpl.readAllPerson();
		//set attribute is used for fetching the data in the jsp page
		request.setAttribute("listOfPersons",list);
		System.out.println("---");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/index.jsp");
        dispatcher.forward(request, response);	
		
	}
	
	private void addUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Person person = new Person();
		person.setId(Integer.parseInt(request.getParameter("id")));
		person.setName(request.getParameter("name"));
		person.setEmail(request.getParameter("email"));
		person.setPassword(request.getParameter("password"));
		
		personImpl.insertPerson(person);		
		getUserList(request, response);
		
	}

	private void editUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("---in edit method---");
			int id = Integer.parseInt(request.getParameter("id"));
		
	        
			Person exisitingPerson = personImpl.readOnePerson(id);
	     
	        request.setAttribute("person", exisitingPerson);
	        //System.out.println(exisitingPerson);
	        getUserList(request, response);
	}
        
        private void updateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        	
        	int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
     
            Person person = new Person(id, name, email, password);
            personImpl.updatePerson(id,person);
         getUserList(request, response);
        }
	
	private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id = Integer.parseInt(request.getParameter("id"));
		 
        personImpl.deletePerson(id);
        getUserList(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
	}
	
	

}
