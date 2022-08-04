package com.lec.ex02_store;
// HeadQuarterStore store = new HeadQuarterStore("본사"); 객체 생성 불가

public interface HeadQuarterStore {	
	public /* abstract */ void kimchi();
	public /* abstract */ void bude(); 
	public /* abstract */ void bibim(); 
	public /* abstract */ void sunde(); 
	public /* abstract */ void gonggibab();
	public String getStr();
}
