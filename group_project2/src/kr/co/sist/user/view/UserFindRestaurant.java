package kr.co.sist.user.view;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

@SuppressWarnings("serial")
public class UserFindRestaurant extends JFrame {
	private JPanel pRecommendation,pRestaurant;
	private JButton[] btnRestaurant,btnFoodClassification;
	private ImageIcon[] iiRestaurant,iiFood;
	private JLabel[] lRestaurant,lFood;
	public UserFindRestaurant() {
		String[] foodClassification= {"�ѽ�","�߽�","���","�Ͻ�","�н�"};
		String[] gaDate= {"�۾��Ĵ�","�����Ĵ�","�����Ĵ�","�״ٽĴ�","�׳�Ĵ�"};
		
		pRecommendation=new JPanel();//���ĺз�
		pRestaurant=new JPanel();//�Ĵ� �г�
		
		btnFoodClassification=new JButton[foodClassification.length];
		btnRestaurant=new JButton[gaDate.length];
		BevelBorder border=new BevelBorder(BevelBorder.RAISED);
		
		for(int i=0;i<btnRestaurant.length;i++) {
			btnRestaurant[i]=new JButton(gaDate[i]);
			btnFoodClassification[i]=new JButton(foodClassification[i]);
			pRecommendation.add(btnFoodClassification[i]);
			pRestaurant.add(btnRestaurant[i]);
		}
		
		pRestaurant.setBorder(border);
		pRecommendation.setBorder(border);
		setLayout(null);
		pRecommendation.setBounds(15, 130, 450, 100);
		pRestaurant.setBounds(15, 20, 450, 100);
		
		add(pRestaurant);
		add(pRecommendation);
		setBounds(50, 50, 500, 300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new UserFindRestaurant();
	}
}
