package com.dlnu.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

public class CheckCodeServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("image/jpeg");
        BufferedImage image = new BufferedImage(60,20,BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();

        g.setColor(new Color(255,255,255));
        g.fillRect(0,0,60,20);
        g.setColor(new Color(0,0,0));

        Random random = new Random();
        String number = random.nextInt(99999)+"";

        HttpSession session = req.getSession();
        session.setAttribute("ck",number);

        g.drawString(number,5,15);

        for (int i = 0; i < 6; i++) {
            g.setColor(new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255)));
            g.drawLine(random.nextInt(60), random.nextInt(20),random.nextInt(60),random.nextInt(20));
        }

        OutputStream outputStream = resp.getOutputStream();
        ImageIO.write(image,"jpeg",outputStream);
    }
}
