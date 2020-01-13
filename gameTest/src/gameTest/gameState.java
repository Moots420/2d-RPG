package gameTest;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import Text;
import entities.Tree;
import gameTest.display.Assets;
import inventory.InvSlot;

public class gameState extends State {
public boolean inMenu;
	
	public static World world;
	private Rectangle[] rects = new Rectangle[4];
	public gameState(Handler handler) {
		super(handler); 
		inMenu = false;
		    	world = new World(handler, "src/gameTest/Worlds/World.lvl");
	//	world = new World(handler, "scr/gametest/Worlds/MapFor.csv");
	    handler.setWorld(world);
		 //Engine.getGameCamera().move(0, 0);
	}
	
	
	
	public void tick() {
	
		world.tick();
		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_ESCAPE)) {
			if(inMenu == false) {
				inMenu = true;
				handler.getWorld().getEntityManager().inMenu = true;
			}else if (inMenu == true) {
				inMenu = false;
				handler.getWorld().getEntityManager().paused = false;
			}
		}
		if(inMenu) {
			handler.getWorld().getEntityManager().paused = true;
		}else {
			handler.getWorld().getEntityManager().inMenu = false;
		}
		
		//Engine.getGameCamera().move(1, 1);
	}


	public void render(Graphics g) {
		
			world.render(g);
		
			
			if(inMenu) {
				g.drawImage(Assets.pausemenu,0,0,800,600,null);	
				rects[0] = new Rectangle(120,180,150,50);
				rects[1] = new Rectangle(120,230,150,50);
				rects[2] = new Rectangle(120,280,150,50);
				rects[3] = new Rectangle(120,480,150,50);
				Rectangle r = new Rectangle((int) (handler.getMouseManager().getMouseX()),(int) ( handler.getMouseManager().getMouseY()),10,10);
				Text.drawString(g, "MENU", 100, 100, false, Color.WHITE, Assets.font24);
				
				for(int i = 0; i<rects.length; i++) {
					if(r.intersects(rects[i])) {
						if(i == 0) {
							Text.drawString(g,"New Game-",120,200,false,Color.ORANGE, Assets.font20);
							Text.drawString(g,"Load Game",120,250,false,Color.WHITE, Assets.font20);
							Text.drawString(g,"Save Game",120,300,false,Color.WHITE, Assets.font20);
							Text.drawString(g,"Quit",120,500,false,Color.WHITE, Assets.font20);
						
						}else if(i == 1) {
							
							Text.drawString(g,"New Game",120,200,false,Color.WHITE, Assets.font20);
							Text.drawString(g,"Load Game-",120,250,false,Color.ORANGE, Assets.font20);
							Text.drawString(g,"Save Game",120,300,false,Color.WHITE, Assets.font20);
							Text.drawString(g,"Quit",120,500,false,Color.WHITE, Assets.font20);
						
						}else if(i == 2) {
							Text.drawString(g,"New Game",120,200,false,Color.WHITE, Assets.font20);
							Text.drawString(g,"Load Game",120,250,false,Color.WHITE, Assets.font20);
							Text.drawString(g,"Save Game-",120,300,false,Color.ORANGE, Assets.font20);
							Text.drawString(g,"Quit",120,500,false,Color.WHITE, Assets.font20);
						
						}else if(i == 3) {
							Text.drawString(g,"New Game",120,200,false,Color.WHITE, Assets.font20);
							Text.drawString(g,"Load Game",120,250,false,Color.WHITE, Assets.font20);
							Text.drawString(g,"Save Game",120,300,false,Color.WHITE, Assets.font20);
							Text.drawString(g,"Quit-",120,500,false,Color.ORANGE, Assets.font20);
							}
						else {
						    Text.drawString(g,"New Game",120,200,false,Color.WHITE, Assets.font20);
							Text.drawString(g,"Load Game",120,250,false,Color.WHITE, Assets.font20);
							Text.drawString(g,"Save Game",120,300,false,Color.WHITE, Assets.font20);
							Text.drawString(g,"Quit",120,500,false,Color.WHITE, Assets.font20);
						
						} 
					break;
					}else {
					    Text.drawString(g,"New Game",120,200,false,Color.WHITE, Assets.font20);
						Text.drawString(g,"Load Game",120,250,false,Color.WHITE, Assets.font20);
						Text.drawString(g,"Save Game",120,300,false,Color.WHITE, Assets.font20);
						Text.drawString(g,"Quit",120,500,false,Color.WHITE, Assets.font20);
					
					}
					
				}
				
				
	}
		}
		
	}



