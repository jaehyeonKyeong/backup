package day0405;

public class CsvData {
	
	
	public CsvData(){
		String name = "김우현,장현준,지승민.이종민,김동희,김대현";
		// , 로 구분하여 배열로 얻기
//		String nameChanged= name.replace(".", ",");
		String[] nameArr=name.split(","); //모든 문자열을 잘라내지만 .은 []로 묶어서 자른다 
		
		for(int i=0; i<nameArr.length;i++) {
			System.out.println(nameArr[i]);
		}
	}//CsvData

	public static void main(String[] args) {
		
		new CsvData();
		
		
		

	}//main

}//class
