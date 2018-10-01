package day0718;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class SearchEmp extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		out.write("<!DOCTYPE html>\r\n");
		out.write("<html>\r\n");
		out.write("<head>\r\n");
		out.write("<meta charset=\"UTF-8\">\r\n");
		out.write("<title>Insert title here</title>\r\n");
		out.write(
				"<link rel=\"stylesheet\" type=\"text/css\" href=\"http://211.63.89.140:8080/servlet_prj/common/css/main.css\"/>\r\n");
		out.write("<!--  CDN -->\r\n");
		out.write(
				"<script type=\"text/javascript\" src=\"https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js\"></script>\r\n");
		out.write("<!-- SmartMenus core CSS (required) -->\r\n");
		out.write(" <link href=\"common/js/smart/css/sm-core-css.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
		out.write(
				"<link href=\"common/js/smart/css/sm-simple/sm-simple.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
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

		out.println(".tab {border-top: 2px solid #5b7ce5;border-spacing: 0px}");
		out.println(".noTitle {width: 80px;}");
		out.println(".empnoTitle {width: 90px;}");
		out.println(".enameTitle {width: 150px;}");
		out.println(".jobTitle {width: 150px;}");
		out.println(".salTitle {width: 100px;}");
		out.println(".hiredateTitle {width: 200px;}");
		out.println("th {border-bottom: 1px solid #e7e7e7;background-color: #fdfdfd;color: #545454;height: 25px}");
		out.println("th {border-bottom: 1px solid #e7e7e7;background-color: #fdfdfd;color: #545454;height: 25px}");
		out.println("tr:hover {background-color: #eae9f7;}");

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

		String deptno = request.getParameter("deptno");
		if (deptno == null || "".equals(deptno)) {
			response.sendRedirect("search_dept?page_flag=na");
			return;
		}

		int intDeptno = Integer.parseInt(deptno);
		try {
			List<EmpVO> list = searchEmp(intDeptno);
			Iterator<EmpVO> empIta=list.iterator();
			
			out.print("<div style='width:70px;float:left'>");
			out.print("<img src='day0718/images/dept_");
			out.print(deptno);
			out.print(".png'title='");
			out.print(deptno);
			out.print("�μ� ��ȸ���'/>");
			out.println("</div>");
			out.print("<div style='width:600px;float:left'>");
			out.print("<div>");
			out.print(deptno);
			out.print("�� �μ��� ");
			out.print(list.size());
			out.print("�� ��ȸ�Ǿ����ϴ�.");
			out.print("</div>");
			
			out.println("<table class='tab'>");
			out.println("<tr>");
			out.println("<th class='noTitle'>��ȣ</th>");
			out.println("<th class='empnoTitle'>�����ȣ</th>");
			out.println("<th class='enameTitle'>�����</th>");
			out.println("<th class='jobTitle'>����</th>");
			out.println("<th class='salTitle'>����</th>");
			out.println("<th class='hiredateTitle'>�Ի���</th>");
			out.println("</tr>");
			
			EmpVO ev=null;
			for(int num=1;empIta.hasNext();num++) {
				ev=empIta.next();
				out.println("<tr>");
				
				out.print("<td>");
				out.println(num);
				out.print("</td>");
				out.print("<td>");
				out.println(ev.getEmpno());
				out.print("</td>");
				out.print("<td>");
				out.println(ev.getEname());
				out.print("</td>");
				out.print("<td>");
				out.println(ev.getJob());
				out.print("</td>");
				out.print("<td>");
				out.println(ev.getSal());
				out.print("</td>");
				out.print("<td>");
				out.println(ev.getHiredate());
				out.print("</td>");
				
				out.println("</tr>");
				
			}
			if(list.isEmpty()) {
				out.println("<tr><td colspan='6'>�ش�μ����� ����� �������� �ʽ��ϴ�</td></tr>");
			}
			out.print("</table>");
			out.print("</div>");
		} catch (SQLException se) {
			se.printStackTrace();
			out.println("����� ���񽺰� ��Ȱ���� ���Ͽ� �˼��մϴ�");
		}

		out.write("\t\t</div>\r\n");
		out.write("\t\t<div id=\"footer\">\r\n");
		out.write("\t\t\tCopyright&copy; class4 All Right Reserved.\r\n");
		out.write("\t\t</div>\r\n");
		out.write("\t</div>\r\n");
		out.write("</body>\r\n");
		out.write("</html>\r\n");
	}

	private List<EmpVO> searchEmp(int deptno) throws SQLException {
		List<EmpVO> empList=null;
		empList=EmployeeDAO.getInstance().selectEmp(deptno);
		return empList;
	}

}
