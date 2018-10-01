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
		out.write("<title>아이디찾기</title>\r\n");
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
		out.println("alert('ID는 필수로 입력하셔야 합니다')");
		out.println("$('#id').focus();");
		out.println("return;");
		out.println("}");

		out.println("$('form').submit();");

		out.println("});//click");
		
		out.println("$('#id').keydown(function(evt){");
		out.println("if(evt.which==13 && $('#id').val()==''){");
		out.println("alert('아이디는 필수 입력입니다');");
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
		out.write("\t\t\t\t<label>아이디</label>\r\n");
		out.write("\t\t\t\t<input type=\"text\" name=\"id\" id='id' autofocus='autofocus' class=\"inputBox\"/>\r\n");
		out.write("\t\t\t\t<input type=\"button\" value=\"중복검사\" id='btn' class=\"btn\"/>\r\n");
		out.write("\t\t\t</form>\r\n");
		out.write("\t\t</div>\r\n");

		// 1.파라메터를 받아서
		String id = request.getParameter("id");

		// 2.파라메터가 존재한다면 (web의 parameter 자체가 없다면 null이고 parameter명은 있으나 값이 없다면 empty이다.
		if (id != null && !"".equals(id)) {
			// 3.사용중인지 판단하여 응답한다.
			MemberDAO m_dao = MemberDAO.getInstance();
			out.write("\t\t<div id=\"output\">\r\n");
			try {
				boolean flag = m_dao.idDup(id);
				if (flag) {
					out.write("\t\t\t<div style=\"font-size: 20px;color:#DB4237\">\r\n");
					out.write("\t\t\t입력하신<span>");
					out.println(id); 
					out.write("</span>는 이미 사용중인 아이디 입니다.\r\n");
					out.write("\t\t\t</div>\r\n");
				} else {
					out.write("\t\t\t<div><span style=\"font-size: 23px;\"></span>");
					out.println(id); 
					out.write("<span style=\"font-size: 20px;color:#051339\"> 는사용가능한 아이디 입니다.</span><br>\r\n");
					out.write("\t\t\t<a href=\"javascript:sendId('");
					out.print(id);
					out.write("')\" style=\"font-size: 20px;\">사용</a>\r\n");
					out.write("\t\t\t</div>\r\n");
				}
			} catch (SQLException e) {
				out.println("아이디 중복확인중 문제가 발생 하였습니다.<br>서비스가 원할하지 못한 점 뎨둉합니다...<br>잠시후에 다시 시도해주세요!");
				e.printStackTrace();
			}
			out.write("\t\t</div>\r\n");

		} // end if

		out.write("\t</div>\r\n");
		out.write("</body>\r\n");
		out.write("</html>\r\n");
	}

}
