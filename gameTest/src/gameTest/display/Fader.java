package gameTest.display;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import gameTest.Handler;

public class Fader {
	private Rectangle fade = new Rectangle(0,0,800,600);
	public int alpha = 0;
	private Color fadeEffect;
	int fadeSpeed = 10;
    public boolean fading;
	public Fader(Handler handler) {
	
	}
	public void tick() {
		   fadeEffect = new Color(0,0,0,alpha);
		   if(fading) {
		fadeIn();
		if(alpha>=255) {
			alpha = 255;
			fading = false;
		}
		   }else {
		fadeOut();
		   if(alpha<=0) {
			   alpha = 0;
		   }
		   }
	}
	public boolean isFading() {
		return fading;
	}
	public void render(Graphics g) {
		g.setColor(fadeEffect);
		g.fillRect(fade.x, fade.y, fade.width, fade.height);
		
	}
	public void fadeIn() {
		alpha += fadeSpeed;
	}
public void fadeOut() {
	alpha -= fadeSpeed;
	}
public void fade() {
	fading = true;
}
}
