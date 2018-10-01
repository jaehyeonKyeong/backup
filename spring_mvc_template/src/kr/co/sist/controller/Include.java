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
		model.addAttribute("name","���ҿ�");
		model.addAttribute("addr","��⵵ ������ ��ȱ�");
	//������ ó������� �ƴ� �����θ� ���� �մ� jsp�� include
		
		return "day0920/include_jsp";
	}//viewInclude
	
	@RequestMapping(value="day0920/name_data.do", method=GET)
	public String nameData(Model model) {
		model.addAttribute("names",new String[] {"������","�����","������"});
		
		return "day0920/names_data";
	}//nameData
	
	//.do�� include(������ó���� jsp�� include)
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
		model.addAttribute("canonical_name",cls.getCanonicalName());//CanonicalName->�빮�ڷ� ���� �� �����ϴ� ��
		
		
		return "day0920/success";
		
	}//data
	
	
	//���� Ŭ�����ȿ��� � method�� throws ClassNotFoundException�� ������ �� method�� �ش� ���ܸ� ó���Ѵ�.
	@ExceptionHandler(ClassNotFoundException.class)
	//��ȯ���� ModelAndView�̾���ϰ�, �Ű������� ����ó�� ��ü�̾�� �Ѵ�.
	public ModelAndView exceptionHandling(ClassNotFoundException cnfe) {
		ModelAndView mav=new ModelAndView();
		
		mav.setViewName("day0920/exception");
		mav.addObject("msg1",cnfe.getMessage()); //���� �޼���
		mav.addObject("msg2",cnfe.toString()); //���ܹ߻�Ŭ������ ������ �޼���
		mav.addObject("obj",cnfe);
		
		
		return mav;
	}//exceptionHamlding
	
	
}//class
