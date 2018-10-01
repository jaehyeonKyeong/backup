package day0712;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class parameterValues
 */
@SuppressWarnings("serial")
public class ParameterValues extends HttpServlet {
	
    //2. 요청방식을 처리하는 method Override
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		//3. 응답 방식 설정(MIME-Types)
		response.setContentType("text/html;charset=UTF-8");
		
		//4. 출력 스트림 얻기
		PrintWriter out=response.getWriter();
		//5. 응답 내용 생성
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
	      out.write("#headerTop{ height: 75px; font-family:고딕; font-size:30px; text-align:center;\r\n");
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
	      out.write("            <li><a href=\"../servlet_prj/day0711/parameter.html\">이름이 유일할 때</a></li>\r\n");
	      out.write("            <li><a href=\"../servlet_prj/day0712/parameter_values.html\">이름이 중복될때</a></li>\r\n");
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
	      
	      //parameter 값 받기
	      // <input type="text" 이지만 같은 이름을 가지고 있는 HTML 
	      //Form Control이 여러개이므로 배열로 처리
	      String[] addr= request.getParameterValues("addr");
	      String[] hobby= request.getParameterValues("hobby");
	      
	      out.println("<div>");
	      out.println("<ul>");
	      out.println("<li>본적주소/거주지주소</li>");
	      
	      try {// 배열을 사용하는 경우에는 값이 들어오지 않으면 예외가 발생하게 된다.
	      for(String tempAddr:addr) {
	    	  
	    	  out.println("<li>");
	    	  out.println("/");
	    	  out.println(tempAddr);
	    	  
	    	  out.println("</li>");
	    	  
	      }//end for
	      } catch (NullPointerException npe) {
				out.println("주소 필요");
			}
	      
	      out.println("</ul>");	      
	      out.println("<ul>");
	      out.println("<li>선택하신 취미</li>");
	      
	      /*
	       * tomcat6.0 까지는 NullPinterException이 발생하면 페이지
	       * 자체가 로딩되지 않고 500 예외가 발생하지만
	       * Tomcat 7.0부터는 NullPinterException이 발생되면
	       * 발생한 코드의 전의 페이지는 로딩되고 그 아래 코드는
	       * 로딩 되지 않는다.
	       * 
	       * 
	       */
	      
	      try {// 배열을 사용하는 경우에는 값이 들어오지 않으면 예외가 발생하게 된다.
	    	  for(int i=0; i<hobby.length; i++) {
		    	  out.println("<li>");
		    	  out.println(i+1);
		    	  out.println("");
		    	  out.println(hobby[i]);
		    	  
		    	  out.println("</li>");
		      }
			
		} catch (NullPointerException npe) {
			out.println("취미 필요");
		}
	      
	      
	      out.println("</ul>");
	      
	      out.println("</div>");
	      
	      
	      out.write("\t\t\r\n");
	      out.write("\t\t</div>\r\n");
	      out.write("\t\t<div id=\"footer\">\r\n");
	      out.write("\t\t\tCopyright&copy; class4 All Right Reserved.\r\n");
	      out.write("\t\t</div>\r\n");
	      out.write("\t</div>\r\n");
	      out.write("</body>\r\n");
	      out.write("</html>\r\n");
		
		
		
	}
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//POST 방식의 요청일 때 한글 처리
		
		
		//3. 응답 방식 설정(MIME-Types)
				response.setContentType("text/html;charset=UTF-8");
				
				//4. 출력 스트림 얻기
				PrintWriter out=response.getWriter();
				//5. 응답 내용 생성
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
			      out.write("#headerTop{ height: 75px; font-family:고딕; font-size:30px; text-align:center;\r\n");
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
			      out.write("            <li><a href=\"day0711/parameter.html\">이름이 유일할 때</a></li>\r\n");
			      out.write("            <li><a href=\"day0712/parameter_values.html\">이름이 중복될때</a></li>\r\n");
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
			      
			      //parameter 값 받기
			      // <input type="text" 이지만 같은 이름을 가지고 있는 HTML 
			      //Form Control이 여러개이므로 배열로 처리
			      String[] addr= request.getParameterValues("addr");
			      String[] hobby= request.getParameterValues("hobby");
			      
			      out.println("<div>");
			      out.println("<strong>post 방식</strong>");
			      out.println("<ul>");
			      out.println("<li>본적주소/거주지주소</li>");
			      
			      
			      if(addr!=null) {
			      for(String tempAddr:addr) {
			    	  
			    	  out.println("<li>");
			    	  
			    	  out.println(tempAddr);
			    	  out.println(" ");
			    	  out.println("</li>");
			    	  
			      }//end for
			      }else {
			    	  out.println("<li> 주소가 없습니다. .</li>");
			    	  
			      }//end else
			      
			      out.println("</ul>");	      
			      out.println("<ul>");
			      out.println("<li>선택하신 취미</li>");
			      
			      /*
			       * tomcat6.0 까지는 NullPinterException이 발생하면 페이지
			       * 자체가 로딩되지 않고 500 예외가 발생하지만
			       * Tomcat 7.0부터는 NullPinterException이 발생되면
			       * 발생한 코드의 전의 페이지는 로딩되고 그 아래 코드는
			       * 로딩 되지 않는다.
			       * 
			       * 
			       */
			      
			      if(hobby!=null) {
			     
			    	  for(int i=0; i<hobby.length; i++) {
				    	  out.println("<li>");
				    	  out.println(i+1);
				    	  out.println("");
				    	  out.println(hobby[i]);
				    	  
				    	  out.println("</li>");
				      }//end for
			      }else {
			    	  out.println("<li> 취미가 없습니다. .</li>");
			    	  
			      }//end else
					
				
			      
			      
			      out.println("</ul>");
			      
			      out.println("</div>");
			      
			      
			      out.write("\t\t\r\n");
			      out.write("\t\t</div>\r\n");
			      out.write("\t\t<div id=\"footer\">\r\n");
			      out.write("\t\t\tCopyright&copy; class4 All Right Reserved.\r\n");
			      out.write("\t\t</div>\r\n");
			      out.write("\t</div>\r\n");
			      out.write("</body>\r\n");
			      out.write("</html>\r\n");
	}

}
