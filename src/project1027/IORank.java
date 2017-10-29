package project1027;

import java.awt.Color;
import java.awt.Cursor;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;

class IORank extends JPanel {
	private ImageIcon start_btn = new ImageIcon(Main1027.class.getResource("../image/start_btn.png")); 
	private ImageIcon entered_btn = new ImageIcon(Main1027.class.getResource("../image/entered_btn.png"));
	private ImageIcon main_btn = new ImageIcon(Main1027.class.getResource("../image/main_btn.png"));
	
	
	Image background = null;
	String user;
	private JLabel rank_view[] = new JLabel[5]; ; 
	int length, num=0;
	String[] name;
	int[] score ,rank;
	String addname;
	int addscore;
	int n; //유입경로 .. ? 
	private Main1027 main;
	
	public IORank(Main1027 main, String fname){
		background = new ImageIcon(Main1027.class.getResource("../image/rank_bg.png")).getImage();
		this.setLayout(null); 
		this.main = main;
		input_data(fname);
		sort_data();
		output_data();
		setSize(1010,710);
		
		
		JButton btn_start = new JButton();
		btn_start.setIcon(start_btn);
		btn_start.setBounds(272,546, 200, 63);
		btn_start.setBorderPainted(false);
		btn_start.setContentAreaFilled(false);
		add(btn_start);
		
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
		
		JButton btn_main = new JButton();
		btn_main.setIcon(main_btn);
		btn_main.setBounds(528, 546, 200, 63);
		btn_main.setBorderPainted(false);
		btn_main.setContentAreaFilled(false);
		add(btn_main);
		
		btn_main.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e){
				btn_main.setCursor(new Cursor(Cursor.HAND_CURSOR));
				btn_main.setIcon(entered_btn);
			}
			public void mouseExited(MouseEvent e){
				btn_main.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				btn_main.setIcon(main_btn);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				main.change("indexPage");
			}
		});
	}
	
	public void input_data(String fname) {
		try {
			FileReader fr = new FileReader(new File(fname));
			BufferedReader br = new BufferedReader(fr);
			process(br);
		} catch (IOException e) {
			System.err.println(e);
		}
	}

	public void process(BufferedReader br) {  //버퍼 전달! 
		String csvStr = "";
		String tmpStr = "";

		do {
			try {
				tmpStr = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (tmpStr != null) {
				csvStr += tmpStr + "\t";
			}
		} while (tmpStr != null);
		StringTokenizer parse = new StringTokenizer(csvStr, "\t");
		
		//length = parse.countTokens() / 3;
		
		length = 5;
		
		name = new String[length];
		score = new int[length];
		rank = new int[length];
		
		for (int j = 0; j < length; j++) {
			parse.nextToken();
			rank[j] = 0;
			name[j] = parse.nextToken();
			score[j] = Integer.parseInt(parse.nextToken());
		}
	}

	public void sort_data() {
		for(int i=0;i<length;i++){
			for(int j=0;j<length;j++){
				if(score[i]>score[j]){
					rank[j]++;
				}
			}
		}
	}

	public void output_data() {
		String str;
		setBackground(Color.white); 
		JLabel rank_title = new JLabel("순위           이름          점수");
		rank_title.setFont(new Font("함초롬돋움", Font.PLAIN, 16));
		rank_title.setBounds(407, 165,280,30);
		add(rank_title);
		
		
		for (int i = 0; i <= length; i++) {
			for(int j = 0; j < length ; j++){
				if(i==rank[j]){
					str = (i+1)+"            "+name[j]+"         "+score[j]+"점";
					rank_view[i] = new JLabel(str); 	 //레이블 출력
					rank_view[i].setBounds(407,110+(i+2)*55,280,30);
					rank_view[i].setFont(new Font("함초롬돋움", Font.PLAIN, 17));
					add(rank_view[i]);
				}
			}			
		}		
	}
	public void paintComponent(Graphics g) {
		g.drawImage(background, 0, 0, null);
		setOpaque(false);
		super.paintComponent(g);
	}
}