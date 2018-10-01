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
 * 전체명함을 조회하기 위한 폼 
 * @author owner
 */
public class NamecardListAction implements NamecardAction {
	private String url;
	private boolean forwardFlag;
	
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		String tempPage=request.getParameter("current_page");
				
		int currentPage=1; //기본 1페이지
		if(tempPage !=null) {
			currentPage=Integer.parseInt(tempPage);
		}//end if
		
		NamecardService ns=new NamecardService();
		List<NCListVO> list=ns.searchNc(currentPage);//명함목록
		int totalCount =ns.getTotalCount();//전체 글의 수
		int pageScale=ns.getPageScale();//한 화면에 보여줄 게시물의 수
		int totalPage=ns.totalPage(totalCount, pageScale);//전체 페이지 수
		
		String list_url="namecard_list.do?cmd=NC_M001";
		//페이지 하단 인덱스 리스트 얻기 EX:[1][2][3]
		String indexList=ns.indexList(currentPage, totalPage, list_url);
		
		
		//NamecardService가 업무를 처리한 결과를 받았다.
		//받은 데이터를 보여주기 위해서 JSP로 보내야 한다(scope객체 필요)
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
