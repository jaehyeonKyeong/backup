package kr.co.sist.user.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

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
		} // ���̵� �̺�Ʈó��
		if (ae.getSource() == su.getTfPassword()) {
			su.getTfRePassword().requestFocus();
		} // ��й�ȣ
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
					System.out.println("�����---evt ");
					suvLicensee=new SignUpVO(id,pass,name,LICENSEE_TABLE);//����ڴ� false
					lLicensee=new LoginVO(id,pass,LICENSEE_TABLE);
					System.out.println("id : "+id);
					System.out.println("name : "+name);
					System.out.println("pass : "+pass);
					try {
						l_dao.insertMember(suvLicensee);
					} catch (SQLException e) {
						e.printStackTrace();
					}
					JOptionPane.showMessageDialog(su, "����� ������ �����Ǿ����ϴ�.!", "ȸ������ ����! :(", JOptionPane.WARNING_MESSAGE);
					su.dispose();
				}//end if
				if(user) {
					System.out.println("����� ---evt");
					System.out.println(" id : "+id);
					System.out.println(" name : "+name);
					System.out.println("pass : "+pass);
					suvUser=new SignUpVO(id,pass,name,USER_TABLE);//����ڴ� true
					lUser=new LoginVO(id,pass,USER_TABLE);
					try {
						l_dao.insertMember(suvUser);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					JOptionPane.showMessageDialog(su, "����� ������ �����Ǿ����ϴ�.!", "ȸ������ ����! :(", JOptionPane.WARNING_MESSAGE);
					su.dispose();
				}//end if
				}else {
					JOptionPane.showMessageDialog(su, "��й�ȣ�� Ȯ�����ּ���!.", "ȸ������ ����! :(", JOptionPane.WARNING_MESSAGE);
				}
			}else {
				JOptionPane.showMessageDialog(su, "�ʼ��Է»����� �Է����ּ���!.", "ȸ������ ����! :(", JOptionPane.WARNING_MESSAGE);
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
