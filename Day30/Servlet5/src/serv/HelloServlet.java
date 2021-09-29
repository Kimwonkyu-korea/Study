package serv;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.HumanDto;

@WebServlet("/location")
public class HelloServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("HttpServlet doGet()");

		resp.setContentType("text/html; charset=utf-8");
		PrintWriter pw = resp.getWriter();
		
		pw.println("<html>");

		pw.println("<head>"); 
		pw.println("<title>HelloServletHtml</title>");
		pw.println("</head>");
		
		pw.println("<h3>Hello Servlet</h3>");
		
		// 세션을 생성
		HttpSession session = req.getSession();
		
		// 세션에 저장
		session.setAttribute("name", "giant");
		
		// 세션에서 산출
		String name = (String)session.getAttribute("name");
		
		HumanDto human = new HumanDto("홍길동", 1001);
		
		session.setAttribute("user", human);
		session.setMaxInactiveInterval(10); // 시간만큼 저장
		
		HumanDto h = (HumanDto)session.getAttribute("user");
		
		/*
		// 세션 오브젝트 삭제
		session.removeAttribute("name");
		
		// 세션 삭제
		session.invalidate();
		*/
		
		pw.println("<p>name:"+ name +"</p>");
		pw.println("<p>human:"+ h.toString() +"</p>");

		pw.println("</body>");

		pw.println("</html>");

		pw.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	}
	
}
