package kr.co.sist.user.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class UserReview extends JFrame {
	private DefaultTableModel dtmReview;
	private JTable tTable;
	private JScrollPane spScroll;
	private JButton btnSee,btnDelete;

//	List<testVO> lReviewDate;
//	JTable jTab;
	
	public UserReview(){
		super("��״ٴ� ���� ���");
		String[]  title= {"���� ����","�Ĵ� ��","��õ ��"};
		String[][] date= {
				{"1","�۷����Ĵ�","3"},
				{"2","��ȭ��Ĵ�","3"},
				{"3","�״ٽĴ�","3"},
				{"4","�����Ĵ�","3"}
		};//��������
		btnSee=new JButton("����");
		btnDelete=new JButton("����");
		//1. �𵨰� �����͸� ����
		dtmReview=new DefaultTableModel(date, title);
		tTable=new JTable(dtmReview); //���̺� ���߰�
		spScroll=new JScrollPane(tTable);//���̺� ��ũ���߰�
		
		 /*//���̺� ������ �߰��ϱ�
        //���������͸� �ǵ��� �ʰ� table�� �Ű������� model�� �ִ� �����͸� �����մϴ�
        DefaultTableModel m =
                (DefaultTableModel)table.getModel();
        //�𵨿� ������ �߰� , 1��° �⿡ ���ο� �����͸� �߰��մϴ�
        m.insertRow(1, new Object[]{"d1","d2","d3"});
        //�߰��� ��ġ�� ������ ������ �˸��ϴ�.
        table.updateUI();*/
		tTable.getTableHeader().setReorderingAllowed(false);
		add(spScroll);
		add(btnDelete);
		add(btnSee);
		setLayout(null);
		spScroll.setBounds(20, 20, 280, 250);
		btnSee.setBounds(80,290,70,30);
		btnDelete.setBounds(160,290,70,30);
		setBounds(100,100,340,400);
		setVisible(true);
		
		
		//lReviewDate=new ArrayList<>();
	}
	public static void main(String[] args) {
		new UserReview();
	}
}
