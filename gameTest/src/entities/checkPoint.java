package entities;

import java.awt.Graphics;

import Text;
import gameTest.Handler;
import gameTest.display.Assets;

public class checkPoint extends StaticEntity {

	public checkPoint(Handler handler, float x, float y) {
		super(handler, x, y, 16, 16, true, "Check Point", 1,false,false);
		this.x = x;
		this.y = y;
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.checkpoint , (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width*2,height*2, null);
		
	}

	@Override
	public void die() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void interact() {
		handler.getNotifier().pushNotif("CHECKPOINT!");
		for(int i = 0;i<handler.getWorld().getEntityManager().warptiles.size();i++) {
if(handler.getWorld().getEntityManager().warptiles.get(i).warpNo == 0) {
	handler.getWorld().getEntityManager().warptiles.get(i).destx = (int)this.x ;
	handler.getWorld().getEntityManager().warptiles.get(i).desty = (int)this.y ;
}
}
handler.getWorld().getEntityManager().getPlayer().setCheckpointX((int) this.x);
		handler.getWorld().getEntityManager().getPlayer().setCheckpointY((int)this.y -32);
		
	}

}
