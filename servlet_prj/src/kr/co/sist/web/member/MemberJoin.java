package kr.co.sist.web.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.sist.util.HashAlgorithm;
import kr.co.sist.web.member.dao.MemberDAO;
import kr.co.sist.web.member.vo.WebMemberVO;

@SuppressWarnings("serial")
public class MemberJoin extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		// �Ķ���� �ޱ�
		String id = request.getParameter("id");
		String pass = HashAlgorithm.changeMD5(request.getParameter("pass"));
		String name = request.getParameter("name");
		StringBuilder phone = new StringBuilder();
		phone.append(request.getParameter("phone1")).append("-").append(request.getParameter("phone2")).append("-")
				.append(request.getParameter("phone3"));

		StringBuilder zipcode = new StringBuilder();
		zipcode.append(request.getParameter("zipcode1")).append("-").append(request.getParameter("zipcode2"));

		String addr = request.getParameter("addr");
		String addr_detail = request.getParameter("addr_detail");

		StringBuilder tempSsn = new StringBuilder();
		tempSsn.append(request.getParameter("ssn1")).append("-").append(request.getParameter("ssn2"));

		String ssn = HashAlgorithm.changeMD5(tempSsn.toString());
		String gender = request.getParameter("gender");
		String[] hobby = request.getParameterValues("hobby");

		StringBuilder birth = new StringBuilder();
		birth.append(request.getParameter("birth_year")).append("-").append(request.getParameter("birth_month"))
				.append("-").append(request.getParameter("birth_day"));

		String marriage = request.getParameter("marriage");

		StringBuilder marriage_date = new StringBuilder();
		marriage_date.append(request.getParameter("m_year")).append("-").append(request.getParameter("m_month"))
				.append("-").append(request.getParameter("m_day"));

		String greeting = request.getParameter("greeting");
		String ip = request.getRemoteAddr();

		WebMemberVO wmv = new WebMemberVO(id, pass, name, phone.toString(), zipcode.toString(), addr, addr_detail, ssn,
				gender, birth.toString(), marriage, marriage_date.toString(), greeting, ip, hobby);

		out.write("<!DOCTYPE html>\r\n");
		out.write("<html>\r\n");
		out.write("<head>\r\n");
		out.write("<meta charset=\"UTF-8\">\r\n");
		out.write("<title>");

		out.print(name);

		out.write("���� ȸ�� ������ ȯ���մϴ�!!</title>\r\n");
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
		out.write("<script type=\"text/javascript\" src=\"../common/js/smart/jquery.smartmenus.min.js\"></script>\r\n");
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
		out.write(".outTitle{ font-size: 14px}\r\n");
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
		out.write("\t\t<div style=\"position: relative;margin: 0px auto\">\r\n");

		MemberDAO md = MemberDAO.getInstance();
		try {

			// �񿬰Ἲ�� ���� ������ �� ���̵� ��������� �ٽ� �ѹ� �˻�
			if (md.idDup(id)) { // ������� ���̵�
				out.print("�Է��Ͻ� ���̵� <strong>");
				out.print(id);
				out.print("</strong>��(��) �̹� ������� ���̵��Դϴ�.<br>");
				out.print("�ٸ� ���̵� �Է����ּ���<br>");
				out.print("<a href='javascript:history.back();'>�ٽ� �Է�</a>");
				out.println("<img src='member/images/use_id.png'/>");

			} else {// ��������� ���� ���̵�
				md.insertWebMember(wmv);

				out.write("\t\t\t<img src=\"member/images/member_back.png\" style=\"position: absolute;\"/>\r\n");
				out.write("\t\t\t<div style=\"position: absolute;left: 340px;top: 310px\">\r\n");
				out.write("\t\t\t\t<table>\r\n");
				out.write("\t\t\t\t<tr>\r\n");
				out.write("\t\t\t\t\t<td class=\"outTitle\">���̵� : </td>\r\n");
				out.write("\t\t\t\t\t<td>");
				out.println(id);
				out.write("</td>\r\n");
				out.write("\t\t\t\t</tr>\r\n");
				out.write("\t\t\t\t<tr>\r\n");
				out.write("\t\t\t\t\t<td class=\"outTitle\">�̸� : </td>\r\n");
				out.write("\t\t\t\t\t<td>");
				out.println(name);
				out.write("</td>\r\n");
				out.write("\t\t\t\t</tr>\r\n");
				out.write("\t\t\t\t<tr>\r\n");
				out.write("\t\t\t\t\t<td class=\"outTitle\">��ȭ��ȣ : </td>\r\n");
				out.write("\t\t\t\t\t<td>");
				out.println(phone);
				out.write("</td>\r\n");
				out.write("\t\t\t\t</tr>\r\n");
				out.write("\t\t\t\t<tr>\r\n");
				out.write("\t\t\t\t\t<td class=\"outTitle\">���� : </td>\r\n");
				out.write("\t\t\t\t\t<td>");
				out.print(gender);
				out.write("</td>\r\n");
				out.write("\t\t\t\t</tr>\r\n");
				out.write("\t\t\t\t</table>\r\n");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			out.println("<img src='member/images/sorry.jpg'/><br>");
			out.println("���񽺰� �������� ���Ͽ� �˼��ؿ� �Ф�");
		}
		out.write("\t\t\t\t<a href=\"main\">��������</a>\r\n");
		out.write("\t\t\t</div>\r\n");
		out.write("\t\t</div>\r\n");
		out.write("\t\t</div>\r\n");
		out.write("\t\t<div id=\"footer\">\r\n");
		out.write("\t\t\tCopyright&copy; class4 All Right Reserved.\r\n");
		out.write("\t\t</div>\r\n");
		out.write("\t</div>\r\n");
		out.write("</body>\r\n");
		out.write("</html>\r\n");
	}

}
