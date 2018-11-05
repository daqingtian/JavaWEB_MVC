<%--
  Created by IntelliJ IDEA.
  User: daqingtian
  Date: 2018/11/4
  Time: 16:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/add.do" method="post">
    <table>
        <tr>
            <td>CustomerName:</td>
            <td><input name="name"></td>
            <%--/name值域实体成员变量一致--%>
        </tr>
        <tr>
            <td>Customeraddress:</td>
            <td><input name="address"></td>
        </tr>
        <tr>
            <td>CustomerPhone:</td>
            <td><input name="phone"></td>
        </tr>
        <tr>
            <td><input type="submit" value="add"></td>
        </tr>
    </table>
    <%
        if (request.getAttribute("key")!=null){
    %>
          <%=request.getAttribute("key")%>
    <%
        }
    %>

</form>

</body>
</html>
