<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.File"%>
<%@page import="org.jdom2.output.Format"%>
<%@page import="org.jdom2.output.XMLOutputter"%>
<%@page import="org.jdom2.Element"%>
<%@page import="org.jdom2.Document"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.NamingException"%>
<%@page import="javax.naming.Context"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.io.IOException"%>
<%@page import="java.sql.SQLException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"href="http://localhost:8080/jsp_prj/common/css/main.css">
<!-- CDN -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
</script>
</head>
<body>
	<%
	if(createDeptXml()){
	%>
	XML이 정상적으로 생성 되었습니다.<br>
	<a href="download.jsp?file_name=dept.xml">다운로드</a>
	<%
	}else{
	%>
	죄송합니다. 잠시후에 다시 시도해주세요
	<%
	}
	%>
	
</body>
</html>
<%!
	public boolean createDeptXml() throws SQLException,IOException{
		boolean flag=false;
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		FileOutputStream fos=null;
		
		try{
			//1.JNDI 사용객체 생성
			Context ctx=new InitialContext();
			//2.DataSource얻기
			DataSource ds=(DataSource)ctx.lookup("java:comp/env/jdbc/dbcp");
			//3.
			con=ds.getConnection();
			//4.
			String selectDept="select deptno,dname,loc from dept";
			pstmt=con.prepareStatement(selectDept);
			//5.
			rs=pstmt.executeQuery();
			
			//x1. xml생성 -xml문서객체 생성
			Document doc=new Document();
			
			//x2. 최상위 부모 노드 생성
			Element rootNode=new Element("depts");//<depts>노드 생성
			
			Element deptNode=null; //부서정보(부서번호,부서명,부서위치)를 저장할 노드
			Element deptnoNode=null; //부서번호를 저장할 노드
			Element dnameNode=null;	//부서명을 저장할 노드
			Element locNode=null; //부서위치를 저장할 노드
			
			while(rs.next()){
				//x3. 최상위 부모 노드에 배치될 자식 노드 생성
				deptNode=new Element("dept");
				deptnoNode=new Element("deptno");
				dnameNode=new Element("dname");
				locNode=new Element("loc");
				//노드에 들어갈 값 설정
				deptnoNode.setText(String.valueOf(rs.getInt("deptno")));
				dnameNode.setText(rs.getString("dname"));
				locNode.setText(rs.getString("loc"));
				
				//x4.deptNode에 자식노드 배치
				deptNode.addContent(deptnoNode);
				deptNode.addContent(dnameNode);
				deptNode.addContent(locNode);
				
				//x5. 자식노드를 가진 노드를 최상위 부모노드에 배치
				rootNode.addContent(deptNode);
				
			}//while
			//x6. 최상위 부모노드를 xml문서 객체에 배치
			doc.addContent(rootNode);
			//x7. 자식노드를 가진 xml문서 객체를 출력
			XMLOutputter x_out=new XMLOutputter(Format.getPrettyFormat());
			//x8. 생성하고자 하는 목적지에 도달할 수 있는 출력 스트림을 입력한다.
			File file=new File("C:/dev/workspace/jsp_prj/WebContent/xml0820/dept.xml");
			fos=new FileOutputStream(file);
			x_out.output(doc, fos);
			flag=true;	
			
		}catch(NamingException ne){
			
			ne.printStackTrace();
			
		}finally{
			if(fos!=null){fos.close();}
			if(rs!=null){rs.close();}
			if(pstmt!=null){pstmt.close();}
			if(con!=null){con.close();}
			
		}
		return flag;
	}
	
	
	%>