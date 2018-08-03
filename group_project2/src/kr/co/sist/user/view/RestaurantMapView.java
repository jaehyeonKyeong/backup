package kr.co.sist.user.view;

import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import kr.co.sist.licensee.controller.FileClient;

public class RestaurantMapView extends JFrame{
	ImageIcon restaurantMap;
	
	public RestaurantMapView(String rNum) {
		super("식당 위치");
		FileClient fc=new FileClient();
		try {
			String imgpath=fc.mapDownloadProcess(rNum);
			restaurantMap=new ImageIcon(imgpath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JLabel map=new JLabel(restaurantMap);
		
		add(map);
		
		setBounds(100,100,500,500);
		setVisible(true);
		
		
	}//constructor


}
