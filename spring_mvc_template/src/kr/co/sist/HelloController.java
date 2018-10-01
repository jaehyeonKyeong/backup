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
	
	//여러개의 요청방식을 한 번에 처리하려면 {}로 넣는다.
	@RequestMapping(value="get_post.do", method={GET, POST})
	public String getPost() {
		return "day0917/get_post";
	}//getPost
	
	//하위 경로에대한 요청 : Controller가 어디에 있든 상관 없고, value에서만
	//변경해주면 된다.
	@RequestMapping(value="day0917/sub_dir.do", method=GET)
	public String subDir() {
		return "sub_dir";
	}//getPost
	
	
	
}//class
