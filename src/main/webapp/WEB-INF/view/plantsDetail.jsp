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
<title>PlantsDetail</title>
</head>
<body>

	<div class="container mt-5">
		<c:forEach var="plant" items="${plants}">
			<div class="card mb-3">
				<div class="row g-0">
					<div class="col-md-4">
						<img class="card-image" src="<c:url value='${plant.imagePath}'/>"
							class="img-fluid rounded-start" alt="${plant.plantName}">
					</div>
					<div class="col-md-8">
						<div class="card-body">
							<h2 class="card-title">${plant.plantName}</h2>

							<p class="card-text">
								<style>
.card-title {
	font-size: 50px;
	position: relative;
	margin-bottom: 0.2rem;
	padding: 1rem 0;
	border-bottom: 5px solid;
	color: rgb(97, 98, 89);
	font-size: 26px;
	font-weight: bold;
}

.card-title:before {
	position: absolute;
	bottom: -0.6rem;
	left: 0rem;
	right: 0rem;
	border-bottom: 1px solid;
	content: '';
	color: rgb(97, 98, 89);
}

.plant-info {
	margin-bottom: 10px;
	font-size: 20px;
}
</style>
							<div class="plant-info" style=margin-top:50px>
								<strong>和名:</strong> ${plant.japaneseName}
							</div>

							<div class="plant-info">
								<strong>学名:</strong> <em>${plant.scientificName}</em>
							</div>

							<div class="plant-info">
								<strong>属名:</strong> ${plant.genusName}
							</div>

							<div class="plant-info" style=margin-top:40px>
								<strong>特徴<br></strong> ${plant.description}
							</div>

							</p>
                        <a onclick="location.href='plantsList?plantName=${plant.plantName}'"
                                    class="btn-vertical-border"style=margin-top:40px>PLANTSLISTへ戻る</a>
						</div>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>


	<script src="js/jquery-2.1.4.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>