package project1024;

import java.io.IOException;

import javax.swing.JFrame;

public class Main1024 extends  JFrame{
	public String user;
	//패널추가
	
	public IndexPage indexPage = null;
	public IORank ioRank = null;
	public Howtoplay howto = null;
	
	public static void main(String[] args) throws IOException {
		Main1024 main = new Main1024();
		main.setTitle("구름세탁소 | 김윤영 이예본");
		
		
		//패널추가
		main.indexPage = new IndexPage(main);
		main.ioRank = new IORank(main,"rank.txt");
		main.howto = new Howtoplay(main);
		
		main.add(main.indexPage);
		main.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		main.setVisible(true);
		main.setSize(1015,710);
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
	}
}
