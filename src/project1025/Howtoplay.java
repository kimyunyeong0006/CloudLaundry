package project1025;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Howtoplay extends JPanel{
	Image background = null;
	String user;
	private Main1025 main;
	public Howtoplay(Main1025 main) {
		background = new ImageIcon(Main1025.class.getResource("../image/howto_bg.png")).getImage();
		this.main = main;
		setSize(1010,710);
		setLayout(null);
		
		
		JButton btn_start = new JButton();
		btn_start.setIcon(new ImageIcon(IndexPage.class.getResource("/image/start_btn.png")));
		btn_start.setBounds(272, 546, 200, 63);
		btn_start.setBorderPainted(false);
		btn_start.setContentAreaFilled(false);
		add(btn_start);
		
		btn_start.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				user = JOptionPane.showInputDialog(null,"닉네임을 입력해주세요!");
				if(user == null){
					System.out.println(user);
					return;
				}
				else{
					System.out.println(user);
					main.setUser(user);
					main.change("gamePage");
				}
			}
		});
		
		JButton btn_main = new JButton();
		btn_main.setIcon(new ImageIcon(IORank.class.getResource("/image/main_btn.png")));
		btn_main.setBounds(528, 546, 200, 60);
		btn_main.setBorderPainted(false);
		btn_main.setContentAreaFilled(false);
		add(btn_main);
		
		btn_main.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				main.change("indexPage");
			}
		});
	}
	public void paintComponent(Graphics g) {
		g.drawImage(background, 0, 0, null);
		setOpaque(false);
		super.paintComponent(g);
	}
}
