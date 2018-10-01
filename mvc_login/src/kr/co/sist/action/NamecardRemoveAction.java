package kr.co.sist.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.sist.service.NamecardRemoveService;

/**
 * cmd : NC_U001<br>
 * 명함 변경
 * 
 * @author owner
 */
public class NamecardRemoveAction implements NamecardAction {
	private String url;
	private boolean forwardFlag;

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String nc_num = request.getParameter("nc_num");
		url = "err/delete_err.html";
		forwardFlag = false;
		if (nc_num != null) {
			try {
				
				int ncNum = Integer.parseInt(nc_num);
				NamecardRemoveService nrs=new NamecardRemoveService();
				boolean flag;
				try {
					flag = nrs.namecardRemove(ncNum);
					url="main/namecard_remove_result.jsp";
					forwardFlag=true;
					
					request.setAttribute("removeFlag", flag);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
			} catch (NumberFormatException nfe) {
				url = "err/delete_err.html";
				forwardFlag = false;
				nfe.printStackTrace();
			} 
		}

	}// execute

	@Override
	public String moveURL() {
		return url;
	}// moveURL

	@Override
	public boolean isForward() {
		return forwardFlag;
	}// isForward

}
