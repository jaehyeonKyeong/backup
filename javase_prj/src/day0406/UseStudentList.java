package day0406;

public class UseStudentList {

	public static void main(String[] args) {
		
		String[][] studentList={
				{"김대현","경기도 부천시 역곡동","25","남자"},
				{"지승민","인천시광역시 계산동","27","남자"},
				{"김동희","서울시 관악구 봉천동","20","남자"},
				{"박지영","경기도 수원시 ","29","여자"},
				{"김우현","충청남도 예산시 예산읍","30","남자"},
				{"강소예","서울시 강남구 역삼동","31","여자"},
				{"최주오","경기도 오산시 오산읍","22","남자"},
				{"장현준","부산시 서면 서면동","27","남자"}
			};
		
		StudentList ap = new StudentList(studentList);
//		String[] label = {"이름","주소","나이","성별"};
//		ap.setLabel(label);
		ap.runAll(); //ㅈ

	}

}
