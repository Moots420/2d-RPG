package Sound;

import javax.sound.sampled.Clip;

import gameTest.Handler;

public class soundManager {

	public Clip clip;
	public soundManager(Handler handler) {

	}
	public void play(Clip clip) {
		if(!clip.isActive()) {
		clip.start();
		}
		
		if(clip.getFramePosition() == clip.getFrameLength()) {
			clip.stop();
			clip.setFramePosition(0);
			clip.start();
		}
		
	}

}
