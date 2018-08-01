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
 * �Է¹��� ����� �̹����� �����ϴ� ��
 * java.awt.Image - �̹����� ��ü�� ����
 * java.awt.Graphics - �̹����� �����۾�(ũ�Ⱑ ����� �̹����� �׸��� ��)
 * java.awt.BufferedImage - �̹����۾��� ���� ó���ӵ��� �����ϴ� ��
 * javax.imageio.ImageIO - �̹����� �о���̰ų�, ������ �̹����� �������� ��
 * @author owner
 *
 */
public class ImageResize {
	
	public static boolean imgResize(Component comp,String path) throws IOException { //w(122) x h(110)
		boolean flag=false;
		File readFile=new File(path); 
		
		if(!readFile.exists()) {
			JOptionPane.showMessageDialog(comp, "���� �̹����� �������� �ʽ��ϴ�.");
			return flag;
		}//end if
		
		//1. ���� �̹����� �о���δ�.
		BufferedImage original=ImageIO.read(readFile);
		//2. ũ�⸦ �������� ��ü ����
		//Image.SCALE_SMOOTH-�����̹����� ������ �̹����� ũ�⸦ �����Ͽ� ����
		Image resizeImg=original.getScaledInstance(122, 110, Image.SCALE_SMOOTH);
		//3. ���� �׸� �̹��� ��ü ���� - ������ ���� ũ��� ����� ���� ����
		BufferedImage newImg=new BufferedImage(122, 110, BufferedImage.TYPE_INT_RGB);
		//4. ���� �׸� �̹��� ��ü�� �̹��� ����
		Graphics g=newImg.getGraphics();
		//���� �׸� �̹����� �о���� �̹����� �־� �̹����� �׸���. 
		g.drawImage(resizeImg, 0, 0, null); 
		//�̹����� �� �׷����� Graphics��ü�� �Ҵ�� �ڿ��� �����Ѵ�. 
		g.dispose();
		//5. ������ �̹���(ũ�⺯��� �̹���)�� ������ ������ ���
		flag=ImageIO.write(newImg, "gif", 
				new File(readFile.getParent()+"/s_"+readFile.getName()));
		
		
		return flag;
	}//imgResize
	
}//class






