package kr.co.sist.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.sist.service.NamecardModifyService;
import kr.co.sist.vo.NamecardModifyVO;

/**
 * cmd : NC_U001<br>
 * 명함 변경
 * @author owner
 */
public class NamecardModfiyAction implements NamecardAction {
	private String url;
	private boolean forwardFlag;
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
			String ncNum=request.getParameter("nc_num");
			String dept=request.getParameter("dept");
			String manager=request.getParameter("manager");
			String email1=request.getParameter("email1");
			String email2=request.getParameter("email2");
			String position=request.getParameter("position");
			
			NamecardModifyVO nmv=new NamecardModifyVO(Integer.parseInt(ncNum),dept,manager,email1+"@"+email2,position);
			
			NamecardModifyService nms=new NamecardModifyService();
			try {
				boolean flag=nms.namecardModify(nmv);
				url="main/namecard_modify_result.jsp";
				forwardFlag=true;
				request.setAttribute("modifyFlag", flag);
			} catch (SQLException e) {
				e.printStackTrace();
				url="err/err_modify.html";
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
