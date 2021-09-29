package serv;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("HelloServlet doGet()");
		
		String name = req.getParameter("name");
		System.out.println(name);
		
		String hobby[] = req.getParameterValues("hobby");
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter pw = resp.getWriter();

		pw.println("<html>");
			
		pw.println("<head>");
		pw.println("<title>HelloServletHtml</title>");
		pw.println("</head>");
		
		pw.println("<body>");
		
		pw.println("<h3>Hello Servlet</h3>");
		pw.println("<p>이름:" + name + "</p>");
		
		if(hobby != null) {
			for(int i=0; i<hobby.length; i++) {
				pw.println("<p>취미:" + hobby[i] + "</p>");
			}
		}
		
		pw.println("</body>");
		
		pw.println("</html>");
		
		pw.close();
		
		/*
		 	Servlet -> Java(html)
		 	JSP -> html(java)
		 */
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("HelloServlet doPost()");
		
		req.setCharacterEncoding("utf-8");	//한글 깨짐 방지
		
		String name = req.getParameter("name");
		System.out.println(name);
		
		
	}
}
