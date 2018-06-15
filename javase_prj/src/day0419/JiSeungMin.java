package day0419;

import java.util.Random;

public class JiSeungMin {
	
	public String walking() throws TabaccoException {
		String[] stuArr= {"초딩","중딩","고딩"};
		String stu=stuArr[new Random().nextInt(stuArr.length)];
		if(stu.equals("초딩")) {
			//강제로 발생된 예외는 반드시 try~catch또는 throws(권장)를 해야한다.
			throw new TabaccoException("처..처딩님 금연좀..");
		}
		return stu+"님 흡연중 모르는 척 지나간다.('' )( '') ";
	}

}
