<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<nav class="navbar navbar-expand-md navbar-light bg-white navbar-u">
            <a class="navbar-brand navbar-logo" href="${pageContext.request.contextPath }/designer/main">Pettime</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon"></span>
            </button>
          
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
              <ul class="navbar-nav ml-auto">
              <li class="nav-item dropdown">
                    <a class="nav-link" href="${pageContext.request.contextPath }/designer/main" id="navbarDropdown" role="button"  aria-haspopup="true" aria-expanded="false">
                     메인화면
                    </a>
                    
                  </li>
              <li class="nav-item dropdown">
                    <a class="nav-link" href="${pageContext.request.contextPath }/designer/schedule" id="navbarDropdown" role="button"  aria-haspopup="true" aria-expanded="false">
          	스케쥴
                    </a>
                    
                  </li>
                <li class="nav-item dropdown">
                    <a class="nav-link" href="${pageContext.request.contextPath }/designer/desProfile" id="navbarDropdown" role="button"  aria-haspopup="true" aria-expanded="false">
                      내정보
                    </a>
                    
                  </li>
                  <li class="nav-item">
                  <form action="/pettime/designer/logout" method="post">
                  <input type="hidden"
					name="${_csrf.parameterName }" value="${_csrf.token }" />
                    <button type="submit" class="btn btn-outline-danger Hbutton" id="logoutbtn">
                      logout
                     </button>  
                    </form> 
                  </li>                
              </ul>
            </div>
          </nav>