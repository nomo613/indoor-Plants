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
	rel="stylesheet"
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
	crossorigin="anonymous">
<title>新規登録</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<header>
		<div class="container">
			<nav>
				<div class="navbar-header">
					<h3>indoor Plants</h3>
				</div>
			</nav>
		</div>
	</header>
	<div>
		<main>
			<h2>新規登録</h2>
			<p>観葉植物の樹種名と名前を入力し、登録ボタンを押してください。</p>
			<style>
.custom-input-group-text {
	background-color: #9c9993; /* 色 */
	color: white; /* テキストの色を白 */
}

.custom-form-control {
	border: 2px solid #adaca9; /* 枠線 */
}
</style>
			<form action="plantsList.jsp">
				<div class="input-group mb-3">
					<div class="input-group">
						<span class="input-group-text custom-input-group-text"
							id="basic-addon3">樹種名</span> <input type="text"
							class="form-control custom-form-control" id="basic-url"
							aria-describedby="basic-addon3 basic-addon4">
					</div>
				</div>
				<div class="input-group mb-3">
					<div class="input-group">
						<span class="input-group-text custom-input-group-text"
							id="basic-addon3">氏 名</span> <input type="text"
							class="form-control custom-form-control" id="basic-url"
							aria-describedby="basic-addon3 basic-addon4">
					</div>
				</div>
			</form>
			<button type="button" class="btn btn-outline-secondary"
				onclick="location.href='login'">登録</button>
		</main>
	</div>
	<script src="js/jquery-2.1.4.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>