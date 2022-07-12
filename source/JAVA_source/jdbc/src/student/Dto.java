package student;

public class Dto {

	private int rank;
	private int mNo;
	private String sNo;
	private String mName;
	private String sName;
	private int score;
	public Dto() {}
	public Dto(String sName, String mName, int score) {
		super();
		this.mName = mName;
		this.sName = sName;
		this.score = score;
	}
	
	public Dto(String sNo, String sName, String mName, int score) {
		super();
		this.sNo = sNo;
		this.mName = mName;
		this.sName = sName;
		this.score = score;
	}
	public Dto(int rank, String sNo, String sName, String mName, int score) {
		super();
		rank = rank;
		this.sNo = sNo;
		this.mName = mName;
		this.sName = sName;
		this.score = score;
	}
	@Override
	public String toString() {
		if(rank!=0) {
		return rank+"µî\t"+sName+"\t"+mName+"\t"+score;
	}else {
		return sNo+"\t"+sName+"\t"+mName+"\t"+score;
	}
}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public int getmNo() {
		return mNo;
	}
	public void setmNo(int mNo) {
		this.mNo = mNo;
	}
	public String getsNo() {
		return sNo;
	}
	public void setsNo(String sNo) {
		this.sNo = sNo;
	}
	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
}
