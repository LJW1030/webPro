package newexception;

public class AccountMain {
	
	public static void main(String[] args) {
		Account obj1 = new Account("111-111", "홍길동");
		Account obj2 = new Account("222-222", "김길길", 2000);
		obj1.deposit(1000);
		obj2.deposit(1000);
		try {
			obj1.withdraw(1500);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} // withdraw 메소드 선언시 throws가 있으면 호출시에도 try-catch
		try {
			obj2.withdraw(300);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
