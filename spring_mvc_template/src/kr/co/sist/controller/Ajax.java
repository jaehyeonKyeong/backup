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
		colorMap.put("����"," �������� ����� ��ȣ - �ҽ��� �����ġ�ῡ ���.-���������� �л���� �߻��ϰ� �Ѵ�. �ڱ���, �ڱ�����, ���ǻ�, ������ ��¡, ���� ����Ű�� ���");
		colorMap.put("���","������ ����, �θ� ���� ������, �پ ����, �������� �� ���� ������ �о� �����ʰ� ���ຸ�� �̷п� ����,������ ������, ����, ���ݾ��ϰ�, ����ޱ⸦ �����ϴ¸���.");
		colorMap.put("�ʷ�","- �����, �Ƚ�, ����, �����̿�, ����, �����ִ¾��� - �ʷ��� ���� �ǰ��� ȸ���ϰ� ����� ������Ű�� ��ȭ�� ���·� ���� �մ� �������� �ִ»�");
		colorMap.put("�Ķ�","������ �ݴ��� ���� - �Ĺ��� ������ ����, ȣ������ Ȱ���� ����.  ��ǰ� ����� ����, ����, ������, ������, ����, �̺�, ��, ���, �ڱ�Ž��, ��ȭ, ��������, ġ��, �ڸ�, ��� �������, ����, ������.");
		colorMap.put("����","ȸ���Ϸ��ϴ� ������� ��Ÿ�� �ִ°��̴�. ������ ġ���� ������- ħü�� ����ѱ��, ü���� ���� ������ �Ƶ�,(�˽����� ��Ʈ��ũ), �����Ҿ��� �������� ���Ǳ�� ����(��������), �ɽ��� �������, ������ ��, ��ġ, �����ɷ�, �㿵��, ������ â����, �㹫.");
		colorMap.put("��ȫ","�ູ�� ������, ������ �̹���, ������, �ູ��. ");
	}//instance
	
	@RequestMapping(value="day0920/use_jsp.do", method=GET)
	public String useJsp(String color, Model model) {
		
		JSONObject jo = new JSONObject();
		String temp = "�� ������ ã�� �� �����ϴ�.";
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
		//������ Jsp�� charset�� ���� �ʱ� ������ java���� ��ü�� charset�� jsp�� �����ϰ� ���� �ֵ��� �ƴϸ�, �����͸� jsp�� �����ϰ�
		//���� �־�� �Ѵ�.
		jo.put("name",URLEncoder.encode("�����","UTF-8"));
		JSONArray ja=new JSONArray();
		String[] subject= {"javaSE","DBMS-Oracle","JDBC","HTML","css","JavaScript","jquery","servlet","jsp","jstl","xml","json","mybatis","spring","tomcat "};
		
		JSONObject tempJo=null;
		for(String temp:subject) {
			tempJo=new JSONObject();
			tempJo.put("subject", temp);
			ja.add(tempJo);
		}
		
		jo.put("subject_arr", ja);
		//{"name":"�����","subject_arr":[{"subject":"java"},{"subject":"jsp"}...]}
		
		return jo.toJSONString();
	}//useResponseBody
}
