package com.lec.ex06_volume;
// TV tv = new TV(3);
// tv.volumeUP(3)
public class TV implements IVolume {
	private final int TV_MAX_VOLUME=50;
	private final int TV_MIN_VOLUME=0;
	private int volumeLevel;
	public TV() {}
	public TV(int volumeLevel) {
		this.volumeLevel = volumeLevel;
	}

	@Override
	public void volumeUp() {
		if(volumeLevel < TV_MAX_VOLUME) {
			volumeLevel ++;
			System.out.println("TV ������ 1 �÷� ���� "+volumeLevel);
		}else {
			System.out.println("TV ������ �ִ�ġ�̹Ƿ� �ø��� ���մϴ�.");
		}
	}

	@Override
	public void volumeUp(int level) {
		if(volumeLevel + level <= TV_MAX_VOLUME) { // level ��ŭ ���� �ø�
			volumeLevel += level;
			System.out.println("TV ������ "+level+" �÷� ���� "+volumeLevel);
		}else { // level��ŭ �� �ø� ��� ex. ���� ����45, level10
			int tempLevel = TV_MAX_VOLUME - volumeLevel;
			volumeLevel = TV_MAX_VOLUME;
			System.out.println("TV ������ "+level+"��ŭ �� �ø��� "+tempLevel+"��ŭ �÷� �ִ�ġ"+TV_MAX_VOLUME+"�Դϴ�.");
		}
	}

	@Override
	public void volumeDown()
	{if(volumeLevel > TV_MIN_VOLUME) {
		volumeLevel --;
		System.out.println("TV ������ 1 ���� ���� "+volumeLevel);
	}else {
		System.out.println("TV ������ �ּ�ġ�̹Ƿ� �ø��� ���մϴ�.");
	}
			
		}
	

	@Override
	public void volumeDown(int level) {
		if(volumeLevel - level >= TV_MIN_VOLUME) {
			volumeLevel -= level;
			System.out.println("TV ������"+level+"���� ����"+volumeLevel);
		}else {
			int tempLevel =  volumeLevel;
			volumeLevel = TV_MIN_VOLUME;
			System.out.println("TV ������"+level+"��ŭ �� ������"+tempLevel+"��ŭ ���� �ּ�ġ"+TV_MIN_VOLUME+"�Դϴ�.");
		}
	}

}
