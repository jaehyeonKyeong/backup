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
 * �Է¹��� ����� �̹����� �����ϴ� �� java.awt.Image - �̹����� ��ü�� ���� java.awt.Graphics- �̹�����
 * �����۾�(ũ�Ⱑ����� �̹����� �׸��� ��) javax.imageio.ImageIO - �̹����� �о� ���̰ų�, ������ �̹����� �������� ��
 * java.awt.BufferedImage - �̹����۾��� ���� ó�� �ӵ� ����
 * 
 * @author owner
 */
public class ImageResize {
	public static boolean imgResize(Component comp, String path) throws IOException {// w122*h110 , (ū)244 220
		boolean flag = false;
		File readFile = new File(path);
		if (!readFile.exists()) {
			JOptionPane.showMessageDialog(comp, "�����̹����� �������� �ʽ��ϴ�");
			return flag;
		}
		// 1. �̹����� �о���δ�
		BufferedImage original = ImageIO.read(readFile);
		// 2. ũ�⸦ �������� ��ü ����
		// Image.SCALE_SMOOTH - �����̹����� ������ �̹����� ũ�⸦ �����Ҷ� ����
		Image resizeImg = original.getScaledInstance(122, 110, Image.SCALE_SMOOTH);
		// 3. ���� �׸� �̹��� ��ü�� ���� - ������ ���� ũ��� ����� RGB������ ����
		BufferedImage newImg = new BufferedImage(122, 110, BufferedImage.TYPE_INT_RGB);
		Graphics g = newImg.getGraphics();
		// ���� �׸� �̹����� �о���� �̹����� �־� �̹����� �׸���.
		g.drawImage(resizeImg, 0, 0, null);
		// �̹����� �� �׷����� �׷��Ƚ� ��ü�� �Ҵ�� �ڿ��� �����Ѵ�.
		g.dispose();
		//5. ���λ����� �̹����� ������ ������ ���
		flag=ImageIO.write(newImg, "gif", new File(readFile.getParent()+"/s_"+readFile.getName()));

		return flag;
	}
}
