package com.qf.servlet;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class CheckcodeServlet extends HttpServlet {
	//������֤��ͼƬ����֤���
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//������Ӧ��Ϣͷ  ��������� ���������㷵�ص���һ��jpeg��ʽ��ͼƬ
		response.setContentType("image/jpeg");
		//��ͼ
		//ͨ��BufferedImage �ڴ�ӳ����� �����ͼƬ�Ļ���
		BufferedImage image=new BufferedImage(60,20,BufferedImage.TYPE_INT_RGB);
		//��ȡ���ʶ���
		Graphics g=image.getGraphics();
		//���û��ʵ���ɫ
		g.setColor(new Color(255,255,255));
		//��䱳��ɫ
		g.fillRect(0, 0, 60, 20);
		//����ǰ��ɫ
		g.setColor(new Color(0,0,0));
		//���������
		Random rad=new Random();
		String number=rad.nextInt(99999)+"";
		
		//�����ɵ���֤��󶨵�Session������
		HttpSession session=request.getSession();
		session.setAttribute("ck",number);
		
		
		//�����ɵ���֤��(�����ְ�) ����ͼƬ��
		g.drawString(number, 5, 15);
		//Ϊ��֤����Ӹ�����
		for(int i=0;i<6;i++){
			//����趨���ʵ���ɫ
			g.setColor(new Color(rad.nextInt(255),rad.nextInt(255),rad.nextInt(255)));
			g.drawLine(rad.nextInt(60), rad.nextInt(20), rad.nextInt(60), rad.nextInt(20));
			
		}
		//�����õ���֤��ѹ�������
		//��ȡ�������������������ݵ������
		OutputStream os=response.getOutputStream();
		//��ͼƬѹ�� ���
		/*JPEGImageEncoder encoder=JPEGCodec.createJPEGEncoder(os);
		encoder.encode(image);*/
		//�����ǰ��jdk�汾��֧��JPEGImageEncoder
		ImageIO.write(image,"JPG", os);
		
	}

}







