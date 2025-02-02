<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="css/style.css">
<title>PLANTS LIST</title>
</head>
<body>
	<div class="container my-5">
		<header class="d-flex justify-content-between align-items-center mb-4">
			<h2>PLANTS LIST</h2>
		</header>

		<p style="font-weight: bold; color: rgb(87, 88, 84);">
			登録ボタンを押すと植物に関する生育記録を追加できます。</p>

		<div class="row">
			<%-- 植物リストの繰り返し表示 --%>
			<c:forEach var="plant" items="${plants}">
				<div class="col-md-3 mb-4">
					<div class="wrapper">
						<div class="card">
							<img class="card-image" src="<c:url value='${plant.imagePath}'/>"
								alt="Plant Image">
							<div class="card-box">
								<h2 class="card-title">${plant.plantName}</h2>
								<p class="card-description" style=font-size:13px>
									和名: ${plant.japaneseName}<br> 学名: <em>${plant.scientificName}</em><br>
									属名: ${plant.genusName}
								</p>
								 <a onclick="location.href='growth?plantName=${plant.plantName}'" class="btn-horizontal-border">登録</a>
								<!--  <a onclick="location.href='growth?plantName=${plant.plantName}'" class="btn-vertical-border">登録</a> -->
							</div>
							<!-- card-box 終了 -->
						</div>
						<!-- card 終了 -->
					</div>
					<!-- wrapper 終了 -->

				</div>
				<!-- col-md-3 mb-4 終了 -->
			</c:forEach>
		</div>
		<!-- row 終了 -->
	</div>
	<!-- container 終了 -->

	<script src="js/jquery-2.1.4.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>

</html>




