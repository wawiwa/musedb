<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Login</title>
<link href="<%=request.getContextPath()%>/resources/jQueryAssets/jquery.ui.core.min.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/resources/jQueryAssets/jquery.ui.theme.min.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" media="screen" href="<%=request.getContextPath()%>/resources/jQueryAssets/jqsimplemenu.css"/>
<link href="<%=request.getContextPath()%>/resources/jquery.ui.button.min.css" rel="stylesheet" type="text/css" />
<script src="<%=request.getContextPath()%>/resources/jQueryAssets/jquery-1.8.3.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/resources/jQueryAssets/jqsimplemenu.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/resources/jquery-ui-1.9.2.button.custom.min.js" type="text/javascript"></script>
<script type="text/javascript">
      $(function() {
           $('.jq-menu').jqsimplemenu(); 
       });
    </script>
<meta name="Welcome to our Music Database World" content="" />
<meta name="description" content="Welcome to Our Music Database World" />
</head>

<body bgcolor="#006600">
<s:url var="authUrl" value="/login/j_spring_security_check"/>
<form id="form1" name="form1" method="post" action="${authUrl}">
  <p><img src="/resources/img/gmu1.jpg" width="629" height="355"  alt=""/></p>
  <h1>User Login Page!</h1>
  <div class="contentcontainer" style="margin-top:100px; width:950px">
    <div>
     <ul class="jq-menu">
       <li><a href="<s:url value="/login/signin"/>"><font color="#FF9900">Show User Login </font></a></li>
           <li><a href="registration.jsp"><font color="#FF9900">Registration</font></a></li>
           <li><a href="musicsearch.jsp"><font color="#FF9900">Music Search</font></a></li>
      </ul>
    </div>
        
    <br></br>
  
    <div class="header-body"></div>
    
  </div>

  <p style="text-align:left">&nbsp;</p>
  <p style="text-align:left">Username:
    <input type="text" name="Username2" id="Username2" />
  </p>
  <p>Password:
    <input type="text" name="Username3" id="Username3" />
  </p>
  <p><a href="E:\INFS 740\Group Project\musicui\findpassword.html">Forget passwords?</a></p>
  <p>&nbsp;</p>
  <p>
    <input type="submit" id="Button2">Login</input>
    <button id="Button3">Cancel</button>
  </p>

</form>
<script type="text/javascript">
$(function() {
	$( "#Button2" ).button(); 
});
$(function() {
	$( "#Button3" ).button(); 
});
</script>
</body>
</html>
