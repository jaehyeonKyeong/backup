package day0409;

import java.util.Random;

//����65~90 ����97~122 �� 48~57
public class Homework1 {
	public Homework1() {
		Random r = new Random();
		StringBuilder stb = new StringBuilder();
		// ��4����2����2
		System.out.print("PW : ");
		for (int i = 0; i < 8; i++) {
			int j = 0;
			while (j < 1) {
				char k = (char) (r.nextInt(74) + 48);
				if (k > 57 && k < 65) {
					continue;
				} else if (k < 97 && k > 90) {
					continue;
				} else {
					stb.append(k);
					// System.out.print("("+(int)k+") ");
					j++;
				} // if
			} // while
		} // for
		System.out.println(stb);
	}// constructor
}// class
