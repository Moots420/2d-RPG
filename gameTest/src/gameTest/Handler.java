package gameTest;

import java.util.Random;

import Sound.soundManager;
import inventory.Notifier;

public class Handler {
	private engine Engine;
	private World world;

	private soundManager SoundManager;
	

public Handler(engine Engine) {

	this.Engine = Engine;
	SoundManager = new soundManager(this);
}
public Notifier getNotifier() {
	return getWorld().getNotifier();
}
public MouseManager getMouseManager() {
	return Engine.getMouseManager();
}
public soundManager getSoundManager() {
	return SoundManager;
}

public void setSoundManager(soundManager soundManager) {
	SoundManager = soundManager;
}

public GameCamera getGameCamera() {
	return Engine.getGameCamera();
	
}

public keyManager getKeyManager() {
	return Engine.getKeyManager();
	
}
public int getWidth() {
	return Engine.getWidth();
	
}
public int getHeight() {
	return Engine.getHeight();
	
}
public int getRandomNumber(int min, int max) {
	if (min >= max) {
		throw new IllegalArgumentException("max must be greater than min");
	}

	Random r = new Random();
	return r.nextInt(max-min + 1) + min;
	
	
}


public engine getEngine() {
	return Engine;
}
public void setEngine(engine engine) {
	Engine = engine;
}
public World getWorld() {
	return world;
}
public void setWorld(World world) {
	this.world = world;
}
}
