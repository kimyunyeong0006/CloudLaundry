package project1029;

import javax.swing.JPanel;



class GameObject {
	public int[] level = { 7,13,21}; // ������ ���� ����!
	public int[] speed = { 200, 150, 100 }; // ������ ���� sleep time!!
	int lev = 0; // ���� 0 - 1 - 2 setLev�� �ٲ� �����Դϴ�!

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
	// x,y��ǥ
	// �ӵ�
	// ��ġ�޼���
	// �������� (�̹����� �ٲ� �� �ְ�
	private int x, y;
	private int speed = 0; // y��ǥ�� �߰��ؼ� ���� ��������
	int pollut = 0;
	private int wait = 0;
	
	int[] clickCloud = {0,5,8,13,19};
	private int clickNum = 0;
	
	public Cloud() {
		pollut = 17;  //������(��ư ��ȣ)
		x = (int) (Math.random() * 506);           //X��ǥ (ó�������Ǵ� ��ġ)
		y = 0;                                                     //Y��ǥ 
		speed = (int) (Math.random() * 20) + 10;     // �������� �ð� 
		wait = (int) (Math.random() * 15); // ��Ⱚ�� �־ 0�� �ɶ����� ������ü�� ������ �ʰ� �ϴ� ���!
//		clickNum = clickCloud[pollut]; // Ŭ���ؾ� �� �� �ʱⰪ, �������� ���!
		clickNum = pollut;
		
		System.out.println(
				"������ "+ pollut + ", ( "+x+", "+y+") , ���ǵ� "+speed+", ��ٸ��� �ð�"+wait+", Ŭ���ؾ��� ��!=num "+clickNum	);
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