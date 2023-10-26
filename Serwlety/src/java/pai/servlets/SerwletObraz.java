/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package pai.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author magdarosa
 */
@WebServlet(name="SerwletObraz", urlPatterns={"/SerwletObraz"})
public class SerwletObraz extends HttpServlet
{
 @Override
 protected void doGet(HttpServletRequest req, HttpServletResponse resp)
 throws ServletException, IOException
 {
 req.setCharacterEncoding("UTF-8");
 resp.setContentType("image/jpeg");
 int szer = 300;
 int wys = 60;
 BufferedImage image = new BufferedImage(szer, wys,
BufferedImage.TYPE_INT_RGB);
 Graphics2D g = (Graphics2D)image.getGraphics();
 g.setColor(Color.BLUE);
 g.fillRect(0,0,szer,wys);
 g.setColor(Color.RED);
 g.setFont(new Font("Dialog", Font.BOLD, 16));
 
 String name = req.getParameter("imie");
 g.drawString("Witaj "+ name + " !", 30, wys/2 + 4);
 g.setColor(Color.BLACK);
 g.drawRect(0,0,szer-1,wys-1);
 g.dispose();
 ServletOutputStream sos = resp.getOutputStream();
// JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(sos);
// encoder.encode(image);
ImageIO.write(image, "JPEG", sos);
 }

}
