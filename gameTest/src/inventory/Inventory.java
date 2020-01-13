package inventory;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import Text;
import gameTest.Handler;
import gameTest.display.Assets;
import items.Item;

public class Inventory {
	private Handler handler;
	private ArrayList<Item> inventoryItems;
	public static InvSlot[] invSlots = new InvSlot[10];
	public static InvSlot S1 = new InvSlot(196,556,null);
	public static InvSlot S2 = new InvSlot(238,556,null);
	public static InvSlot S3 = new InvSlot(280,556,null);
	public static InvSlot S4 = new InvSlot(322,556,null);
	public static InvSlot S5 = new InvSlot(364,556,null);
	public static InvSlot S6 = new InvSlot(406,556,null);
	public static InvSlot S7 = new InvSlot(448,556,null);
	public static InvSlot S8 = new InvSlot(490,556,null);
	public static InvSlot S9 = new InvSlot(532,556,null);
	public static InvSlot S10 = new InvSlot(574,556,null);
	public static int selectedSlot;


	public void defineSlots() {
		
		invSlots[0] = S1;
		invSlots[1] = S2;
		invSlots[2] = S3;
		invSlots[3] = S4;
		invSlots[4] = S5;
		invSlots[5] = S6;
		invSlots[6] = S7;
		invSlots[7] = S8;
		invSlots[8] = S9;
		invSlots[9] = S10;

				
	}

	
	public Inventory(Handler handler) {
		defineSlots();
		selectedSlot = -1;
		this.handler = handler;
		inventoryItems = new ArrayList<Item>();
	}

