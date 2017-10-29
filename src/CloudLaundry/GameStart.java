package CloudLaundry;

import java.io.*;
import java.util.StringTokenizer;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import cloudlaundry.Main;

class GameObject {
	public int[] level = { 7, 12, 13 }; // 내려올 구름 갯수!
	public int[] speed = { 700, 500, 300 }; // 레벨에 따른 sleep time!!
	int lev = 0; // 레벨 0 - 1 - 2 setLev로 바꿀 예정입니당!

	public int[] getLevel() {
		return level;
	}

	public void setLevel(int[] level) {
		this.level = level;
	}

	public int getLev() {
		return lev;
	}

	public void setLev(int lev) {
		this.lev = lev;
	}
}

class Cloud extends GameObject {
	// x,y좌표
	// 속도
	// 터치메서드
	// 오염정도 (이미지로 바꿀 수 있게
	private int x, y;
	private int speed = 0; // y좌표에 추가해서 구름 내려가기
	private int pollut = 0;
	private int wait = 0;
	String cimg[] = { "CloudClean0.png", "CloudClean1.png", "CloudClean2.png", "CloudClean3.png", "CloudClean4.png" };
	int[] clickCloud = {0,5,8,13,19};
	private int clickNum = 0;
	// 구름오염도에 따른 구름!
	// ImageIcon[] iic;
	// iic[0] = new ImageIcon("CloudClean0.png");
	// iic1 = new ImageIcon("CloudClean1.png");
	// iic2 = new ImageIcon("CloudClean2.png");
	// iic3 = new ImageIcon("CloudClean3.png");
	// iic4 = new ImageIcon("CloudClean4.png");
	public Cloud() {
		pollut = (int) (Math.random() * 3) + 2;
		x = (int) (Math.random() * 506);
		y = 0;
		speed = (int) (Math.random() * 20) + 10;
		wait = (int) (Math.random() * 15); // 대기값을 주어서 0이 될때까지 구름객체가 나오지 않게 하는 방법!
		clickNum = clickCloud[pollut]; // 클릭해야 할 수 초기값, 오염수와 비례!
	}

	public int getWait() {
		return wait;
	}

	public void setWait(int wait) {
		this.wait = wait;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getPollut() {
		return pollut;
	}

	public void setPollut(int pollut) {
		this.pollut = pollut;
	}

	public int getClickNum() {
		return clickNum;
	}

	public void setClickNum(int clickNum) {
		this.clickNum = clickNum;
	}
	
}// cloud

public class GameStart extends JFrame {
	GameObject go = new GameObject();
	Cloud cloud[] = new Cloud[go.level[go.getLev()]];
	JButton butCloud[] = new JButton[go.level[go.getLev()]];
	Image screenImage;
	Graphics screenGraphic;
	private int mouseX, mouseY;
	JPanel leftJP = new JPanel(); // 구름있는 패널
	JPanel rightJP = new JPanel(); // 타임, 스코어, 네임, 메세지 패널

	Image background = new ImageIcon(Main.class.getResource("../image/GameBG.png")).getImage();

		// *****************************
	JLabel title = new JLabel(new ImageIcon(Main.class.getResource("../image/titleImage.png")));

	JLabel timer = new JLabel("100초");

	JLabel clock = new JLabel(new ImageIcon(Main.class.getResource("../image/Alarm01.png")));

	public GameStart() throws InterruptedException {
		setUndecorated(true); // 기본 메뉴바 안보임
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true); // 화면에 보이게 해줌

		// 사이즈
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		leftJP.setSize(630, 600);
		rightJP.setSize(265, 600);
		// 배경
		setBackground(new Color(0, 0, 0, 0));
		leftJP.setBackground(new Color(0, 0, 0, 0));
		rightJP.setBackground(new Color(0, 0, 0, 0));
		// 레이아웃
		setLayout(null);
		leftJP.setLayout(null);
		rightJP.setLayout(null);
		// 위치
		leftJP.setBounds(25, 55, 640, 625);
		rightJP.setBounds(690, 55, 285, 625);

		setLocationRelativeTo(null); // 중앙배치
		
		 ActionListener listener = new ActionListener() {
		        @Override
		        public void actionPerformed(ActionEvent e) {
		            if (e.getSource() instanceof JButton) {
		            	 ((Cloud)e.getSource()).setPollut(((Cloud)e.getSource()).getPollut()-1); //한번클릭할때마다 클릭해야할수--;
		            	 System.out.println((Cloud)e.getSource()+"오염도"+((Cloud)e.getSource()).getPollut());
		            }
		        }
		    };

		// 색깔
		// leftJP.setBackground(Color.BLUE);
		// rightJP.setBackground(Color.RED);
		JButton[] butCloud = new JButton[cloud.length];

		for (int i = 0; i < cloud.length; i++) {
			cloud[i] = new Cloud();
			System.out.println(i + "오염도 : " + cloud[i].getPollut());
			butCloud[i] = new JButton(new ImageIcon(cloud[i].cimg[cloud[i].getPollut()]));
			System.out.println(cloud[i].getPollut());
			// //온클릭시 pollut--;
			// //버튼 사이즈, add하기!;
			System.out.println(i + "x좌표 : " + cloud[i].getX());
			// butCloud[i].setBounds(cloud[i].getX(), cloud[i].getY(), 160, 124);
			// leftJP.add(butCloud[i]);
			// System.out.println(i+"번째 구름 생성");
			// add(leftJP);
			// Thread.sleep(500);
		} // for 초기 구름 생성
		
		while (true) {
			for (int i = 0; i < cloud.length; i++) {
				if (cloud[i].getWait() > 0) {
					cloud[i].setWait(cloud[i].getWait() - 1);
				} else {
					Thread.sleep(go.speed[go.getLev()]);
					System.out.println(i + "스피드" + cloud[i].getSpeed());
					butCloud[i].setBounds(cloud[i].getX(), cloud[i].getY(), 160, 124);
					leftJP.add(butCloud[i]);
					// 버튼 온클릭시 set바꿔주기
					butCloud[i].addActionListener(listener);
					
					leftJP.setVisible(true);
					add(leftJP);
					cloud[i].setY(cloud[i].getY() + cloud[i].getSpeed());
				} // else
					// rightJP.setVisible(true);
					// add(rightJP);
			} // for move
		} // while

		// 시간, 점수 업데이트

	}// 생성자 메서드

	
	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);

	}

	void screenDraw(Graphics g) {
		g.drawImage(background, 0, 0, null); // 단순이미지(배경)
		paintComponents(g); // 고정이미지(메뉴바)
		this.repaint();
	}

	public static void main(String[] args) throws InterruptedException {
		new GameStart();
	}
}