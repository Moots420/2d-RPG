package gameTest.display;

import java.awt.image.BufferedImage;

public class Animation {
private int speed, index;
private long lastTime, timer;
private BufferedImage[] frames;

public Animation(int speed, BufferedImage[] frames) {
	this.speed = speed;
	this.frames = frames;
	index = 0;
	timer = 0;
	lastTime = System.currentTimeMillis();
}

public void tick() {
	timer += System.currentTimeMillis() - lastTime;
lastTime = System.currentTimeMillis();

if(timer > speed) {
	index ++;
	timer = 0;

			if(index >= frames.length) {
				index = 0;
			}
}
}




public void setSpeed(int s) {
	this.speed = s;
	
}


public int getSpeed() {
	return speed;
}

public BufferedImage getCurrentFrame() {
return frames[index];	
}
public void setCurrentFrame(int frame) {
	
	index = frame;


}


}
