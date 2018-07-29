package kr.co.sist.user.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

@SuppressWarnings("serial")
public class UserGiftCardInfo extends JFrame {
	private DefaultTableModel dtmGiftCard;
	private JTable tGiftCard;
	private JScrollPane spScroll;
	private JButton btnClose;
	public UserGiftCardInfo() {
		super("경붓다님 상품권 리스트");
		String[]  title= {"받은 날짜","상품권 명","사용여부"};
		String[][] date= {
				{"2018/07/08","2000원","O"},
				{"2018/07/09","3000원",""},
				{"2018/07/10","4000원",""}
		};//가데이터
		//1. 모델과 데이터를 연결
		dtmGiftCard=new DefaultTableModel(date, title);
		tGiftCard=new JTable(dtmGiftCard); //테이블에 모델추가
		spScroll=new JScrollPane(tGiftCard);//테이블에 스크롤추가
		btnClose=new JButton("닫기");
		tGiftCard.getTableHeader().setReorderingAllowed(false);
		
		// DefaultTableCellHeaderRenderer 생성 (가운데 정렬을 위한)
		DefaultTableCellRenderer tScheduleCellRenderer = new DefaultTableCellRenderer();
		// DefaultTableCellHeaderRenderer의 정렬을 가운데 정렬로 지정
		tScheduleCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		// 정렬할 테이블의 ColumnModel을 가져옴
		TableColumnModel tcmSchedule = tGiftCard.getColumnModel();
		// 반복문을 이용하여 테이블을 가운데 정렬로 지정
		for (int i = 0; i < tcmSchedule.getColumnCount(); i++) {
		tcmSchedule.getColumn(i).setCellRenderer(tScheduleCellRenderer);
		}
		
		add(btnClose);
		add(spScroll);
		setLayout(null);
		spScroll.setBounds(20, 20, 280, 250);
		btnClose.setBounds(125, 290, 60, 30);
		setBounds(100,100,340,400);
		
		setVisible(true);
	}
	public static void main(String[] args) {
		new UserGiftCardInfo();
	}
}
