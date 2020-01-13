package entities;

import java.awt.Graphics;

import gameTest.Handler;
import gameTest.entity;
import gameTest.tile;
import gameTest.display.Assets;

public class Grave extends entity {

	public Grave(Handler handler, float x, float y) {
		super(handler, x, y, 16,16, false, "Grave", 1, false, false);
		
	}

	@Override
	public void tick() {
	
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.grave,(int) (x-handler.getGameCamera().getxOffset()),(int)(y-handler.getGameCamera().getyOffset()),width*2,height*2,null);
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
