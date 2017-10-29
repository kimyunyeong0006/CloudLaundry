package CloudLaundry;


import java.awt.Label;
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

public class TestCL extends JFrame{
	JFrame f = new JFrame();
	String user;
//	private JLabel rank_view[] = new JLabel[5]; 
	public TestCL(){

		JPanel jp = new JPanel();
		JButton btn_how = new JButton("게임방법");
		JButton btn_start = new JButton("게임시작");
		JButton btn_rank = new JButton("랭킹보기");
		JButton btn_end = new JButton("게임종료");
		jp.add(btn_how);
		jp.add(btn_start);
		jp.add(btn_rank);
		jp.add(btn_end);
		
		add(jp);
		
		
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
				IOrank io = new IOrank(f,"rank.txt","김윤영",44);
				jp.setVisible(false);

				
			}
		});
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		TestCL test = new TestCL();
	}
}

class IOrank extends JFrame {
	private JLabel rank_view[] = new JLabel[5]; ; 
	int length, num=0;
	String[] name;
	int[] score ,rank;
	JPanel rank_p;
	String addname;
	int addscore;
	JFrame F = new JFrame();
	int n; //유입경로 .. ? 
	
	public IOrank(String fname){
		n=0;
		input_data(fname);
		output_data();
	}
	public IOrank(JFrame f, String fname, String addname, int addscore){
		F=f;
		n=1;
		this.addname = addname;
		this.addscore = addscore;
		
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
		
		name = new String[length+n];
		score = new int[length+n];
		rank = new int[length+n];
		
		for (int j = 0; j < length; j++) {
			parse.nextToken();
			rank[j] = 1;
			name[j] = parse.nextToken();
			score[j] = Integer.parseInt(parse.nextToken());
		}
		if(n==1){
			name[length]=addname;
			score[length]=addscore;
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
		System.out.println("순위\t이름\t점수");
		rank_p = new JPanel();
		JButton btn_test = new JButton("테스트");
		rank_p.add(btn_test);
		for (int i = 1; i <= length; i++) {
			for(int j = 0; j < length ; j++){
				if(i==rank[j]){
					System.out.println(i+"\t"+name[j]+"\t"+score[j]+"\t");
					rank_view[i] = new JLabel(i+"\t"+name[j]+"\t"+score[j]+"\t"); 	
					rank_p.add(rank_view[i]);
				}
			}		
		}		
		add(rank_p);
	}
	
}

