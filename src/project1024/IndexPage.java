package project1024;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Color;



class IndexPage extends JPanel{
	String user;
	private Main1024 main;
	
	Image background = null;
	
	
	
	public IndexPage(Main1024 main){
		setBorder(null);
		this.main = main;
		JButton btn_how = new JButton();
		btn_how.setIcon(new ImageIcon(IndexPage.class.getResource("/image/howto_btn.png")));
		btn_how.setBounds(272, 452, 200, 63);
		btn_how.setBorderPainted(false);
		btn_how.setContentAreaFilled(false);
		
		JButton btn_start = new JButton();
		btn_start.setIcon(new ImageIcon(IndexPage.class.getResource("/image/start_btn.png")));
		btn_start.setBounds(272, 546, 200, 63);
		btn_start.setBorderPainted(false);
		btn_start.setContentAreaFilled(false);
		
		JButton btn_rank = new JButton();
		btn_rank.setIcon(new ImageIcon(IndexPage.class.getResource("/image/rank_btn.png")));
		btn_rank.setBounds(528, 448, 200, 63);
		btn_rank.setBorderPainted(false);
		btn_rank.setContentAreaFilled(false);
		
		JButton btn_end = new JButton();
		btn_end.setIcon(new ImageIcon(IndexPage.class.getResource("/image/exit_btn.png")));
		btn_end.setBounds(528, 546, 200, 63);
		btn_end.setBorderPainted(false);
		btn_end.setContentAreaFilled(false);
		
		setLayout(null);
		add(btn_how);
		add(btn_start);
		add(btn_rank);
		add(btn_end);
		
		setSize(1010,710);
		
		background = new ImageIcon(Main1024.class.getResource("../image/main_bg.png")).getImage();
		
		btn_how.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				main.change("howtoPage");
			}
		});
		
		btn_start.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				user = JOptionPane.showInputDialog(null,"닉네임을 입력해주세요!");
				System.out.println(user);
				main.setUser(user);
			}
		});
		
		btn_rank.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				main.change("rankPage");
			}
		});
		
		btn_end.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int check = JOptionPane.showConfirmDialog(null, "정말 종료하시겠습니까?");
				if(check==0){
					System.exit(0);
				}
			}
		});
		setVisible(true);
	}
	public void paintComponent(Graphics g) {
		g.drawImage(background, 0, 0, null);
		setOpaque(false);
		super.paintComponent(g);
	}
}