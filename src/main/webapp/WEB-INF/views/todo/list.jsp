<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2026-03-26
  Time: 오후 9:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
</head>
<body>
<!--<h1>Hello, world!</h1>-->
<div class ="container-fluid">
    <div class="row">
        <!--        <h1>Header</h1>-->

        <div class="col">
            <nav class="navbar navbar-expand-lg bg-body-tertiary">
                <div class="container-fluid">
                    <a class="navbar-brand" href="#">Navbar</a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarNav">
                        <ul class="navbar-nav">
                            <li class="nav-item">
                                <a class="nav-link active" aria-current="page" href="#">Home</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">Features</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">Pricing</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link disabled" aria-disabled="true">Disabled</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>

        </div>
        <!--        header 끝-->
    </div>
    <div class="row content">
        <!--        <h1>Content</h1>-->
        <div class="col">
            <div class="card">
                <div class="card-header">
                    Featured
                </div>
                <div class="card-body">
                    <h5 class="card-title">Special title treatment</h5>
                    <table class="table">
                        <thead>
                        <tr>
                            <th scope="col">Tno</th>
                            <th scope="col">Title</th>
                            <th scope="col">Writer</th>
                            <th scope="col">DueDate</th>
                            <th scope="col">Finished</th>
                        </tr>
                        </thead>
                        <tbody>
<%--                        <c:forEach items="${dtoList}" var="dto">--%>
                            <c:forEach items="${responseDTO.dtoList}" var="dto">
                            <tr>
                                <th scope="row"><c:out value="${dto.tno}"/></th>
                                <td>
                                    <a href="/todo/read?tno=${dto.tno}" class="text-decoration-none"
                                       data-tno="${dto.tno}">
                                    <c:out value="${dto.title}"/>
                                    </a>
                                </td>
                                <td><c:out value="${dto.writer}"/></td>
                                <td><c:out value="${dto.dueDate}"/></td>
                                <td><c:out value="${dto.finished}"/></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <div class="float-end">
                        <ul class="pagination flex-wrap">
                            <c:if test="${responseDTO.prev}">
                                <li class="page-item">
                                    <a class="page-link" data-num="${responseDTO.start -1}">Previous</a>
                                </li>
                            </c:if>
                            <c:forEach begin="${responseDTO.start}" end="${responseDTO.end}" var="num">
                                <li class="page-item ${responseDTO.page == num? "active":""}">
                                    <a class="page-link" data-num="${num}">${num}</a>
                                </li>
                            </c:forEach>
                            <c:if test="${responseDTO.next}">
                                <li class="page-item">
                                    <a class="page-link" data-num="${responseDTO.end +1}">next</a>
                                </li>
                            </c:if>
                        </ul>
                    </div>
                    <script>
                        document.querySelector(".pagination").addEventListener("click", function (e) {
                            e.preventDefault()
                            e.stopPropagation()
                            const target = e.target
                            if(target.tagName !== 'A') {
                                return
                            }
                            const num = target.getAttribute("data-num")
                            self.location = `/todo/list?page=\${num}` //백틱(` `)을 이용해서 템플릿 처리
                        },false)
                    </script>
                </div>
            </div>

        </div>

    </div>
    <!--    row content 끝 -->
    <div class="row content">

        <h1>Content</h1>
    </div>

    <div class="row footer">
        <!--        <h1>Footer</h1>-->
        <div class="row fixed-bottom" style="z-index: -100">
            <footer class="py-1 my-1">
                <p class="text-center text-muted">Footer</p>
            </footer>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>
</body>
</html>
