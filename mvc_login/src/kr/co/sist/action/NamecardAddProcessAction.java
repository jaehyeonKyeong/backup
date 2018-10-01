package kr.co.sist.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.co.sist.service.NamecardAddService;
import kr.co.sist.vo.NamecardVO;

/**
 * cmd : NC_I002<br>
 * 입력된 명함을 DB에 추가하는 업무
 * @author owner
 */
public class NamecardAddProcessAction implements NamecardAction {
	private String url;
	private boolean forwardFlag;
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		//파일 업로드가 수행되도록 MultipartRequest를 사용한다.
		//MultipartRequest는 동일 파일명이 존재할 경우 중복파일에 대한 처리를 수행해준다.
		String repository="C:/dev/workspace/mvc_login/WebContent/upload";
//		String repository="C:/web/mvc_login/upload";
		int maxSize=1024*1024*10;//Byte KByte MB
 		//파일 업로드가 수행된다
		MultipartRequest mr=new MultipartRequest(request, repository, maxSize, "UTF-8", new DefaultFileRenamePolicy());
		//encType="multipart/form-data"일때에는 parameter전송방식이 아니므로request.getParameter를 사용할 수 없다.(URL뒤에 붙이는것은 가능하다)
		String company=mr.getParameter("company");
		String manager=mr.getParameter("manager");
		String dept=mr.getParameter("dept");
		String position=mr.getParameter("position");
		String phone1=mr.getParameter("phone1");
		String phone2=mr.getParameter("phone2");
		String phone3=mr.getParameter("phone3");
		String fax1=mr.getParameter("fax1");
		String fax2=mr.getParameter("fax2");
		String fax3=mr.getParameter("fax3");
		String addr=mr.getParameter("addr");
		String email1=mr.getParameter("email1");
		String email2=mr.getParameter("email2");
		
		//input type=file 은 getparameter로 받을 수 없다
		//FilesystemName 또는 OriginalName으로 받을 수 있다.
		
		String fileName=mr.getFilesystemName("file");
		
		//새로고침시 중복데이터가 추가 되는 것을 막기 위해서 session을 사용한다.
		//1.session얻기
		HttpSession session=request.getSession();
		//2.session에서 value얻기
		String sesCom=(String)session.getAttribute("ses_com");
		String sesMgr=(String)session.getAttribute("ses_mgr");
		
		boolean insertFlag=false;
		//세션의 값과 파라메터값이 같다면
		if(company.equals(sesCom)&&manager.equals(sesMgr)) {
			insertFlag=true;
		}else {
			//세션의 값과 파라메터 값이 같지 않다면
			session.setAttribute("ses_com",company);
			session.setAttribute("ses_mgr",manager);
		}
		
		
		//값을 VO에 저장
		NamecardVO nv=new NamecardVO(fileName, company, dept, manager, position, phone1+"-"+phone2+"-"+phone3, fax1+"-"+fax2+"-"+fax3, addr, email1+"@"+email2);
		//service로 전달${param.이름}
		NamecardAddService nas=new NamecardAddService();
		try {
			if(!insertFlag) { //세션의 값과 파라메터의 값이 다른경우에만 insert수행
				nas.addNamecard(nv);
			}
		//입력정보 중 몇가지를 출력하기 위해 scope객체에 넣는다
		request.setAttribute("com", company);
		request.setAttribute("comImg", fileName==null||"".equals(fileName)?"default.png":fileName);
		request.setAttribute("manager", manager);
		request.setAttribute("position", position);
		
		//이클립스를 가지고 실행할 때만 코드를 실행한다.
		//서비스를 할 경우에는(서버세팅하여 운용) 이 코드를 반드시 삭제하거나 주석처리한다.
		try {
			Thread.sleep(1500);
		}catch(InterruptedException ie) {
			ie.printStackTrace();
		}
		
		url="main/nc_add_success.jsp";
				forwardFlag=true;
		}catch(SQLException e) {
			e.printStackTrace();
			url="err/add_err.html";
			forwardFlag=false;
		}
		
	}//execute

	@Override
	public String moveURL() {
		return url;
	}//moveURL

	@Override
	public boolean isForward() {
		return forwardFlag;
	}//isForward

}
