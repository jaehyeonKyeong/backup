package kr.co.sist.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.io.IOException;

import org.springframework.stereotype.Controller;

@Controller //매개변수에 경로를 주면 RequestMapping에는 경로를 생략해도 된다
public class Forward {
	
	@RequestMapping(value="day0921/forward_a.do",method=GET)
	public String forwardA(String exe_file)  {
		//실행되는 자바에서 외부 프로그램 실행 하기(runtime,process)
		//1.실행할 파일명 설정
		StringBuilder exeFile=new StringBuilder();
		exeFile.append("c:/windows/system32/").append(exe_file).append(".exe");
		//2.실행 환경 정보를 가져오는 클래스 (Runtime)생성
		Runtime rt=Runtime.getRuntime();
		//3.실행파일의 경로 설정하여 Process를 얻는다
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
