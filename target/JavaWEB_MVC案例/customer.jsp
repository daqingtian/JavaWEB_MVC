<%@ page import="domain.Customer" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: daqingtian
  Date: 2018/11/2
  Time: 21:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="/js/jquery-1.8.3.min.js" charset="UTF-8"></script>
    <script type="javascript">

        (function(){
            alert("f");
        })();


        $(function () {
            $(".update").click(function () {
                alert("aaaaa");
            })
        })
        // $(function () {
        //     $(".delete").click(function () {
        //         alert("aaaaa")
        //         var flag = confirm("确定要删除吗");
        //         return flag;
        //     })
        // })
    </script>
</head>
<body>

    <form action="/query.do" method="post">
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
                <td><input type="submit" value="query"></td>
                <td><a href="/addcustomer.jsp">添加新客户</a></td>
            </tr>
        </table>
    </form>
    <%
        List<Customer> customers = (List<Customer>) request.getAttribute("customers");
    %>

    <table border="1" cellpadding="10" cellspacing="0">
        <tr>
            <th>getId</th>
            <th>getName</th>
            <th>getAddress</th>
            <th>getPhone</th>
            <th>update/delete</th>
        </tr>
        <%
            for(Customer customer: customers){
        %>
        <tr>
            <td><%= customer.getId() %></td>
            <td><%= customer.getName() %></td>
            <td><%= customer.getAddress() %></td>
            <td><%= customer.getPhone() %></td>
            <td><a href="edit.do?id=<%=customer.getId() %>" class="update">修改</a>
                <a href="delete.do?id=<%=customer.getId() %>" class="delete">删除</a></td>
        </tr>
        <br/>
        <%
            }
        %>
    </table>









</body>
</html>
