package kr.co.sist.user.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import kr.co.sist.licensee.controller.licenssenameDate;
import kr.co.sist.licensee.view.RestaurantManagementView;
import kr.co.sist.user.dao.LoginDAO;
import kr.co.sist.user.view.Category;
import kr.co.sist.user.view.Login;
import kr.co.sist.user.view.SignUp;
import kr.co.sist.user.vo.LoginVO;
import kr.co.sist.user.vo.SignUpVO;
import kr.co.sist.user.vo.UserInfoVO;

public class LoginEvt implements ActionListener {
	private Login lg;
	private String id,password;
	private LoginVO lv;
	private SignUpVO suv;
	
	
	public LoginEvt(Login lg) {
		this.lg=lg;
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		id = lg.getTfId().getText();
		password = new String(lg.getPfPassword().getPassword());
		LoginDAO l_dao=LoginDAO.getInstance();
		
//		SignUpEvt sue=new SignUpEvt();
		if(ae.getSource()==lg.getBtnSignUp()) {
			new SignUp();
		}
		if(ae.getSource()==lg.getBtnLogin()) {
			if(lg.getRbUser().isSelected()) {
				System.out.println("사용자");
				lv=new LoginVO(id,password,SignUpEvt.USER_TABLE);
				System.out.println(id+"/"+password+"/"+SignUpEvt.USER_TABLE);
				try {
					UserInfoVO uiv =l_dao.selectLogin(lv);
					
					if(uiv!=null) {
						new Category(uiv);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}else if(lg.getRbManager().isSelected()) {
				System.out.println("사업자");
				lv=new LoginVO(id,password,SignUpEvt.LICENSEE_TABLE);
				System.out.println(id+"/"+password+"/"+SignUpEvt.LICENSEE_TABLE+"/");
				try {    
					 licenssenameDate name =l_dao.licenseeLogin(lv);
					if(name !=null) {
						new RestaurantManagementView(name);
						JOptionPane.showMessageDialog(lg, "정상적으로 로그인되었습니다." ,"확인.",JOptionPane.INFORMATION_MESSAGE);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}else {
				System.out.println("선택안됨");
			}
		}
	}

}
