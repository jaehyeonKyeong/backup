package day0405;

public class CsvData {
	
	
	public CsvData(){
		String name = "�����,������,���¹�.������,�赿��,�����";
		// , �� �����Ͽ� �迭�� ���
//		String nameChanged= name.replace(".", ",");
		String[] nameArr=name.split(","); //��� ���ڿ��� �߶����� .�� []�� ��� �ڸ��� 
		
		for(int i=0; i<nameArr.length;i++) {
			System.out.println(nameArr[i]);
		}
	}//CsvData

	public static void main(String[] args) {
		
		new CsvData();
		
		
		

	}//main

}//class
