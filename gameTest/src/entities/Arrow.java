package entities;

import java.awt.Graphics;
import java.awt.Rectangle;

import gameTest.Creature;
import gameTest.Handler;
import gameTest.entity;
import gameTest.display.Assets;

public class Arrow extends Creature {
private int arrowSpd;
private int ArrowD;
private int timer, decayTime;
	public Arrow(Handler handler, float x, float y, int direction) {
		super(handler, x, y, 32, 32, false, "Arrow",false,1,false,false);
		this.ArrowD = direction;
		this.x = x;
		this.y = y;
		arrowSpd = 4;
		timer = 0;
		decayTime = 60*5;
		handler.getWorld().getEntityManager().getPlayer().attackTimer = 0;
	}


	public void tick() {
		timer ++;
		if(timer>decayTime) {
			System.out.println("removed Arrow");
			this.active = false;
		}
		move();
		if(ArrowD == 0) {
		yMove = arrowSpd;
	}else if(ArrowD == 1) {
		xMove = -arrowSpd;
	}else if(ArrowD == 2) {
		yMove = -arrowSpd;
	}else if(ArrowD == 3) {
		xMove = arrowSpd;
	}
   for (entity e: handler.getWorld().getEntityManager().getEntities()) {
			if(e == this || e == handler.getWorld().getEntityManager().getPlayer() || e.entName == "Arrow")
				continue;
			if(this.getCollisionBounds(0, 0, 0, 0).intersects(e.getCollisionBounds(0, 0, 0, 0)) && e.vunerable) {
				System.out.println("HIT");
				e.hurt(handler.getWorld().getEntityManager().getPlayer().arrowStr);
				e.hit = true;
               handler.getWorld().getEntityManager().getPlayer().lastHit(e);
				active = false;
				
			}
		
   }
	}

	public void postRender(Graphics g) {
		
	if(ArrowD == 0) {
		g.drawImage(Assets.arrowdown,(int) (x - handler.getGameCamera().getxOffset()),(int)(y - handler.getGameCamera().getyOffset()) ,width,height,null);

	}else if(ArrowD == 1) {
		g.drawImage(Assets.arrowleft,(int) (x - handler.getGameCamera().getxOffset()),(int)(y - handler.getGameCamera().getyOffset()) ,width,height,null);

	}else if(ArrowD == 2) {
		g.drawImage(Assets.arrowup,(int) (x - handler.getGameCamera().getxOffset()),(int)(y - handler.getGameCamera().getyOffset()) ,width,height,null);
}else if (ArrowD == 3) {
	g.drawImage(Assets.arrowright,(int) (x - handler.getGameCamera().getxOffset()),(int)(y - handler.getGameCamera().getyOffset()) ,width,height,null);
	
	}
		
	}

	@Override
	public void die() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void interact() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		postRender(g);
		
	}

}
