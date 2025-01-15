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
<title>生育記録編集</title>
</head>
<body>
	<header>
		<style>
.align-left {
	text-align: left; /* テキストを左揃え */
	margin-left: 4%; /* 必要に応じて左マージンを調整 */
}
</style>
		<h2 class="align-left">
			生育記録編集<span class="badge bg-secondary"></span>
		</h2>
	</header>
	<style>
.custom-width {
	max-width: 200px; /* 幅を200pxに制限 */
	margin-left: 4%;
}
</style>
	<div class="form-floating mb-3 custom-width">
		<input type="email" class="form-control" id="floatingInputDisabled"
			placeholder="name@example.com" disabled> <label
			for="floatingInputDisabled">フランスゴム</label>
	</div>
	<div class="form-floating mb-3 custom-width">
		<input type="email" class="form-control" id="floatingInputDisabled"
			placeholder="name@example.com" disabled> <label
			for="floatingTextareaDisabled">長谷川京子</label>
	</div>
	</div>

	<style>
.align-right {
	text-align: right; /* テキストを右揃え */
	margin-right: 6%; /* 必要に応じて右マージンを調整 */
}
</style>
	<div class="align-right">
		<button type="button" class="btn btn-outline-secondary"
			onclick="location.href='growthOut'">登録</button>
	</div>

	<nav aria-label="Pagination">
		<ul class="pagination pagination-sm  custom-pagination">
			<li class="page-item active" aria-current="page"><span
				class="page-link">1</span></li>
			<li class="page-item"><a class="page-link" href="#">2</a></li>
			<li class="page-item"><a class="page-link" href="#">3</a></li>
		</ul>
		<style>
.custom-pagination .page-item.active .page-link {
	background-color: #9c9c97; /* 背景色 */
	border-color: #a0a09d; /* 枠線も変更 */
	color: #6b6969; /* テキスト色をダークグレーに */
}

.custom-pagination .page-link {
	color: #797b7c; /* 通常状態のリンク色 */
}

.custom-pagination .page-link:hover {
	background-color: #f8f9fa; /* ホバー時の背景色 */
	color: #b5babe; /* ホバー時のリンク色 */
}
</style>
	</nav>
	<table class="table table-bordered">
		<thead>
			<tr>
				<th scope="col" style="width: 5%;">no.</th>
				<th scope="col" style="width: 20%;">日付</th>
				<th scope="col" style="width: 10%;">水やり</th>
				<th scope="col" style="width: 50%;">育成記録</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<th scope="row">1</th>
				<td><input type="date" style="width: 100%;"></td>
				<td><select style="width: 100%;">
						<option value="毎日">毎日</option>
						<option value="2～3日">2～3日</option>
						<option value="週1回">週1回</option>
						<option value="週1回">適宜</option>
				</select></td>
				 <td><textarea name="summery" cols="100" rows="3" type="text"
				     placeholder="例: 良好/葉が弱ってる"></textarea>
				 </td>
			<tr>
				<th scope="row">1</th>
				<td><input type="date" style="width: 100%;"></td>
				<td><select style="width: 100%;">
						<option value="毎日">毎日</option>
						<option value="2～3日">2～3日</option>
						<option value="週1回">週1回</option>
						<option value="週1回">適宜</option>
				</select></td>
				 <td><textarea name="summery" cols="100" rows="3" type="text"
				     placeholder="例: 良好/葉が弱ってる"></textarea>
				 </td>
			<tr>
				<th scope="row">1</th>
				<td><input type="date" style="width: 100%;"></td>
				<td><select style="width: 100%;">
						<option value="毎日">毎日</option>
						<option value="2～3日">2～3日</option>
						<option value="週1回">週1回</option>
						<option value="週1回">適宜</option>
				</select></td>
				 <td><textarea name="summery" cols="100" rows="3" type="text"
				     placeholder="例: 良好/葉が弱ってる"></textarea>
				 </td>
			<tr>
				<th scope="row">1</th>
				<td><input type="date" style="width: 100%;"></td>
				<td><select style="width: 100%;">
						<option value="毎日">毎日</option>
						<option value="2～3日">2～3日</option>
						<option value="週1回">週1回</option>
						<option value="週1回">適宜</option>
				</select></td>
				 <td><textarea name="summery" cols="100" rows="3" type="text"
				     placeholder="例: 良好/葉が弱ってる"></textarea>
				 </td>
			<tr>
				<th scope="row">1</th>
				<td><input type="date" style="width: 100%;"></td>
				<td><select style="width: 100%;">
						<option value="毎日">毎日</option>
						<option value="2～3日">2～3日</option>
						<option value="週1回">週1回</option>
						<option value="週1回">適宜</option>
				</select></td>
				 <td><textarea name="summery" cols="100" rows="3" type="text"
				     placeholder="例: 良好/葉が弱ってる"></textarea>
				 </td>
			<tr>
				<th scope="row">1</th>
				<td><input type="date" style="width: 100%;"></td>
				<td><select style="width: 100%;">
						<option value="毎日">毎日</option>
						<option value="2～3日">2～3日</option>
						<option value="週1回">週1回</option>
						<option value="週1回">適宜</option>
				</select></td>
				 <td><textarea name="summery" cols="100" rows="3" type="text"
				     placeholder="例: 良好/葉が弱ってる"></textarea>
				 </td>
			<tr>
				<th scope="row">1</th>
				<td><input type="date" style="width: 100%;"></td>
				<td><select style="width: 100%;">
						<option value="毎日">毎日</option>
						<option value="2～3日">2～3日</option>
						<option value="週1回">週1回</option>
						<option value="週1回">適宜</option>
				</select></td>
				 <td><textarea name="summery" cols="100" rows="3" type="text"
				     placeholder="例: 良好/葉が弱ってる"></textarea>
				 </td>
		</tbody>
	</table>
	<script src="js/jquery-2.1.4.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>