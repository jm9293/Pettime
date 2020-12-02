<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<nav class="navbar navbar-expand-md navbar-light bg-white navbar-u">
            <a class="navbar-brand navbar-logo" href="${pageContext.request.contextPath }/admin/adminMain">Pettime</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon"></span>
            </button>
          
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
              <ul class="navbar-nav ml-auto">
                <li class="nav-item dropdown">
                    <a class="nav-link" href="${pageContext.request.contextPath }/admin/adRes" id="navbarDropdown" role="button"  aria-haspopup="true" aria-expanded="false">
                      예약현황
                    </a>
                    
                  </li>
                  <li class="nav-item dropdown">
                    <a class="nav-link" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                      정보관리
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="${pageContext.request.contextPath }/admin/adInfo/adUserlist">회원정보</a>
                        <a class="dropdown-item" href="${pageContext.request.contextPath }/admin/adInfo/adDeslist">미용사정보</a>
                    </div>
                  </li>
                  <li class="nav-item dropdown">
                    <a class="nav-link" href="${pageContext.request.contextPath }/admin/adProduct/adProlist" id="navbarDropdown" role="button" aria-haspopup="true" aria-expanded="false">
                      상품관리
                    </a>     
                  </li>

                  <li class="nav-item dropdown">
                    <a class="nav-link" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                      고객센터
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="">공지사항</a>                        
                        <a class="dropdown-item" href="">고객 상담 게시판</a>
                    </div>
                  </li>                 
              </ul>
            </div>
          </nav>