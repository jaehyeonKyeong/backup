package kr.co.sist.user.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import kr.co.sist.user.dao.MemberDAO;
import kr.co.sist.user.view.Category;
import kr.co.sist.user.view.RestaurantSearchView;
import kr.co.sist.user.view.UserGiftCardInfo;
import kr.co.sist.user.view.UserReview;
import kr.co.sist.user.view.UserShop;

public class CategoryEvt implements ActionListener {
	private UserGiftCardInfoEvt ugie;
	private UserGiftCardInfo ugi;
	Category cg;
	UserShop us;
//	String point;
	int point;
	public CategoryEvt(Category cg) {
		this.cg=cg;
//		ugci=us.getUgci();
	}

	public void setPoint() {
		MemberDAO m_dao=MemberDAO.getInstance();
		try {
			point=m_dao.selectPoint(cg.getBtnID().getText());
			cg.getLblUserPoint().setText(String.valueOf(point)+"Point");
//			this.point=String.valueOf(point);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int getPoint() {
		return point;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == cg.getBtnRestaurant()) {
			new RestaurantSearchView(cg.getId());
		} // ¿À´Ã ¹¹ ¸ÔÁö
		if (ae.getSource() == cg.getBtnID()) {
			ugi=new UserGiftCardInfo(cg.getId(),cg.getName());
		} // ¾ÆÀÌµð¹öÆ°
		if (ae.getSource() == cg.getBtnReview()) {
			new UserReview(cg.getId(),cg.getName());
		} // ¸®ºä
		if (ae.getSource() == cg.getBtnShop()) {
			new UserShop(cg);
		} // »óÁ¡
	}


}
