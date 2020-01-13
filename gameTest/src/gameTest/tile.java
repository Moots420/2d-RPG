package gameTest;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import gameTest.display.Animation;
import gameTest.display.Assets;

public class tile {
	//static stuff here
	public static tile[] tiles = new tile[10000];
	public static tile errorTile = new tile(Assets.errorTile,null,0,false,false);
    
	public static tile grassTopL = new tile(Assets.grassTopL,null,1,false,false);
	public static tile grassTopM = new tile(Assets.grassTopM,null,2,false,false);
	public static tile grassTopR = new tile(Assets.grassTopR,null,3,false,false);
	public static tile grassMidL = new tile(Assets.grassMidL,null,4,false,false);
	public static tile grassMid = new tile(Assets.grassMid,null,5,false,false);
	public static tile grassMidR = new tile(Assets.grassMidR,null,6,false,false);
	public static tile grassBotL = new tile(Assets.grassBotL,null,7,false,false);
	public static tile grassBotM = new tile(Assets.grassBotM,null,8,false,false);
	public static tile grassBotR = new tile(Assets.grassBotR,null,9,false,false);
	
	public static tile dungeon_wall = new tile(Assets.dungeon_wall,null,10,true,false);
	public static tile dungeon_wall1 = new tile(Assets.dungeon_wall1,null,11,true,false);
	public static tile dungeon_wall2 = new tile(Assets.dungeon_wall2,null,12,true,false);
	public static tile dungeon_wall3 = new tile(Assets.dungeon_wall3,null,13,true,false);
	public static tile dungeon_wall4 = new tile(Assets.dungeon_wall4,null,14,true,false);
	public static tile dungeon_wall5 = new tile(Assets.dungeon_wall5,null,15,true,false);
	public static tile dungeon_wall6 = new tile(Assets.dungeon_wall6,null,16,true,false);
	public static tile dungeon_wall7 = new tile(Assets.dungeon_wall7,null,17,true,false);
	public static tile dungeon_wall8 = new tile(Assets.dungeon_wall8,null,18,true,false);
	public static tile dungeon_floor = new tile(Assets.dungeon_floor,null,19,false,false);
	public static tile dungeon_floor1 = new tile(Assets.dungeon_floor1,null,20,false,false);
	public static tile dungeon_floor2 = new tile(Assets.dungeon_floor2,null,21,false,false);
	public static tile dungeon_floor3 = new tile(Assets.dungeon_floor3,null,22,false,false);
	public static tile dungeon_floor4 = new tile(Assets.dungeon_floor4,null,23,false,false);
	public static tile dungeon_floor5 = new tile(Assets.dungeon_floor5,null,24,false,false);
	public static tile dungeon_floor6 = new tile(Assets.dungeon_floor6,null,25,false,false);
	public static tile dungeon_floor7 = new tile(Assets.dungeon_floor7,null,26,false,false);
	public static tile dungeon_floor8 = new tile(Assets.dungeon_floor8,null,109,false,false);
	public static tile dungeon_floor_fence = new tile(Assets.dungeon_floor_fence,null,27,true,false);
	public static tile dungeon_floor_fence1 = new tile(Assets.dungeon_floor_fence1,null,28,true,false);
	public static tile dungeon_floor_fence2 = new tile(Assets.dungeon_floor_fence2,null,29,true,false);
	public static tile dungeon_floor_fence3 = new tile(Assets.dungeon_floor_fence3,null,30,true,false);
	public static tile dungeon_floor_fence4 = new tile(Assets.dungeon_floor_fence4,null,31,true,false);
	public static tile fence1 = new tile(Assets.fence1,null,32,true,false);
	public static tile fence2 = new tile(Assets.fence2,null,33,true,false);
	public static tile fence3 = new tile(Assets.fence3,null,34,true,false);
	public static tile fence4 = new tile(Assets.fence4,null,35,true,false);
	public static tile fence5 = new tile(Assets.fence5,null,36,true,false);
	public static tile fence6 = new tile(Assets.fence6,null,37,true,false);
	public static tile fence7 = new tile(Assets.fence7,null,38,true,false);
	public static tile fence8 = new tile(Assets.fence8,null,39,true,false);
	public static tile pathCenter = new tile(Assets.pathCenter,null,40,false,false);
	public static tile path1 = new tile(Assets.path1,null,41,false,false);
	public static tile path2 = new tile(Assets.path2,null,42,false,false);
	public static tile path3 = new tile(Assets.path3,null,43,false,false);
	public static tile path4 = new tile(Assets.path4,null,44,false,false);
	public static tile path5 = new tile(Assets.path5,null,45,false,false);
	public static tile path6 = new tile(Assets.path6,null,46,false,false);
	public static tile path7 = new tile(Assets.path7,null,47,false,false);
	public static tile path8 = new tile(Assets.path8,null,48,false,false);
	public static tile path9 = new tile(Assets.path9,null,49,false,false);
	public static tile path10 = new tile(Assets.path10,null,50,false,false);
	public static tile path11 = new tile(Assets.path11,null,51,false,false);
	public static tile path12 = new tile(Assets.path12,null,52,false,false);
	public static tile path13 = new tile(Assets.path13,null,53,false,false);
	public static tile path14 = new tile(Assets.path14,null,54,false,false);
	public static tile path15 = new tile(Assets.path15,null,55,false,false);
	public static tile path16 = new tile(Assets.path16,null,56,false,false);
	public static tile blackTile = new tile(Assets.blackTile,null,57,true,false);
	public static tile tfenceL = new tile(Assets.tfenceL,null,58,true,false);
	public static tile tfenceR = new tile(Assets.tfenceR,null,59,true,false);
	public static tile water = new tile(null,Assets.water,60,true,true);
	public static tile water1 = new tile(Assets.water1,null,61,true,false);
	public static tile water2 = new tile(Assets.water2,null,62,true,false);
	public static tile water3 = new tile(Assets.water3,null,63,true,false);
	public static tile water4 = new tile(Assets.water4,null,64,true,false);
	public static tile water5 = new tile(Assets.water5,null,65,true,false);
	public static tile water6 = new tile(Assets.water6,null,66,true,false);
	public static tile water7 = new tile(Assets.water7,null,67,true,false);
	public static tile water8 = new tile(Assets.water8,null,68,true,false);
	public static tile water9 = new tile(Assets.water9,null,69,true,false);
	public static tile water10 = new tile(Assets.water10,null,70,true,false);
	public static tile water11 = new tile(Assets.water11,null,71,true,false);
	public static tile water12 = new tile(Assets.water12,null,72,true,false);
	public static tile water13 = new tile(Assets.water13,null,73,true,false);
	public static tile water14 = new tile(Assets.water14,null,74,true,false);
	public static tile water15 = new tile(Assets.water15,null,75,true,false);
	public static tile water16 = new tile(Assets.water16,null,76,true,false);
	public static tile insidepath1 = new tile(Assets.insidepath1,null,77,false,false);
	public static tile insidepath2 = new tile(Assets.insidepath2,null,78,false,false);
	public static tile insidepath3 = new tile(Assets.insidepath3,null,79,false,false);
	public static tile insidepath4 = new tile(Assets.insidepath4,null,80,false,false);
	public static tile insidepath5 = new tile(Assets.insidepath5,null,81,false,false);
	public static tile insidepath6 = new tile(Assets.insidepath6,null,82,false,false);
	public static tile insidepath7 = new tile(Assets.insidepath7,null,83,false,false);
	public static tile insidepath8 = new tile(Assets.insidepath8,null,84,false,false);
	public static tile housewall1 = new tile(Assets.housewall1,null,85,true,false);
	public static tile housewall2 = new tile(Assets.housewall2,null,86,true,false);
	public static tile housewall3 = new tile(Assets.housewall3,null,87,true,false);
	public static tile housewall4 = new tile(Assets.housewall4,null,88,true,false);
	public static tile housewall5 = new tile(Assets.housewall5,null,89,true,false);
	public static tile housewall6 = new tile(Assets.housewall6,null,90,true,false);
	public static tile entercave = new tile(Assets.entercave,null,91,false,false);
	public static tile dirt = new tile(Assets.dirt,null,92,false,false);
	public static tile dirt1 = new tile(Assets.dirt1,null,93,false,false);
	public static tile dirt2 = new tile(Assets.dirt2,null,94,false,false);
	public static tile dirt3 = new tile(Assets.dirt3,null,95,false,false);
	public static tile dirt4 = new tile(Assets.dirt4,null,96,false,false);
	public static tile dirt5 = new tile(Assets.dirt5,null,97,false,false);
	public static tile dirt6 = new tile(Assets.dirt6,null,98,false,false);
	public static tile dirt7 = new tile(Assets.dirt7,null,99,false,false);
	public static tile dirt8 = new tile(Assets.dirt8,null,100,false,false);
	public static tile dirt9 = new tile(Assets.dirt9,null,101,false,false);
	public static tile dirt10 = new tile(Assets.dirt10,null,102,false,false);
	public static tile dirt11 = new tile(Assets.dirt11,null,103,false,false);
	public static tile dirt12 = new tile(Assets.dirt12,null,104,false,false);
	public static tile dirt13 = new tile(Assets.dirt13,null,105,false,false);
	public static tile dirt14 = new tile(Assets.dirt14,null,106,false,false);
	public static tile dirt15 = new tile(Assets.dirt15,null,107,false,false);
	public static tile dirt16 = new tile(Assets.dirt16,null,108,false,false);
				//class
	protected static final int TILEWIDTH = 32, TILEHEIGHT = 32;
	protected boolean solid;
	protected BufferedImage texture;
	protected BufferedImage[] animatedTexture;
	protected final int id;
	protected boolean isAnimated;
	public static int xPos, yPos;
	private Animation thisAn;
public tile(BufferedImage texture,BufferedImage[] animatedTexture, int id,boolean isSolid,boolean isAnimated) {
	this.animatedTexture = animatedTexture;
	this.texture = texture;
	this.solid = isSolid;
	this.id = id;
	tiles[id] = this;
	this.isAnimated = isAnimated;
	if(isAnimated) {
		thisAn = new Animation(350, animatedTexture);
	   
	}
	
}

public static tile[] getTiles() {
	return tiles;
}

public static void setTiles(tile[] tiles) {
	tile.tiles = tiles;
}

public void tick() {
	if(thisAn != null) {
	thisAn.tick();
	}
	//System.out.println("tickin");
}
public void render(Graphics g, int x, int y) {
	xPos = x;
	yPos = y;
	if(isAnimated) {
	g.drawImage(thisAn.getCurrentFrame(),x,y,TILEWIDTH,TILEHEIGHT,null);	
	}else {
	g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
	}
}
public static int getxPos() {
	return xPos;
}

public static int getyPos() {
	return yPos;
}

public boolean isSolid() {
	return solid;
	
}
public int getId() {
	return id;
}
}
