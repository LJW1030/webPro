package singletion1;

public class SingletonClass {
	private int i;
	// ��ü ���������� �� ��ü �ּҸ� return�ϰ� 
	// ��ü ���� �������� ��ü �����ϰ� �� �ּҸ� return
	private static SingletonClass INSTANCE;
	public static SingletonClass getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new SingletonClass();
		}
		return INSTANCE;
	}
	private SingletonClass() {}
	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}
}
