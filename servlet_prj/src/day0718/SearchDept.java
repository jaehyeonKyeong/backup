package day0718;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Generated;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class SearchDept extends HttpServlet {

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
		
		out.println("$('#btn').click(function(){");
		out.println("$('form').submit();");
		out.println("});");
		
		out.write("});\r\n");
		out.write("</script>\r\n");
		out.write("<style type=\"text/css\">\r\n");
		out.write("#wrap { width: 1024px; height: 1000px; margin: 0px auto }\r\n");
		out.write("#header{ height: 150px }\r\n");
		out.write("#headerTop{ height: 75px; font-family:고딕; font-size:30px; text-align:center;\r\n");
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
		out.println(".deptnoTitle {width: 100px;}");
		out.println(".dnameTitle {width: 150px;}");
		out.println(".locTitle {width: 150px;}");
		out.println("th {border-bottom: 1px solid #e7e7e7;background-color: #fdfdfd;color: #545454;height: 25px}");
		out.println("th {border-bottom: 1px solid #e7e7e7;background-color: #fdfdfd;color: #545454;height: 25px}");
		out.println("tr:hover {background-color: #eae9f7;}");

		out.write("</style>\r\n");
		out.write("</head>\r\n");
		out.write("<body>\r\n");
		out.write("\t<div id=\"wrap\">\r\n");
		out.write("\t\t<div id=\"header\">\r\n");
		out.write("\t\t\t<div id=\"headerTop\">\r\n");
		out.write("\t\t\t\tWeb 연습  s('. ^)v \r\n");
		out.write("\t\t\t</div>\r\n");
		out.write("\t\t\t<div id=\"navi\">\r\n");
		out.write("\t\t\t    <nav id=\"main-nav\">\r\n");
		out.write("      <!-- Sample menu definition -->\r\n");
		out.write("     <!--  <ul id=\"main-menu\" class=\"sm sm-blue\"> -->\r\n");
		out.write("      <ul id=\"main-menu\" class=\"sm sm-simple\">\r\n");
		out.write("        <li><a href=\"#\">Home</a></li>\r\n");
		out.write("        <li><a href=\"#\">파라메터연습</a>\r\n");
		out.write("          <ul>\r\n");
		out.write("            <li><a href=\"parameter.html\">이름이 유일할 때</a></li>\r\n");
		out.write("            <li><a href=\"parameter_values.html\">이름이 중복될때</a></li>\r\n");
		out.write("            <li><a href=\"#\" class=\"disabled\">사용불가</a></li>\r\n");
		out.write("          </ul>\r\n");
		out.write("        </li>\r\n");
		out.write("        <li><a href=\"#\">불법다운로드</a></li>\r\n");
		out.write("        <li><a href=\"#\">지원</a>\r\n");
		out.write("          <ul>\r\n");
		out.write("            <li><a href=\"\">빛동희</a></li>\r\n");
		out.write("            <li><a href=\"\">갓대현</a></li>\r\n");
		out.write("          </ul>\r\n");
		out.write("        </li>\r\n");
		out.write("        \r\n");
		out.write("        <li><a href=\"#\">4강의장에 대해서</a>\r\n");
		out.write("          <ul class=\"mega-menu\">\r\n");
		out.write("            <li>\r\n");
		out.write("              <!-- The mega drop down contents -->\r\n");
		out.write("              <div style=\"width:400px;max-width:100%;\">\r\n");
		out.write("                <div style=\"padding:5px 24px;\">\r\n");
		out.write("                <p>Servlet과 JSP를 만드는 목적 : 동적으로 HTML을 생성하기위해서</p>\r\n");
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

		// 전체 부서 목록
		out.println("<div style='padding-top:30px;padding-left:20px'>");
		String msg=request.getParameter("page_flag");
		out.println("<span style='font-size:16px;font-weight:bold'>브레드리아 부서정보</span>");
		if(msg !=null) {
			out.println("<span id='warn' style='color:#ff0000'>비정상적인 요청으로 방문 하셨습니다.</span>");
			out.println("<script type='text/javascript'>");
			out.println("$('#warn').fadeOut(1000).fadeIn(1000).fadeOut(1000).fadeIn(1000).fadeOut(1000).fadeIn(1000).fadeOut(1000);");
			out.println("</script>");
		}
		out.println("<br>");
		try {
			List<DeptVO> deptList = searchAllDept();
			out.println("<table class='tab'>");
			out.println("<tr>");
			out.println("<th class='noTitle'>번호</th>");
			out.println("<th class='deptnoTitle'>부서번호</th>");
			out.println("<th class='dnameTitle'>부서명</th>");
			out.println("<th class='locTitle'>위치</th>");
			out.println("</tr>");
			Iterator<DeptVO> deptIta=deptList.iterator();
			DeptVO tempDept=null;
			for(int no=1;deptIta.hasNext();no++) {
				tempDept=deptIta.next();
				out.println("<tr>");
				out.print("<td>");
				out.print(no);
				out.print("</td>");
				out.print("<td>");
				out.print(tempDept.getDeptno());
				out.print("</td>");
				out.print("<td>");
				out.print("<a href='search_emp?deptno=");
				out.print(tempDept.getDeptno());
				out.print("'>");
				out.print(tempDept.getDname());
				out.print("</a>");
				out.print("</td>");
				out.print("<td>");
				out.print(tempDept.getLoc());
				out.print("</td>");
				out.println("</tr>");
				
			}
			if(deptList.isEmpty()) {
				out.println("<tr><td colspan='4'>부서정보가 존재하지 않습니다.</td></tr>");
			}
			out.println("</table>");
			out.println("<div style='margin-top:10px'>");
			out.println("<form method='get' action='search_emp'>");
			for(DeptVO dv:deptList) {
				out.print("<input type='radio' name='deptno' value='");
				out.print(dv.getDeptno());
				out.print("'>");
				out.print(dv.getDname());
				out.print("&nbsp;");
			}
			out.println("<input type='button' value='부서조회' id='btn' class='btn'>");
			out.println("</form>");
			out.println("</div>");
		} catch (SQLException e) {
			e.printStackTrace();
			out.println("사용 중에 불편을 드려 죄송합니다.<br>잠시후에 다시 시도해주세요.");
		}
		out.println("</div>");

		out.write("\t\t</div>\r\n");
		out.write("\t\t<div id=\"footer\">\r\n");
		out.write("\t\t\tCopyright&copy; class4 All Right Reserved.\r\n");
		out.write("\t\t</div>\r\n");
		out.write("\t</div>\r\n");
		out.write("</body>\r\n");
		out.write("</html>\r\n");
	}// doGet

	private List<DeptVO> searchAllDept() throws SQLException {
		List<DeptVO> list = new ArrayList<DeptVO>();
		EmployeeDAO e_dao = EmployeeDAO.getInstance();
		list = e_dao.selectAllDept();
		return list;
	}

}
