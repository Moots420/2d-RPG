package gameTest.display;

import java.awt.Color;
import java.awt.Graphics;

import Text;
import gameTest.Handler;

public class DayNight {
	float currentTime;
   int timer,shadeTime;
   int alpha,maxAlpha;
   public Color nightShade;
	
	public DayNight(Handler handler) {
	   
	   maxAlpha = 90;
	   timer = 1;
	   
	   
	   
   }
	public void tick() {
		 nightShade = new Color(48,96,130,alpha);
		 currentTime += .1;
		 if(timer > currentTime+.6) {
			 timer += 1;
			timer = (int)currentTime;
		 }
		}
	
	
	public void render(Graphics g) {
		    g.setColor(nightShade);
			g.fillRect(0, 0, 800, 600);
	Text.drawString(g, "TIME: " +Integer.toString(timer), 20, 600, false, Color.white, Assets.font16);
	}
}
