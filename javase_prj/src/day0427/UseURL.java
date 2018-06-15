package day0427;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class UseURL extends JFrame implements ActionListener {
	private JTextField jtfURL;
	private JLabel jlOutput;
	private JTextArea jtaHTML;
	private JButton btnRequest;

	public UseURL() {
		super("HTML얻기");
		jtfURL = new JTextField(20);
		btnRequest = new JButton("요청");
		jlOutput = new JLabel("요청값");
		jtaHTML = new JTextArea();

		jlOutput.setBorder(new TitledBorder("요청 URL"));

		JPanel jpNorth = new JPanel();

		jpNorth.add(new JLabel("주소"));
		jpNorth.add(jtfURL);
		jpNorth.add(btnRequest);

		JScrollPane jspCenter = new JScrollPane(jtaHTML);
		jspCenter.setBorder(new TitledBorder("응답 받은 html"));

		add(BorderLayout.NORTH, jpNorth);
		add(BorderLayout.CENTER, jspCenter);
		add(BorderLayout.SOUTH, jlOutput);

		btnRequest.addActionListener(this);
		jtfURL.addActionListener(this);

		setBounds(10, 10, 800, 600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}// constructor

	private void readHTML(String param_url) throws IOException {
		URL url = new URL(param_url);// URL에 입력된 서버로 소켓을 사용하여 연결(소켓없이는 연결이 되지 않음 : 소켓은 만들어진 언어에 상관없이 연결이 다 된다.)
		// 요청한 서버에서 응답되는 HTML을 읽어 들이기 위해 Stream을 사용
		BufferedReader br = null;
		try {

			br = new BufferedReader(new InputStreamReader(url.openStream(),"euc-kr"));
			String temp = "";
			jtaHTML.setText("");
			while ((temp = br.readLine()) != null) {
				jtaHTML.append(temp + "\n");
			}

			jlOutput.setText("요청 프로토콜 :" + url.getProtocol() + "   |   요청 도메인(서버) : " + url.getHost()
					+ "   |   요청 포트 : " + url.getDefaultPort() + "   |   QueryString : " + url.getQuery());
			jtfURL.setText("");

		} finally {
			if (br != null) {
				br.close();
			} // bufferedReader가 null이 아니라면 연결을 끊어준다.
		} // try
	}// readHTML

	@Override
	public void actionPerformed(ActionEvent e) {
		String url = jtfURL.getText().trim();
		if (url.equals("")) {
			JOptionPane.showMessageDialog(this, "URL은 필수 입력");
			jtfURL.requestFocus();
			return;
		}
		try {
			readHTML(url);
		} catch (IOException e1) {
			JOptionPane.showMessageDialog(this, "URL로 연결하는 중 문제 발생");
			e1.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new UseURL();
	}

}
