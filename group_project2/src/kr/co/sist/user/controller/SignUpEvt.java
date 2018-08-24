package kr.co.sist.user.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.swing.JOptionPane;

import kr.co.sist.user.dao.LoginDAO;
import kr.co.sist.user.view.SignUp;
import kr.co.sist.user.vo.LoginVO;
import kr.co.sist.user.vo.SignUpVO;

public class SignUpEvt implements ActionListener {
	private SignUp su;
	private String id, name, pass,rePass;
	private boolean user, buisnessman;
	private SignUpVO suvUser,suvLicensee;
	private LoginVO lUser,lLicensee;
	static final String  USER_TABLE="fp_user";
	static final String  LICENSEE_TABLE="LICENSEE";

	public SignUpEvt() {
		// TODO Auto-generated constructor stub
	}
	public SignUpEvt(SignUp su) {
		this.su = su;
	}

	@Override
	
	public void actionPerformed(ActionEvent ae) {
		id = su.getTfID().getText();
		name = su.getTfName().getText();
		pass = su.getTfPassword().getText();
		rePass= su.getTfRePassword().getText();
		buisnessman = su.getRbBuisnessman().isSelected();
		user = su.getRbUser().isSelected();
		LoginDAO l_dao=LoginDAO.getInstance();
		

		if (ae.getSource() == su.getTfID()) {
			su.getTfPassword().requestFocus();
		} // 아이디 이벤트처리
		if (ae.getSource() == su.getTfPassword()) {
			su.getTfRePassword().requestFocus();
		} // 비밀번호
		if (ae.getSource() == su.getTfRePassword()) {
			su.getTfName().requestFocus();
		} // name

		if(ae.getSource() == su.getBtnCancle()) {
			su.dispose();
		}//end if
		
		if(ae.getSource() == su.getBtnSignUp()) {
			if(!(name.equals("") || id.equals("") || pass.equals("")|| !(buisnessman|| user))) {
				if(pass.equals(rePass)) {
				if(buisnessman) {
					System.out.println("사업자---evt ");
					suvLicensee=new SignUpVO(id,pass,name,LICENSEE_TABLE);//사업자는 false
					lLicensee=new LoginVO(id,pass,LICENSEE_TABLE);
					System.out.println("id : "+id);
					System.out.println("name : "+name);
					System.out.println("pass : "+pass);
					try {
						l_dao.insertMember(suvLicensee);
					} catch (SQLException e) {
						e.printStackTrace();
					}
					JOptionPane.showMessageDialog(su, "사업자 계정이 생성되었습니다.!", "회원가입 성공! :(", JOptionPane.WARNING_MESSAGE);
					su.dispose();
				}//end if
				if(user) {
					System.out.println("사용자 ---evt");
					System.out.println(" id : "+id);
					System.out.println(" name : "+name);
					System.out.println("pass : "+pass);
					suvUser=new SignUpVO(id,pass,name,USER_TABLE);//사용자는 true
					lUser=new LoginVO(id,pass,USER_TABLE);
					System.out.println("아이디 몇자니 "+id.length()+"비밀번호 몇자니 "+pass.length());
					try {
						l_dao.insertMember(suvUser);
						JOptionPane.showMessageDialog(su, "사용자 계정이 생성되었습니다.!", "회원가입 성공! :(", JOptionPane.WARNING_MESSAGE);
						su.dispose();
					}catch (SQLIntegrityConstraintViolationException e) {
						JOptionPane.showMessageDialog(su, "해당아이디는 존재합니다.!!", "회원가입 실패 :(", JOptionPane.WARNING_MESSAGE);
						e.printStackTrace();
					}catch (SQLException e) {
						if(id.length()>15) {
						JOptionPane.showMessageDialog(su, "아이디  는 15자까지만 가능합니다!", "회원가입 실패 :(", JOptionPane.WARNING_MESSAGE);
						}
						if(pass.length()>20) {
							JOptionPane.showMessageDialog(su, "비밀번호  는 20자까지만 가능합니다!", "회원가입 실패 :(", JOptionPane.WARNING_MESSAGE);
						}
						if(name.length()>30) {
							JOptionPane.showMessageDialog(su, "이름은 10자까지만 가능합니다! 죄송합니다 ㅠ.ㅠ", "회원가입 실패 :(", JOptionPane.WARNING_MESSAGE);
						}
						e.printStackTrace();
					}
				}//end if
				}else {
					JOptionPane.showMessageDialog(su, "비밀번호를 확인해주세요!.", "회원가입 실패! :(", JOptionPane.WARNING_MESSAGE);
				}
			}else {
				JOptionPane.showMessageDialog(su, "필수입력사항을 입력해주세요!.", "회원가입 실패! :(", JOptionPane.WARNING_MESSAGE);
			}//end else
		}//end if
	}//actionPerformed
	public LoginVO getlUser() {
		return lUser;
	}

	public LoginVO getlLicensee() {
		return lLicensee;
	}

}//class
