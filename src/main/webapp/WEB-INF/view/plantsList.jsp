<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="css/style.css">
    <title>PLANTS LIST</title>
</head>
<body>
    <div class="container my-5">
        <header class="d-flex justify-content-between align-items-center mb-4">
            <h2>PLANTS LIST</h2>
        </header>

        <%-- エラーメッセージ表示 --%>
        <c:if test="${not empty error}">
            <div class="alert alert-danger my-3" role="alert">
                ${error}
            </div>
        </c:if>

        <%-- 通常メッセージ表示 --%>
        <c:if test="${not empty sessionScope.message}">
            <div class="alert alert-success my-3">${sessionScope.message}</div>
            <c:remove var="message" scope="session"/>
        </c:if>

        <div class="row">
            <%-- 植物リストの繰り返し --%>
            <c:forEach var="plant" items="${plants}">
                <div class="col-md-4 mb-4">
                    <div class="card h-100 p-2" style="display: flex; flex-direction: column; justify-content: space-between;">
                        <div class="d-flex align-items-center mb-2">
                            <%-- 左側の画像 --%>
                            <img src="${plant.imagePath}" alt="Plant Image" class="img-fluid rounded" style="width: 100px; height: auto; margin-right: 15px;">

                            <%-- 右側のテキスト --%>
                            <div class="flex-grow-1 text-center">
                                <h5 class="card-title text-secondary">${plant.plantName}</h5>
                                <p class="card-text text-muted mb-1">
                                    和名: ${plant.japaneseName}<br>
                                    学名: ${plant.scientificName}<br>
                                    属名: ${plant.genusName}
                                </p>
                                <p class="card-text text-secondary small mb-0">${plant.description}</p>
                            </div>
                        </div>
                        <%-- 編集ボタン --%>
                        <div>
                            <button type="button" class="btn btn-outline-secondary w-100" style="text-align: left;" onclick="location.href='growth?id=${plant.id}'">編集</button>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>

    <script src="js/jquery-2.1.4.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>
</html>




