<%--
  Created by IntelliJ IDEA.
  User: huang.b.h
  Date: 2020/8/14
  Time: 16:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>展示账户数据列表</h1>
    <table border="0.5">
        <tr>
            <th>账户id</th>
            <th>账户名称</th>
            <th>账户金额</th>
        </tr>
        <c:forEach items="${accountList}" var="account">
            <tr>
                <td>${account.id}</td>
                <td>${account.name}</td>
                <td>${account.money}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
