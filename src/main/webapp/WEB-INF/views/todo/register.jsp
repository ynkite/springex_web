<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2026-03-13
  Time: 오후 6:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <form action="/todo/register" method="post">
    <div>
        Title: <input type="text" name="title" placeholder="INSERT TITLE">
    </div>
    <div>
        DueDate: <input type="date" name="dueDate">
    </div>
    <div>
        Writer: <input type="text" name="writer">
    </div>
    <div>
        Finished: <input type="checkbox" name="finished">
    </div>
    <div>
        <button type="submit">REGISTER</button>
    </div>
  </form>
</body>
</html>
