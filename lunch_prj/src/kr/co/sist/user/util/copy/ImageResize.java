package kr.co.sist.user.util.copy;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 * �Է¹��� ����� �̹����� �����ϴ� ��</br>
 * java.awt.Image - �̹����� ��ü�� ����</br>
 * java.awt.Graphics - �̹����� �����۾�(ũ�Ⱑ ����� �̹����� �׸��� ��)</br>
 * java.awt.BufferedImage- �̹��� �۾��� ���� ó�� �ӵ��� �����ϴ� ��</br>
 * javax.imageio.ImageIO-�̹����� �о���̰ų�, ������ �̹����� �������� ��</br>
 * 
 * 
 * @author ������
 *
 */
public class ImageResize {
	public static boolean imgResize(Component comp, String path) throws IOException {// w(244) xh(220)
		boolean flag = false;
		File readFile = new File(path);
		if (!readFile.exists()) {
			JOptionPane.showMessageDialog(comp, "���� �̹����� �������� �ʽ��ϴ�.");
			return flag;

		} // end if

		// 1. ���� �̹����� �о���δ�.
		BufferedImage original = ImageIO.read(readFile);
		// 2. ũ�⸦ �������� ��ü�� ����
		// Image.SCALE_SMOOTH : ���� �̹����� ������ �̹����� ũ�⸦ �����Ͽ� ����
		Image resizeImg = original.getScaledInstance(244, 220, Image.SCALE_SMOOTH);

		// 3. ���� �׸� �̹��� ��ü ���� : ������ ���� ũ��� ����� ������ ����
		BufferedImage newImg = new BufferedImage(244, 220, BufferedImage.TYPE_INT_RGB);

		// 4. ���α׸� �̹��� ��ü�� �̹��� ����
		Graphics g = newImg.getGraphics();
		// ���� �׸� �̹����� �о���� �̹����� �־� �̹����� �׸���.
		g.drawImage(resizeImg, 0, 0, null);
		// �̹����� �� �׷����� Graphics ��ü�� �Ҵ�� �ڿ��� �����Ѵ�.
		g.dispose();
		// 5.���� ������ �̹����� ������ ������ ���
		flag = ImageIO.write(newImg, "gif", new File
				(readFile.getParent() +"/"+ readFile.getName().substring(2)));

		return flag;
	}// imgResize
}// class
