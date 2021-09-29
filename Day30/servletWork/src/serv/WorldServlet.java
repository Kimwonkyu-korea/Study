package serv;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.HumanDto;

public class WorldServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HumanDto dto = (HumanDto)req.getAttribute("human"); 
		/*
		String name = req.getParameter("name");
		String age[] = req.getParameterValues("age");
		String gen[] = req.getParameterValues("gen");
		String hobby[] = req.getParameterValues("hobby");
		*/
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter pw = resp.getWriter();
		
		pw.println("<html>");
			
		pw.println("<head>");
		pw.println("<title>WorldServletHtml</title>");
		pw.println("</head>");
		
		pw.println("<body>");
		
		pw.println("<h3>World Servlet</h3>");
		/*
		pw.println("<p>이름:" + name + "</p>");
		
		if(age != null) {
			for(int i=0; i<hobby.length; i++) {
				pw.println("<p>취미:" + hobby[i] + "</p>");
			}
		}
		if(gen != null) {
			for(int i=0; i<hobby.length; i++) {
				pw.println("<p>취미:" + hobby[i] + "</p>");
			}
		}
		if(hobby != null) {
			for(int i=0; i<hobby.length; i++) {
				pw.println("<p>취미:" + hobby[i] + "</p>");
			}
		}
		*/
		if(dto != null) {
			pw.println("<p>"+ dto.toString()+ "</p>");
		}
		
		pw.println("</body>");
		
		pw.println("</html>");
		
		pw.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
}
