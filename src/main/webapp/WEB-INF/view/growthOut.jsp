<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <link rel="stylesheet" href="css/style.css">
    <title>登録確認</title>
</head>
<body>
    <header>
        <h2>登録確認</h2>
    </header>
    <div style="text-align: right; margin-right: 200px; color: #808080">
    <button type="button" class="btn btn-outline-secondary" onclick="location.href='logout'">ログアウト</button>
    </div>
    <div class="container">
        <div class="row">
            <!-- 左側のカード -->
            <div class="card">
                <img src="images/A-1.jpg" class="card-img-top" alt="image">
                <div class="card-body">
                    <h2 class="card-title">フランスゴム</h2>
                </div>
                <ul class="list-group list-group-flush">
                    <li class="list-group-item">会員ID: 0000001</li>
                    <li class="list-group-item">パスワード: 0000000002</li>
                    <li class="list-group-item">名前: スヌーピー</li>
                </ul>
                <div class="card-body">
                    <a href="https://www.hyponex.co.jp/plantia/plantia-7077/" class="card-link">link1</a>
                    <a href="https://hitohana.tokyo/indoor-plants/ficus-rubiginosa/ficus-rubiginosa-magari-25" class="card-link">link2</a>
                </div>
            </div>
            <!-- 右側のギャラリー -->
            <div class="col-md-6">
            <p>参考イメージ</p>
                <div class="photo-gallery" id="photoGallery">        
                    <img src="images/F-1.jpg" alt="Photo 1">
                    <img src="images/F-2.jpg" alt="Photo 2">
                    <img src="images/F-7.jpg" alt="Photo 7">
                    <img src="images/F-4.jpg" alt="Photo 4">
                    <img src="images/F-5.jpg" alt="Photo 5">
                    <img src="images/F-6.jpg" alt="Photo 6">
                </div>
            </div>
        </div>
    </div>
</body>
</html>