<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
    <h1 class="h2">${course.courseName} 교육과정</h1>
    <div class="btn-toolbar mb-2 mb-md-0">
        <button onclick="location.href='/course'" type="button" class="btn btn-sm btn-outline-info">
            Register Course
        </button>
  </div>
</div>
<div id="no" style="display: none">${course.courseNo}</div>
<div class="table-responsive">
    <table class="table table-sm">
        <thead>
          <tr>
            <th>교육과정명</th>
            <th>사업구분</th>
            <th>정원</th>
            <th>교육시작일</th>
            <th>교육종료일</th>
            <th>센터위치</th>
            <th>강의실</th>
            <th>진행상태</th>
            <th>합격정원</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td><a href="<c:url value='/course/detail/${course.courseNo}'/>">${course.courseName}</a></td>
            <td>${course.courseCategory}</td>
            <td>${course.courseCapacity}</td>
            <td>${course.courseStartDate}</td>
            <td>${course.courseEndDate}</td>
            <td>${course.courseLocation}</td>
            <td>${course.courseClassroom}</td>
            <td>${course.courseProgress}</td>
            <td>${course.courseInterviewPassNo}</td>
          </tr>
        </tbody>
    </table>
</div>
