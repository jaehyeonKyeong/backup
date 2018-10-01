package kr.co.sist.action;

import java.io.IOException;
import java.util.List;

import javax.print.attribute.standard.RequestingUserName;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.sist.service.NamecardService;
import kr.co.sist.vo.NCListVO;

/**
 * cmd : NC_M001<br>
 * ��ü������ ��ȸ�ϱ� ���� �� 
 * @author owner
 */
public class NamecardListAction implements NamecardAction {
	private String url;
	private boolean forwardFlag;
	
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		String tempPage=request.getParameter("current_page");
				
		int currentPage=1; //�⺻ 1������
		if(tempPage !=null) {
			currentPage=Integer.parseInt(tempPage);
		}//end if
		
		NamecardService ns=new NamecardService();
		List<NCListVO> list=ns.searchNc(currentPage);//���Ը��
		int totalCount =ns.getTotalCount();//��ü ���� ��
		int pageScale=ns.getPageScale();//�� ȭ�鿡 ������ �Խù��� ��
		int totalPage=ns.totalPage(totalCount, pageScale);//��ü ������ ��
		
		String list_url="namecard_list.do?cmd=NC_M001";
		//������ �ϴ� �ε��� ����Ʈ ��� EX:[1][2][3]
		String indexList=ns.indexList(currentPage, totalPage, list_url);
		
		
		//NamecardService�� ������ ó���� ����� �޾Ҵ�.
		//���� �����͸� �����ֱ� ���ؼ� JSP�� ������ �Ѵ�(scope��ü �ʿ�)
		request.setAttribute("nameList", list);
		request.setAttribute("nameIndexList", indexList);
		
		
		
		url="main/namecard_main.jsp";
		forwardFlag=true;
		
	}//execute

	public String moveURL() {
		return url;
	}//moveURL

	public boolean isForward() {
		return forwardFlag;
	}//isForward

}
