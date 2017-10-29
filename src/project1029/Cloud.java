package project1029;

import javax.swing.JPanel;



class GameObject {
	public int[] level = { 7,13,21}; // 내려올 구름 갯수!
	public int[] speed = { 200, 150, 100 }; // 레벨에 따른 sleep time!!
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
	int pollut = 0;
	private int wait = 0;
	
	int[] clickCloud = {0,5,8,13,19};
	private int clickNum = 0;
	
	public Cloud() {
		pollut = 17;  //오염도(버튼 번호)
		x = (int) (Math.random() * 506);           //X좌표 (처음생성되는 위치)
		y = 0;                                                     //Y좌표 
		speed = (int) (Math.random() * 20) + 10;     // 떨어지는 시간 
		wait = (int) (Math.random() * 15); // 대기값을 주어서 0이 될때까지 구름객체가 나오지 않게 하는 방법!
//		clickNum = clickCloud[pollut]; // 클릭해야 할 수 초기값, 오염수와 비례!
		clickNum = pollut;
		
		System.out.println(
				"오염도 "+ pollut + ", ( "+x+", "+y+") , 스피드 "+speed+", 기다리는 시간"+wait+", 클릭해야할 수!=num "+clickNum	);
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