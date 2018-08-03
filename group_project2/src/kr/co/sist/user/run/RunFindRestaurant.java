package kr.co.sist.user.run;

import java.io.File;

import kr.co.sist.user.view.Login;
public class RunFindRestaurant {

	public static void main(String[] args) {
		//img를 올릴 폴더 생성
		File imgDir=new File("C:/run_group3/img");
		if(!imgDir.exists()) {
			imgDir.mkdirs();
		}
		new Login();
		
		
	}

}
