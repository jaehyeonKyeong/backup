package day0405;

public class CsvData {
	public CsvData() {
		String name="�����,������,���¹�.������,�赿��,�����";
		//.�� �����Ͽ� �迭�� ���
		///.�� []�� ���� ��� �ڸ���.
		
		String[] nameArr=name.split("��");
		for(int i=0;i<nameArr.length; i++) {
			System.out.println(nameArr[i]);
		}
	}//csvdata
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new CsvData();
	}//main

}
