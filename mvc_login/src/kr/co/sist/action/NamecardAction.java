package kr.co.sist.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface NamecardAction {
	public void execute(HttpServletRequest request,HttpServletResponse response)	throws IOException,ServletException;
	public String moveURL();
	public boolean isForward();  
}





