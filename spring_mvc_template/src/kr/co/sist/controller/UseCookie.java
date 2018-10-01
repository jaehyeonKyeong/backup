package kr.co.sist.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class UseCookie {
	@RequestMapping(value="day0921/add_cookie.do",method=GET)
	public String addCookie(HttpServletResponse response) {
		//1.ÄíÅ° »ý¼º
		Cookie cookieName=new Cookie("name", "donghee");
		Cookie cookieAge=new Cookie("age", "29");
		//2.ÄíÅ° »ýÁ¸½Ã°£
		cookieName.setMaxAge(60*60*24*7);
		cookieAge.setMaxAge(60*60*24*7);
		//3.ÄíÅ° ½É±â
		response.addCookie(cookieName);
		response.addCookie(cookieAge);
		
		return "day0921/cookie_result";
	}
	@RequestMapping(value="day0921/read_cooke.do",method=GET)
	public String readCookie(@CookieValue(defaultValue="name")String name,@CookieValue(value="age")String age,Model model){
		model.addAttribute("c_name",name);
		model.addAttribute("c_age",age);
		return "day0921/read_cookie";
	}

}
