package day0716;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class PopupClose extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out =response.getWriter();
		//1. 현재 일자를 값으로 가진 쿠키를 생성하여
		String today="";
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
		today=sdf.format(new Date());
		
		Cookie cookie=new Cookie("popupFlag",today);
		
		//생존 시간 설정
		cookie.setMaxAge(60*60*24*1);
		
		//2. 쿠키를 심는다
		response.addCookie(cookie);
		
		out.println("<script type='text/javascript'>");
		out.println("self.close()");
		out.println("</script>");
	}

}
