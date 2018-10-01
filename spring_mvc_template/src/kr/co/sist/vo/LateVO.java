package kr.co.sist.vo;

import lombok.Data;

@Data
public class LateVO {
	private String name,addr;

	public LateVO(String name, String addr) {
		this.name = name;
		this.addr = addr;
	}
	
	
}
