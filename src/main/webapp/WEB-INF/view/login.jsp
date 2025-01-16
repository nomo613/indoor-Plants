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
<title>ログイン</title>
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
	<div class="container admin-container">
		<main>
			<h2>ログイン</h2>
			<p>ログインIDとパスワードを入力し、ログインボタンを押してください。</p>

			<style>
.custom-input-group-text {
	background-color: #9c9993; /* 色 */
	color: white; /* テキストの色を白 */
}

.custom-form-control {
	border: 2px solid #adaca9; /* 枠線 */
	

}
</style>
			<form action="login" method="post">
				<div class="input-group mb-3">
					<div class="input-group">
						<span class="input-group-text custom-input-group-text"
							id="basic-addon3">ログインID</span> <input type="text"
							class="form-control custom-form-control" name="loginId"
							id="basic-url" aria-describedby="basic-addon3 basic-addon4">
					</div>
				</div>
				<div class="input-group mb-3">
					<div class="input-group">
						<span class="input-group-text custom-input-group-text"
							id="basic-addon3">パスワード</span> <input type="password"
							class="form-control custom-form-control" name="loginPass"
							id="basic-url" aria-describedby="basic-addon3 basic-addon4">
					</div>
				</div>
				<button type="submit" class="btn btn-outline-secondary">ログイン</button>
			</form>
			<p class="alert alert-danger custom-error" 
    style="${error ? '' : 'display: none;'}">ログインIDまたはパスワードが違います</p>

		</main>
	</div>
	<script src="js/jquery-2.1.4.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>