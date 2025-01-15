<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
<title>ログアウト</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<header class="admin-header">
  <div class="container">
    <nav>
      <div class="navbar-header">
        <h3>IndoorPlants</h3>
      </div>
    </nav>
  </div>
</header>
<div class="container admin-container">
  <main>
      <h2>ログアウト完了</h2>
      <button type="button" class="btn btn-outline-secondary" onclick="location.href='indoorPlants'">トップページに戻る</button>
  </main>
</div>
<script src="../js/jquery-2.1.4.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
</body>
</html>