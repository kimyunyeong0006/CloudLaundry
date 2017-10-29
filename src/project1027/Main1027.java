package project1027;

import java.io.IOException;

import javax.swing.JFrame;

public class Main1027 extends  JFrame{
	public String user;
	//패널추가
	
	static Main1027 main;
	public IndexPage indexPage = null;
	public IORank ioRank = null;
	public Howtoplay howto = null;
	public static GameStart gamePage = null;
	
	public static void main(String[] args) throws IOException {
		main = new Main1027();
		main.setTitle("구름세탁소 | 김윤영 이예본");
		
		//패널추가
		main.indexPage = new IndexPage(main);
		main.ioRank = new IORank(main,"rank.txt");
		main.howto = new Howtoplay(main);
//		main.gamePage = new GameStart(main);
		
		main.add(main.indexPage);
		main.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		main.setVisible(true);
		main.setSize(1015,710);
		
		Music introMusic = new Music("introMusic.mp3", true);
		introMusic.start();
	}
	
	public void setUser(String user){
		this.user = user;
	}
	public String getUser(){
		return user;
	}
	
	public void change(String panelName) {
		if(panelName.equals("rankPage")){
			getContentPane().removeAll();
			getContentPane().add(ioRank);
			revalidate();
			repaint();
		}
		else if(panelName.equals("indexPage")){
			getContentPane().removeAll();
			getContentPane().add(indexPage);
			revalidate();
			repaint();
		}
		else if(panelName.equals("howtoPage")){
			getContentPane().removeAll();
			getContentPane().add(howto);
			revalidate();
			repaint();
		}
		else if(panelName.equals("gamePage")){
			
			getContentPane().removeAll();
			
			revalidate();
			repaint();
			gamePage = new GameStart(main);
//			getContentPane().add(gamePage);
//			gamePage.ch=true;
		}
	}
}
