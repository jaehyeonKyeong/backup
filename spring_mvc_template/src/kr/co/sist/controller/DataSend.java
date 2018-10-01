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
		//HttpServletRequest�� ����Ͽ� View�� ������ ����
		
		List<LateVO> list = new ArrayList<>();
		list.add(new LateVO("������","����� ������"));
		list.add(new LateVO("������","������ ��ž��"));
		list.add(new LateVO("���ҿ�","��⵵ ������ ���׵�"));
		list.add(new LateVO("������","��⵵ ������"));
		list.add(new LateVO("���渲","���Ǳ� ������"));
		
		//���� �������� �ʴ� ���
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
			m.addAttribute("name","���ֿ�");
			
		}catch (MalformedURLException me) {
			me.printStackTrace();
		}catch (IOException ie) {
			ie.printStackTrace();
		}//end catch
			
		return "day0919/model_view";
	}//useModel
	
	@RequestMapping(value="day0919/use_mav.do", method= {GET, POST})
	public ModelAndView useModelAndView() {
		//1. ModelAndView ��ü�� ����
		ModelAndView mav = new ModelAndView();
		//2. view ����
		mav.setViewName("day0919/mav_view");
		//3. ������ ����
		String[] subject= {"Java SE","Java EE", "HTML5", "jQuery", "Oracle"};
		String[] names= {"������","�����","�����","���ҿ�","������","�̻���"};
		
		mav.addObject("subject", subject);
		mav.addObject("names", names);
		
		return mav;
	}//useModelAndView
	
	//value�� �迭�� ������ �������� url�� �� ���� ó���� �� �ִ�.
	@RequestMapping(value= {"day0919/a.do","day0919/b.do","day0919/c.do","day0919/yana.do"}, method=GET)
	public String multiDo() {
		
		return "day0919/multi_result";
	}//multiDo
	
	//HttpSession���
	@RequestMapping(value="day0919/use_session",method=GET)
//	public String useHttpSession(HttpServletRequest request) {
//		//1.���Ǿ��
//		HttpSession session=request.getSession();
	public String useHttpSession(HttpSession session) {
		//2.������ �����ð� ����
		session.setMaxInactiveInterval(60*60);//�� ���� -> �� �ð�
		//3.���ǿ� �� ����
		session.setAttribute("name", "�����");
		session.setAttribute("addr", new String[] {"��⵵ ������ ������","����� ������ ���ﵿ �ѵ�����"});
		
		return "day0919/use_http_session";
	}//useHttpSession
	
	
	@RequestMapping(value="day0919/use_session_attr.do", method=GET)
	public String useSessionAttr(Model m) {
		m.addAttribute("name", "�赿��");
		m.addAttribute("date", new String[] {"2018-03-20","2018-10-16","1990-12-17","2018-05-05"});
		
		return "day0919/use_session_attr";
		
	}//useSessionAttr
	
	
	@RequestMapping(value="day0920/remove_session.do",method=GET)
	public String removeSession(SessionStatus ss) {
		ss.setComplete(); //������ ����� �Ϸ�Ǿ����Ƿ� �������� �Ҵ�� ������ ���� ��� �����ȴ�.
		return "day0920/remove_session";
	}//removeSession	
	
//	������ ���� �ڵ�δ� ������ �������� �ʴ´�.
//	public String removeSession(HttpSession session) {
//		session.removeAttribute("name");
//		session.invalidate(); //��ȿȭ
//		return "day0920/remove_session";
//	}//removeSession
	
	
	
	
	
}//class
