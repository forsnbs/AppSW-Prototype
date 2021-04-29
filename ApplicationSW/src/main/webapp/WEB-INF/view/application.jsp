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
    <title>Application</title>

    <!-- Bootstrap core CSS -->
    <link href="/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="/css/main.css" rel="stylesheet">
</head>
<body>
<div class="container">
	<div class="py-5 text-center">
		<h1 class="h2">${course.courseName} 교육과정 신청</h1>
	</div>
	<div class="row justify-content-center">
	    <div class="col-md-6 order-md-1">
		    <div class="d-flex flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
			    <ul>
			    	<li><span>기간</span>&nbsp; ${course.courseStartDate}&nbsp; ~ &nbsp;${course.courseEndDate}</li>
			    	<li><span>장소</span>&nbsp; ${course.courseLocation}</li>
			    	<li><span>시간</span>&nbsp; &nbsp; 09:00 ~ 18:00</li>
			    </ul>
			</div>
	        <form id="first-app-form" method="post" class="needs-validation" novalidate>
	            <div class="row">
		            <div class="col-md-12 mb-3 py-2">
		                <label for="personName">1. 이름을 적어주세요</label>
		                <input type="text" name="personName" class="form-control" id="personName" placeholder="" value="" required>
			            <div class="invalid-feedback">
							이름을 입력해주세요.
		                </div>
		            </div>
	            </div>

	            <div class="row">
		            <div class="col-md-12 mb-3 py-2">
		                <label for="personAge">2. 나이를 적어주세요 <br/> 
							<span>(향후 취업지원에 활용됩니다)</span>		                
		                </label>
		                <input type="text" name="personAge" class="form-control" id="personAge" placeholder="" value="" required>
			            <div class="invalid-feedback">
							나이를 입력해주세요.
		                </div>
		            </div>
	            </div>

	            <div class="row">
		            <div class="col-md-12 mb-3 py-2">
		                <label for="personEmail">3. 이메일을 적어주세요 <br/> 
							<span>(진행절차를 안내드릴 에정입니다. 자주사용하는 메일을 적어주세요.)</span>		                
		                </label>
		                <input type="text" name="personEmail" class="form-control" id="personEmail" placeholder="" value="" required>
			            <div class="invalid-feedback">
							이메일을 입력해주세요.
		                </div>
		            </div>
	            </div>

	            <div class="row">
		            <div class="col-md-12 mb-3 py-2">
		                <label for="personCellphoneNo">4. 연락가능한 전화번호를 적어주세요</label>
		                <input type="text" name="personCellphoneNo" class="form-control" id="personCellphoneNo" placeholder="" value="" required>
			            <div class="invalid-feedback">
							연락가능한 전화번호를 입력해주세요.
		                </div>
		            </div>
	            </div>
	
	            <hr class="mb-4">
	            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	            <button id="first-app-submit" class="btn btn-primary btn-lg btn-block mb-4" type="submit">교육신청</button>
	        </form>
	    </div>
	</div>
</div>
	
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="/js/bootstrap.bundle.min.js"></script>
    <script src="/js/application.js"></script>
    </body>
</html>