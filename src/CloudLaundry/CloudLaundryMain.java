package CloudLaundry;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


class IndexPage extends JPanel{
	String user;
	private CloudLaundryMain main;
	public IndexPage(CloudLaundryMain main){
		this.main = main;
		JButton btn_how = new JButton("게임방법");
		JButton btn_start = new JButton("게임시작");
		JButton btn_rank = new JButton("랭킹보기");
		JButton btn_end = new JButton("게임종료");
		add(btn_how);
		add(btn_start);
		add(btn_rank);
		add(btn_end);
		
		setSize(1000,700);
		btn_start.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				user = JOptionPane.showInputDialog(null,"닉네임을 입력해주세요!");
				System.out.println(user);
			}
		});
		
		btn_rank.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				main.change("rankPage");
			}
		});
		setVisible(true);
	}
}

class IORank extends JPanel {
	private JLabel rank_view[] = new JLabel[5]; ; 
	int length, num=0;
	String[] name;
	int[] score ,rank;
	String addname;
	int addscore;
	int n; //유입경로 .. ? 
	private CloudLaundryMain main;
	public IORank(CloudLaundryMain main, String fname){
		this.setLayout(null); 
		this.main = main;
		input_data(fname);
		sort_data();
		output_data();
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
		JLabel rank_title = new JLabel("순위          이름         점수");
		rank_title.setBounds(100, 0,200,200);
		add(rank_title);
		for (int i = 0; i <= length; i++) {
			for(int j = 0; j < length ; j++){
				if(i==rank[j]){
					str = (i+1)+"            "+name[j]+"         "+score[j]+"점";
					rank_view[i] = new JLabel(str); 	 //레이블 출력
					rank_view[i].setBounds(100,(i+1)*50,200,200);
					add(rank_view[i]);
				}
			}			
		}		
	}
	
}


public class CloudLaundryMain extends  JFrame{
	//패널추가
	public IndexPage indexPage = null;
	public IORank ioRank = null;
	
	public static void main(String[] args) throws IOException {
		CloudLaundryMain main = new CloudLaundryMain();
		main.setTitle("구름세탁소 | 김윤영 이예본");
		
		//패널추가
		main.indexPage = new IndexPage(main);
		main.ioRank = new IORank(main,"rank.txt");
		
		main.add(main.indexPage);
		main.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		main.setSize(700,500);
		main.setVisible(true);
	}

	public void change(String panelName) {
		if(panelName.equals("rankPage"))
		getContentPane().removeAll();
		getContentPane().add(ioRank);
		revalidate();
		repaint();
	}
}


