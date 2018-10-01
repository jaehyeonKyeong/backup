package kr.co.sist.web.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.sist.web.member.dao.MemberDAO;
import kr.co.sist.web.member.vo.ZipcodeVO;

@SuppressWarnings("serial")
public class FindZip extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
	      out.write("<!DOCTYPE html>\r\n");
	      out.write("<html>\r\n");
	      out.write("<head>\r\n");
	      out.write("<meta charset=\"UTF-8\">\r\n");
	      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"http://211.63.89.140:8080/servlet_prj/common/css/main.css\"/>\r\n");
	      out.write("<title>우편번호찾기</title>\r\n");
	      out.write("<script type=\"text/javascript\" src=\"https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js\"></script>\r\n");
	      out.write("<style type=\"text/css\">\r\n");
	      out.write("\t#wrap{ position: relative; width:502px;height: 303px;margin: 0px auto }\r\n");
	      out.write("\t#zipInput{ position: absolute; top:60px; left:70px }\r\n");
	      out.write("\t#zipOutput{ position: absolute; top:110px; left:10px; font-weight: bold }\r\n");
	      out.write("\t#zipTitle{ width: 80px; height: 20px}\r\n");
	      out.write("\t#addrTitle{ width: 300px; height: 20px}\r\n");
	      out.write("\t.zipData{ width: 80px; }\r\n");
	      out.write("\t.addrData{ width: 300px; }\r\n");
	      out.write("\ttable{ border-spacing: 0px}\r\n");
	      out.write("\tth { border :1px solid #333 }\r\n");
	      out.write("\ttd{ text-align: center; border-bottom: 1px solid #333}\r\n");
	      out.write("</style>\r\n");
	      out.write("<script type=\"text/javascript\">\r\n");

	      out.println("$(function(){");
	      out.println("$('#btn').click(function(){");
	      out.println("	if($('#dong').val()==''){");
	      out.println("	alert('동 이름을 넣어주세요');");
	      out.println("	$('#dong').focus();");
	      out.println("return;");
	      out.println("	}//end if");
	      out.println("$('form').submit();");
	      
	      out.println("});//click");
	      out.println("});//ready");
	      
	      out.println("function sendZip(zipcode,addr){");
	      out.println("opener.window.document.pFrm.zipcode1.value=zipcode.split('-')[0];");
	      out.println("opener.window.document.pFrm.zipcode2.value=zipcode.split('-')[1];");
	      out.println("opener.window.document.pFrm.addr.value=addr;");
	      out.println("self.close();");
	      out.println("}//sendZip");
	      
	      out.write("</script>\r\n");
	      out.write("</head>\r\n");
	      out.write("<body>\r\n");
	      out.write("\t<div id=\"wrap\">\r\n");
	      out.write("\t\t<img src=\"member/images/zip_background.png\" />\r\n");
	      out.write("\t\t<div id=\"zipInput\">\r\n");
	      out.write("\t\t\t<form action=\"find_zip\" method=\"get\">\r\n");
	      out.write("\t\t\t\t<label>동이름</label>\r\n");
	      out.write("\t\t\t\t<input type=\"text\" autofocus='autofocus' name=\"dong\" id=\"dong\" class=\"inputBox\"/>\r\n");
	      out.write("\t\t\t\t<input type=\"button\" value=\"우편번호조회\" id=\"btn\" class=\"btn\"/><br/>\r\n");
	      out.write("\t\t\t\t예) 역삼동, 상도동\r\n");
	      out.write("\t\t\t</form>\r\n");
	      out.write("\t\t</div>\r\n");
	      out.write("\t\t\r\n");
	      out.write("\t\t<div id=\"zipOutput\">\r\n");
	      out.write("\t\t<table>\r\n");
	      out.write("\t\t\t<tr>\r\n");
	      out.write("\t\t\t\t<th id=\"zipTitle\">우편번호</th>\r\n");
	      out.write("\t\t\t\t<th id=\"addrTitle\">주소</th>\r\n");
	      out.write("\t\t\t</tr>\r\n");
	      out.write("\t\t</table>\r\n");
	      out.write("\t\t<div style=\"overflow:auto; width: 382px;height: 240px\">\r\n");
	      out.write("\t\t<table>\r\n");
	      
	      //1. 파라메터를 받아서
	      String dong=request.getParameter("dong");
	      //2. 파라메터가 존재한다면
	      if(dong!=null && !"".equals(dong)) {	    	  
	      //3. DB Table을 조회하여 결과를 출력한다.
	    	  MemberDAO md=MemberDAO.getInstance();
	    	  try {
				List<ZipcodeVO> zipList=md.selectZipcode(dong);
				StringBuilder addr=new StringBuilder();
				StringBuilder link=new StringBuilder();
				for(ZipcodeVO zv:zipList) {
					addr.append(zv.getSido()).append(" ")
					.append(zv.getGugun()).append(" ")
					.append(zv.getDong()).append(" ");
					//클릭했을때 부모창으로 넘겨줄 값
					link.append("<a href=\"javascript:sendZip('")
					.append(zv.getZipcode()).append("','")
					.append(addr).append("')\">");
					out.write("\t\t\t<tr>\n\n");
					out.write("\t\t\t\t<td class=\"zipData\">");
					out.print(link);
					out.print(zv.getZipcode());
					out.print("</a></td>\r\n");
					out.write("\t\t\t\t<td class=\"addrData\">");
					out.print(link);
					out.print(addr);
					out.print(" ");
					out.print(zv.getBunji());
					out.print("</a></td>\r\n");	
					out.write("\t\t\t</tr>\r\n");	
					addr.delete(0, addr.length());
					link.delete(0, link.length());
				}//end for
				if(zipList.isEmpty()) {
					out.print("<tr><td colspan='2' style='width:330px'>");
					out.print(dong);
					out.println("은(는) 존재하지 않습니다.<br/>동이름을 확인해주세요.</td></tr>");
				}
				
			} catch (SQLException e) {
				out.print("<tr><td colspan='2' style='width:380px'>서비스가 원활하지 못하여 지성!</td></tr>");
				e.printStackTrace();
			}//end catch
	    
	      }//end if
	      out.write("\t\t</table>\r\n");
	      out.write("\t\t</div>\r\n");
	      out.write("\t\t</div>\r\n");
	      out.write("\t</div>\r\n");
	      out.write("</body>\r\n");
	      out.write("</html>\r\n");
	}

}
