<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="id" scope="session" class="webservice.ServicesProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
id.setEndpoint(request.getParameter("endpoint"));
%>

<%
String method = request.getParameter("method");
int methodID = 0;
if (method == null) methodID = -1;

if(methodID != -1) methodID = Integer.parseInt(method);
boolean gotMethod = false;

try {
switch (methodID){ 
case 2:
        gotMethod = true;
        java.lang.String getEndpoint2mtemp = id.getEndpoint();
if(getEndpoint2mtemp == null){
%>
<%=getEndpoint2mtemp %>
<%
}else{
        String tempResultreturnp3 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getEndpoint2mtemp));
        %>
        <%= tempResultreturnp3 %>
        <%
}
break;
case 5:
        gotMethod = true;
        String endpoint_0id=  request.getParameter("endpoint8");
            java.lang.String endpoint_0idTemp = null;
        if(!endpoint_0id.equals("")){
         endpoint_0idTemp  = endpoint_0id;
        }
        id.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        webservice.Services getServices10mtemp = id.getServices();
if(getServices10mtemp == null){
%>
<%=getServices10mtemp %>
<%
}else{
        if(getServices10mtemp!= null){
        String tempreturnp11 = getServices10mtemp.toString();
        %>
        <%=tempreturnp11%>
        <%
        }}
break;
case 13:
        gotMethod = true;
        java.lang.String queryPlayerRank13mtemp = id.queryPlayerRank();
if(queryPlayerRank13mtemp == null){
%>
<%=queryPlayerRank13mtemp %>
<%
}else{
        String tempResultreturnp14 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(queryPlayerRank13mtemp));
        %>
        <%= tempResultreturnp14 %>
        <%
}
break;
case 16:
        gotMethod = true;
        int queryPlayerNum16mtemp = id.queryPlayerNum();
        String tempResultreturnp17 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(queryPlayerNum16mtemp));
        %>
        <%= tempResultreturnp17 %>
        <%
break;
case 19:
        gotMethod = true;
        java.lang.String queryPlayerName19mtemp = id.queryPlayerName();
if(queryPlayerName19mtemp == null){
%>
<%=queryPlayerName19mtemp %>
<%
}else{
        String tempResultreturnp20 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(queryPlayerName19mtemp));
        %>
        <%= tempResultreturnp20 %>
        <%
}
break;
case 22:
        gotMethod = true;
        id.readRecord();
break;
}
} catch (Exception e) { 
%>
Exception: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.toString()) %>
Message: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.getMessage()) %>
<%
return;
}
if(!gotMethod){
%>
result: N/A
<%
}
%>
</BODY>
</HTML>