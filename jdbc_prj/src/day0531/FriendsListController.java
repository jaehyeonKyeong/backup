package day0531;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.List;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

public class FriendsListController extends MouseAdapter implements ActionListener {

	private FriendsListView flv;
	private boolean selectFlag; // List선택 여부를 저장할 변수

	public FriendsListController(FriendsListView flv) {
		this.flv = flv;
		viewList();
		
	}// constructor

	@Override
	public void mouseClicked(MouseEvent me) {
		String selectedData = flv.getDlm().getElementAt(flv.getFriendsList().getSelectedIndex());
		StringTokenizer stk = new StringTokenizer(selectedData, "/-");

		// 선택된 데이터를 tf에 채운다
		if (me.getClickCount() == 2) {
			flv.getTfName().setText(stk.nextToken());
			flv.getTfAge().setText(stk.nextToken());
			flv.getTfPhone1().setText(stk.nextToken());
			flv.getTfPhone2().setText(stk.nextToken());
			flv.getTfPhone3().setText(stk.nextToken());
		}

		selectFlag = true;

	}

	private FriendsListVO inputData() {
		FriendsListVO flVO = null;
		String name = flv.getTfName().getText().trim();
		int age = Integer.parseInt(flv.getTfAge().getText().trim());
		String phn1 = flv.getTfPhone1().getText().trim();
		String phn2 = flv.getTfPhone2().getText().trim();
		String phn3 = flv.getTfPhone3().getText().trim();

		StringBuilder phoneNumber = new StringBuilder();
		phoneNumber.append(phn1).append("-").append(phn2).append("-").append(phn3);
		// 입력데이터를 model객체에 입력한다
		flVO = new FriendsListVO(name, phoneNumber.toString(), age);
		return flVO;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == flv.getBtnAdd()) {// 추가
			FriendsListVO flVO=inputData();
			FriendsListDAO flDAO=FriendsListDAO.getInstance();
			List<FriendsListVO> list=null;
			flv.getDlm().removeAllElements();
			try {
				flDAO.insertColumnInfo(flVO);
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "추가중 문제가 발생하였습니다.");
				e.printStackTrace();
			}
			viewList();
			// 다음 입력을 편하게 하기 위해 tf를 초기화 한다.
			flv.getTfName().setText("");
			flv.getTfAge().setText("");
			flv.getTfPhone1().setText("");
			flv.getTfPhone2().setText("");
			flv.getTfPhone3().setText("");

			flv.getTfName().requestFocus();
			selectFlag = false;// 추가된 상태는 리스트를 선택한 상태가 아니므로 false
		}
		if (ae.getSource() == flv.getBtnDelete()) {// 삭제
			if (!selectFlag) {
				JOptionPane.showMessageDialog(flv, "삭제할 친구를 선택해주세요");
				return;// 반환형 void의 return은 사용할 값을 반환하는 것이 아니라, 아랫줄 코드의 샐행을 막는 일을 하게 됩니다.
			}
			if (showConfirm("정말 삭제할건가요?")) {
				flv.getDlm().removeElementAt(flv.getFriendsList().getSelectedIndex());
				selectFlag = false;
			}
		}
		if (ae.getSource() == flv.getBtnAdjust()) {// 수정
			if (!selectFlag) {
				JOptionPane.showMessageDialog(flv, "정보를 수정할 친구를 선택해주세요");
				return;// 반환형 void의 return은 사용할 값을 반환하는 것이 아니라, 아랫줄 코드의 샐행을 막는 일을 하게 됩니다.
			}
			if (showConfirm("정말 변경하시겠어요?")) {
				int indx = flv.getFriendsList().getSelectedIndex();
				// 삭제후
				flv.getDlm().removeElementAt(indx);
				// 선택한 데이터자리에 추가
//				flv.getDlm().add(indx, userData());

				selectFlag = false;
			}

		}
		if (ae.getSource() == flv.getBtnClose()) {// 종료
			if (showConfirm("정말로 종료하실건가요?")) {
				flv.dispose();
			}
		}
	}

	private boolean showConfirm(String msg) {
		boolean flag = false;
		flag = JOptionPane.showConfirmDialog(flv, msg) == 0;
		return flag;
	}
	
	public void viewList() {
		FriendsListDAO flDAO=FriendsListDAO.getInstance();
		List<FriendsListVO> list=null;
		try {
			list=flDAO.selectColumnInfo();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(flv, "데이터베이스를 불러오는 중 오류가 발생하였습니다");
			e.printStackTrace();
		}
		
		for(FriendsListVO flVO : list) {
		StringBuilder userData=new StringBuilder();
		userData.append(flVO.getName()).append(" / ").append(flVO.getAge()).append(" / ").append(flVO.getPhone_num());
		flv.getDlm().addElement(userData.toString());
		}
	}

}
