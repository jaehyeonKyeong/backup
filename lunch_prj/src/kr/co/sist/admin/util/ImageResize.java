package kr.co.sist.admin.util;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 * 입력받은 경로의 이미지를 변경하는 일 java.awt.Image - 이미지를 객체로 생성 java.awt.Graphics- 이미지의
 * 실제작업(크기가변경된 이미지를 그리는 일) javax.imageio.ImageIO - 이미지를 읽어 들이거나, 생성된 이미지를 내보내는 일
 * java.awt.BufferedImage - 이미지작업에 대한 처리 속도 개선
 * 
 * @author owner
 */
public class ImageResize {
	public static boolean imgResize(Component comp, String path) throws IOException {// w122*h110 , (큰)244 220
		boolean flag = false;
		File readFile = new File(path);
		if (!readFile.exists()) {
			JOptionPane.showMessageDialog(comp, "원본이미지가 존재하지 않습니다");
			return flag;
		}
		// 1. 이미지를 읽어들인다
		BufferedImage original = ImageIO.read(readFile);
		// 2. 크기를 변경해줄 객체 생성
		// Image.SCALE_SMOOTH - 원본이미지에 가깝게 이미지의 크기를 변경할때 생성
		Image resizeImg = original.getScaledInstance(122, 110, Image.SCALE_SMOOTH);
		// 3. 새로 그릴 이미지 객체를 생성 - 내용은 없고 크기와 사용할 RGB색상을 설정
		BufferedImage newImg = new BufferedImage(122, 110, BufferedImage.TYPE_INT_RGB);
		Graphics g = newImg.getGraphics();
		// 새로 그릴 이미지에 읽어들인 이미지를 넣어 이미지를 그린다.
		g.drawImage(resizeImg, 0, 0, null);
		// 이미지를 다 그렸으면 그래픽스 객체에 할당된 자원을 해제한다.
		g.dispose();
		//5. 새로생성한 이미지를 지정한 폴더에 기록
		flag=ImageIO.write(newImg, "gif", new File(readFile.getParent()+"/s_"+readFile.getName()));

		return flag;
	}
}
