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
		super(name+"�� ���� ���");
		String[]  title= {"���� ����","�Ĵ� ��","��õ ��"};
		String[][] date=null; 
		 this.id=id;
		 this.name=name;
			

		//1. �𵨰� �����͸� ����
		dtmReview=new DefaultTableModel(date, title);
		tTable=new JTable(dtmReview); //���̺� ���߰�
		spScroll=new JScrollPane(tTable);//���̺� ��ũ���߰�
		btnSee=new JButton("����");
		btnDelete=new JButton("����");
		
		 /*//���̺� ������ �߰��ϱ�
        //���������͸� �ǵ��� �ʰ� table�� �Ű������� model�� �ִ� �����͸� �����մϴ�
        DefaultTableModel m =
                (DefaultTableModel)table.getModel();
        //�𵨿� ������ �߰� , 1��° �⿡ ���ο� �����͸� �߰��մϴ�
        m.insertRow(1, new Object[]{"d1","d2","d3"});
        //�߰��� ��ġ�� ������ ������ �˸��ϴ�.
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
