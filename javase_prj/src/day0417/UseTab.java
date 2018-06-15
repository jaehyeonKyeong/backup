package day0417;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class UseTab extends JFrame {

	private JTabbedPane jtp;
	private UseTab ut;

	public UseTab() {
		super("탭 연습");
		ut = this;
		jtp = new JTabbedPane();
		ImageIcon ii = new ImageIcon("C:/dev/workspace/javase_prj/src/day0417/img/img4.png");
		JLabel lblImg = new JLabel(ii);

		JButton btn = new JButton("버튼");

		JPanel panel = new JPanel();
		panel.add(new JLabel("이름"));
		panel.add(new JTextField(20));
		panel.add(new JButton("입력"));

		jtp.add("이미지", lblImg);
		jtp.addTab("버튼", btn);
		jtp.addTab("다양한 컴포넌트", panel);

		UseTab.MouseEvt me = this.new MouseEvt();
		jtp.addMouseListener(me);

		add("Center", jtp);
		setBounds(250, 100, 600, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}// constructor

	public class MouseEvt extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent me) {
			JOptionPane.showMessageDialog(ut, jtp.getTitleAt(jtp.getSelectedIndex()));
		}
	}

	public static void main(String[] args) {
		new UseTab();
	}

}
