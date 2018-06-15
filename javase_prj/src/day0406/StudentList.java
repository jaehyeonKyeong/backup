package day0406;

public class StudentList {
	
	private final static int REF =0; //���� ������ ���� ���� ���� ��ȣ
	private int COLUMN_NUM; //���� ����
	private String[][] studentList; //�л� data ����� �迭
	private String[] label; //������ �� ����� �迭
	
//	private String[] address_temp;
	
	public String[] getLabel() {
		return label;
	}//getLabel

	public void setLabel(String[] label) {
		this.label = label;
	}//setLabel

	public StudentList() {
		System.out.println("�ּ� �迭�� �Է��� �ּ���");
	}//StudentList
	
	public StudentList(String[][] studentList) {
		this.studentList=studentList;
		COLUMN_NUM = studentList[REF].length; //���� ���� �ʱ�ȭ
		label = new String[] {"�̸�","�ּ�","����","����"}; //�⺻ �� �ʱ�ȭ
//		address_temp=address[REF];
	}//StudentList
	
	//1~5�� ��ü data ���
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
	
	//���м�
	public void printDivision(){
		System.out.println("========================================");
	}
	
	//1�� ������ ���
	public void printList() {
		printLine(label);
		for(int i=0;i<studentList.length;i++) {
			printLine(studentList[i]);
		}//end for
	}//printList
	
	// ���� ���������
	public void printLine(String[] line) {
		for(int i=0;i<COLUMN_NUM;i++) {
			System.out.printf("%s\t",line[i]);
		}//end if
		System.out.println();
	}//printLine
	
	// �������� ���� ����� �ο��� ���
	public void printCountry(){
		int cnt=0;
		for(int i=0;i<studentList.length;i++) {
			if(studentList[i][1].endsWith("��")) {
				cnt++;
			}//end if
		}//end for
		System.out.printf("�������� '��'�� ����� �ο��� [%d]\n",cnt);
	}//printCountry
	
	//������ ���� �̸鼭 '��'���� ����� ��� ���
	public void printManKim() {
		System.out.println("������ ���� �̸鼭 '��'���� ����� ��� ���");
		for(int i=0;i<studentList.length;i++) {
			if(studentList[i][3].equals("����")&&studentList[i][0].startsWith("��")) {
				printLine(studentList[i]);
			}//end if
		}//end for
	}// end printManKim
	
	//���� �� ���� ���� ���̸� ���
	public void printMaxAge() {
		int maxAge=0; //�ְ���
		int temp=0;//String�� int�� ��ȯ�Ͽ� �ӽ� ����
		for(int i=0;i<studentList.length;i++) {
			temp = Integer.parseInt(studentList[i][2]);
			if(temp>maxAge) {
				maxAge=temp;
			}//end if
		}//end for
		System.out.printf("���� �� ���� ���� ���� [%d]\n",maxAge);
	}//printMaxAge
	//���� �� ������ ����%�� ���� ����%��  ���
	public void printManWomanPercent() {
		int manCnt=0;//���ڼ�
		int womanCnt=0;//���ڼ�
		int totalCnt=0;//���� ��
		for(int i=0;i<studentList.length;i++) {
			if(studentList[i][3].equals("����")) {
				manCnt++;
			} else {
				womanCnt++;
			}//end if
		}//end for
		totalCnt=manCnt+womanCnt;
		System.out.printf("���� [%.1f], ���� [%.1f]\n",(double)manCnt/totalCnt*100,(double)womanCnt/totalCnt*100);
	}

}
