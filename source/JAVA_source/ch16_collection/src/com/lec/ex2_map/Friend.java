package com.lec.ex2_map;

import java.text.SimpleDateFormat;
import java.util.Date;
// Friend f = new Friend("全","010-9999-9999")
// sysout(F) -> 全狼 楷遏贸 010-9999-9999, 积老: 04岿 04老
public class Friend {

	private String name;
	private String tel;
	private Date birth;
	public Friend(String name, String tel) {
		super();
		this.name = name;
		this.tel = tel;
	}
	public Friend(String name, String tel, Date birth) {
		super();
		this.name = name;
		this.tel = tel;
		this.birth = birth;
	}
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("MM岿 dd老");
		if(birth !=null) {
			return name+"狼 楷遏贸 "+tel+", 积老"+sdf.format(birth);
		}else {
			return name+"狼 楷遏贸 "+tel;
		}//if
	}//toString
}//class