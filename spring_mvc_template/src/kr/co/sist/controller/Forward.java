package kr.co.sist.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.io.IOException;

import org.springframework.stereotype.Controller;

@Controller //�Ű������� ��θ� �ָ� RequestMapping���� ��θ� �����ص� �ȴ�
public class Forward {
	
	@RequestMapping(value="day0921/forward_a.do",method=GET)
	public String forwardA(String exe_file)  {
		//����Ǵ� �ڹٿ��� �ܺ� ���α׷� ���� �ϱ�(runtime,process)
		//1.������ ���ϸ� ����
		StringBuilder exeFile=new StringBuilder();
		exeFile.append("c:/windows/system32/").append(exe_file).append(".exe");
		//2.���� ȯ�� ������ �������� Ŭ���� (Runtime)����
		Runtime rt=Runtime.getRuntime();
		//3.���������� ��� �����Ͽ� Process�� ��´�
		Process proc;
		try {
			proc = rt.exec(exeFile.toString());
			proc.waitFor();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return "forward:forward_b.do";
	}
	@RequestMapping(value="day0921/forward_b.do",method=GET)
	public String forwardB(String exeFile) {
		
		System.out.println("forwardB------");
		
		return "day0921/forward_chain";
	}
}
