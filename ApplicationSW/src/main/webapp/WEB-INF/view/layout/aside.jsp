<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<aside id="sidebarMenu"	class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse">
    <ul class="nav flex-column">
        <li class="nav-item dropdown"><a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true"
            aria-expanded="false"> <strong>Course</strong></a>
            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                <a class="dropdown-item" href="<c:url value='/course/진행예정'/>">진행예정</a>
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="<c:url value='/course/진행중'/>">진행중</a>
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="<c:url value='/course/진행완료'/>">진행완료</a>
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="<c:url value='/course/진행취소'/>">진행취소</a>
            </div>
        </li>
    </ul>
</aside>
