package day0712;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class ForwardA extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//데이터 처리 목적(응답이 되질 않는다)
		String[] names= {"송램지","강지형","이종민","꿀형","탈붓다"};
		String[] addrs= {"성남시 태평동","성남시 야탑동","서울시 광진구 구의동","오산시 수청동","구리시 인창동"};
		
		System.out.println("요청이름 :"+request.getParameter("name"));
		System.out.println("요청나이 :"+request.getParameter("age"));
		//1.이동할 페이지 설정
		RequestDispatcher rd=request.getRequestDispatcher("forward_b");
		//2.화면에서 보여줄 데이터를 요청객체의 속성으로 설정
		request.setAttribute("names", names);
		request.setAttribute("addrs", addrs);
		//3.이동
		rd.forward(request, response);
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		out.print("adfsdfdsafasdfsadfasdfsadf");
		
	}

}
