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
		super("HTML���");
		jtfURL = new JTextField(20);
		btnRequest = new JButton("��û");
		jlOutput = new JLabel("��û��");
		jtaHTML = new JTextArea();

		jlOutput.setBorder(new TitledBorder("��û URL"));

		JPanel jpNorth = new JPanel();

		jpNorth.add(new JLabel("�ּ�"));
		jpNorth.add(jtfURL);
		jpNorth.add(btnRequest);

		JScrollPane jspCenter = new JScrollPane(jtaHTML);
		jspCenter.setBorder(new TitledBorder("���� ���� html"));

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
		URL url = new URL(param_url);// URL�� �Էµ� ������ ������ ����Ͽ� ����(���Ͼ��̴� ������ ���� ���� : ������ ������� �� ������� ������ �� �ȴ�.)
		// ��û�� �������� ����Ǵ� HTML�� �о� ���̱� ���� Stream�� ���
		BufferedReader br = null;
		try {

			br = new BufferedReader(new InputStreamReader(url.openStream(),"euc-kr"));
			String temp = "";
			jtaHTML.setText("");
			while ((temp = br.readLine()) != null) {
				jtaHTML.append(temp + "\n");
			}

			jlOutput.setText("��û �������� :" + url.getProtocol() + "   |   ��û ������(����) : " + url.getHost()
					+ "   |   ��û ��Ʈ : " + url.getDefaultPort() + "   |   QueryString : " + url.getQuery());
			jtfURL.setText("");

		} finally {
			if (br != null) {
				br.close();
			} // bufferedReader�� null�� �ƴ϶�� ������ �����ش�.
		} // try
	}// readHTML

	@Override
	public void actionPerformed(ActionEvent e) {
		String url = jtfURL.getText().trim();
		if (url.equals("")) {
			JOptionPane.showMessageDialog(this, "URL�� �ʼ� �Է�");
			jtfURL.requestFocus();
			return;
		}
		try {
			readHTML(url);
		} catch (IOException e1) {
			JOptionPane.showMessageDialog(this, "URL�� �����ϴ� �� ���� �߻�");
			e1.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new UseURL();
	}

}
