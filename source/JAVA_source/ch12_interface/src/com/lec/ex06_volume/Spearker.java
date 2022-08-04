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
			System.out.println("스피커 볼륨을 1 올려 현재 "+volumeLevel);
		}else {
			System.out.println("스피커 볼륨이 최대치이므로 올리지 못합니다.");
		}
	}

	@Override
	public void volumeUp(int level) {
		if(volumeLevel + level <= SPEAKER_MAX_VOLUME) { // level 만큼 볼륨 올림
			volumeLevel += level;
			System.out.println("스피커 볼륨을 "+level+" 올려 현재 "+volumeLevel);
		}else { // level만큼 못 올릴 경우 ex. 현재 볼륨45, level10
			int tempLevel = SPEAKER_MAX_VOLUME - volumeLevel;
			volumeLevel = SPEAKER_MAX_VOLUME;
			System.out.println("스피커 볼륨을 "+level+"만큼 못 올리고 "+tempLevel+"만큼 올려 최대치"+SPEAKER_MAX_VOLUME+"입니다.");
		}
	}

	@Override
	public void volumeDown()
	{if(volumeLevel > SPEAKER_MIN_VOLUME) {
		volumeLevel --;
		System.out.println("스피커 볼륨을 1 내려 현재 "+volumeLevel);
	}else {
		System.out.println("스피커 볼륨이 최소치이므로 올리지 못합니다.");
	}
			
		}
	

	@Override
	public void volumeDown(int level) {
		if(volumeLevel - level >= SPEAKER_MIN_VOLUME) {
			volumeLevel -= level;
			System.out.println("스피커 볼륨을"+level+"내려 현재"+volumeLevel);
		}else {
			int tempLevel =  volumeLevel;
			volumeLevel = SPEAKER_MIN_VOLUME;
			System.out.println("스피커 볼륨을"+level+"만큼 못 내리고"+tempLevel+"만큼 내려 최소치"+SPEAKER_MIN_VOLUME+"입니다.");
		}
	}

}
