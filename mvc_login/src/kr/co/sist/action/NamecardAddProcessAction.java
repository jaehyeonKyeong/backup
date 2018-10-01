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
 * �Էµ� ������ DB�� �߰��ϴ� ����
 * @author owner
 */
public class NamecardAddProcessAction implements NamecardAction {
	private String url;
	private boolean forwardFlag;
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		//���� ���ε尡 ����ǵ��� MultipartRequest�� ����Ѵ�.
		//MultipartRequest�� ���� ���ϸ��� ������ ��� �ߺ����Ͽ� ���� ó���� �������ش�.
		String repository="C:/dev/workspace/mvc_login/WebContent/upload";
//		String repository="C:/web/mvc_login/upload";
		int maxSize=1024*1024*10;//Byte KByte MB
 		//���� ���ε尡 ����ȴ�
		MultipartRequest mr=new MultipartRequest(request, repository, maxSize, "UTF-8", new DefaultFileRenamePolicy());
		//encType="multipart/form-data"�϶����� parameter���۹���� �ƴϹǷ�request.getParameter�� ����� �� ����.(URL�ڿ� ���̴°��� �����ϴ�)
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
		
		//input type=file �� getparameter�� ���� �� ����
		//FilesystemName �Ǵ� OriginalName���� ���� �� �ִ�.
		
		String fileName=mr.getFilesystemName("file");
		
		//���ΰ�ħ�� �ߺ������Ͱ� �߰� �Ǵ� ���� ���� ���ؼ� session�� ����Ѵ�.
		//1.session���
		HttpSession session=request.getSession();
		//2.session���� value���
		String sesCom=(String)session.getAttribute("ses_com");
		String sesMgr=(String)session.getAttribute("ses_mgr");
		
		boolean insertFlag=false;
		//������ ���� �Ķ���Ͱ��� ���ٸ�
		if(company.equals(sesCom)&&manager.equals(sesMgr)) {
			insertFlag=true;
		}else {
			//������ ���� �Ķ���� ���� ���� �ʴٸ�
			session.setAttribute("ses_com",company);
			session.setAttribute("ses_mgr",manager);
		}
		
		
		//���� VO�� ����
		NamecardVO nv=new NamecardVO(fileName, company, dept, manager, position, phone1+"-"+phone2+"-"+phone3, fax1+"-"+fax2+"-"+fax3, addr, email1+"@"+email2);
		//service�� ����${param.�̸�}
		NamecardAddService nas=new NamecardAddService();
		try {
			if(!insertFlag) { //������ ���� �Ķ������ ���� �ٸ���쿡�� insert����
				nas.addNamecard(nv);
			}
		//�Է����� �� ����� ����ϱ� ���� scope��ü�� �ִ´�
		request.setAttribute("com", company);
		request.setAttribute("comImg", fileName==null||"".equals(fileName)?"default.png":fileName);
		request.setAttribute("manager", manager);
		request.setAttribute("position", position);
		
		//��Ŭ������ ������ ������ ���� �ڵ带 �����Ѵ�.
		//���񽺸� �� ��쿡��(���������Ͽ� ���) �� �ڵ带 �ݵ�� �����ϰų� �ּ�ó���Ѵ�.
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
