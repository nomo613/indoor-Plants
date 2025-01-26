<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/style.css">
    <title>登録植物</title>
</head>
<body>
    <h1>登録の植物</h1>

    <c:if test="${not empty error}">
        <p style="color: red;">${error}</p>
    </c:if>
    <c:if test="${not empty sessionScope.message}">
        <p style="color: green;">${sessionScope.message}</p>
        <c:remove var="message" scope="session"/>
    </c:if>

    <ul>
        <c:forEach var="plant" items="${registeredPlants}">
            <li>${plant.plantName}</li>
        </c:forEach>
    </ul>

    <a href="plantsList">植物リストに戻る</a>
</body>
</html>
