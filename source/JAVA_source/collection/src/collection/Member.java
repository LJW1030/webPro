package collection;

public class Member {

	private String name;
	private String tel;
	private String address;
	public Member(String name, String tel, String address) {
		this.name = name;
		this.tel = tel;
		this.address = address;
	}
	@Override
	public String toString() {
		return name +"\t" + tel +"\t" + address;
	}
	public String getTel() {
		return tel;
	}
}
