package exceptionExs;

import java.text.SimpleDateFormat;
import java.util.Date;

// Friend f = new Friend("홍길동", "010-9999-9999");
// sysout(f) -> [이름]홍길동 [전화]***-****-9999 [입력일]22년4월1일
public class Friend {
	private String name;
	private String tel;
	private Date enterDate;
	public Friend(String name) {
		this.name = name;
		enterDate = new Date();
	}
	public Friend(String name, String tel) {
		this.name = name;
		this.tel = tel;
		enterDate = new Date();
	}	
	@Override
	public String toString() { // sysout(f) -> [이름]홍길동 [전화]***-****-9999 [입력일]22년4월1일
		if(tel != null) {
			String post = tel.substring(tel.lastIndexOf('-')+1);
			SimpleDateFormat sdf = new SimpleDateFormat("yy년M월d일친구됨");
			return "[이름]" +name+ "\t[전화]***-****-" +post+ "\t[입력일]" +sdf.format(enterDate);
		}else {
			SimpleDateFormat sdf = new SimpleDateFormat("yy년M월d일친구됨");
			return "[이름]" +name+ "\t\t[전화]없음" +"\t\t\t[입력일]" +sdf.format(enterDate);
		}
	}
	public Date getEnterDate() {
		return enterDate;
	}
	public void setEnterDate(Date enterDate) {
		this.enterDate = enterDate;
	}
}
