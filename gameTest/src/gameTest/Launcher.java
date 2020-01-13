package gameTest;

import gameTest.display.display;

public class Launcher {
//starts the game
	public static int resX;
	public static int resY;
	public static void main(String[] args) {
		//resX = 608;
		//resY = 320;
	    resX = 800;
	    resY = 600;
		engine En = new engine("Game title",(int)resX,(int) resY);
		En.start();
	}
	public static int getResX() {
		return resX;
	}
	public static int getResY() {
		return resY;
	}

}
