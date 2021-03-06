<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.80.0">
    <meta name="_csrf" content="${_csrf.token}"/>
	<meta name="_csrf_header" content="${_csrf.headerName}"/>
    <title>Management Main</title>

    <!-- Bootstrap core CSS -->
    <link href="/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="/css/main.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="layout/header.jsp" />
	
	<jsp:include page="layout/nav.jsp" />
    
    <div class="row main">
        <jsp:include page="layout/aside.jsp" />
        
        <main class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">	
			<jsp:include page="layout/courseMain.jsp" />
			<jsp:include page="layout/courseApplicant.jsp" />
			<jsp:include page="layout/emailContents.jsp" />
    	 </main>
    </div>
    
    <jsp:include page="layout/footer.jsp" />
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="/js/bootstrap.bundle.min.js"></script>
<script src="/js/courseMain.js"></script>
</body>
</html>