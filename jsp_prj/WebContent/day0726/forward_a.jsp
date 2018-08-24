<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" info="데이터 처리 목적"%>
<%!
	private Map<String,String> map;
	
	{//instance영역:객체가 생성되면 호출하지 않아도 자동호출 되며
		//method가 아니지만 class field에서 method내의 코드를 정의할 필요가 있을때 사용한다.
	map=new HashMap<String,String>();
	map.put("지승민","커밋을 잘하며,분위기를 잘 띄워준다.");
	map.put("이상훈","고양이를 좋아하며,고양이를 좋아한다.");
	map.put("김우현","돈까스를 좋아하며,지상최고의 음식이라고 생각한다.탄이나 가야지");
	map.put("김동희","바나나와 닭가슴살,브로콜리,방울토마토,아몬드...");
	map.put("송재원","숨은 맛집을 잘 찾아내며,점심식사에 돈을 뿌린다.");
	}

%>
<%
	//처리된 데이터
	String[] names = { "지승민", "이상훈", "김우현", "김동희", "송재원" };

	String name = request.getParameter("name");
	//1.이동할 페이지 설정
	RequestDispatcher rd = request.getRequestDispatcher("forward_b.jsp");
	//2.처리된 데이터를 이동할 페이지로 전달하기 위해 속성으로 설정
	request.setAttribute("names", names);//보여줄데이터
	request.setAttribute("data", map.get(name));//이름의 특징
	//3.이동
	rd.forward(request, response);
	
%>