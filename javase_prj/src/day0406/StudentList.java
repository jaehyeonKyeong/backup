package day0406;

public class StudentList {
	
	private final static int REF =0; //열의 갯수를 구할 기준 행의 번호
	private int COLUMN_NUM; //열의 갯수
	private String[][] studentList; //학생 data 저장용 배열
	private String[] label; //데이터 라벨 저장용 배열
	
//	private String[] address_temp;
	
	public String[] getLabel() {
		return label;
	}//getLabel

	public void setLabel(String[] label) {
		this.label = label;
	}//setLabel

	public StudentList() {
		System.out.println("주소 배열을 입력해 주세요");
	}//StudentList
	
	public StudentList(String[][] studentList) {
		this.studentList=studentList;
		COLUMN_NUM = studentList[REF].length; //열의 갯수 초기화
		label = new String[] {"이름","주소","나이","성별"}; //기본 라벨 초기화
//		address_temp=address[REF];
	}//StudentList
	
	//1~5번 전체 data 출력
	public void runAll() {
		printDivision();
		printList();
		printDivision();
		printCountry();
		printDivision();
		printManKim();
		printDivision();
		printMaxAge();
		printDivision();
		printManWomanPercent();
		
		
	}//runAll
	
	//구분선
	public void printDivision(){
		System.out.println("========================================");
	}
	
	//1번 테이터 출력
	public void printList() {
		printLine(label);
		for(int i=0;i<studentList.length;i++) {
			printLine(studentList[i]);
		}//end for
	}//printList
	
	// 한줄 데이터출력
	public void printLine(String[] line) {
		for(int i=0;i<COLUMN_NUM;i++) {
			System.out.printf("%s\t",line[i]);
		}//end if
		System.out.println();
	}//printLine
	
	// 거주지가 읍인 사람의 인원수 출력
	public void printCountry(){
		int cnt=0;
		for(int i=0;i<studentList.length;i++) {
			if(studentList[i][1].endsWith("읍")) {
				cnt++;
			}//end if
		}//end for
		System.out.printf("거주지가 '읍'인 사람의 인원수 [%d]\n",cnt);
	}//printCountry
	
	//성별이 남자 이면서 '김'씨인 사람을 모두 출력
	public void printManKim() {
		System.out.println("성별이 남자 이면서 '김'씨인 사람을 모두 출력");
		for(int i=0;i<studentList.length;i++) {
			if(studentList[i][3].equals("남자")&&studentList[i][0].startsWith("김")) {
				printLine(studentList[i]);
			}//end if
		}//end for
	}// end printManKim
	
	//나이 중 가장 많은 나이를 출력
	public void printMaxAge() {
		int maxAge=0; //최고나이
		int temp=0;//String을 int로 변환하여 임시 저장
		for(int i=0;i<studentList.length;i++) {
			temp = Integer.parseInt(studentList[i][2]);
			if(temp>maxAge) {
				maxAge=temp;
			}//end if
		}//end for
		System.out.printf("나이 중 가장 많은 나이 [%d]\n",maxAge);
	}//printMaxAge
	//성별 중 남자의 성별%와 여자 성별%를  출력
	public void printManWomanPercent() {
		int manCnt=0;//남자수
		int womanCnt=0;//여자수
		int totalCnt=0;//남여 합
		for(int i=0;i<studentList.length;i++) {
			if(studentList[i][3].equals("남자")) {
				manCnt++;
			} else {
				womanCnt++;
			}//end if
		}//end for
		totalCnt=manCnt+womanCnt;
		System.out.printf("남자 [%.1f], 여자 [%.1f]\n",(double)manCnt/totalCnt*100,(double)womanCnt/totalCnt*100);
	}

}
