<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.80.0">
	<meta name="_csrf" content="${_csrf.token}"/>
	<meta name="_csrf_header" content="${_csrf.headerName}"/>
    <title>Manager Registration</title>
    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="css/managerRegister.css" rel="stylesheet">
  </head>
<body class="text-center">
  <div class="container">
    <form id="registerMgrForm" action="" method="post" class="form-mgr-reg">
      <div>
        <img class="mb-4" src="img/playdata_signature.png" alt="" width="100%" height="auto">
        <h1 class="h3 mb-3 font-weight-normal">Manager Registration</h1>
      </div>
      <div>
        <label for="personName" class="sr-only">Manager Name</label>
        <input name="personName" type="text" id="personName" class="form-control" placeholder="Enter Manager name" value="" required autofocus>
      </div>
      <div>
        <label for="personEmail" class="sr-only">Manager Email</label>
        <input name="personEmail" type="email" id="personEmail" class="form-control" placeholder="Enter Manager email" value="" required>
      </div>
      <div>
        <label for="inputPassword" class="sr-only">Manager Password</label>
        <input name="password" type="password" id="password" class="form-control" placeholder="Enter password" value="" required>
      </div>
      <div>
        <label for="enabled" class="sr-only">Enalbed</label>
        <select class="form-control" id="enabled" name="enabled" required>
          <option value="true">사용가능</option>
          <option value="false">사용불가능</option>
        </select>
      </div>
      <div>
        <label for="systemAuthority" class="sr-only">System Authority</label>
        <select class="form-control" id="systemAuthority" name="systemAuthority" required>
          <option value="ADMIN">관리자</option>
          <option value="GENERAL">일반</option>
        </select>
      </div>
      <div>
      	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        <button id="register-mgr" class="btn btn-lg btn-color btn-block" type="submit">Register</button>
      </div>
      <div>
        <p class="mt-5 mb-3 text-muted">&copy; 2021</p>
      </div>
    </form>
  </div>
  
  <script type="text/javascript">
    const register_button = document.getElementById("register-mgr");
    const form = document.getElementById("registerMgrForm");
  
    register_button.addEventListener("click", ()=>{
      let entries = new FormData(form).entries();
      let params = new URLSearchParams(entries);
      let params_entries = Object.fromEntries(params);
  	  let data = JSON.stringify(params_entries);
  	
  	  let xhr = new XMLHttpRequest();
  	  let url = "http://localhost:8081/managers";

  	xhr.onreadystatechange = function(){
  		if(xhr.readyState == 4 && xhr.status == 200){
  	      alert(data);
  	      alert("등록 성공");
  	  	}
  	  };
  	  xhr.open("POST", url, true);
  	  xhr.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');
  	  xhr.send(data);
      });
  </script>
  
</body>
</html>