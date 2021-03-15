<%@ page errorPage="error.jsp" %>
<%
	if(session.getAttribute("username") == null)
		throw new Exception("Access Denied");
%>
