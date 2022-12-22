<%@ page language="java" contentType="text/html; charset=utf-8" import="java.util.*,com.qf.entity.*,java.text.*"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>login</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css"
			href="css/style.css" />
	</head>

	<body>
		<div id="wrap">
			<div id="top_content">
					<%@ include file="head.jsp" %>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						登录
					</h1>
					<form action="login.do" method="post">
						<table cellpadding="0" cellspacing="0" border="0"
							class="form_table">
							<tr>
								<td valign="middle" align="right">
									用户名:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="uname" value="<%=request.getAttribute("uname")==null?"":request.getAttribute("uname") %>" />
									
									<span style="color:red">
										<%=request.getAttribute("umsg")==null?"":request.getAttribute("umsg") %>
									</span>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									密码:
								</td>
								<td valign="middle" align="left">
									<input type="password" class="inputgri" name="pwd" />
									<span style="color:red">
										<%=request.getAttribute("pmsg")==null?"":request.getAttribute("pmsg") %>
									</span>
								</td>
							</tr>
								<tr>
								<td valign="middle" align="right">
									验证码:
									<img id="num" src="checkCode.do" />
									<a href="javascript:;" onclick="document.getElementById('num').src = 'checkCode.do?'+(new Date()).getTime()">换一张</a>
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="number" />
									<span style="color:red">
										<%=request.getAttribute("ckmsg")==null?"":request.getAttribute("ckmsg") %>
									</span>
								</td>
							</tr>
						</table>
						<p>
							<input type="submit" class="button" value="登录" />
						</p>
					</form>
				</div>
			</div>
			<div id="footer">
				<div id="footer_bg">
					ABC@126.com
				</div>
			</div>
		</div>
	</body>
</html>
    