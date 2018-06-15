package day0405;

public class CsvTest {

	public static void main(String[] args) {
		String str = "지승민,이종민,신종성,송재원,이진영.김우현";
		String[] st = str.split(",");
		for(int i=0; i<st.length;i++) {
			System.out.println(st[i]);
		}
		// TODO Auto-generated method stub

	}

}
