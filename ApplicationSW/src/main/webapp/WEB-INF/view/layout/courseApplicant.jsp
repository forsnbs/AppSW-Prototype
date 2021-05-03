<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h4>교육신청자</h4>
<div class="table-responsive">
    <table class="table table-sm">
        <thead>
          <tr>
            <th>신청일자</th>
            <th>이름</th>
            <th>나이</th>
            <th>이메일</th>
            <th>최종학력</th>
            <th>전공</th>
            <th>역량평가</th>
            <th>면접일정</th>
            <th>면접상태</th>
            <th>면접결과</th>
            <th>메일발송상태</th>
          </tr>
        </thead>
        <tbody>
        <c:forEach items="${personCourse}" var="personCourse">
          <tr>
            <td>${personCourse.relationStartDate}</td>
            <td class="person-name">${personCourse.getPerson().personName}</td>
            <td>${personCourse.getPerson().personAge}</td>
            <td class="person-email">${personCourse.getPerson().personEmail}</td>
            <td>${personCourse.getPerson().finalEduCategory}</td>
            <td>${personCourse.getPerson().finalEduMajorOne}</td>
            <td>${personCourse.topcitScore}</td>
            <td>${personCourse.interviewDatetime}</td>
            <td>${personCourse.interviewFlag}</td>
            <td>${personCourse.interviewPassFlag}</td>
			<td>
			  <div class="col-md-7 text-sm">
			      <select class="custom-select d-block"  id="deliveredEmailCategory" name="deliveredEmailCategory" required>
			          <option value="" <c:if test="${personCourse.deliveredEmailCategory == null}">selected="selected"</c:if>>미발송</option>
			          <option value="면접일정" <c:if test="${personCourse.deliveredEmailCategory == '면접일정'}">selected="selected"</c:if>>면접</option>
			          <option value="합격" <c:if test="${personCourse.deliveredEmailCategory == '합격'}">selected="selected"</c:if>>합격</option>
			          <option value="불합격" <c:if test="${personCourse.deliveredEmailCategory == '불합격'}">selected="selected"</c:if>>불합격</option>
			    </select>
			  </div>
			</td>
			<td id="sendButton">
			  <button name="sending-email-btn" class="btn btn-sm btn-outline-primary">발송</button>
			</td>            
          </tr>
          </c:forEach>
        </tbody>
    </table>
</div>