
package inventory;

import java.awt.Color;
import java.awt.Graphics;

import Text;
import gameTest.Handler;
import gameTest.entity;
import gameTest.display.Assets;

public class Notifier{
    private String[] msg = new String[3];
    private int timer = 0;
    private Color alpha1 = new Color(255,255,255,175);
    private Color alpha2 = new Color(255,255,255,100);
    public Notifier(Handler handler, float x, float y, int width, int height) {
  
       msg[0] = "";
       msg[1] = "";
       msg[2] = "";
		
	}
         public void pushNotif (String message) {
            msg[2] = msg[1];
            msg[1] = msg[0];
            msg[0] = message;

        	
        	 timer = 0;
         }
		public void tick() {
			
		timer ++;
		if(timer>60*3) {
			//msg[2] = msg[1];
			//msg[1] = msg[0];
			//msg[0] = "";
			pushNotif("");
			timer = 0;
		}
		
			
		}
		public void render(Graphics g) {
			
			Text.drawString(g, msg[0], 400,32, true, Color.WHITE , Assets.font16);
			
			Text.drawString(g, msg[1], 400,64, true, alpha1 , Assets.font12);
			Text.drawString(g, msg[2], 400,96, true, alpha2 , Assets.font10);
		}
	
         
}
