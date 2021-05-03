<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
    <title>Management Main</title>

    <!-- Bootstrap core CSS -->
    <link href="/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="/css/main.css" rel="stylesheet">
</head>
<body>
<div class="container">
	<div class="py-5 text-center">
		<h2>Course Registration</h2>
	</div>
	<div class="row justify-content-center">
	    <div class="col-md-6 order-md-1">
	        <form id="register-course-form" action="<c:url value='/course'/>" method="post" enctype="multipart/form-data" class="needs-validation" novalidate>
	            <div class="row">
		            <div class="col-md-12 mb-3">
		                <label for="courseName">교육과정명</label>
		                <input type="text" name="courseName" class="form-control" id="courseName" placeholder="" value="" required>
			            <div class="invalid-feedback">
							과정명을 입력해주세요.
		                </div>
		            </div>
	            </div>
	     
	            <div class="row">
		            <div class="col-md-12 mb-3">
		                <label for="courseUrl">교육과정 홈페이지 주소</label>
		                <input type="text" name="courseUrl" class="form-control" id="courseUrl" placeholder="" value="" required>
			            <div class="invalid-feedback">
							과정명을 입력해주세요.
		                </div>
		            </div>
	            </div>
	
	            <div class="row">          
	                <div class="col-md-6 mb-3">
	                    <label for="courseCategory">사업구분</label>
	                    <select class="custom-select d-block w-100" name="courseCategory" id="courseCategory" required>
	                    <option value="">사업구분</option>
	                    <option value="국가기간">국가기간</option>
	                    <option value="혁신성장">혁신성장</option>
	                    <option value="K디지털">K디지털</option>
	                    <option value="싹SSAC">싹SSAC</option>
	                    </select>
	                    <div class="invalid-feedback">
	                                사업구분을 선택해주세요.
	                    </div>
	                </div>
	                <div class="col-md-6 mb-3">
	                <label for="courseProgress">진행상태</label>
	                <select class="custom-select d-block w-100" name="courseProgress" id="courseProgress" required>
	                    <option value="">상태</option>
	                    <option value="진행예정">진행예정</option>
	                    <option value="진행중">진행중</option>
	                    <option value="진행완료">진행완료</option>
	                    <option value="진행취소">진행취소</option>
	                </select>
	                <div class="invalid-feedback">
	                        진행상태를 선택해주세요.
	                </div>
	                </div>
	            </div>
	
	            <div class="mb-3">
	            <label for="courseCapacity">교육정원 <span class="text-muted"> (두자리숫자만 입력)</span></label>
	            <div class="input-group">
	                <input type="text" class="form-control" name="courseCapacity" id="courseCapacity" value="" placeholder="교육정원" maxlength="2" onkeypress="return isNumber(event)" required>
	                <div class="invalid-feedback" style="width: 100%;">
	                        교육정원을 입력해주세요.
	                </div>
	            </div>
	            </div>
	
	            <div class="row">
	                <div class="col-md-6 mb-3">
	                    <label for="courseStartDate">교육시작일자</label>
	                    <input type="date" name="courseStartDate" class="form-control" id="courseStartDate" value="" required>
	                    <div class="invalid-feedback">
	                                교육시작 일자를 입력해주세요.
	                    </div>
	                </div>
	                <div class="col-md-6 mb-3">
	                    <label for="courseEndDate">교육종료일자</label>
	                    <input type="date" name="courseEndDate" class="form-control" id="courseEndDate" value="" onchange="return checkEndDate()" required>
	                    <div class="invalid-feedback">
	                                    교육종료 일자를 입력해주세요.
	                    </div>
	                </div>
	            </div>
	
	            <div class="row">
	                <div class="col-md-6 mb-3">
	                    <label for="courseLocation">교육장소</label>
	                    <select class="custom-select d-block w-100" name="courseLocation" id="courseLocation" required>
	                        <option value="" >교육장소 선택</option>
	                        <option value="남부">남부</option>
	                        <option value="서초">서초</option>
	                        <option value="영등포">영등포</option>
	                    </select>
	                    <div class="invalid-feedback">
	                            교육장소를 선택해주세요.
	                    </div>
	                </div>
	
	                <div class="col-md-6 mb-3">
	                    <label for="courseClassroom">강의실</label>
	                    <select class="custom-select d-block w-100" name="courseClassroom" id="courseClassroom" required>
	                        <option value="">강의실 선택</option>
	                        <option value="CLASSROOM1">1강의실</option>
	                        <option value="CLASSROOM2">2강의실</option>
	                        <option value="CLASSROOM3">3강의실</option>
	                        <option value="CLASSROOM4">4강의실</option>
	                        <option value="CLASSROOM5">5강의실</option>
	                    </select>
	                    <div class="invalid-feedback">
	                        강의실을 선택해주세요.
	                    </div>
	                </div>
	            </div>
	
	            <label for="">교육과정 커리큘럼 파일등록</label>
	            <div class="custom-file">
	                <input type="file" name="attachedFile" class="custom-file-input" id="attachedFile" onchange="fileAttachment()" accept=".hwp, .doc, .docx, .txt" required>
	                <label id="file-label" class="custom-file-label" for="attachedFile">파일 선택</label>
	                <span class="text-muted"> (최대용량 5MB, 첨부가능 파일 확장자 : .hwp, .doc, .docx)</span>
	            </div>
	            <hr class="mb-4">
	            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	            <button id="register-course-btn" class="btn btn-primary btn-lg btn-block mb-4" type="submit">과정등록</button>
	        </form>
	    </div>
	</div>
</div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="/js/bootstrap.bundle.min.js"></script>
    <script src="/js/courseRegister.js"></script>
    </body>
</html>