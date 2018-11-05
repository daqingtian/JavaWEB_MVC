<%@ page import="domain.Customer" %><%--
  Created by IntelliJ IDEA.
  User: daqingtian
  Date: 2018/11/5
  Time: 0:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Customer customer = (Customer) request.getAttribute("customer");
%>


<form action="/update.do" method="post">
    <table>
        <tr style="display: none">
            <td><input name="id" value=<%=customer.getId()%>></td>
        </tr>
        <tr>
            <td>CustomerName:</td>
            <td><input name="name" value=<%=customer.getName()%>></td>
            <%--/name值域实体成员变量一致--%>
        </tr>
        <tr>
            <td>Customeraddress:</td>
            <td><input name="address" value=<%=customer.getAddress()%>></td>
        </tr>
        <tr>
            <td>CustomerPhone:</td>
            <td><input name="phone" value=<%=customer.getPhone()%>></td>
        </tr>
        <tr>
            <td><input type="submit" value="更新"></td>
        </tr>
    </table>
    <%--<%--%>
        <%--if (request.getAttribute("key")!=null){--%>
    <%--%>--%>
    <%--<%=request.getAttribute("key")%>--%>
    <%--<%--%>
        <%--}--%>
    <%--%>--%>

</form>

</body>
</html>
