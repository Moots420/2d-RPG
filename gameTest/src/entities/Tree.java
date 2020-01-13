package entities;

import java.awt.Graphics;

import gameTest.Handler;
import gameTest.display.Assets;
import items.Item;

public class Tree extends StaticEntity{
private int treeType;
	public Tree(Handler handler, float x, float y,int lvl,int treeType) {
		super(handler, x, y, 16, 28, false, "Tree",lvl,true,false);
	    this.treeType = treeType;
		headTile = Assets.treeHead;
		bounds.x = 10;
		bounds.y = (int) (height-4);
	    bounds.width = width ;
	    bounds.height = (int) (height -10);
	    health = 100;
	    maxHealth = health;
	}

	@Override
	public void die() {
		handler.getWorld().getEntityManager().getPlayer().setCurrentExp(1);
		if(handler.getWorld().getEntityManager().getPlayer().lastEntity == this) {
			handler.getWorld().getEntityManager().getPlayer().lastEntity = null;
			
		}
		int r = handler.getRandomNumber(0, 1000);
		handler.getWorld().getItemManager().addItem(Item.Log.createNew((int)x,(int) y,1));
		
		if(r<200) {
			handler.getWorld().getItemManager().addItem(Item.Log.createNew((int)x,(int) y,1));
			
		}else if(r>200 && r<800) {
			handler.getWorld().getItemManager().addItem(Item.smlCoins.createNew((int)x,(int) y,1));
			
		}else if(r>800) {
			
		}
		
	}
	public void tick() {
		
		
	}

	@Override
	public void render(Graphics g) {
		if(treeType == 0 ) {
		g.drawImage(Assets.tree , (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width*2,height*2, null);
		}else if(treeType ==1) {
			g.drawImage(Assets.tree2 , (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width*2,height*2, null);
			
		}else if(treeType == 2) {
			g.drawImage(Assets.tree3 , (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width*2,height*2, null);
			
		}else if(treeType == 3) {
			g.drawImage(Assets.tree4 , (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width*2,height*2, null);
			
		}
	}

	@Override
	public void interact() {
		// TODO Auto-generated method stub
		
	}

}
