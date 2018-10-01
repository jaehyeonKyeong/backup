package day0914;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Songs {
	
	@Autowired
	private KangJiHyoung kjh;
	
	public KangJiHyoung getKjh() {
		return kjh;
	}
}
