package serv;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.HumanDto;

public class HelloServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("HelloServlet doGet()");

		String name = req.getParameter("name");
		String age = req.getParameter("age");
		String gen = req.getParameter("gen");
		String[] hobby = req.getParameterValues("hobby");
		
		HumanDto human = new HumanDto(name, age, gen, hobby);
		req.setAttribute("human", human);
		
		RequestDispatcher rd = req.getRequestDispatcher("world");
		rd.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
}
