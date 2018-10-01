package kr.co.sist;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET; 
import static org.springframework.web.bind.annotation.RequestMethod.POST;; 

@Controller
public class HelloController {
	
	@RequestMapping(value="index.do", method=GET)
	public String hello() {
		return "list";
	}//hello

	@RequestMapping(value="get.do", method=GET)
	public String get() {
		return "get";
	}//get
	
	@RequestMapping(value="post.do", method=POST)
	public String post() {
		return "day0917/post";
	}//post
	
	//�������� ��û����� �� ���� ó���Ϸ��� {}�� �ִ´�.
	@RequestMapping(value="get_post.do", method={GET, POST})
	public String getPost() {
		return "day0917/get_post";
	}//getPost
	
	//���� ��ο����� ��û : Controller�� ��� �ֵ� ��� ����, value������
	//�������ָ� �ȴ�.
	@RequestMapping(value="day0917/sub_dir.do", method=GET)
	public String subDir() {
		return "sub_dir";
	}//getPost
	
	
	
}//class
