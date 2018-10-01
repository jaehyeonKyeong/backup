package kr.co.sist.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.sist.action.NamecardAction;
import kr.co.sist.action.NamecardAddFormAction;
import kr.co.sist.action.NamecardAddProcessAction;
import kr.co.sist.action.NamecardListAction;
import kr.co.sist.action.NamecardModfiyAction;
import kr.co.sist.action.NamecardRemoveAction;
import kr.co.sist.action.NamecardSearchAction;

@SuppressWarnings("serial")
public class MainController extends HttpServlet {
	
	private static Map<String, NamecardAction> ncMap;
	
	static{
		ncMap=new HashMap<String,NamecardAction>();
		//메인,명함리스트조회
		ncMap.put("NC_M001",new NamecardListAction());
		//명함 입력 폼
		ncMap.put("NC_I001",new NamecardAddFormAction());
		//입력명함 추가 업무
		ncMap.put("NC_I002",new NamecardAddProcessAction());
		//입력상세조회
		ncMap.put("NC_S001",new NamecardSearchAction());
		//명함 수정
		ncMap.put("NC_U001",new NamecardModfiyAction());
		//명함 삭제
		ncMap.put("NC_D001",new NamecardRemoveAction());
		
		
	}//static 영역 : 클래스가 실행되면 호출하지 않아도 한번만 자동 실행되는역
	
//	{
//		
//	}//instance영역 : 클래스가 객체로 생성될때마다 호출하지 않아도
	// 자동 실행되는 영역
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get방식으로 요청되면 doPost method에서 처리(요청방식은 변경되지 않는다.)
		doPost(request,response); 
	}//doGet
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		//키에 따라 동작을하며 키는 외부에서 입력된다. :
		//command pattern이라고 한다. 
		String cmd=request.getParameter("cmd");
		
		
		//최초요청시 또는 cmd가 없었을 때 
		if(cmd ==null) {
			cmd="NC_M001"; //메인화면을 보여주도록 키를 설정한다.
		}//end if
		
		
		
		//입력된 command에 따른 XxxxAction받는다.
		//객체 다형성: (na)같은 이름의 객체이지만 꺼내와지는 객체에 따라
		//다르게 사용된다.
		NamecardAction na =ncMap.get(cmd);
		if(na ==null) {//cmd를 외부에서 조작하면 na에는 null이 들어온다.
			na=ncMap.get("NC_M001");
		}
		//method 다형성: (execute, moveURL, isForward) 같은이름의
		//method  이지만 다른 업무를 수행한다.
		na.execute(request, response);//method polymorphism
		String url=na.moveURL();
		boolean isForward=na.isForward();
		pageMove(request, response, url, isForward);
	}//doPost
	
	private void pageMove(HttpServletRequest request	,HttpServletResponse response, String url, boolean flag)throws IOException,ServletException{
		
		if(flag) {//forward로 이동할때(현재 서버내 Servlet, JSP)
			RequestDispatcher rd=request.getRequestDispatcher(url);
			rd.forward(request, response);
		}else {// redirect이동(현재 서버, 외부 서버의 Servlet, JSP, HTML)
			response.sendRedirect(url);
		}//end else 
		
	}//pageMove
	
}//class
