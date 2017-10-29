package project1027;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Cursor;



class IndexPage extends JPanel{
	String user;
	private Main1027 main;
	
	private ImageIcon howto_btn = new ImageIcon(Main1027.class.getResource("../image/howto_btn.png")); 
	private ImageIcon start_btn = new ImageIcon(Main1027.class.getResource("../image/start_btn.png")); 
	private ImageIcon rank_btn = new ImageIcon(Main1027.class.getResource("../image/rank_btn.png")); 
	private ImageIcon exit_btn = new ImageIcon(Main1027.class.getResource("../image/exit_btn.png")); 
	
	private ImageIcon entered_btn = new ImageIcon(Main1027.class.getResource("../image/entered_btn.png"));
	Image background = null;
	
	
	
	public IndexPage(Main1027 main){
		
		
		setBorder(null);
		this.main = main;
		JButton btn_how = new JButton();
		btn_how.setIcon(howto_btn);
		btn_how.setBounds(272, 452, 200, 63);
		btn_how.setBorderPainted(false);
		btn_how.setContentAreaFilled(false);
		
		JButton btn_start = new JButton();
		btn_start.setIcon(start_btn);
		btn_start.setBounds(272, 546, 200, 63);
		btn_start.setBorderPainted(false);
		btn_start.setContentAreaFilled(false);
		
		JButton btn_rank = new JButton();
		btn_rank.setIcon(rank_btn);
		btn_rank.setBounds(528, 448, 200, 63);
		btn_rank.setBorderPainted(false);
		btn_rank.setContentAreaFilled(false);
		
		JButton btn_end = new JButton();
		btn_end.setIcon(exit_btn);
		btn_end.setBounds(528, 546, 200, 63);
		btn_end.setBorderPainted(false);
		btn_end.setContentAreaFilled(false);
		
		setLayout(null);
		add(btn_how);
		add(btn_start);
		add(btn_rank);
		add(btn_end);
		
		setSize(1010,710);
		
		background = new ImageIcon(Main1027.class.getResource("../image/main_bg.png")).getImage();
		
		btn_how.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e){
				btn_how.setCursor(new Cursor(Cursor.HAND_CURSOR));
				btn_how.setIcon(entered_btn);
			}
			public void mouseExited(MouseEvent e){
				btn_how.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				btn_how.setIcon(howto_btn);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				main.change("howtoPage");
			}
		});
		
		
		btn_start.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e){
				btn_start.setCursor(new Cursor(Cursor.HAND_CURSOR));
				btn_start.setIcon(entered_btn);
			}
			public void mouseExited(MouseEvent e){
				btn_start.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				btn_start.setIcon(start_btn);
			}
			@Override
			public void mousePressed(MouseEvent e) {
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
		
		btn_rank.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e){
				btn_rank.setCursor(new Cursor(Cursor.HAND_CURSOR));
				btn_rank.setIcon(entered_btn);
			}
			public void mouseExited(MouseEvent e){
				btn_rank.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				btn_rank.setIcon(rank_btn);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				main.change("rankPage");
			}
		});
		
		btn_end.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e){
				btn_end.setCursor(new Cursor(Cursor.HAND_CURSOR));
				btn_end.setIcon(entered_btn);
			}
			public void mouseExited(MouseEvent e){
				btn_end.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				btn_end.setIcon(exit_btn);
			}
			@Override
			public void mousePressed(MouseEvent e) {
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