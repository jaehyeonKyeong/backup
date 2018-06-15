package day0406;

/**
 * 아래의 배열을 입력받아 요구사항을 처리하세요. String[][] temp={ {"김대현","경기도 부천시 역곡동","26","남자"},
 * {"지승민","인천시광역시 계산동","26","남자"}, {"김동희","서울시 관악구 봉천동","26","남자"}, {"박지영","경기도
 * 수원시 ","26","여자"}, {"김우현","충청남도 예산시 예산읍","26","남자"}, {"강소예","서울시 강남구
 * 역삼동","26","여자"}, {"최주오","경기도 오산시 오산읍","26","남자"}, {"장현준","부산시 서면
 * 서면동","26","남자"} }; 문제 1. 위의 데이터를 아래의 라벨에 맞춰 출력하세요. 이름 주소 나이 성별 문제 2. 거주지가
 * '읍'인 사람의 인원수를 출력하세요.
 * 
 * 문제3. 성별이 남자 이면서 '김'씨인 사람을 모두 출력하세요.
 * 
 * 문제 4. 나이 중 가장 많은 나이를 출력하세요.
 * 
 * 문제 5. 성별 중 남자의 성별%와 여자 성별%를 출력하세요.
 * 
 * 
 * @author owner
 */
public class Homework {

	public Homework() {
	}

	@SuppressWarnings("unused")
	public Homework(String[][] temp) {
		int count = 0;
		int[] num = null;
		num=new int[8];
		System.out.println("이름\t주소\t\t나이\t성별\t");
		System.out.println("-------------------------------------");
		for (int i = 0; i < temp.length; i++) {

			for (int j = 0; j < temp[i].length; j++) {
				System.out.printf("%s\t", temp[i][j]);
			}
			if (temp[i][1].endsWith("읍")) {
				count++;
			}
			System.out.println();
		}
		System.out.println("------------------------------------");
		System.out.printf("거주지가 '읍'인 사람 [%d]명\n", count);
		System.out.print("성별이 남자 이면서 '김'씨인 사람 : ");
		int age=Integer.parseInt(temp[0][2]);
		int s_count=1;
		for (int i = 0; i < temp.length; i++) {
			if (temp[i][3].startsWith("남")) {
				if(temp[i][0].startsWith("김")) {
				System.out.printf("%s ", temp[i][0]);
				}
				s_count++;
			}
			if(i+1<7) {
				if (Integer.parseInt(temp[i][2]) < Integer.parseInt(temp[i + 1][2])) {
					age = Integer.parseInt(temp[i + 1][2]);
				}//if
			}else {
				break;
			}
			
		}//for
		int malePersent=((int)(s_count*100/8));
		int femalePersent=100-malePersent;
		System.out.println();
		System.out.println("제일 많은 나이 "+age+"살");
		System.out.println("총인원중 남자 비율 : "+malePersent+"%\n총인원중 여자의 비율 : "+femalePersent+"%");
	
	}//Homework
}//class
