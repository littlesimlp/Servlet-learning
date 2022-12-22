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
		//step1 ����һ���������͵�ʵ�� ��ʵ����������Ϊ�������ṩ��Ĭ�ϵ�����
		DiskFileItemFactory facotry=new DiskFileItemFactory();
		//step2 ����һ��������
		ServletFileUpload sfu=new ServletFileUpload(facotry);
		String fileName="";
		//step3ʹ�ý����� ��������
		try {
			//����֮�󣬻Ὣ���е�����ת����һ����FileItem����һ�������е����ݶ�Ӧ��һ��FileItem����
			List<FileItem>items=sfu.parseRequest(request);
			//step4 ����items����
			for(int i=0;i<items.size();i++){
				//��ȡ�����е�����ʱ��Ҫ�����ֱ��������
				FileItem item=items.get(i);
				if(item.isFormField()){
					//���ʱ��ͨ���� �Ȳ����κδ���
				}else{
					//���������ͨ����  �Ǿ����ļ��ϴ�����
					ServletContext sctx=this.getServletContext();
					//ͨ��ServletContext�����getRealPath���������ļ���ʵ��·��
					String path=sctx.getRealPath("upload");
					//��ȡ�ļ���
					fileName=item.getName();
					File file=new File(path+"\\"+fileName);
					item.write(file);	
				}
			}
			//��תҳ�� ���ϴ����ͼƬ ��ʾ���������
			HttpSession session=request.getSession();
			session.setAttribute("name", fileName);
			response.sendRedirect("main.jsp");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}



