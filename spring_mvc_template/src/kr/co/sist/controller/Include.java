package kr.co.sist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.Random;

@Controller
public class Include {
	@RequestMapping(value="day0920/include_jsp.do",method=GET)
	public String viewInclude(Model model) {
		model.addAttribute("name","강소예");
		model.addAttribute("addr","경기도 수원시 장안구");
	//데이터 처리결과가 아닌 디자인만 가직 잇는 jsp를 include
		
		return "day0920/include_jsp";
	}//viewInclude
	
	@RequestMapping(value="day0920/name_data.do", method=GET)
	public String nameData(Model model) {
		model.addAttribute("names",new String[] {"이종민","배수진","경제현"});
		
		return "day0920/names_data";
	}//nameData
	
	//.do를 include(데이터처리된 jsp를 include)
	@RequestMapping(value="day0920/do_include.do", method=GET)
	public String doInclude() {
		
		return "day0920/do_jsp";
	}//doInclude
	
	
	@RequestMapping(value="day0920/exception.do",method=GET)
	public String data(Model model) throws ClassNotFoundException{
		String className="java.lang.String";
		if(new Random().nextBoolean()) {
			className="java.lang.string";
		}//end if
		
		Class<String> cls=(Class<String>)Class.forName(className);
		model.addAttribute("name",cls.getName());
		model.addAttribute("canonical_name",cls.getCanonicalName());//CanonicalName->대문자로 썼을 때 접근하는 것
		
		
		return "day0920/success";
		
	}//data
	
	
	//현재 클래스안에서 어떤 method든 throws ClassNotFoundException을 날리면 이 method가 해당 예외를 처리한다.
	@ExceptionHandler(ClassNotFoundException.class)
	//반환형이 ModelAndView이어야하고, 매개변수가 예외처리 객체이어야 한다.
	public ModelAndView exceptionHandling(ClassNotFoundException cnfe) {
		ModelAndView mav=new ModelAndView();
		
		mav.setViewName("day0920/exception");
		mav.addObject("msg1",cnfe.getMessage()); //예외 메세지
		mav.addObject("msg2",cnfe.toString()); //예외발생클래스와 간단한 메세지
		mav.addObject("obj",cnfe);
		
		
		return mav;
	}//exceptionHamlding
	
	
}//class
