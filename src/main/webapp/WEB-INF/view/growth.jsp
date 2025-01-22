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
<title>生育記録の登録</title>
<style>
/* ページ全体を中央揃えにする */
body {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh; /* ビューポート全体の高さ */
    margin: 0; /* 余白をリセット */
    background-color:  rgb(164, 187, 177); /* 背景色を設定 */
}

/* フォームのスタイル */
.form-container {
    width: 400px; /* フォームの幅 */
    padding: 20px;
    background-color: #ffffff; /* 背景色を白に設定 */
    border-radius: 8px; /* 角を丸くする */
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2); /* 影を追加 */
}

.align-right {
    text-align: right; /* テキストを右揃え */
}

</style>
</head>
<body>

<div class="form-container">
	<h2 class="text-center">
		生育記録の登録
	</h2>

	<form action="growth" method="post">
		<p>
			観察日: <input type="date" name="testedAt" class="form-control">
		</p>

		<p>
			水やり: <input name="watering_frequency" list="watering-options"
				class="form-control" placeholder="選択または入力してください">
			<datalist id="watering-options">
				<option value="毎日"></option>
				<option value="2日～3日"></option>
				<option value="1週間"></option>
				<option value="適宜"></option>
			</datalist>
		</p>

		<p>
			生育状況:
			<textarea name="summary" class="form-control"    rows="10"
				placeholder="例: 良好/葉が弱ってる"></textarea>
			<c:out value="${item.summary}" />
		</p>

		<p class="align-right">
			<button type="submit" class="btn btn-outline-secondary">登録</button>
		</p>
	</form>
</div>

<script src="js/jquery-2.1.4.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>
