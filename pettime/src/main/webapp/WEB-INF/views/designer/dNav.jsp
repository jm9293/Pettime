<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
  
  
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="${pageContext.request.contextPath }/designer/main">Pet-time Designer</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo02" aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
    <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
      <li class="nav-item">
        <a class="nav-link" href="${pageContext.request.contextPath }/designer/main">메인화면</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="${pageContext.request.contextPath }/designer/schedule">스케줄</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">공지사항</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">My</a>
      </li>
      <li>
	    <form method="post" class="form-inline my-2 my-lg-0" action="/pettime/designer/logout">
	    
	      <button class="btn btn-outline-danger Hbutton" type="submit">Logout</button>
	      <input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }" />
	    </form>
    	</li>
    </ul>
  </div>
</nav>  
