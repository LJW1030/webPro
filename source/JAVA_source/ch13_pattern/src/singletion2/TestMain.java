package singletion2;

public class TestMain {

	public static void main(String[] args) {
		FirstClass firstobj = new FirstClass();
		SecondClass secondObj = new SecondClass();
		SingletonClass singobj = SingletonClass.getInstance();
		System.out.println("MainÇÔ¼ö¿¡¼­ ½Ì±ÛÅæ °´Ã¼ÀÇ i°ª : "+singobj.getI());
	}

}
