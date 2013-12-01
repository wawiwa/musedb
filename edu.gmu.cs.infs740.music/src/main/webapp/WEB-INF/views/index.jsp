<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
   <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
   <title>Insert title here</title>
   <script src="<%=request.getContextPath()%>/resources/jquery/jquery.js" type="text/javascript"></script>
   <script type="text/javascript">
      function doGet()
      {
    	  var resUrl = "<%=request.getContextPath()%>/items/" + $("#param_inp").val();
	      $.get(resUrl, showXML);
      }
      
      function doSearch()
      {
    	  var resUrl = "<%=request.getContextPath()%>/items/Find";
	      $.post(resUrl, $("#data_frm").serialize(), showXML);
      }
      
      function doGetJson()
      {
    	  var resUrl = "<%=request.getContextPath()%>/json/"  + $("#param_inp").val();
	      $.getJSON(resUrl, showJSON);
      }
      
      function doGetJson()
      {
    	  var resUrl = "<%=request.getContextPath()%>/items/json/"  + $("#param_inp").val();
	      $.getJSON(resUrl, showJSON);
      }
      
      function doSearchJson()
      {
    	  var resUrl = "<%=request.getContextPath()%>/items/json/Find";
	      $.post(resUrl, $("#data_frm").serialize(), showJSONList);
      }
      
      function findByTitle()
      {
    	  var resUrl = "<%=request.getContextPath()%>/composition/title";
    	  //alert("hello: "+resUrl);
	      $.post(resUrl, $("#data_frm").serialize(), showCompositionList);
      }
      
      function showXML(xmlData) 
      {
		  var xml = (new XMLSerializer()).serializeToString(xmlData);
		  $("#result_txt").html("");
		  $("#result_txt").append(document.createTextNode(xml));
      }
	  
      function showJSON(jsonData) 
      {
          var json = "<p><b><em>FRUIT</em></b></p>";
          json += "<b>Name: </b>";
          json += jsonData.name;
          json += "<br/>";
          json += "<b>Quantity: </b>";
          json += jsonData.quantity;
		  $("#result_txt").html(json);
      }
	  
      function showJSONList(jsonList) 
      {
          var htmlList = "<table style='border-width:2px;border-style:solid;border-spacing:0;' width='300px'><caption><strong>List of returned items</strong></caption>";
          htmlList += "<thead><tr>";
          htmlList += "<th style='border:1px solid;'>Name</th>";
          htmlList += "<th style='border:1px solid;'>Quantity</th>";
          htmlList += "</tr></thead>";
          htmlList += "<tbody>";
          for (var i = 0; i < jsonList.fruitList.length; i++) {
              htmlList += "<tr>";
              htmlList += "<td style='border:1px solid;'>" + jsonList.fruitList[i].name + "</td>";
              htmlList += "<td style='border:1px solid;'>" + jsonList.fruitList[i].quantity + "</td>";
              htmlList += "</tr>";
          }
          htmlList += "</tbody>";
          htmlList += "</table>";
		  $("#result_txt").html(htmlList);
      }
	  
      function showCompositionList(searchResult) 
      {
    	  //alert("CL called");
    	  if($.isEmptyObject(searchResult)) {
    		  //alert("in if st");
    		  $("#result_txt").html("<h3> No results matched your query. </h3>");
    		  return;
    	  }
    	  //alert("CL length: "+searchResult.length);
          var htmlList = "<table style='border-width:2px;border-style:solid;border-spacing:0;' width='600px'><caption><strong>List of Compositions</strong></caption>";
          htmlList += "<thead><tr>";
          htmlList += "<th style='border:1px solid;'>Main Title</th>";
          htmlList += "<th style='border:1px solid;'>Work Title</th>";
          htmlList += "<th style='border:1px solid;'>Publisher</th>";
          htmlList += "</tr></thead>";
          htmlList += "<tbody>";
          for (var i = 0; i < searchResult.length; i++) {
              htmlList += "<tr>";
              htmlList += "<td style='border:1px solid;'>" + searchResult[i].mainTitle + "</td>";
              htmlList += "<td style='border:1px solid;'>" + searchResult[i].workTitle + "</td>";
              htmlList += "<td style='border:1px solid;'>" + searchResult[i].publisher + "</td>";
              htmlList += "</tr>";
          }
          htmlList += "</tbody>";
          htmlList += "</table>";
		  $("#result_txt").html(htmlList);
      }
	  
      $(function() 
      {
        $("#doGet_btn").click(doGet);
        $("#doSearch_btn").click(doSearch);
        $("#doGetJson_btn").click(doGetJson);
        $("#doSearchJson_btn").click(doSearchJson);
        $("#searchCompositions_btn").click(findByTitle);
      });
   </script>
</head>
<body>
   <h1>Hey Dudes!</h1>
   <h2>A global community of friends and strangers spitting out their
   inner-most and personal thoughts on the web for everyone else to see.</h2>

	<p>  The time on the server is ${serverTime}. </p>
	
	<p><a href="<s:url value="/login/signin"/>">Sign in</a></p>

   <b>Click here to look at what these people are spitting right now...</b>

    <form id="data_frm" method="post" action="">
      <p>
        <label>Name:<input id="param_inp" type="text" name="param" /></label>
      </p>
      <p>
        <input id="doGet_btn" type="button" value="Get Item" /><br/>
        <input id="doSearch_btn" type="button" value="Find Items" /><br/>
        <input id="doGetJson_btn" type="button" value="Get JSON Item" /><br/>
        <input id="doSearchJson_btn" type="button" value="Find JSON Items" /><br/>
      </p>
      <p>
        <label>Title:<input id="composer_inp" type="text" name="title" /></label>
        <input id="searchCompositions_btn" type="button" value="Search Compositions" /><br/>
      </p>
    </form>
   <hr/>
   <h3>Result:</h3>
   <div id="result_txt"></div>
</body>
</html>