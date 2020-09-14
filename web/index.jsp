<%
    session.setMaxInactiveInterval(150);
%>
<html>
    <body>
        <h3>Session-Example-Application</h3>
        <hr>
        <form action="VerifyUser">
            Userid <input type="text" name="t1"/>
            <input type="submit" value="Login"/>
        </form>
        <hr>
    </body>
</html>
