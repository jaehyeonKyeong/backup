package kr.co.sist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class PageMove {
	
	/**
	 * @return
	 */
	@RequestMapping(value="redirect_html.do", method=GET)
	public String redirectHTML() {
		//WEB-INF/views ������ �ƴ� Web Content�� �����ϴ� ������
		//ã�ư� ������ �̵��������� �տ� redirect:�� �ٿ��ش�.
		return "redirect:day0917/redirect_1.html";
	}//redirectHTML
	
	@RequestMapping(value="redirect_jsp.do", method=GET)
	public String redirectJSP() {
		//WEB-INF/views ������ �ƴ� Web Content�� �����ϴ� ������
		//ã�ư� ������ �̵��������� �տ� redirect:�� �ٿ��ش�.
		return "redirect:day0917/redirect_2.jsp";
	}//redirectHTML
	
}//class
