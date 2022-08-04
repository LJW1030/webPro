package com.lec.ex06_volume;
// Speaker s = new Speaker(3);
// s.volumeUP(3)
public class Spearker implements IVolume {
	private final int SPEAKER_MAX_VOLUME=100;
	private final int SPEAKER_MIN_VOLUME=0;
	private int volumeLevel;
	public Spearker() {}
	public Spearker(int volumeLevel) {
		this.volumeLevel = volumeLevel;
	}

	@Override
	public void volumeUp() {
		if(volumeLevel < SPEAKER_MAX_VOLUME) {
			volumeLevel ++;
			System.out.println("����Ŀ ������ 1 �÷� ���� "+volumeLevel);
		}else {
			System.out.println("����Ŀ ������ �ִ�ġ�̹Ƿ� �ø��� ���մϴ�.");
		}
	}

	@Override
	public void volumeUp(int level) {
		if(volumeLevel + level <= SPEAKER_MAX_VOLUME) { // level ��ŭ ���� �ø�
			volumeLevel += level;
			System.out.println("����Ŀ ������ "+level+" �÷� ���� "+volumeLevel);
		}else { // level��ŭ �� �ø� ��� ex. ���� ����45, level10
			int tempLevel = SPEAKER_MAX_VOLUME - volumeLevel;
			volumeLevel = SPEAKER_MAX_VOLUME;
			System.out.println("����Ŀ ������ "+level+"��ŭ �� �ø��� "+tempLevel+"��ŭ �÷� �ִ�ġ"+SPEAKER_MAX_VOLUME+"�Դϴ�.");
		}
	}

	@Override
	public void volumeDown()
	{if(volumeLevel > SPEAKER_MIN_VOLUME) {
		volumeLevel --;
		System.out.println("����Ŀ ������ 1 ���� ���� "+volumeLevel);
	}else {
		System.out.println("����Ŀ ������ �ּ�ġ�̹Ƿ� �ø��� ���մϴ�.");
	}
			
		}
	

	@Override
	public void volumeDown(int level) {
		if(volumeLevel - level >= SPEAKER_MIN_VOLUME) {
			volumeLevel -= level;
			System.out.println("����Ŀ ������"+level+"���� ����"+volumeLevel);
		}else {
			int tempLevel =  volumeLevel;
			volumeLevel = SPEAKER_MIN_VOLUME;
			System.out.println("����Ŀ ������"+level+"��ŭ �� ������"+tempLevel+"��ŭ ���� �ּ�ġ"+SPEAKER_MIN_VOLUME+"�Դϴ�.");
		}
	}

}
