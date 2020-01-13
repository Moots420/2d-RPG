package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Comparator;

import Text;
import gameTest.Handler;
import gameTest.Player;
import gameTest.entity;
import gameTest.display.Assets;


public class EntityManager {
    public boolean paused, inMenu;
	private Handler handler;
	private Player player;
	public ArrayList<entity> entities;
	public ArrayList<warpTile> warptiles;	
	private Comparator<entity> renderSorter = new Comparator<entity>() {
		public int compare(entity a, entity b) {
			if(a.getY() + a.getHeight() < b.getY() + b.getHeight())
				return -1;
			return 1;
		}
		
	};
	
	
	public EntityManager(Handler handler, Player player) {
		paused = false;
		this.handler = handler;
		this.player = player;
		entities = new ArrayList<entity>();
        warptiles = new ArrayList<warpTile>();
		addEntity(player);
		
	}
	public void tick() {
		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_P)) {
			if(paused) {
				paused = false;
			}else if(!paused) {
				paused = true;
			}
		
		}
		/*/Iterator<entity> it = entities.iterator();
		while(it.hasNext()) {
			
			entity e = it.next();
			e.tick();
			if (!e.isActive()) {
				it.remove();
			}
		}
		/*/
		for (int i = 0; i < warptiles.size(); i++) {
			if(warptiles.get(i)!= null) {
			warptiles.get(i).tick();
			}
		}
		for (int i = 0; i < entities.size(); i++) {
			if(!paused) {
		entities.get(i).tick();
			}
		if(!entities.get(i).isActive()) {
	    	entities.remove(i);
	    }
		
		}
		entities.sort(renderSorter);
		
	}
	public void render(Graphics g) {
	
			
		
		for( entity e: entities) {
			e.render(g);
		}
		if(paused && !inMenu) {
			Text.drawString(g, "PAUSED",400,274, true, Color.BLACK, Assets.font24);
			Text.drawString(g, "PAUSED",400,278, true, Color.BLACK, Assets.font24);
			Text.drawString(g, "PAUSED",402,276, true, Color.BLACK, Assets.font24);
			Text.drawString(g, "PAUSED",398,276, true, Color.BLACK, Assets.font24);
			Text.drawString(g, "PAUSED",400,276, true, Color.RED, Assets.font24);
			
		}
		player.postRender(g);
		for(int i = 0; i<warptiles.size(); i++) {
			warptiles.get(i).render(g);
		}
	}
	//addEntity(new Cow(handler, 224, 100)
	public void addEntity(entity e) {
	entities.add(e);	
	}
	public void addWarp(warpTile w) {
		warptiles.add(w);
	}
	public void removeWarp(warpTile w) {
		warptiles.remove(w);
	}
	
	//getters setters
	public Handler getHandler() {
		return handler;
	}
	public void setHandler(Handler handler) {
		this.handler = handler;
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	public ArrayList<entity> getEntities() {
		return entities;
	}
	public void setEntities(ArrayList<entity> entities) {
		this.entities = entities;
	}
	
}
