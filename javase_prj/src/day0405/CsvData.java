package day0405;

public class CsvData {
	public CsvData() {
		String name="김우현,장현준,지승민.이종민,김동희,김대현";
		//.로 구분하여 배열로 얻기
		///.은 []로 따로 묶어서 자른다.
		
		String[] nameArr=name.split("김");
		for(int i=0;i<nameArr.length; i++) {
			System.out.println(nameArr[i]);
		}
	}//csvdata
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new CsvData();
	}//main

}
