<%@page import="dao.BbsDao"%>
<%@page import="dto.BbsDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
int seq = Integer.parseInt( request.getParameter("seq") );

String id = request.getParameter("id");
String content =  request.getParameter("content");
String title =  request.getParameter("title");
%>

      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
BbsDao dao = BbsDao.getInstance();

BbsDto dto = new BbsDto(id, title, content);
dto.setSeq(seq);
boolean isS = dao.updatecount(dto);
if(isS){
%>
	<script type="text/javascript">
	alert("수정이 완료되었습니다");
	location.href = "bbslist.jsp";
	</script>
<%
}else{
%>
	<script type="text/javascript">
	alert("다시 수정해주세요");
	location.href = "bbsupdate.jsp?seq=<%=seq %>";
	</script>
<%
}
%>

</body>
</html>