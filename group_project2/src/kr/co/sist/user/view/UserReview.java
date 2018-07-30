package kr.co.sist.user.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import kr.co.sist.user.controller.UserReviewEvt;

@SuppressWarnings("serial")
public class UserReview extends JFrame {
	private DefaultTableModel dtmReview;
	private JTable tTable;
	private JScrollPane spScroll;
	private JButton btnSee,btnDelete;
	private String id,name;
//	List<testVO> lReviewDate;
//	JTable jTab;
	
	public UserReview(String id,String name){
		super(name+"님 리뷰 목록");
		String[]  title= {"리뷰 제목","식당 명","추천 수"};
		String[][] date=null; 
		 this.id=id;
		 this.name=name;
			

		//1. 모델과 데이터를 연결
		dtmReview=new DefaultTableModel(date, title);
		tTable=new JTable(dtmReview); //테이블에 모델추가
		spScroll=new JScrollPane(tTable);//테이블에 스크롤추가
		btnSee=new JButton("보기");
		btnDelete=new JButton("삭제");
		
		 /*//테이블에 데이터 추가하기
        //원본데이터를 건들지 않고 table의 매개변수인 model에 있는 데이터를 변경합니다
        DefaultTableModel m =
                (DefaultTableModel)table.getModel();
        //모델에 데이터 추가 , 1번째 출에 새로운 데이터를 추가합니다
        m.insertRow(1, new Object[]{"d1","d2","d3"});
        //추가를 마치고 데이터 갱신을 알립니다.
        table.updateUI();*/
		tTable.getTableHeader().setReorderingAllowed(false);
		
		setLayout(null);
		spScroll.setBounds(20, 20, 280, 250);
		btnSee.setBounds(80,290,70,30);
		btnDelete.setBounds(160,290,70,30);
		setBounds(100,100,340,400);
		
		UserReviewEvt uge=new UserReviewEvt(this);
		btnDelete.addActionListener(uge);
		btnSee.addActionListener(uge);
		
		
		add(spScroll);
		add(btnDelete);
		add(btnSee);
		setVisible(true);
		
		
		//lReviewDate=new ArrayList<>();
	}
	public JTable gettTable() {
		return tTable;
	}
	public JButton getBtnSee() {
		return btnSee;
	}
	public JButton getBtnDelete() {
		return btnDelete;
	}
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public DefaultTableModel getDtmReview() {
		return dtmReview;
	}

}
