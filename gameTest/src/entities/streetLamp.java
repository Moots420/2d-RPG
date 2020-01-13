package entities;

import java.awt.Graphics;

import gameTest.Handler;
import gameTest.display.Animation;
import gameTest.display.Assets;

public class streetLamp extends StaticEntity{
    private Animation streetLampAnim;
	public streetLamp(Handler handler, float x, float y){
		super(handler, x, y, 32, 66, false, "Street Lamp", 1, false,false);
		// TODO Auto-generated constructor stub
		streetLampAnim = new Animation(125,Assets.streetLamp);
		
	}

	@Override
	public void tick() {
			streetLampAnim.tick();
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(streetLampAnim.getCurrentFrame(),(int) (x - handler.getGameCamera().getxOffset()),(int)(y - handler.getGameCamera().getyOffset()) ,width,height,null);
		
		
	}

	@Override
	public void die() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void interact() {
		// TODO Auto-generated method stub
		
	}

}