	public void tick() {
		for(int i = 0; i < inventoryItems.size(); i++) {
		//for(Item i : inventoryItems) {
			 if(inventoryItems.get(i).getCount()<= 0) {
				 inventoryItems.remove(i);
			 
			 }
			
		}



				
	     	if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_1) && selectedSlot != 0) {
	     		selectedSlot = 0;
	     		return;
			}else 		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_2) && selectedSlot != 1) {
				selectedSlot = 1;
				return;
			}else 		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_3) && selectedSlot != 2) {
				selectedSlot = 2;
				return;
			}else 		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_4) && selectedSlot != 3) {
				selectedSlot = 3;
				return;
			}else 		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_5) && selectedSlot != 4) {
				selectedSlot = 4;
				return;
			}else 		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_6) && selectedSlot != 5) {
				selectedSlot = 5;
				return;
			}else 		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_7) && selectedSlot != 6) {
				selectedSlot = 6;
				return;
			}else 		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_8) && selectedSlot != 7) {
				selectedSlot = 7;
				return;
			}else 		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_9) && selectedSlot != 8) {
				selectedSlot = 8;
				return;
			}else 		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_0) && selectedSlot != 9) {
				selectedSlot = 9;
				return;
			}
				
		
			
		
				
					
				if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_1) && selectedSlot == 0 && invSlots[0].item != null) {
					if(invSlots[0].item.isUseable()) {
						invSlots[0].item.useItem(invSlots[0].item);		
						invSlots[0].item.deductCount(1);
					}
				}else 		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_2) && selectedSlot == 1 && invSlots[1].item != null) {
					if(invSlots[1].item.isUseable()) {
						invSlots[1].item.useItem(invSlots[1].item);		
						invSlots[1].item.deductCount(1);
					}
				}else 		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_3) && selectedSlot == 2 && invSlots[2].item != null) {
					if(invSlots[2].item.isUseable()) {
						invSlots[2].item.useItem(invSlots[2].item);		
						invSlots[2].item.deductCount(1);
					}
				}else 		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_4) && selectedSlot == 3 && invSlots[3].item != null) {
					if(invSlots[3].item.isUseable()) {
						invSlots[3].item.useItem(invSlots[3].item);					
						invSlots[3].item.deductCount(1);
					}
				}else 		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_5) && selectedSlot == 4 && invSlots[4].item != null) {
					if(invSlots[4].item.isUseable()) {
						invSlots[4].item.useItem(invSlots[4].item);		
						invSlots[4].item.deductCount(1);
					}
				}else 		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_6) && selectedSlot == 5 && invSlots[5].item != null) {
					if(invSlots[5].item.isUseable()) {
						invSlots[5].item.useItem(invSlots[5].item);	
						invSlots[5].item.deductCount(1);
					}
				}else 		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_7) && selectedSlot == 6 && invSlots[6].item != null) {
					if(invSlots[6].item.isUseable()) {
						invSlots[6].item.useItem(invSlots[6].item);	
						invSlots[6].item.deductCount(1);
					}
				}else 		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_8) && selectedSlot == 7 && invSlots[7].item != null) {
					if(invSlots[7].item.isUseable()) {
						invSlots[7].item.useItem(invSlots[7].item);		
						invSlots[7].item.deductCount(1);
					}
				}else 		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_9) && selectedSlot == 8 && invSlots[8].item != null) {
					if(invSlots[8].item.isUseable()) {
						invSlots[8].item.useItem(invSlots[8].item);	
						invSlots[8].item.deductCount(1);
					}
				}else 		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_0) && selectedSlot == 9 && invSlots[9].item != null) {
					if(invSlots[9].item.isUseable()) {
						invSlots[9].item.useItem(invSlots[9].item);		
						invSlots[9].item.deductCount(1);
					}else {
						selectedSlot = -1;
					}
				}
			}
	
		

	

	public void render(Graphics g) {
	
		for (int i = 0; i<invSlots.length;i++) {
			if(invSlots[i].item != null) {
				
				  g.drawImage(invSlots[i].item.getTexture(),invSlots[i].SlotX+((36 - invSlots[i].item.ITEMWIDTH)/2),invSlots[i].SlotY +((32 - invSlots[i].item.ITEMHEIGHT)/2), 26, 26, null);
					Text.drawString(g, Integer.toString(invSlots[i].item.getCount()), invSlots[i].SlotX+16, invSlots[i].SlotY-20,true, Color.WHITE, Assets.font8);
				}
			
			if(handler.getWorld().getEntityManager().paused == false) {
				
			Rectangle r = new Rectangle((int) (handler.getMouseManager().getMouseX()),(int) ( handler.getMouseManager().getMouseY()),10,10);
			Rectangle s = new Rectangle(invSlots[i].SlotX, invSlots[i].SlotY,32,32);
			if(invSlots[i].item != null && invSlots[i].item.getCount() <= 0) {
				selectedSlot = -1;
				invSlots[i].item = null;
			}
			if(r.intersects(s) && invSlots[i].item != null && handler.getMouseManager().isRightPressed()) {
				handler.getMouseManager().setRightPressed(false);
				if(invSlots[i].item.isUseable()) {
				invSlots[i].item.useItem(invSlots[i].item);
				invSlots[i].item.deductCount(1);
				
				}else {
					handler.getNotifier().pushNotif("NO USE");
				}
				
			}
			if(r.intersects(s) && invSlots[i].item != null && handler.getMouseManager().isLeftPressed() && selectedSlot != i) {
				selectedSlot = i;
				
				handler.getMouseManager().setLeftPressed(false);
			}else if(r.intersects(s) && invSlots[i].item != null && handler.getMouseManager().isLeftPressed() && selectedSlot == i) {
				selectedSlot = -1;
				handler.getMouseManager().setLeftPressed(false);
				
			}
		
			
			if(r.intersects(s) && invSlots[i].item == null && handler.getMouseManager().isLeftPressed() && selectedSlot > -1) {
				 invSlots[i].item =invSlots[selectedSlot].item ;
				 invSlots[selectedSlot].item = null;
				selectedSlot = -1;
				handler.getMouseManager().setLeftPressed(false);
			}
			if (r.intersects(s) && invSlots[i].item != null && selectedSlot == -1) {
				Text.drawString(g, invSlots[i].item.getName(),400,500, true, Color.WHITE, Assets.font16);
				
			}
				if(selectedSlot == -1){
				   g.setColor(Color.WHITE);
			}
				if(selectedSlot >-1 && invSlots[selectedSlot].item != null) {
					Text.drawString(g, invSlots[selectedSlot].item.getName(),400,500, true, Color.WHITE, Assets.font16);
					
				}
	      	
	       if(i == selectedSlot) {
	    	   g.setColor(Color.ORANGE);
	    	//   g.drawRect(s.x+2, s.y+2, s.width+2, s.height+2);
	    	 
	       }else {
	    	   g.setColor(Color.WHITE);
	       }
	      // g.drawRect(s.x, s.y, s.width, s.height);	
	      // g.drawRect(r.x, r.y, r.width, r.height);
	      // g.drawRect( MouseInfo.getPointerInfo().getLocation().x-(int)handler.getGameCamera().getxOffset(),  MouseInfo.getPointerInfo().getLocation().y-(int)handler.getGameCamera().getyOffset() ,16,16);
		

			
		}
		

		}
    }
	

	 public void addItem (Item item) {
		 for(Item i : inventoryItems) {
			 if(i.getId() == item.getId()) {
				 i.setCount(i.getCount()+item.getCount());
				 return;
			 }
		 }
		 
		 
	     
		 for(int i = 0; i<invSlots.length; i++) {
			 if(invSlots[i].item != null)
				 continue;
			 else
				 invSlots[i].item = item;
			     inventoryItems.add(item);
			     return;
			 
		 }
		 
	
	 }
	
	//getters setters
	public Handler getHandler() {
		return handler;
	}
	public void setHandler(Handler handler) {
		this.handler = handler;
	}

}
