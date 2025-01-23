<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
<!-- Bootstrap Icons CDN -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css" rel="stylesheet">
<title>ログイン</title>
<link rel="stylesheet" href="css/style.css">
<style>
  .custom-input-group-text {
    background-color: #9c9993; /* 色 */
    color: white; /* テキストの色を白 */
  }
  .custom-form-control {
    border: 2px solid #adaca9; /* 枠線 */
  }
  .toggle-password {
    cursor: pointer;
    position: absolute;
    top: 50%;
    right: 10px;
    transform: translateY(-50%);
    font-size: 16px;
    color: #555;
  }
</style>
</head>
<body>
<header>
  <div class="container">
    <nav>
      <div class="navbar-header">
        <h3>Indoor Plants</h3>
      </div>
    </nav>
  </div>
</header>
<div class="container admin-container">
  <main>
    <h2>会員ログイン</h2>
    <p>ログインIDとパスワードを入力し、ログインボタンを押してください。</p>

    <c:if test="${error}">
      <p class="alert alert-danger">ログインIDまたはパスワードが違います</p>
    </c:if>

    <form action="login" method="post">
      <div class="input-group mb-3">
        <div class="input-group">
          <span class="input-group-text custom-input-group-text" id="basic-addon3">会員ID</span>
          <input type="text" class="form-control custom-form-control" name="loginId" aria-describedby="basic-addon3 basic-addon4">
        </div>
      </div>
      <div class="input-group mb-3 position-relative">
        <div class="input-group">
          <span class="input-group-text custom-input-group-text" id="basic-addon3">パスワード</span>
          <input type="password" class="form-control custom-form-control" id="loginPass" name="loginPass" aria-describedby="basic-addon3 basic-addon4">
          <span class="toggle-password" onclick="togglePassword()">
            <i class="bi bi-eye"></i> <!-- 非表示状態 -->
          </span>
        </div>
      </div>
      <button type="submit" class="btn btn-outline-secondary">ログイン</button>
    </form>
  </main>
</div>

<script src="js/jquery-2.1.4.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script>
  function togglePassword() {
    const passwordInput = document.getElementById('loginPass');
    const toggleIcon = document.querySelector('.toggle-password i');
    
    if (passwordInput.type === 'password') {
      passwordInput.type = 'text';
      toggleIcon.classList.remove('bi-eye');
      toggleIcon.classList.add('bi-eye-slash'); // 表示中アイコンに変更
    } else {
      passwordInput.type = 'password';
      toggleIcon.classList.remove('bi-eye-slash');
      toggleIcon.classList.add('bi-eye'); // 非表示アイコンに戻す
    }
  }
</script>

</body>
</html>