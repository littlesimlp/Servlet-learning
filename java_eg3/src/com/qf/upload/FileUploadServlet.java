package com.qf.upload;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


public class FileUploadServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//step1 创建一个工厂类型的实例 该实例的作用是为解析器提供了默认的配置
		DiskFileItemFactory facotry=new DiskFileItemFactory();
		//step2 创建一个解析器
		ServletFileUpload sfu=new ServletFileUpload(facotry);
		String fileName="";
		//step3使用解析器 解析数据
		try {
			//解析之后，会将表单中的数据转换成一个个FileItem对象。一个表单域中的数据对应于一个FileItem对象
			List<FileItem>items=sfu.parseRequest(request);
			//step4 遍历items集合
			for(int i=0;i<items.size();i++){
				//读取表单域中的数据时，要先区分表单域的类型
				FileItem item=items.get(i);
				if(item.isFormField()){
					//如果时普通表单域 先不做任何处理
				}else{
					//如果不是普通表单域  那就是文件上传表单域
					ServletContext sctx=this.getServletContext();
					//通过ServletContext对象的getRealPath方法来或文件的实际路径
					String path=sctx.getRealPath("upload");
					//获取文件名
					fileName=item.getName();
					File file=new File(path+"\\"+fileName);
					item.write(file);	
				}
			}
			//跳转页面 将上传后的图片 显示在浏览器上
			HttpSession session=request.getSession();
			session.setAttribute("name", fileName);
			response.sendRedirect("main.jsp");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}



