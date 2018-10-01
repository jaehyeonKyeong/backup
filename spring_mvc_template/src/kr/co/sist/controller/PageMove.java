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
		//WEB-INF/views 폴더가 아닌 Web Content에 존재하는 폴더를
		//찾아갈 때에는 이동할페이지 앞에 redirect:을 붙여준다.
		return "redirect:day0917/redirect_1.html";
	}//redirectHTML
	
	@RequestMapping(value="redirect_jsp.do", method=GET)
	public String redirectJSP() {
		//WEB-INF/views 폴더가 아닌 Web Content에 존재하는 폴더를
		//찾아갈 때에는 이동할페이지 앞에 redirect:을 붙여준다.
		return "redirect:day0917/redirect_2.jsp";
	}//redirectHTML
	
}//class
