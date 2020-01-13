package entities;

import java.awt.Graphics;

import gameTest.Handler;
import gameTest.entity;
import gameTest.display.Assets;

public class Haybale1 extends entity {

	public Haybale1(Handler handler, float x, float y ){
		super(handler, x, y, 16, 16, false, "Haybale1", 1, false, false);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(Assets.haybale1, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width*2,height*2, null);
		
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
