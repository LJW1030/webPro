package ex_parentchild;

public class Main {

	public static void main(String[] args) {
		
		ChildClass child = new ChildClass();
		System.out.println(child.cStr);
		child.getMamiName();
		child.getPapaName();
	}

}
