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
	        <form id="register-course-form" method="post" enctype="multipart/form-data" class="needs-validation" novalidate>
	            <div class="row">
		            <div class="col-md-12 mb-3 py-2">
		                <label for="courseName">과정명</label>
		                <input type="text" name="courseName" class="form-control" id="courseName" placeholder="" value="${course.courseName}" required>
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
	                    <option value="국가기간" <c:if test="${course.courseCategory == '국가기간'}">selected="selected"</c:if>>국가기간</option>
	                    <option value="혁신성장" <c:if test="${course.courseCategory == '혁신성장'}">selected="selected"</c:if>>혁신성장</option>
	                    <option value="K디지털" <c:if test="${course.courseCategory == 'K디지털'}">selected="selected"</c:if>>K디지털</option>
	                    <option value="싹SSAC" <c:if test="${course.courseCategory == '싹SSAC'}">selected="selected"</c:if>>싹SSAC</option>
	                    </select>
	                    <div class="invalid-feedback">
	                                사업구분을 선택해주세요.
	                    </div>
	                </div>
	                <div class="col-md-6 mb-3">
	                <label for="courseProgress">진행상태</label>
	                <select class="custom-select d-block w-100" name="courseProgress" id="courseProgress" required>
	                    <option value="">상태</option>
	                    <option value="진행예정" <c:if test="${course.courseProgress == '진행예정'}">selected="selected"</c:if>>진행예정</option>
	                    <option value="진행중" <c:if test="${course.courseProgress == '진행중'}">selected="selected"</c:if>>진행중</option>
	                    <option value="진행완료" <c:if test="${course.courseProgress == '진행완료'}">selected="selected"</c:if>>진행완료</option>
	                    <option value="진행취소" <c:if test="${course.courseProgress == '진행취소'}">selected="selected"</c:if>>진행취소</option>
	                </select>
	                <div class="invalid-feedback">
	                        진행상태를 선택해주세요.
	                </div>
	                </div>
	            </div>
	
	            <div class="mb-3">
	            <label for="courseCapacity">교육정원 <span class="text-muted"> (두자리숫자만 입력)</span></label>
	            <div class="input-group">
	                <input type="text" class="form-control" name="courseCapacity" id="courseCapacity" value="${course.courseCapacity}" placeholder="교육정원" maxlength="2" onkeypress="return isNumber(event)" required>
	                <div class="invalid-feedback" style="width: 100%;">
	                        교육정원을 입력해주세요.
	                </div>
	            </div>
	            </div>
	
	            <div class="row">
	                <div class="col-md-6 mb-3">
	                    <label for="courseStartDate">교육시작일자</label>
	                    <input type="date" name="courseStartDate" class="form-control" id="courseStartDate" value="${course.courseStartDate}" required>
	                    <div class="invalid-feedback">
	                                교육시작 일자를 입력해주세요.
	                    </div>
	                </div>
	                <div class="col-md-6 mb-3">
	                    <label for="courseEndDate">교육종료일자</label>
	                    <input type="date" name="courseEndDate" class="form-control" id="courseEndDate" value="${course.courseEndDate}" onchange="return checkEndDate()" required>
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
	                        <option value="남부" <c:if test="${course.courseLocation == '남부'}">selected="selected"</c:if>>남부</option>
	                        <option value="서초" <c:if test="${course.courseLocation == '서초'}">selected="selected"</c:if>>서초</option>
	                        <option value="영등포" <c:if test="${course.courseLocation == '영등포'}">selected="selected"</c:if>>영등포</option>
	                    </select>
	                    <div class="invalid-feedback">
	                            교육장소를 선택해주세요.
	                    </div>
	                </div>
	
	                <div class="col-md-6 mb-3">
	                    <label for="courseClassroom">강의실</label>
	                    <select class="custom-select d-block w-100" name="courseClassroom" id="courseClassroom" required>
	                        <option value="">강의실 선택</option>
	                        <option value="CLASSROOM1"  <c:if test="${course.courseClassroom == 'CLASSROOM1'}">selected="selected"</c:if>>1강의실</option>
	                        <option value="CLASSROOM2" <c:if test="${course.courseClassroom == 'CLASSROOM2'}">selected="selected"</c:if>>2강의실</option>
	                        <option value="CLASSROOM3" <c:if test="${course.courseClassroom == 'CLASSROOM3'}">selected="selected"</c:if>>3강의실</option>
	                        <option value="CLASSROOM4" <c:if test="${course.courseClassroom == 'CLASSROOM4'}">selected="selected"</c:if>>4강의실</option>
	                        <option value="CLASSROOM5" <c:if test="${course.courseClassroom == 'CLASSROOM5'}">selected="selected"</c:if>>5강의실</option>
	                    </select>
	                    <div class="invalid-feedback">
	                        강의실을 선택해주세요.
	                    </div>
	                </div>
	            </div>
	
				 <div class="mb-3">
		          <label for="file">교육과정 커리큘럼 파일</label>
			     	<c:forEach items="${course.getAttachedFiles()}" var="attachedFiles">
		          		<a class="form-control" href="<c:url value="/api/download/file/${attachedFiles.fileNo}"/>">${attachedFiles.getOriginalFilename()}</a>
					</c:forEach>
				  	<span class="text-muted"> (파일명 클릭시 다운로드)</span>
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