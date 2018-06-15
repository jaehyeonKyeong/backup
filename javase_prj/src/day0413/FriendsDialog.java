package day0413;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

/**
 * ģ�� �߰��� �ڽ�â
 * @author owner
 */
@SuppressWarnings("serial")
public class FriendsDialog extends Dialog implements ActionListener {
	@SuppressWarnings("unused")
	private FriendsWindow fw;
	private TextField tfName;
	private Button btnAdd,btnClose;
	@SuppressWarnings("unused")
	private List<String> listFriends;
	
	public FriendsDialog(FriendsWindow fw) {
		super(fw,"ģ���߰�",true);
		//modal����:�ڽ� â�� ����Ǿ����� �θ�â�� ���õ��� ������ "���"�̶�� �ϰ� �θ�â�� ���õǸ� "����" �̶���Ѵ�
		listFriends=fw.getListFriends();//�θ�â�� ���簡���� �ִ� ģ�� ��� (callByReferance)
		//�Ű������� ���� �θ�ü�� �ν��Ͻ� ���� �Ҵ�
		this.fw=fw;
		
		Label lblTitle=new Label("ģ���߰�");
		lblTitle.setFont(new Font("SansSerif", Font.BOLD, 25));
		
		Font font=new Font("SansSerif",Font.PLAIN,14);
		Label lblName=new Label("�̸�");
		tfName=new TextField(20);
		btnAdd=new Button("�߰�");
		btnClose=new Button("�ݱ�");
		
		lblName.setFont(font);
		tfName.setFont(font);
		btnAdd.setFont(font);
		btnClose.setFont(font);
		
		Panel panCenter=new Panel();
		
		panCenter.add(lblName);
		panCenter.add(tfName);
		panCenter.add(btnAdd);
		panCenter.add(btnClose);
		
		//������ ������Ʈ(dialog)
		
		add("North",lblTitle);
		add("Center",panCenter);
		
		//�̺�Ʈ ���
		btnAdd.addActionListener(this);
		btnClose.addActionListener(this);
		tfName.addActionListener(this);
		tfName.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent ke) {
				if(ke.getKeyCode()==27) {
					dispose();
				}
			}
			
		});
		
		
		setBounds(fw.getX()+150,fw.getY()+200,350,200);
		//////dialog�� window ���� �̺�Ʈ�� �׻� visible���� �־����.//////
		addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
			
		});
		//////////////////////////////////////////////////////
		setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==btnAdd||ae.getSource()==tfName) {
			//�Էµ� �̸��� ���ͼ�
			//������ ������ ��
			String name=tfName.getText().replaceAll(" ", "");
			//�θ�â�� ������ java.util.List�� �߰��ϰ�
			listFriends.add(name);			
			//�θ�â�� �������� java.awt.List�� �����Ѵ�.
			fw.setFriends();
			//���� �Է��� ���ϵ��� TextField�� �ʱ�ȭ
			tfName.setText("");
		}
		if(ae.getActionCommand().equals("�ݱ�")){
			dispose();
		}
	}

}
