<%@page import="java.net.URLDecoder"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String fileName = request.getParameter("file_name");
	fileName = URLEncoder.encode(fileName, "UTF-8");
	//1.다운로드를 할 수 있도록 응답방식을 변경한다.
	response.setContentType("application/octet-stream");
	//2.다운로드 Header정보 설정(다운로드할 파일명 설정)
	response.setHeader("Content-Disposition", "attachment;fileName=" + fileName);
	//3.다운로드할 파일을 저장
	//파일 이름이 한글이거나 띄어쓰기가 있다면 다운이 되질 않으니 urldecoder.decode로 디코드해준다.
	File file = new File("C:/dev/workspace/jsp_prj/WebContent/xml0820/" + URLDecoder.decode(fileName,"UTF-8")); 
	//파일을 내용을 저장할 Byte의 배열 생성
	byte[] readData = new byte[(int) file.length()];

	//파일의 내용을 읽어들여 배열에 설정해야함.
	int tempData = 0;
	int idx = 0;
	
	FileInputStream fis = null;
	OutputStream os = null;

	try {
		fis = new FileInputStream(file);
		
		while ((tempData = fis.read()) != -1) {
			readData[idx] = (byte) tempData;
			idx++;
		}
		
		//4.out 초기화
		out.clear();
		//5.out 재설정
		out=pageContext.pushBody();
		//6.출력Stream을 얻고
		os=response.getOutputStream();
		//7.출력스트림에 읽어들인 파일의 내용을 기록
		os.write(readData);
		
		
	} finally {
		if (fis != null) {
			fis.close();
		}
		if (os != null) {
			os.close();
		}
	}
%>