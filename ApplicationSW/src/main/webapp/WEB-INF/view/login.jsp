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
    <title>Signin</title>
    <!-- Bootstrap core CSS -->
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="/css/signin.css" rel="stylesheet">
  </head>
  <body class="text-center">
	<div class="container">
	    <form action="loginProc" class="form-signin" method="post">
	      <div>
	      	<img class="mb-4" src="img/playdata_signature.png" alt="" width="100%" height="auto">
	      </div>
	      <div>
	      	<h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
	      </div>
	      <div>
		    <label for="personEmail" class="sr-only">Manager ID</label>
	        <input name="personEmail" type="email" id="personEmail" class="form-control" placeholder="Email address" required autofocus>
	      </div>
	      <div>
	        <label for="inputPassword" class="sr-only">Password</label>
	        <input name="password" type="password" id="inputPassword" class="form-control" placeholder="Password" required>
	      </div>
	      <div class="checkbox mb-3">
	        <label>
	          <input type="checkbox" value="remember-me"> Remember me
	        </label>
	      </div>
	      <div>
	      	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	        <button class="btn btn-lg btn-color btn-block" type="submit">Sign in</button>
	      </div>
	      <div>
	      	<p class="mt-5 mb-3 text-muted">&copy; 2021</p>
	      </div>
	    </form>
	</div>
  </body>
</html>