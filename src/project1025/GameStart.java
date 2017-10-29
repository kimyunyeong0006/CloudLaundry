package project1025;

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


public class GameStart extends JPanel{
	Image background = null;
	String user;
	
	String cImg[] = { 
			"Cloud_img-17.png", "Cloud_img-16.png", "Cloud_img-15.png", "Cloud_img-14.png", "Cloud_img-14.png" 
			,"Cloud_img-13.png", "Cloud_img-12.png", "Cloud_img-11.png", "Cloud_img-10.png", "Cloud_img-09.png"
			,"Cloud_img-08.png", "Cloud_img-07.png", "Cloud_img-06.png", "Cloud_img-05.png", "Cloud_img-04.png"
			,"Cloud_img-03.png", "Cloud_img-02.png", "Cloud_img-01.png"};
	int cnt = 17;
	
	GameObject go = new GameObject();
	public Main1025 main;
	
	Cloud cloud[] = new Cloud[go.level[go.getLev()]];
	JButton cloud_btn[] = new JButton[go.level[go.getLev()]];
	
	int t = 20;
	JLabel timer = new JLabel(t+"초");
	
	ActionListener listener = new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e) {
				if(cnt >= 0){
					((AbstractButton)e.getSource()).setIcon(new ImageIcon
							(GameTest.class.getResource("/cloudImage/"+cImg[cnt--])));
					System.out.println((AbstractButton)e.getSource());
				}
				else {
					((AbstractButton)e.getSource()).setVisible(false);
				}
			}
	};
	
	
	public GameStart(Main1025 main) {
		background = new ImageIcon(Main1025.class.getResource("../image/game_bg.png")).getImage();
		this.main = main;
		setSize(1010,710);
		setLayout(null);
		setVisible(true);
	}
	
	public void paintComponent(Graphics g) {
		g.drawImage(background, 0, 0, null);
		setOpaque(false);
		super.paintComponent(g);
	}
	
	public void cloudMove(){
		for(int i=0;i<cloud_btn.length;i++){
			cloud[i] = new Cloud();
			cloud_btn[i] = new JButton(new ImageIcon(GameStart.class.getResource("/cloudImage/"+cImg[cloud[i].pollut])));
			System.out.println(cloud[i].getPollut());
			System.out.println(i + "x좌표 : " + cloud[i].getX());
			cloud_btn[i].setBorderPainted(false);
			cloud_btn[i].setContentAreaFilled(false);
			cloud_btn[i].setFocusPainted(false);
			add(cloud_btn[i]);
			cloud_btn[i].addActionListener(listener);
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
	}
}
