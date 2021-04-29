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
    <title>Management Main</title>


    <!-- Bootstrap core CSS -->
    <link href="/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="/css/main.css" rel="stylesheet">
</head>
<body>

    <header>
        <div class="row flex-nowrap justify-content-center align-items-center">
          <div class="col-4 text-center">
            <a onclick="location.href='/main'"><img class="mt-3 mb-4" src="img/playdata_signature.png" alt="" width="40%" height="auto"></a>
          </div>
        </div>
    </header>

    <div class="navbar navbar-dark bg-dark flex-md-nowrap p-0 shadow">
      <a class="navbar-brand col-md-3 col-lg-2 mr-0 px-3" href="#">playdata</a>
      <button class="navbar-toggler position-absolute d-md-none collapsed" type="button" data-toggle="collapse" data-target="#sidebarMenu" aria-controls="sidebarMenu" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <input class="form-control form-control-dark w-100" type="text" placeholder="Search" aria-label="Search">
      <ul class="navbar-nav px-3">
        <li class="nav-item text-nowrap">
          <a class="nav-link" href="#">Sign out</a>
        </li>
      </ul>
    </div>

    <div class="container-fluid">
        <div class="row main-board">
          <aside id="sidebarMenu" class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse">
            <nav>
                <div>
                    <ul class="nav flex-column">
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <strong>Course</strong>
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="<c:url value='/main/진행예정'/>">진행예정</a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="<c:url value='/main/진행중'/>">진행중</a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="<c:url value='/main/진행완료'/>">진행완료</a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="<c:url value='/main/진행취소'/>">진행취소</a>
                            </div>
                        </li>
                    </ul>
                </div>
            </nav>
          </aside>  
          <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4">
              <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                  <h1 class="h2">모집 진행중 교육과정</h1>
                  <div class="btn-toolbar mb-2 mb-md-0">
                      <button onclick="location.href='/course'" type="button" class="btn btn-sm btn-outline-info">
	                      Register Course
                      </button>
                </div>
              </div>
              <div class="table-responsive">
                  <table class="table table-sm">
                      <thead>
                        <tr>
                          <th>#</th>
                          <th>Header</th>
                          <th>Header</th>
                          <th>Header</th>
                          <th>Header</th>
                        </tr>
                      </thead>
                      <tbody>
                        <tr>
                          <td>1</td>
                          <td>random</td>
                          <td>data</td>
                          <td>placeholder</td>
                          <td>text</td>
                        </tr>
                      </tbody>
                  </table>
              </div>
          </main>
	      <footer class="main-footer">
	        <div class="row justify-content-center">
	          <div class="col-md-6">
	            <div class="footer-title mb-3">
	              <h6><strong>데이터 전문기업 엔코아 교육센터 플레이데이터</strong></h6>
	            </div>
	            <ul class="text-small">
	              <li><strong>대표이사</strong> 이화식</li>
	              <li><strong>개인정보책임관리자</strong> 최원재</li>
	              <li><strong>서초교육센터</strong> 서울시 서초구 서초대로46길 42, 엔코아 타워</li>
	              <li><strong>남부교육센터</strong> 서울시 서초구 효령로 335, 1층 플레이데이터</li>
	              <li><strong>사업자등록번호</strong> 229-81-30104</li>
	              <li><strong>통신판매업신고번호</strong> 2017-서울서초-1653</li>
	            </ul>
	          </div>
	        </div>
	      </footer>
        </div>
    </div>



    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="/js/bootstrap.bundle.min.js"></script>
    </body>
</html>