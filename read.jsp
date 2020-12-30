<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>detail</title>
<script type="text/javascript" src="/resources/js/jquery-3.5.1.js"></script>
<script type="text/javascript" src="/resources/js/reply.js"></script>
<script type="text/javascript" src="/resources/js/detail.js"></script>
</head>
<body>
<h1>게시판 상세리스트입니다.</h1>
<h3>환영합니다. <%=session.getAttribute("loginId")%>님</h3><br><br>

<div class=""></div> 
<form name="frm1" action="/board/update" method="post">
<table border="1">
	<tr>
		<td>No</td>
		<td><input type="hidden" id="bno" name="bno" value="${detail2.bno}">
		${detail2.bno}</td>
	</tr>
	<tr>
		<td>Writer</td>
		<td><input type="hidden" name="writer" value="${detail2.writer}">
		${detail2.writer}</td>
	</tr>	
	<tr>
		<td>Title</td>
		<td>${detail2.title}</td>
	</tr>	
	<tr>
		<td>Content   ${showImg.fileName}</td>
		<td colspan="3">${detail2.content}<br>
		<div class="readult">
		<ul>
		</ul>
		</div></td>
	</tr>
<!--  
<input type="submit" value="Update" onclick="javascript:form.action='/board/update'" />
<input type="submit" value="Delete" onclick="javascript:form.action='/board/delete'" />
-->
	<tr>
		<td colspan="2">
		<input type="submit" value="UPDATE" onclick="btn_click('update')"/>
		<input type="submit" value="DELETE "onclick="btn_click('delete')"/>
		</td>
	</tr>

</table>
</form>
<br><br>
<!--  <div id="htmltest">-->
<div>
<h3>댓글 리스트</h3>
<ul id="replies">
 
<!--<li reno=reno id=replies>
	<input type="hidden" id="replyText" value="replyText">replyText
	<div id="upt">
	</div>
	
	<div>
	<textarea id="replyText" name="replyText" rows="10" cols="50">
	comment</textarea>
	<br>
	<input type="text" id="reupDate" name="reupDate" rows="10" cols="10">
	<button id='commentUpt>댓글수정</button></div>
	<li>190번 댓글입니다.</li>-->
</ul> 
</div>
<br><br>
<!-- 댓글:jquery 생성 및 textarea 추가 -->
<div><textarea id="replyText" name="replyText" rows="10" cols="50"></textarea></div>
<div><input type="text" id="replyPpl" name="replyPpl"><br></div>
<div><button id="replyAddBtn">REPLY</button></div>
</body>
</html>
