package kr.co.sist.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.filter.ServletContextRequestLoggingFilter;

@Controller
public class ParameterProcess {
	
	@RequestMapping(value="use_request.do", method=GET)
	public String useRequestForm(){
		//�Է��� ������ �̵� : redirect
		return "redirect:day0918/request_form.html";
	}//useRequestForm
	
	@RequestMapping(value="day0918/use_request_process.do", method= {GET,POST})
	public String useRequestFormProcess(HttpServletRequest request)throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String[] subject = request.getParameterValues("subject");
		
		System.out.println(name+age);
		System.out.println("������ ����");
		if(subject != null) {
			for( int i=0; i<subject.length; i++) {
				System.out.println(subject[i]);
			}
		}else {
			System.out.println("�Ӹ��� ���� ���� ����");
		}//end else
		
		return "day0918/request_result";
	}
	
	@RequestMapping(value="use_param.do", method=GET)
	public String useParamForm(){
		//������ ����� �Է� �� ������ �̵� : forward
		return "day0918/request_param";
	}//useParamForm
	
	//HttpServletRequest�� ������� �ʰ� HTML Form Control�� �̸���
	//method parameter���� ���ٸ�
	@RequestMapping(value="use_param_process.do", method= {GET, POST})
	public String useParamProcess(@RequestParam(defaultValue="�ѵ�")String name,@RequestParam(defaultValue="0") int age, String[] subject) throws UnsupportedEncodingException  {
		
		System.out.println("�Ű����� ���"+name+age);
		System.out.println("������ ����");
		if(subject != null) {
			for( int i=0; i<subject.length; i++) {
				System.out.println(subject[i]);
			}
		}else {
			System.out.println("�Ӹ��� ���� ���� ����");
		}//end else
		
		return "day0918/param_result";
	}//useParamProcess
	
	@RequestMapping(value="use_vo.do", method=GET)
	public String useVO(){
		//������ ����� �Է� �� ������ �̵� : forward
		return "day0918/vo_param";
	}//useParamForm
	
	@RequestMapping(value="use_vo_process.do", method= {GET, POST})
	public String useVOProcess(){
		//������ ����� �Է� �� ������ �̵� : forward
		return "day0918/vo_result";
	}//useParamForm
	
	
}//class
