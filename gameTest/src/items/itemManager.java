package items;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

import gameTest.Handler;

public class itemManager {

	private Handler handler;
	private ArrayList<Item> items;
	public itemManager(Handler handler) {
		this.handler = handler;	
		items = new ArrayList<Item>();
		
		
	}
	public ArrayList<Item> getItems() {
		return items;
	}
	public void tick() {
	   Iterator<Item> it = items.iterator();
	   while(it.hasNext()) {
		   Item i = it.next();
		   i.tick();
		   if(i.pickedUp){
			   it.remove();
		   }
	   }
	}
	public void render(Graphics g) {
		for(Item i :items)
			i.render(g);
	}
	
	public void addItem(Item i) {
		i.setHandler(handler);
		items.add(i);
		System.out.println(i);
	}
	
	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}
}
