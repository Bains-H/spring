<%--
  Created by IntelliJ IDEA.
  User: benfe
  Date: 2020/7/31
  Time: 15:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--    <form action="${pageContext.request.contextPath}/user/quick22" method="post" enctype="multipart/form-data">--%>
<%--        名称：<input type="text" name="username"><br>--%>
<%--        文件：<input type="file" name="uploadFile"><br>--%>
<%--        <input type="submit" name="提交"><br>--%>
<%--    </form>--%>

    <form action="${pageContext.request.contextPath}/user/quick23" method="post" enctype="multipart/form-data">
        名称：<input type="text" name="username"><br>
        文件1：<input type="file" name="uploadFiles"><br>
        文件2：<input type="file" name="uploadFiles"><br>
        文件3：<input type="file" name="uploadFiles"><br>
        <input type="submit" name="提交"><br>
    </form>

</body>
</html>
