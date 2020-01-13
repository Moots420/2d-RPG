package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import gameTest.Handler;

public class warpTile {
	private Handler handler;
	private Rectangle warptile;
	public int destx,desty,x,y;
	public boolean isActive;
	public int warpNo;
public warpTile(Handler handler,int x,int y,int destx,int desty,boolean isActive,int warpNo) {
	warptile = new Rectangle(x,y,32,32);
	this.isActive = isActive;
	this.x = x; this.y = y;
	this.handler = handler;
	this.destx = destx;
	this.desty = desty;
	this.warpNo = warpNo;
	
}

public boolean isActive() {
	return isActive;
}

public void setActive(boolean isActive) {
	this.isActive = isActive;
}

public void tick() {
	if(handler.getWorld().getEntityManager().getPlayer().getCollisionBounds(0, 0, 0, 0).intersects(warptile)){
		if(isActive && !handler.getKeyManager().e) {	
		warp();
		handler.getWorld().getEntityManager().getPlayer().setFacing(2);
		}
		
	}
	
}

public void warp() {
	handler.getWorld().getFader().fade();
	if(handler.getWorld().getFader().alpha>= 255) {
	handler.getWorld().getEntityManager().getPlayer().setX(destx);
	handler.getWorld().getEntityManager().getPlayer().setY(desty);
	}
	
}

public void render(Graphics g) {
	
	//g.setColor(Color.RED);
	//g.fillRect(this.x-(int)handler.getGameCamera().getxOffset(), this.y-(int)handler.getGameCamera().getyOffset(), 32, 32);
	
}


}
