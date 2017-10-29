package project1027;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import CloudLaundry.GameTest;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameStart extends JPanel{
	Image background = null;
	String user;
	long startTime, elapsedTime;
	String cImg[] = { 
			"Cloud_img-17.png", "Cloud_img-16.png", "Cloud_img-15.png", "Cloud_img-14.png", "Cloud_img-14.png" 
			,"Cloud_img-13.png", "Cloud_img-12.png", "Cloud_img-11.png", "Cloud_img-10.png", "Cloud_img-09.png"
			,"Cloud_img-08.png", "Cloud_img-07.png", "Cloud_img-06.png", "Cloud_img-05.png", "Cloud_img-04.png"
			,"Cloud_img-03.png", "Cloud_img-02.png", "Cloud_img-01.png"};
	
	GameObject go = new GameObject();
	public Main1027 main;
	
	Cloud cloud[] = new Cloud[go.level[go.getLev()]];
	JButton cloud_btn[] = new JButton[go.level[go.getLev()]];
	
	//int t = 20;
	JLabel timer;
	ActionListener listener[] = new ActionListener[cloud.length];
	
	public void listeneradd(){
		for(int i=0;i<cloud.length;i++ ){
			int j=i;
			listener[i] = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
					if(cloud[j].getClickNum() > 0){
						cloud[j].setClickNum(cloud[j].getClickNum()-1);
						((AbstractButton)e.getSource()).setIcon(new ImageIcon
								(GameStart.class.getResource("/cloudImage/"+cImg[cloud[j].getClickNum()])));
						System.out.println((AbstractButton)e.getSource());
					}
					
					// 어레이아웃오브바운드 ㅎ해결하기
					else {
						((AbstractButton)e.getSource()).setVisible(false);
					}
				}
		};
		}
	}
	
	public GameStart(Main1027 main) {
		//System.out.println(elapsedTime + " ms");
		background = new ImageIcon(Main1027.class.getResource("../image/game_bg.png")).getImage();
		this.main = main;
		setSize(1010,710);
		setLayout(null);
		setVisible(true);
		listeneradd();
	}
	
	public void paintComponent(Graphics g) {
		g.drawImage(background, 0, 0, null);
		setOpaque(false);
		super.paintComponent(g);
	}
	
	public void cloudMove(){
		startTime = System.currentTimeMillis();	
		for(int i=0;i<cloud_btn.length;i++){
			cloud[i] = new Cloud();
			cloud_btn[i] = new JButton(new ImageIcon(GameStart.class.getResource("/cloudImage/"+cImg[cloud[i].pollut])));
			System.out.println(cloud[i].getPollut());
			System.out.println(i + "x좌표 : " + cloud[i].getX());
			cloud_btn[i].setBorderPainted(false);
			cloud_btn[i].setContentAreaFilled(false);
			cloud_btn[i].setFocusPainted(false);
			add(cloud_btn[i]);
			cloud_btn[i].addActionListener(listener[i]);
		}
		
		while (true) {
			for (int i = 0; i < cloud_btn.length; i++) {
				if (cloud[i].getWait() > 0) {
					cloud[i].setWait(cloud[i].getWait() - 1);
				} else {
					try {
						Thread.sleep(go.speed[go.getLev()]);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(i + "스피드"+ cloud[i].getSpeed());
					cloud_btn[i].setBounds(cloud[i].getX(), cloud[i].getY(), 160, 124);
//					cloud_btn[i].addActionListener(listener);
					cloud[i].setY(cloud[i].getY() + cloud[i].getSpeed());
				} // else
			} // for move	
		} // while
	}//cloud move
	int minute;
	int sec;
	public void gameTimer() throws InterruptedException {
		Thread.sleep(1000); //1초마다 업데이트해주기!
		elapsedTime = System.currentTimeMillis() - startTime;
		minute = (int)elapsedTime/60;
		sec = (int)elapsedTime%60;
		timer = new JLabel(minute+":"+sec);
		//우ㅣ치지정, add, 스레드 처리
	}
	
	
}//class gameStart