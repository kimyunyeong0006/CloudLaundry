package CloudLaundry;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import project1025.Main1025;


public class GameTest extends JFrame{
	Image background = null;
	
	String cImg[] = { 
			"Cloud_img-17.png", "Cloud_img-16.png", "Cloud_img-15.png", "Cloud_img-14.png", "Cloud_img-14.png" 
			,"Cloud_img-13.png", "Cloud_img-12.png", "Cloud_img-11.png", "Cloud_img-10.png", "Cloud_img-09.png"
			,"Cloud_img-08.png", "Cloud_img-07.png", "Cloud_img-06.png", "Cloud_img-05.png", "Cloud_img-04.png"
			,"Cloud_img-03.png", "Cloud_img-02.png", "Cloud_img-01.png"};
	int cnt = 17;
	
	public GameTest(){
		background = new ImageIcon(Main1025.class.getResource("../image/game_bg.png")).getImage();
		JPanel jp = new JPanel();
		getContentPane().add(jp);
		jp.setLayout(null);
		
//		JButton[] btn_arr = new JButton[3];
		JButton button1 = new JButton("");
		button1.setBounds(12, 10, 112, 64);
		button1.setIcon(new ImageIcon(GameTest.class.getResource("/cloudImage/Cloud_img-01.png")));
		button1.setBorderPainted(false);
		button1.setContentAreaFilled(false);
		button1.setFocusPainted(false);
		jp.add(button1);
		
//		button1.addActionListener(new ActionListener(){
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				button.setIcon(new ImageIcon(GameTest.class.getResource("/cloudImage/"+cImg[cnt--])));
//			}
//		});
		
		ActionListener listener = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==button1){
					if(cnt >= 0){
						button1.setIcon(new ImageIcon(GameTest.class.getResource("/cloudImage/"+cImg[cnt--])));
					}
					
				}
			}
		};
		button1.addActionListener(listener);
		
		setSize(300,300);
		setVisible(true);
	}
	public static void main(String[] args) {
		new GameTest();
	}
	
}
