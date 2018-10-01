package kr.co.sist.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import kr.co.sist.vo.LateVO;
@SessionAttributes({"name","date"})
@Controller
public class DataSend {
	
	@RequestMapping(value="day0919/use_request.do",method= {GET, POST})
	public String useRequest(HttpServletRequest request) {
		//HttpServletRequest를 사용하여 View로 데이터 전달
		
		List<LateVO> list = new ArrayList<>();
		list.add(new LateVO("이종민","서울시 광진구"));
		list.add(new LateVO("강지형","성남시 야탑동"));
		list.add(new LateVO("강소예","경기도 수원시 송죽동"));
		list.add(new LateVO("경제현","경기도 구리시"));
		list.add(new LateVO("오경림","관악구 낙성대"));
		
		//제일 권장하지 않는 방법
		request.setAttribute("late_list", list);
		
		return "day0919/request_view";
	}//useRequest
	
	@RequestMapping(value="day0919/use_model.do",method= {GET,POST})
	public String useModel(Model m) {
		
		try {
		URL url=new URL("https://www.bloodinfo.net/bloodstats_stocks.do");
			InputStream is=url.openStream() ;
			InputStreamReader isr=new InputStreamReader(is,"euc-kr");
			BufferedReader br=new BufferedReader(isr);
			String str="";
			int i=0;
			StringBuilder temp=new StringBuilder();
			while((str=br.readLine())!= null) {
				if(i >=390 && i <= 452) {
					temp.append(str+"\n");
				}
				i++;
			}
			
			String scraping=temp.toString();
			scraping=scraping.replaceAll("<img src=\"", "<img src=\"https://www.bloodinfo.net/");
			
			m.addAttribute("blood", scraping);
			m.addAttribute("name","최주오");
			
		}catch (MalformedURLException me) {
			me.printStackTrace();
		}catch (IOException ie) {
			ie.printStackTrace();
		}//end catch
			
		return "day0919/model_view";
	}//useModel
	
	@RequestMapping(value="day0919/use_mav.do", method= {GET, POST})
	public ModelAndView useModelAndView() {
		//1. ModelAndView 객체를 생성
		ModelAndView mav = new ModelAndView();
		//2. view 설정
		mav.setViewName("day0919/mav_view");
		//3. 데이터 설정
		String[] subject= {"Java SE","Java EE", "HTML5", "jQuery", "Oracle"};
		String[] names= {"신종성","배수진","송재원","강소예","경제현","이상훈"};
		
		mav.addObject("subject", subject);
		mav.addObject("names", names);
		
		return mav;
	}//useModelAndView
	
	//value를 배열로 넣으면 여러개의 url을 한 번에 처리할 수 있다.
	@RequestMapping(value= {"day0919/a.do","day0919/b.do","day0919/c.do","day0919/yana.do"}, method=GET)
	public String multiDo() {
		
		return "day0919/multi_result";
	}//multiDo
	
	//HttpSession사용
	@RequestMapping(value="day0919/use_session",method=GET)
//	public String useHttpSession(HttpServletRequest request) {
//		//1.세션얻기
//		HttpSession session=request.getSession();
	public String useHttpSession(HttpSession session) {
		//2.세션의 생존시간 설정
		session.setMaxInactiveInterval(60*60);//초 기준 -> 한 시간
		//3.세션에 값 설정
		session.setAttribute("name", "송재원");
		session.setAttribute("addr", new String[] {"경기도 성남시 수정구","서울시 강남구 역삼동 한독빌딩"});
		
		return "day0919/use_http_session";
	}//useHttpSession
	
	
	@RequestMapping(value="day0919/use_session_attr.do", method=GET)
	public String useSessionAttr(Model m) {
		m.addAttribute("name", "김동희");
		m.addAttribute("date", new String[] {"2018-03-20","2018-10-16","1990-12-17","2018-05-05"});
		
		return "day0919/use_session_attr";
		
	}//useSessionAttr
	
	
	@RequestMapping(value="day0920/remove_session.do",method=GET)
	public String removeSession(SessionStatus ss) {
		ss.setComplete(); //세션의 사용이 완료되었으므로 브라우저에 할당된 세션의 값이 모두 삭제된다.
		return "day0920/remove_session";
	}//removeSession	
	
//	기존의 삭제 코드로는 세션이 삭제되지 않는다.
//	public String removeSession(HttpSession session) {
//		session.removeAttribute("name");
//		session.invalidate(); //무효화
//		return "day0920/remove_session";
//	}//removeSession
	
	
	
	
	
}//class
