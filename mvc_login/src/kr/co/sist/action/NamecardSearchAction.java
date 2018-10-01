package kr.co.sist.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.sist.service.NamecardSearchService;
import kr.co.sist.vo.NamecardAllVO;

/**
 * cmd : NC_S001<br>
 * 선택된 명함의 상세조회 업무
 * @author owner
 */
public class NamecardSearchAction implements NamecardAction {
	private String url;
	private boolean forwardFlag;
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String nc_num=request.getParameter("nc_num");
		int intNcNum=0;
		if(nc_num ==null) { // parameter 외부 조작 (parameter 제거)
			url="index.html";
			forwardFlag=false;
		}else {
			try {
				intNcNum=Integer.parseInt(nc_num);
				
				NamecardSearchService ns=new NamecardSearchService();
				
				NamecardAllVO nav=ns.searchNamecard(intNcNum);
				//업무처리한 결과 받기
				request.setAttribute("ncData", nav);
				url="main/namecard_search.jsp";
				forwardFlag=true;
				
			}catch(NumberFormatException nfe) {// parameter 외부 조작 (parameter의 값을 문자열로)
				url="index.html";
				forwardFlag=false;
			}
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
