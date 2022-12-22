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
	//生成验证码图片和验证码的
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置响应消息头  告诉浏览器 服务器给你返回的是一个jpeg格式的图片
		response.setContentType("image/jpeg");
		//画图
		//通过BufferedImage 内存映像对象 来完成图片的绘制
		BufferedImage image=new BufferedImage(60,20,BufferedImage.TYPE_INT_RGB);
		//获取画笔对象
		Graphics g=image.getGraphics();
		//设置画笔的颜色
		g.setColor(new Color(255,255,255));
		//填充背景色
		g.fillRect(0, 0, 60, 20);
		//设置前景色
		g.setColor(new Color(0,0,0));
		//生成随机数
		Random rad=new Random();
		String number=rad.nextInt(99999)+"";
		
		//将生成的验证码绑定到Session对象当中
		HttpSession session=request.getSession();
		session.setAttribute("ck",number);
		
		
		//将生成的验证码(纯数字版) 画到图片上
		g.drawString(number, 5, 15);
		//为验证码添加干扰线
		for(int i=0;i<6;i++){
			//随机设定画笔的颜色
			g.setColor(new Color(rad.nextInt(255),rad.nextInt(255),rad.nextInt(255)));
			g.drawLine(rad.nextInt(60), rad.nextInt(20), rad.nextInt(60), rad.nextInt(20));
			
		}
		//将画好的验证码压缩并输出
		//获取服务器向浏览器输出数据的输出流
		OutputStream os=response.getOutputStream();
		//将图片压缩 输出
		/*JPEGImageEncoder encoder=JPEGCodec.createJPEGEncoder(os);
		encoder.encode(image);*/
		//如果当前的jdk版本不支持JPEGImageEncoder
		ImageIO.write(image,"JPG", os);
		
	}

}







