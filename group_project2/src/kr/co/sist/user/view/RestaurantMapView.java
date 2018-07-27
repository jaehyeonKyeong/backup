package kr.co.sist.user.view;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class RestaurantMapView extends JFrame{
	ImageIcon restaurantMap;
	
	public RestaurantMapView() {
		super("식당 위치");
		restaurantMap=new ImageIcon("C:/dev/workspace/group_project2/src/kr/co/sist/user/view/images/rest_map.PNG");
		JLabel map=new JLabel(restaurantMap);
		
		add(map);
		
		setBounds(100,100,500,500);
		setVisible(true);
		
		
	}//constructor

	public static void main(String[] args) {
		new RestaurantMapView();

	}

}
