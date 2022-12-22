<%@ page language="java" contentType="text/html; charset=utf-8" import="java.util.*,com.qf.entity.*,java.text.*"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>emplist</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<style type="text/css">
			#apid{
				text-align:center;
			}
		</style>
		<link rel="stylesheet" type="text/css" href="css/style.css" />
	</head>
	<body>
		<div id="wrap">
			<div id="top_content"> 
				
				
				<form action="list.do" method="post">
					<input name="age" ><input type="submit" value="搜索">
				</form>
				
				<%@ include file="head.jsp" %>
				
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						欢迎!
					</h1>
					<table class="table">
						<tr class="table_header">
							<td>
								ID
							</td>
							<td>
								姓名
							</td>
							<td>
								薪资
							</td>
							<td>
								年龄
							</td>
							<td>
								操作
							</td>
						</tr>
						
						<%            
							//java代码
							//到request中取出 绑定的数据
							List<Emp>emps=(List<Emp>)request.getAttribute("emps");
							//循环迭代 数据并显示
							for(Emp emp:emps){
						%>
						
						
						<tr class="row1">
							<td>
								<%=emp.getId() %>
							</td>
							<td>
								<%=emp.getRealname() %>
							</td>
							<td>
								<%=emp.getSalary() %>
							</td>
							<td>
								<%=emp.getAge() %>
							</td>
							<td>
								<a href="del.do?id=<%=emp.getId() %>">删除</a>&nbsp;<a href="toUpdate.do?id=<%=emp.getId() %>">修改</a>
							</td>
						</tr>
					
					<%}
							%>
					
					
					</table>
					<%
						EmpPage p=(EmpPage)request.getAttribute("page");
						int cur=p.getCurrentPage();
						int totalPage=p.getTotalPage();
					%>
					
					<p id="apid">
						<%
							if(cur!=1){
						%>
							<a href="list.do?current=<%=cur-1%>">上一页</a>
						
						<%
							}						
						%>
						
						<%
							for(int i=1;i<=totalPage;i++){
						
						%>
						
						
						
						<a href="list.do?current=<%=i%>"><%=i %></a>
						
						
						
						<%
							}
						%>
						
						
						
						<%
							if(cur!=totalPage){
						%>
							<a href="list.do?current=<%=cur+1%>">下一页</a>
						
						<%
							}						
						%>
					
					
						
					</p>
					<p>
						<input type="button" class="button" value="添加" onclick="location='addEmp.jsp'"/>
					</p>
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
    