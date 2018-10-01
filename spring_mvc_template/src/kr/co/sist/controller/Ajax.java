package kr.co.sist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;;

@Controller
public class Ajax {
	Map<String, String> colorMap=new HashMap<String,String>();
	{
		colorMap.put("빨강"," 외향적인 사람이 선호 - 소심증 우울증치료에 사용.-주의집중을 분산시켜 발산하게 한다. 자극적, 자극유발, 불의색, 생명의 상징, 삶을 고양시키는 통로");
		colorMap.put("노랑","유아적 성향, 부모에 의한 의존성, 뛰어난 상상력, 생각들이 잘 정리 마음을 털어 놓지않고 실행보다 이론에 집중,정신적 외톨이, 은밀, 수줍어하고, 존경받기를 갈망하는마음.");
		colorMap.put("초록","- 생명력, 안심, 진정, 긴장이완, 묵상, 균형있는아이 - 초록을 통해 피곤을 회복하고 기분을 안정시키며 온화한 상태로 균형 잇는 안정감을 주는색");
		colorMap.put("파랑","빨강과 반대의 성질 - 식물의 성장을 지연, 호르몬의 활동을 감퇴.  상실과 재생의 마음, 신중, 내성적, 보수적, 절망, 이별, 고독, 우울, 자기탐구, 정화, 내적성장, 치유, 자립, 희망 모범적인, 솔직, 도덕적.");
		colorMap.put("보라","회복하려하는 생명력이 나타나 있는것이다. 고통을 치유의 힘으로- 침체된 우울한기분, 체험을 가진 불행한 아동,(알슐러와 하트위크), 정서불안을 가져오는 몸의기능 저하(막스륙사), 심신의 기능저하, 병약한 색, 재치, 관찰능력, 허영심, 예술적 창조성, 허무.");
		colorMap.put("분홍","행복의 에너지, 여성의 이미지, 달콤함, 행복감. ");
	}//instance
	
	@RequestMapping(value="day0920/use_jsp.do", method=GET)
	public String useJsp(String color, Model model) {
		
		JSONObject jo = new JSONObject();
		String temp = "색 정보를 찾을 수 없습니다.";
		if(colorMap.containsKey(color)) {
			temp=colorMap.get(color);
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
		
		jo.put("selectColor", temp);
		jo.put("time", sdf.format(new Date()));
		
		model.addAttribute("json_obj", jo);
		
		return "day0920/ajax_view";
	}//useJsp
	
	@RequestMapping(value="day0921/use_response_body.do",method=GET)
	@ResponseBody
	public String useResponseBody() throws UnsupportedEncodingException {
		
		JSONObject jo=new JSONObject();
		//보여줄 Jsp와 charset이 맞지 않기 때문에 java파일 자체의 charset을 jsp와 동일하게 맞춰 주든지 아니면, 데이터만 jsp와 동일하게
		//맞춰 주어야 한다.
		jo.put("name",URLEncoder.encode("송재원","UTF-8"));
		JSONArray ja=new JSONArray();
		String[] subject= {"javaSE","DBMS-Oracle","JDBC","HTML","css","JavaScript","jquery","servlet","jsp","jstl","xml","json","mybatis","spring","tomcat "};
		
		JSONObject tempJo=null;
		for(String temp:subject) {
			tempJo=new JSONObject();
			tempJo.put("subject", temp);
			ja.add(tempJo);
		}
		
		jo.put("subject_arr", ja);
		//{"name":"송재원","subject_arr":[{"subject":"java"},{"subject":"jsp"}...]}
		
		return jo.toJSONString();
	}//useResponseBody
}
