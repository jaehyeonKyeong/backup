package day0717;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UseSessionC extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
	      out.write("<!DOCTYPE html>\r\n");
	      out.write("<html>\r\n");
	      out.write("<head>\r\n");
	      out.write("<meta charset=\"UTF-8\">\r\n");
	      out.write("<title>Insert title here</title>\r\n");
	      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"http://211.63.89.140:8080/servlet_prj/common/css/main.css\"/>\r\n");
	      out.write("<!--  CDN -->\r\n");
	      out.write("<script type=\"text/javascript\" src=\"https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js\"></script>\r\n");
	      out.write("<!-- SmartMenus core CSS (required) -->\r\n");
	      out.write(" <link href=\"common/js/smart/css/sm-core-css.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
	      out.write("<link href=\"common/js/smart/css/sm-simple/sm-simple.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
	      out.write("<!-- SmartMenus jQuery plugin -->\r\n");
	      out.write("<script type=\"text/javascript\" src=\"common/js/smart/jquery.smartmenus.min.js\"></script>\r\n");
	      out.write("<script type=\"text/javascript\">\r\n");
	      out.write("$(function() {\r\n");
	      out.write("\t$('#main-menu').smartmenus({\r\n");
	      out.write("\t\tsubMenusSubOffsetX: 1,\r\n");
	      out.write("\t\tsubMenusSubOffsetY: -8\r\n");
	      out.write("\t});\r\n");
	      out.write("});\r\n");
	      out.write("</script>\r\n");
	      out.write("<style type=\"text/css\">\r\n");
	      out.write("#wrap { width: 1024px; height: 1000px; margin: 0px auto }\r\n");
	      out.write("#header{ height: 150px }\r\n");
	      out.write("#headerTop{ height: 75px; font-family:���; font-size:30px; text-align:center;\r\n");
	      out.write("\t\t\t\t\tfont-weight:bold; padding-top:25px;\r\n");
	      out.write("\t\t\tbackground: #FFF url(common/images/header_bg.png)}\r\n");
	      out.write("#navi{ height: 500px}\r\n");
	      out.write("#container{ height:750px }\r\n");
	      out.write("#footer{ height:60px;background: #FFF url(common/images/footer_bg.png) ;\r\n");
	      out.write("\t\t\tfont-size: 16px; font-weight: bold; text-align: right; \r\n");
	      out.write("\t\t\tpadding-right: 30px; padding-top:40px;\r\n");
	      out.write("\t\t\twidth: 994px;}\r\n");
	      out.write("</style>\r\n");
	      out.write("</head>\r\n");
	      out.write("<body>\r\n");
	      out.write("\t<div id=\"wrap\">\r\n");
	      out.write("\t\t<div id=\"header\">\r\n");
	      out.write("\t\t\t<div id=\"headerTop\">\r\n");
	      out.write("\t\t\t\tWeb ����  s('. ^)v \r\n");
	      out.write("\t\t\t</div>\r\n");
	      out.write("\t\t\t<div id=\"navi\">\r\n");
	      out.write("\t\t\t    <nav id=\"main-nav\">\r\n");
	      out.write("      <!-- Sample menu definition -->\r\n");
	      out.write("     <!--  <ul id=\"main-menu\" class=\"sm sm-blue\"> -->\r\n");
	      out.write("      <ul id=\"main-menu\" class=\"sm sm-simple\">\r\n");
	      out.write("        <li><a href=\"#\">Home</a></li>\r\n");
	      out.write("        <li><a href=\"#\">�Ķ���Ϳ���</a>\r\n");
	      out.write("          <ul>\r\n");
	      out.write("            <li><a href=\"parameter.html\">�̸��� ������ ��</a></li>\r\n");
	      out.write("            <li><a href=\"parameter_values.html\">�̸��� �ߺ��ɶ�</a></li>\r\n");
	      out.write("            <li><a href=\"#\" class=\"disabled\">���Ұ�</a></li>\r\n");
	      out.write("          </ul>\r\n");
	      out.write("        </li>\r\n");
	      out.write("        <li><a href=\"#\">�ҹ��ٿ�ε�</a></li>\r\n");
	      out.write("        <li><a href=\"#\">����</a>\r\n");
	      out.write("          <ul>\r\n");
	      out.write("            <li><a href=\"\">������</a></li>\r\n");
	      out.write("            <li><a href=\"\">������</a></li>\r\n");
	      out.write("          </ul>\r\n");
	      out.write("        </li>\r\n");
	      out.write("        \r\n");
	      out.write("        <li><a href=\"#\">4�����忡 ���ؼ�</a>\r\n");
	      out.write("          <ul class=\"mega-menu\">\r\n");
	      out.write("            <li>\r\n");
	      out.write("              <!-- The mega drop down contents -->\r\n");
	      out.write("              <div style=\"width:400px;max-width:100%;\">\r\n");
	      out.write("                <div style=\"padding:5px 24px;\">\r\n");
	      out.write("                <p>Servlet�� JSP�� ����� ���� : �������� HTML�� �����ϱ����ؼ�</p>\r\n");
	      out.write("                </div>\r\n");
	      out.write("              </div>\r\n");
	      out.write("            </li>\r\n");
	      out.write("          </ul>\r\n");
	      out.write("        </li>\r\n");
	      out.write("      </ul>\r\n");
	      out.write("    </nav>\r\n");
	      out.write("\t\t\t</div>\r\n");
	      out.write("\t\t</div>\r\n");
	      out.write("\t\t<div id=\"container\">\r\n");
	      
	      //�������������� ����� ���� ���ǿ��� ��´�
	      //������ �̵��� ���� ����� �� �ִ�.
	      //1.���Ǿ��
	      HttpSession session=request.getSession();
	      //2.���ǰ� ���(�ٸ����������� ������ ���� �̵��� ���������� ���)
	      String name=(String)session.getAttribute("name");
	      //**���ǿ��� ���� ���ö����� ���� ���� �����ϴ��� �ݵ�� ó���ϴ� �ڵ尡 �־���Ѵ�.
	      if(name==null) {
	    	  //���ǿ��� ���� ���� ������
	    	  //1.�������������� �ƹ��� ������ ���� �ʾ� interval�� �Ѿ����.
	    	  //2.�� �������� ��û�� ������.
	    	  response.sendRedirect("day0717/use_session_a.html");
	    	  return;
	      }
	      long loginTime=(Long)session.getAttribute("loginTime");
	      
	      Date date=new Date(loginTime);
	      out.println("<strong>");
	      out.print(name);
	      out.print("( ���� �ð� ... ");
	      out.print(new SimpleDateFormat("yyyy-MM-dd kk:mm:ss").format(date));
	      out.print(" | ���� �ð� ...  ");
	      out.print(new SimpleDateFormat("yyyy-MM-dd kk:mm:ss").format(new Date()));
	      out.print(")�� �α��� �ϼ̽��ϴ�.<br>");
	      out.println("<a href=\"javascript:location.replace('use_session_d')\">�α׾ƿ�</a>");
	      
	      out.write("\t\t</div>\r\n");
	      out.write("\t\t<div id=\"footer\">\r\n");
	      out.write("\t\t\tCopyright&copy; class4 All Right Reserved.\r\n");
	      out.write("\t\t</div>\r\n");
	      out.write("\t</div>\r\n");
	      out.write("</body>\r\n");
	      out.write("</html>\r\n");
	}

}
