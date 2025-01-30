<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!doctype html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <link href="https://fonts.googleapis.com/css2?family=Lato:wght@400;700&family=M+PLUS+Rounded+1c:wght@400;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="css/style.css">
    <title>生育記録の登録</title>
    <style>
        body {
            background-color: rgb(164, 187, 177);
            text-align: center;
            font-family: 'Lato', 'M PLUS Rounded 1c', sans-serif;
            margin: 0;
            padding: 0;
            background-image: url('images/.jpg'); /* 背景画像のパス */
        }

        .container {
            margin-top: 2rem;
            background: #f9f9f9d3;
            padding: 2rem;
            border-radius: 10px;
            box-shadow: 0px 4px 6px rgba(0, 0, 0, 0.1);
        }

        h3 {
            color: rgb(110, 104, 94);
              margin-bottom: 1rem;
        }

        table {
            margin: auto;
            width: 90%;
            border-collapse: collapse;
        }

        table th, table td {
            padding: 1rem;
            border: 1px solid #ddd;
            text-align: center;
        }

        table tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        table tr:hover {
            background-color: #e9ffe8;
        }

        a {
            text-decoration: none;
            color: rgb(87, 88, 84);
            font-weight: bold;
        }

        a:hover {
            color: rgb(87, 88, 84);
        }

    </style>
</head>
<body>
    <div class="container">
        <h3>生育の記録</h3>

        <div class="left-bottom-info">
            
            <div class="plant-info">
                <strong>PLANTS : </strong>
                <c:out value="${plantName}" /> 
            </div>
        </div>
        <style>
            .left-bottom-info {
                margin-top: 1rem;
                display: flex; /* フレックスボックス */
                align-items: center; /* 縦方向を中央 */
                gap: 10rem; /* 項目の間隔調整 */
                padding: 1rem;
                background-color: #f9f9f9;
                border-radius: 8px;
                box-shadow: 0px 4px 6px rgba(0, 0, 0, 0.1);
            }

            .plant-info {
                font-size: 1rem;
                color: rgb(87, 88, 84);
            }
        </style>
   <form action="logout" method="post">
    <p><a href="logout" class="btn btn-outline-secondary" disabled>登録</a></p>
</form>

<table class="table table-striped table-hover">
    <thead>
        <tr>
            <th>ID</th>
            <th>観察年月日</th>
            <th>水やり頻度</th>
            <th>生育状況</th>
        </tr>
    </thead>
    <tbody>
        <%-- ページネーションの設定 --%>
        <c:set var="pageSize" value="15" />
        <c:set var="page" value="${empty param.page ? 1 : param.page}" />
        <c:set var="start" value="${(page - 1) * pageSize}" />
        <c:set var="end" value="${start + pageSize}" />

        <%-- データの表示 --%>
        <c:forEach var="growthList" items="${growths}" varStatus="status">
            <c:if test="${status.index >= start && status.index < end}">
                <tr>
                    <td><c:out value="${growthList.id}" /></td>
                    <td><fmt:formatDate value="${growthList.observationAt}" pattern="yyyy-MM-dd" /></td>
                    <td><c:out value="${growthList.watering}" /></td>
                    <td><c:out value="${growthList.record}" /></td>
                </tr>
            </c:if>
        </c:forEach>
    </tbody>
</table>

<%-- ページネーションのリンク --%>
<div class="wrapper">
    <div class="pagination-next">
        <c:if test="${end < growths.size()}">
            <a href="?page=${page + 1}" class="pagination-next-link key-btn">次のページ</a>
        </c:if>
    </div>
    
    <div class="pagination">
        <%-- 現在のページを表示 --%>
        <span aria-current="page" class="page-numbers current">${page}</span>

        <%-- 2ページ目以降のリンクを表示 --%>
        <c:forEach begin="1" end="${(growths.size() + pageSize - 1) / pageSize}" var="p">
            <a class="page-numbers" href="?page=${p}">${p}</a>
        </c:forEach>

        <%-- 「…」の省略表示（ページ数が多い場合） --%>
        <c:if test="${(growths.size() / pageSize) > 5}">
            <span class="page-numbers dots">&hellip;</span>
            <a class="page-numbers" href="?page=${(growths.size() / pageSize)}">
                ${(growths.size() + pageSize - 1) / pageSize}
            </a>
        </c:if>

        <%-- 「次へ」ボタン --%>
        <c:if test="${end < growths.size()}">
            <a class="next page-numbers" href="?page=${page + 1}">
                <span class="screen-reader-text">次へ</span>
                <span class="fa fa-angle-right" aria-hidden="true"></span>
            </a>
        </c:if>
    </div>
</div>

    <style>

    table th:nth-child(1), table td:nth-child(1) {
        width: 5%;
    }
    table th:nth-child(2), table td:nth-child(2) {
        width: 20%;
    }
    table th:nth-child(3), table td:nth-child(3) {
        width: 20%;
    }
    table th:nth-child(4), table td:nth-child(4) {
        width: 55%;
    }
    </style>
</body>
</html>
