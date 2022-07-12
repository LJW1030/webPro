package exceptionExs;

import java.text.SimpleDateFormat;
import java.util.Date;

// Friend f = new Friend("ȫ�浿", "010-9999-9999");
// sysout(f) -> [�̸�]ȫ�浿 [��ȭ]***-****-9999 [�Է���]22��4��1��
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
	public String toString() { // sysout(f) -> [�̸�]ȫ�浿 [��ȭ]***-****-9999 [�Է���]22��4��1��
		if(tel != null) {
			String post = tel.substring(tel.lastIndexOf('-')+1);
			SimpleDateFormat sdf = new SimpleDateFormat("yy��M��d��ģ����");
			return "[�̸�]" +name+ "\t[��ȭ]***-****-" +post+ "\t[�Է���]" +sdf.format(enterDate);
		}else {
			SimpleDateFormat sdf = new SimpleDateFormat("yy��M��d��ģ����");
			return "[�̸�]" +name+ "\t\t[��ȭ]����" +"\t\t\t[�Է���]" +sdf.format(enterDate);
		}
	}
	public Date getEnterDate() {
		return enterDate;
	}
	public void setEnterDate(Date enterDate) {
		this.enterDate = enterDate;
	}
}
