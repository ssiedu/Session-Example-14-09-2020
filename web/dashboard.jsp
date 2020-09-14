<%
    String sid=session.getId();
    int n=session.getMaxInactiveInterval();
    long val=session.getCreationTime();
    java.util.Date dt=new java.util.Date(val);
    out.println("Your Session Id : "+sid+"<br>");
    out.println("Your Session Was Created : "+dt+"<br>");
    out.println("Your Session Will Expire If You Remain Idle For "+n+" Seconds");
    //to read something from session (you can skip first step)
    String uid=(String)session.getAttribute("userid");
    if(uid==null){
        response.sendRedirect("index.jsp");
    }
%>
<html>
    <body>
        <h3>User-Dashboard</h3>
        <hr>
        <pre>
        <a href="ActiveCaseServlet">active-cases</a>
        <a href="RecoveredCaseServlet">recovered-cases</a>
        <a href="TotalDeathServlet">total-deaths</a>
        <a href="KillSession">logout</a>
        </pre>
        <hr>
    </body>
</html>
