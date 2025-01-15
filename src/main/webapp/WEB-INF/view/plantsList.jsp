<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <link rel="stylesheet" href="css/style.css">
    <title>PLANTS LIST</title>
</head>
<body>
  <h2>PLANTS LIST</h2>
   <!-- カード外にログアウトボタンを配置 -->
<div style="text-align: right; margin-right: 200px;　color: #808080">
  <button type="button" class="btn btn-outline-dark" onclick="location.href='logout'">ログアウト</button>
</div>
 <div class="container">
  <div class="row">
    <!-- カード1 -->
     <div class="col-md-6">
         <div class="card mb-3" style="max-width: 600px; margin: 20px; padding: 10px; background-color: #f5f5f5; color: #333;">
       <div class="row g-0">
          <div class="col-md-4">
            <img src="images/A-1.jpg" class="img-fluid rounded-start" alt="image">
          </div>
          <div class="col-md-8">
            <div class="card-body">
              <h5 class="card-title" style="color: #696969; margin-bottom: 20px;">フランスゴム</h5>
              <p class="card-text" style="color: #808080;">和名: コバノゴムビワ(小葉のゴム琵琶)<br>学名: Ficus elastica<br>クワ科イチジク属</p>
              <div>
                <small class="text-body-secondary" style="color: #808080; ">
                  環境適応力が高く、初心者でも育てやすい観葉植物です。<br>有害物質(ホルムアルデヒドや一酸化炭素など)を吸収する能力があるとされ、室内の空気清浄に役立つ植物の一つです。
                </small>
              <div style="margin-top: 20px;">
                <button type="button" class="btn btn-outline-success" onclick="location.href='growth'">編集</button>
              </div>
            </div>
          </div>
        </div>
      </div>
         </div>
     </div>
 <!-- カード2 -->
 <div class="col-md-6">
  <div class="card mb-3" style="max-width: 600px; margin: 20px; padding: 10px; background-color: #f5f5f5; color: #333;">
<div class="row g-0">
   <div class="col-md-4">
     <img src="images/C-3.jpg" class="img-fluid rounded-start" alt="image">
   </div>
   <div class="col-md-8">
     <div class="card-body">
       <h5 class="card-title" style="color: #696969;">サンセベリア</h5>
       <p class="card-text" style="color: #808080;">和名: チトセラン(千歳蘭)<br>学名: Dracaena trifasciata<br>ドラセナ属</p>
       <div>
         <small class="text-body-secondary" style="color: #808080; ">
          水やりの頻度が少なく、剪定もあまり必要ないため、<br>初心者でも比較的管理がしやすい植物です。<br>他の植物よりも空気清浄効果が高いが出ましたが、<br>サンスベリアは品種も多く更に個性的な形が魅力的なため、見る者を強く惹きつけます。
         </small>
       <div style="margin-top: 20px;">
         <button type="button" class="btn btn-outline-success" onclick="location.href='growth'">編集</button>
       </div>
     </div>
   </div>
 </div>
</div>
  </div>
</div>
</div>
</div>
<div class="container">
  <div class="row">
   <!-- カード3 -->
   <div class="col-md-6">
    <div class="card mb-3" style="max-width: 600px; margin: 20px; padding: 10px; background-color: #f5f5f5; color: #333;">
  <div class="row g-0">
     <div class="col-md-4">
       <img src="images/A-1.jpg" class="img-fluid rounded-start" alt="image">
     </div>
     <div class="col-md-8">
       <div class="card-body">
         <h5 class="card-title" style="color: #696969; margin-bottom: 20px;">モンステラ</h5>
         <p class="card-text" style="color: #808080;">和名: ホウライショウ<br>学名: Monstera deliciosa<br>サトイモ科 / ホウライショウ属</p>
         <div>
           <small class="text-body-secondary" style="color: #808080; ">
            つる性の着生植物で、原生地では、<br>付着根で樹木やヤシ類などに這い上がって伸びます。<br>※原産地は熱帯アメリカ<br>ハワイ語で「湧き出る水」という意味から連想し、金運アップや幸運が舞い込むなど言われている縁起が良い植物です。
           </small>
         <div style="margin-top: 20px;">
           <button type="button" class="btn btn-outline-success" onclick="location.href='growth'">編集</button>
         </div>
       </div>
     </div>
   </div>
 </div>
    </div>
</div>
<!-- カード4 -->
<div class="col-md-6">
<div class="card mb-3" style="max-width: 600px; margin: 20px; padding: 10px; background-color: #f5f5f5; color: #333;">
<div class="row g-0">
<div class="col-md-4">
<img src="..." class="img-fluid rounded-start" alt="image">
</div>
<div class="col-md-8">
<div class="card-body">
  <h5 class="card-title" style="color: #696969;"></h5>
  <p class="card-text" style="color: #808080;"></p>
  <div>
    <small class="text-body-secondary" style="color: #808080; ">

    </small>
  <div style="margin-top: 20px;">
    <button type="button" class="btn btn-outline-success" onclick="location.href='growth'">編集</button>
  </div>
</div>
</div>
</div>
</div>
</div>
</div>
</div>
</div>

  <script src="js/jquery-2.1.4.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
</body>
</html>