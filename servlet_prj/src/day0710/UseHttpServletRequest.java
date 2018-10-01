package day0710;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UseHttpServletRequest
 */
public class UseHttpServletRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UseHttpServletRequest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("--------------------doGet,doPost,service ��� �����ڿ� ���� ������ ��µȴ�");
		// 3.�������� ����(MIME-Type ����)
				response.setContentType("text/html;charset=UTF-8");
				// 4.��½�Ʈ�� ���
				PrintWriter out = response.getWriter();
				// 5.���䳻�� ����
				out.println("<!DOCTYPE html>");
				out.println("<html>");
				out.println("<head>");
				out.println("<meta charset='UTF-8'>");
				out.println("<title>��ûó�� ��ü�� ���</title>");
				out.println("<link rel=\"stylesheet\" type=\"text/css\"href=\"http://211.63.89.140:8080/servlet_prj/common/css/main.css\" />");
				out.println("<style>span{font_weight:bold}</style>");
				out.println("</head>");
				out.println("<body>");
				out.println("<a href='use_httpservletrequest?name=jaewon.song&age=25&age=26'>��û</a><br>");
				out.println("<form action='use_httpservletrequest' method='post'>");
				out.println("<input type='hidden' name='name' value='HB'/>");
				out.println("<input type='hidden' name='age' value='28'/>");
				out.println("<input type='hidden' name='age' value='29'/>");
				out.println("<input type='submit' value='post��Ŀ�û'/>");
				out.println("</form><br>");
				out.println("<span style='color:#ff0000;font-weight:bold;font-size:25px;'>��û��ü�� ��� </span><br>");
				
				out.print("��û URL:<span>");
				out.print(request.getRequestURL());
				out.println("</span><br>");
				
				out.print("��û protocol:<span>");
				out.print(request.getProtocol());
				out.println("</span><br>");
				
				out.print("��û ������:<span>");
				out.print(request.getServerName());
				out.println("</span><br>");
				
				out.print("��û ������Ʈ:<span>");
				out.print(request.getServerPort());
				out.println("</span><br>");
				
				out.print("��û URI:<span>");
				out.print(request.getRequestURI());
				out.println("</span><br>");
				
				out.print("��û ���� ���:<span>");
				out.print(request.getServletPath());
				out.println("</span><br>");
				
				out.print("querystring:<span>");
				out.print(request.getQueryString());
				out.println("</span><br>");
				
				out.print("�Ķ����(�̸� ����):<span>");
				out.print(request.getParameter("name"));
				out.println("</span><br>");
				
				out.print("�Ķ����(�̸� �ߺ�):<span>");
				out.print(Arrays.toString(request.getParameterValues("age")));
				out.println("</span><br>");
				
				out.print("��û���:<span>");
				out.print(request.getMethod());
				out.println("</span><br>");
				
				out.print("�������� IP:<span>");
				out.print(request.getRemoteAddr());
				out.println("</span><br>");
				
				out.print("�������� port:<span>");
				out.print(request.getRemotePort());
				out.println("</span><br>");
				
				out.println("</body>");
				
				String[] blockIp= {"133","137","145","141","149","152"};
				boolean flag=false;
				String ip=request.getRemoteAddr();
				
				for(String temp:blockIp) {
					if(ip.endsWith(temp)) {
						flag=true;
					}
				}
				
				if(flag) {
					response.sendRedirect("http://www.police.go.kr/main.html");
					return;
				}
				
				
				out.println("</html>");
	}

}
