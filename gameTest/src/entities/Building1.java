package entities;

import java.awt.Graphics;

import gameTest.Handler;
import gameTest.display.Assets;

public class Building1 extends StaticEntity {
    public boolean isOpen;
    private int doorX,doorY;
    private warpTile thisWarp;
	public int WarpX,WarpY;
	public Building1(Handler handler, float x, float y,int warpx,int warpy) {
		super(handler, x, y, 67, 73, true, "building1", 1, false,true);
		isOpen = false;
		this.x = x;
		this.y = y;
		doorX = 32;
		doorY = 114;
		WarpX = warpx;
		WarpY = warpy;
//	 handler.getWorld().getEntityManager().warptiles.add(thisWarp);
			
	}

	public void tick() {
		 handler.getWorld().getEntityManager().addWarp(new warpTile(handler,(int) (x +doorX), (int) (y + doorY)-5,WarpX,WarpY,true,50));
			
	if(isOpen) {
		
		for(int i = 0; i<handler.getWorld().getEntityManager().warptiles.size(); i++) {
			
			if(handler.getWorld().getEntityManager().warptiles.get(i).warpNo == 50) {
				handler.getWorld().getEntityManager().warptiles.get(i).isActive = true;
				 
					
				
			}
		}
	}else {
		for(int i = 0; i<handler.getWorld().getEntityManager().warptiles.size(); i++) {
		
			if(handler.getWorld().getEntityManager().warptiles.get(i).warpNo == 50) {
				handler.getWorld().getEntityManager().warptiles.get(i).isActive = false;
				 
					
				
			}
		}
		 
	}
	
		
	}

	
	public void render(Graphics g) {
		
//g.fillRect(this.bounds.x,this.bounds.y,this.bounds.width,this.bounds.y);
			 if(isOpen) {
		 g.drawImage(Assets.building1open, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width*2,height*2, null);
		
	 }else if(!isOpen) {

			 g.drawImage(Assets.building1closed, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width*2,height*2, null);
		 
	 }
	}

	@Override
	public void die() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void interact() {
    if(isOpen == false) {
    	isOpen = true;
    }else if(isOpen == true) {
    	
 	
    	isOpen = false;
    }
		
	
	}

}
