package kr.co.sist.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * cmd : NC_M001<br>
 * 모든 명함을 조회 (10건)
 * @author owner
 */
public class NamecardAddFormAction implements NamecardAction {
	private String url;
	private boolean forwardFlag;
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		url="main/namecard_frm.jsp";
		forwardFlag=true;
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
