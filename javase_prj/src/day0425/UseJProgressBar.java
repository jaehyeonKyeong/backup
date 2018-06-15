package day0425;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

public class UseJProgressBar extends JFrame implements ActionListener, Runnable {
	JProgressBar jpb;
	JButton btnStart;
	Thread prograssThread;
	int sum, value;

	public UseJProgressBar() {
		super("≈±Ÿ ¡ÿ∫Ò¡ﬂ..");
		jpb = new JProgressBar(0, 100);
		btnStart = new JButton("Ω√¿€");

		setLayout(null);
		jpb.setBounds(10, 10, 450, 30);
		btnStart.setBounds(180, 55, 100, 25);

		btnStart.addActionListener(this);

		add(jpb);
		add(btnStart);

		setBounds(500, 200, 480, 130);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}// constroctor

	@Override
	public void actionPerformed(ActionEvent e) {
		prograssThread = new Thread(this);
		prograssThread.start();

	}

	@Override
	public void run() {
		sum = 0;
		Random r = new Random();
		while (sum <= jpb.getMaximum()) {
			value = r.nextInt(10) + 1;
			sum += value;
			jpb.setValue(sum);
			jpb.setStringPainted(true);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		JOptionPane.showMessageDialog(this, "≈±Ÿ");
	}

	public static void main(String[] args) {
		new UseJProgressBar();
	}

}
