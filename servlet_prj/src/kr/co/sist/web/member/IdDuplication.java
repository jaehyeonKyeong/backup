package kr.co.sist.web.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.sist.web.member.dao.MemberDAO;

@SuppressWarnings("serial")
public class IdDuplication extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write("\r\n");
		out.write("<!DOCTYPE html>\r\n");
		out.write("<html>\r\n");
		out.write("<head>\r\n");
		out.write("<meta charset=\"UTF-8\">\r\n");
		out.write(
				"<link rel=\"stylesheet\" type=\"text/css\" href=\"http://211.63.89.140:8080/servlet_prj/common/css/main.css\"/>\r\n");
		out.write("<title>���̵�ã��</title>\r\n");
		out.write("<style type=\"text/css\">\r\n");
		out.write("\t#wrap{ position: relative; width:502px;height: 303px;margin: 0px auto }\r\n");
		out.write("\t#idInput{ position: absolute; top:110px; left:80px }\r\n");
		out.write("\t#output{ position: absolute; top:200px; left:60px; font-weight: bold }\r\n");
		out.write("</style>\r\n");

		out.println(
				"<script type=\"text/javascript\"src=\"https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js\"></script>");

		out.write("<script type=\"text/javascript\">\r\n");

		out.println("$(function(){");

		out.println("$('#btn').click(function(){");

		out.println("if($('#id').val()==''){");
		out.println("alert('ID�� �ʼ��� �Է��ϼž� �մϴ�')");
		out.println("$('#id').focus();");
		out.println("return;");
		out.println("}");

		out.println("$('form').submit();");

		out.println("});//click");
		
		out.println("$('#id').keydown(function(evt){");
		out.println("if(evt.which==13 && $('#id').val()==''){");
		out.println("alert('���̵�� �ʼ� �Է��Դϴ�');");
		out.println("$('#id').focus();");
		out.println("}");
		out.println("});");

		out.println("});//ready");
		
		out.println("function sendId(id){");
		out.println("opener.window.document.pFrm.id.value=id;");
		out.println("self.close();");
		out.println("}");

		out.write("</script>\r\n");
		out.write("</head>\r\n");
		out.write("<body>\r\n");
		out.write("\t<div id=\"wrap\">\r\n");
		out.write("\t\t<img src=\"member/images/id_background.png\" />\r\n");
		out.write("\t\t<div id=\"idInput\">\r\n");
		out.write("\t\t\t<form action=\"\" method=\"get\">\r\n");
		out.write("\t\t\t\t<label>���̵�</label>\r\n");
		out.write("\t\t\t\t<input type=\"text\" name=\"id\" id='id' autofocus='autofocus' class=\"inputBox\"/>\r\n");
		out.write("\t\t\t\t<input type=\"button\" value=\"�ߺ��˻�\" id='btn' class=\"btn\"/>\r\n");
		out.write("\t\t\t</form>\r\n");
		out.write("\t\t</div>\r\n");

		// 1.�Ķ���͸� �޾Ƽ�
		String id = request.getParameter("id");

		// 2.�Ķ���Ͱ� �����Ѵٸ� (web�� parameter ��ü�� ���ٸ� null�̰� parameter���� ������ ���� ���ٸ� empty�̴�.
		if (id != null && !"".equals(id)) {
			// 3.��������� �Ǵ��Ͽ� �����Ѵ�.
			MemberDAO m_dao = MemberDAO.getInstance();
			out.write("\t\t<div id=\"output\">\r\n");
			try {
				boolean flag = m_dao.idDup(id);
				if (flag) {
					out.write("\t\t\t<div style=\"font-size: 20px;color:#DB4237\">\r\n");
					out.write("\t\t\t�Է��Ͻ�<span>");
					out.println(id); 
					out.write("</span>�� �̹� ������� ���̵� �Դϴ�.\r\n");
					out.write("\t\t\t</div>\r\n");
				} else {
					out.write("\t\t\t<div><span style=\"font-size: 23px;\"></span>");
					out.println(id); 
					out.write("<span style=\"font-size: 20px;color:#051339\"> �»�밡���� ���̵� �Դϴ�.</span><br>\r\n");
					out.write("\t\t\t<a href=\"javascript:sendId('");
					out.print(id);
					out.write("')\" style=\"font-size: 20px;\">���</a>\r\n");
					out.write("\t\t\t</div>\r\n");
				}
			} catch (SQLException e) {
				out.println("���̵� �ߺ�Ȯ���� ������ �߻� �Ͽ����ϴ�.<br>���񽺰� �������� ���� �� ���E�մϴ�...<br>����Ŀ� �ٽ� �õ����ּ���!");
				e.printStackTrace();
			}
			out.write("\t\t</div>\r\n");

		} // end if

		out.write("\t</div>\r\n");
		out.write("</body>\r\n");
		out.write("</html>\r\n");
	}

}
