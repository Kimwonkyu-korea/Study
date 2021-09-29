package serv;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.HumanDto;

public class HelloServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("HelloServlet doGet()");
		
		String name = req.getParameter("name");
		System.out.println(name);
		
		int number = Integer.parseInt(req.getParameter("number"));
		System.out.println(number);
		/*
		 * resp.setContentType("text/html; charset=utf-8"); PrintWriter pw =
		 * resp.getWriter(); pw.println("<html>");
		 * 
		 * pw.println("<head>"); pw.println("<title>HelloServletHtml</title>");
		 * pw.println("</head>");
		 * 
		 * pw.println("<body>");
		 * 
		 * pw.println("<h3>Hello Servlet</h3>");
		 * 
		 * pw.println("</body>");
		 * 
		 * pw.println("</html>");
		 * 
		 * pw.close();
		 */
		// 짐싸!
		HumanDto human = new HumanDto(name, number);	// 객체로 만듬
		req.setAttribute("human", human); 				// 문자열, object
		
		
		resp.sendRedirect("world");  		// servlet으로 이동	 짐을 안가져감
	//	resp.sendRedirect("index.html");  	// web으로 이동
		
		// 이동해
	//	RequestDispatcher rd = req.getRequestDispatcher("world");
	//	rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
