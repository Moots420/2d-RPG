package gameTest.display;

import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.InputStream;

import javax.sound.sampled.Clip;
import Sound.soundLoader;

public class Assets {
private static final int w64 = 64, h64 = 64;
private static final int w16 = 16, h16 = 16;
	public static BufferedImage  
	checkpoint,
	grave,
	tree,
	stone,
	charDown,
	grassTopL,
	grassTopM,
	grassTopR,
	grassMidL,
	grassMid,
	grassMidR,
	grassBotL,
	grassBotM,
	grassBotR,
	cursor,
	hud,
	inv,
	cowHead,
	treeHead,
	fence1,
	fence2,
	fence3,
	fence4,
	fence5,
	fence6,
	fence7,
	fence8,
	tfenceL,
	tfenceR,
	house1,
	pathCenter,
	path1,
	path2,
	path3,
	path4,
	path5,
	path6,
	path7,
	path8,
	path9,
	path10,
	path11,
	path12,
	path13,
	path14,
	path15,
	path16,
	blackTile,
	slimeHead,
	healthpotion,
	playerHurt0,
	playerHurt1,
	playerHurt2,
	playerHurt3,
	arrowup,
	arrowdown,
	arrowleft,
	arrowright,
	arrowitem,
	dungeon_wall,
	dungeon_wall1,
	dungeon_wall2,
	dungeon_wall3,
	dungeon_wall4,
	dungeon_wall5,
	dungeon_wall6,
	dungeon_wall7,
	dungeon_wall8,
	dungeon_floor,
	dungeon_floor1,
	dungeon_floor2,
	dungeon_floor3,
	dungeon_floor4,
	dungeon_floor5,
	dungeon_floor6,
	dungeon_floor7,
	dungeon_floor8,
	dungeon_floor_fence,
	dungeon_floor_fence1,
	dungeon_floor_fence2,
	dungeon_floor_fence3,
	dungeon_floor_fence4,
	water1,
	water2,
	water3,
	water4,
	water5,
	water6,
	water7,
	water8,
	water9,
	water10,
	water11,
	water12,
	water13,
	water14,
	water15,
	water16,
	insidepath1,
	insidepath2,
	insidepath3,
	insidepath4,
	insidepath5,
	insidepath6,
	insidepath7,
	insidepath8,
	housewall1,
	housewall2,
	housewall3,
	housewall4,
	housewall5,
	housewall6,
	entercave,
	errorTile,
	building1closed,
	building1open,
	pausemenu,
	haybale1,
	crate1,
	tree2,
	tree3,
	tree4,
	dirt,
	dirt1,
	dirt2,
	dirt3,
	dirt4,
	dirt5,
	dirt6,
	dirt7,
	dirt8,
	dirt9,
	dirt10,
	dirt11,
	dirt12,
	dirt13,
	dirt14,
	dirt15,
	dirt16;
	public static BufferedImage[] streetLamp;
	public static BufferedImage coins_sml,log1,meat;
	public static BufferedImage[] skele_left;
	public static BufferedImage[] skele_right;
	public static BufferedImage[] skele_still;
	public static BufferedImage[] skele_attackl;
	public static BufferedImage[] skele_attackr;
	public static BufferedImage[] skele_hurt;
	public static BufferedImage[] player_down;
	public static BufferedImage[] player_up;
	public static BufferedImage[] player_right;
	public static BufferedImage[] player_left;
	public static BufferedImage[] player_still;
	public static BufferedImage[] startBtn;
	public static BufferedImage[] ePrompt;
	public static BufferedImage[] cow_left;
	public static BufferedImage[] cow_right;
	public static BufferedImage[] cow_still;
	public static BufferedImage[] cow_hurt;
	public static BufferedImage[] slime_left;
	public static BufferedImage[] slime_right;
	public static BufferedImage[] slime_att;
	public static BufferedImage[] slime_still;
	public static BufferedImage[] slime_hurt;
	public static BufferedImage[] player_down_att;
	public static BufferedImage[] player_up_att;
	public static BufferedImage[] player_right_att;
	public static BufferedImage[] player_left_att;
	public static BufferedImage[] cow_ride_left;
	public static BufferedImage[] cow_ride_right;
	public static BufferedImage[] cow_ride_still;
	public static BufferedImage[] plr_shoot_down;
	public static BufferedImage[] plr_shoot_left;
	public static BufferedImage[] plr_shoot_up;
	public static BufferedImage[] plr_shoot_right;
	public static BufferedImage[] coin;
	public static BufferedImage[] water;
	public static Font font4,font6,font8,font10,font12,font16,font20,font24;
	public static Clip pop, moo;		
	public static void init() {
		//sounds
	
		pop = soundLoader.loadSound("C:/Users/harri/Desktop/gameBulild_lib/pop.wav");
		moo = soundLoader.loadSound("C:/Users/harri/Desktop/gameBulild_lib/moo.wav");
		//fonts
		//font2 = FontLoader.loadFont("gfx/pixel.ttf", 2);
		font4 = FontLoader.loadFont("gfx/pixel.ttf", 4);
		font6 = FontLoader.loadFont("gfx/pixel.ttf", 6);
		font8 = FontLoader.loadFont("gfx/pixel.ttf", 8);
		font10 = FontLoader.loadFont("gfx/pixel.ttf", 10);
		font12 = FontLoader.loadFont("gfx/pixel.ttf", 12);
		font16 = FontLoader.loadFont("gfx/pixel.ttf", 16);
		font20 = FontLoader.loadFont("gfx/pixel.ttf", 20);
		font24 = FontLoader.loadFont("gfx/pixel.ttf", 24);
		
		//images
	    spriteSheet pauseSheet = new spriteSheet(ImageLoader.loadImage("gfx/pausemenu.png"));
		spriteSheet invSheet = new spriteSheet(ImageLoader.loadImage("gfx/inventory.png"));
		spriteSheet sheet1 = new spriteSheet(ImageLoader.loadImage("gfx/groundTiles.png"));
		spriteSheet charSheet = new spriteSheet(ImageLoader.loadImage("gfx/charmain.png"));
		spriteSheet gSheet = new spriteSheet(ImageLoader.loadImage("gfx/grassSheet.png"));
		spriteSheet start = new spriteSheet(ImageLoader.loadImage("gfx/start.png"));
		spriteSheet hudSheet = new spriteSheet(ImageLoader.loadImage("gfx/hud.png"));
	final	spriteSheet buildingSheet = new spriteSheet(ImageLoader.loadImage("gfx/buildings.png"));
		skele_still = new BufferedImage[2];
	    skele_hurt = new BufferedImage[1];
	    skele_right = new BufferedImage[2];
	    skele_left = new BufferedImage[2];
	    skele_attackl = new BufferedImage[4];
	    skele_attackr = new BufferedImage[4];
	    slime_hurt = new BufferedImage[1];
		slime_still = new BufferedImage[2];
		slime_left = new BufferedImage[2];
		slime_right = new BufferedImage[2];
		slime_att =new BufferedImage[4];
		cow_ride_left = new BufferedImage[2];
		cow_ride_right = new BufferedImage[2];
		cow_ride_still = new BufferedImage[2];
		streetLamp = new BufferedImage[3];
		
		plr_shoot_up = new BufferedImage[3];
		plr_shoot_down = new BufferedImage[3];
		plr_shoot_left = new BufferedImage[3];
		plr_shoot_right =  new BufferedImage[3];
		
		player_down = new BufferedImage[2];
		player_up = new BufferedImage[2];
		player_right = new BufferedImage[2];
		player_left = new BufferedImage[2];
		
		player_down_att = new BufferedImage[2];
		player_up_att = new BufferedImage[2];
		player_right_att = new BufferedImage[2];
		player_left_att = new BufferedImage[2];
		
		player_still = new BufferedImage[4];
		startBtn = new BufferedImage[2];
		ePrompt = new BufferedImage[2];
		cow_right = new BufferedImage[2];
		cow_left = new BufferedImage[2];
		cow_still = new BufferedImage[2];
		cow_hurt = new BufferedImage[2];
		
		water = new BufferedImage[2];
		
		coin = new BufferedImage[8];
		//heads
	    treeHead = charSheet.crop(16, 128, 16, 16);
		cowHead = charSheet.crop(0,128,16,16);
		slimeHead = charSheet.crop(32,128,16,16);
		
		
		//displays
		pausemenu = pauseSheet.crop(0,0,800,600);
		inv = invSheet.crop(0, 0, 608, 320);
		hud = hudSheet.crop(0, 0, 800, 600);
		ePrompt[0] = sheet1.crop(208, 0, w16, h16);
		ePrompt[1] = sheet1.crop(224, 0, w16, h16);
		startBtn[0] = start.crop(0, 0,256, 64);
		startBtn[1] = start.crop(0, 64, 256, 64);
		
		//coin
		coin[0] =charSheet.crop(560,64,16,16);
		coin[1] =charSheet.crop(576,64,16,16);
		coin[2] =charSheet.crop(592,64,16,16);
		coin[3] =charSheet.crop(608,64,16,16);
		coin[4] =charSheet.crop(624,64,16,16);
		coin[5] =charSheet.crop(608,64,16,16);
		coin[6] =charSheet.crop(592,64,16,16);
		coin[7] =charSheet.crop(576,64,16,16);
		//slime
		slime_left[0] = charSheet.crop(16,160,16,16);
		slime_left[1] = charSheet.crop(32,160,16,16);
		
		slime_right[0] = charSheet.crop(16,176,16,16);
		slime_right[1] = charSheet.crop(32,176,16,16);
		
		slime_att[0] = charSheet.crop(0,144,16,16);
		slime_att[1] = charSheet.crop(16,144,16,16);
		slime_att[2] = charSheet.crop(32,144,16,16);
		slime_att[3] = charSheet.crop(48,144,16,16);
		
		slime_still[0] = charSheet.crop(0,160,16,16);
		slime_still[1] = charSheet.crop(0,176,16,16);
		slime_hurt[0] = charSheet.crop(48,176,16,16);
				
	//streetlamp
		streetLamp[0] = charSheet.crop(576,15,16,33);
		streetLamp[1] = charSheet.crop(592,15,16,33);
		streetLamp[2] = charSheet.crop(608,15,16,33);
		//skeleton
	
		
		skele_still[0] =charSheet.crop(16,192,16,16);
		skele_still[1] = charSheet.crop(16,208,16,16);
	   
		skele_hurt[0] =  charSheet.crop(0,208,16,16);
	    
	    skele_right[0] =charSheet.crop(32,208,16,16); 
		skele_right[1] =charSheet.crop(48,208,16,16); 
	    
		skele_left[0] =charSheet.crop(32,192,16,16);
	    skele_left[1] =charSheet.crop(48,192,16,16);
	   
	    skele_attackl[0]=charSheet.crop(64,192,16,16); 
	    skele_attackl[1]=charSheet.crop(80,192,16,16); 
	    skele_attackl[2]=charSheet.crop(96,192,16,16); 
	    skele_attackl[3]=charSheet.crop(112,192,16,16); 
	
	    skele_attackr[0]=charSheet.crop(64,208,16,16); 
	    skele_attackr[1]=charSheet.crop(80,208,16,16); 
	    skele_attackr[2]=charSheet.crop(96,208,16,16); 
	    skele_attackr[3]=charSheet.crop(112,208,16,16); 
	
		
		//cow		
		
		cow_left[0] = charSheet.crop(160,17,20,16);
		cow_left[1] = charSheet.crop(160,33,20,16);
	   
		cow_right[0] = charSheet.crop(193,17,20,16);
		cow_right[1] = charSheet.crop(193,33,20,16);
				
		cow_still[0] = charSheet.crop(160,1,20,16);
		cow_still[1] = charSheet.crop(193,1,20,16);
		
		cow_hurt[0] = charSheet.crop(160,49,20,16);
		cow_hurt[1] = charSheet.crop(193,49,20,16);
		
		//player
		playerHurt0 = charSheet.crop(0,16,16,16);
		playerHurt1 = charSheet.crop(48,16,16,16);
		playerHurt2 = charSheet.crop(16,16,16,16);
		playerHurt3 = charSheet.crop(32,16,16,16);
		
		plr_shoot_up[0] = charSheet.crop(112,80,16,16);
		plr_shoot_up[1] = charSheet.crop(128, 80,16,16);
		plr_shoot_up[2] = charSheet.crop(144,80,16,16);
		
		plr_shoot_down[0] = charSheet.crop(64,80,16,17);
		plr_shoot_down[1] = charSheet.crop(80,80,16,16);
		plr_shoot_down[2] = charSheet.crop(96,80,16,16);
		
		plr_shoot_left[0] = charSheet.crop(142,64,16,16);
		plr_shoot_left[1] = charSheet.crop(80,64,16,16);
		plr_shoot_left[2] = charSheet.crop(96,64,16,16);
		
		plr_shoot_right[0] = charSheet.crop(112,64,16,16);
		plr_shoot_right[1] = charSheet.crop(128,64,16,16);
		plr_shoot_right[2] = charSheet.crop(144,64,16,16);
		cow_ride_left[0] = charSheet.crop(192,72,20,24);
		cow_ride_left[1] = charSheet.crop(224,72,20,24);
		
		cow_ride_right[0] = charSheet.crop(192,104,20,24);
		cow_ride_right[1] = charSheet.crop(224,104,20,24);
				
		cow_ride_still[0] = charSheet.crop(160,72,20,24);
		cow_ride_still[1] = charSheet.crop(160,104,20,24);
		
		
		player_down[0] = charSheet.crop(16, 0, 16, 16);
	    player_down[1] = charSheet.crop(32, 0, 16, 16);
	    player_down_att[0] = charSheet.crop(0,48, w16, h16);
	    player_down_att[1] = charSheet.crop(16,48, w16, h16);
	    
	    player_up[0] = charSheet.crop(16, 32, w16, h16);
	    player_up[1] = charSheet.crop(32, 32, w16, h16);
	    player_up_att[0] = charSheet.crop(32,48, w16, h16);
	    player_up_att[1] = charSheet.crop(48,48, w16, h16);
	    
	    player_right[0] = charSheet.crop(80, 0, w16, h16);
	    player_right[1] = charSheet.crop(96, 0, w16, h16);
	    player_right_att[0] = charSheet.crop(64,16, w16, h16);
	    player_right_att[1] = charSheet.crop(80,16, w16, h16);
	    
	    player_left[0] = charSheet.crop(80, 32, w16, h16);
	    player_left[1] = charSheet.crop(96, 32, w16, h16);
	    player_left_att[0] = charSheet.crop(64,48, w16, h16);
	    player_left_att[1] = charSheet.crop(80,48, w16, h16);
	    
	    player_still[0] = charSheet.crop(0,0,16,16);
	    player_still[1] = charSheet.crop(64,32,16,16);
	    player_still[2] = charSheet.crop(0,32,16,16);
	    player_still[3] = charSheet.crop(64,0,16,16);
	
	    //world object
	    haybale1 = charSheet.crop(400,272,16,16);
	    crate1 = charSheet.crop(384, 272, 16, 16);
	    //tiles
	    grave = charSheet.crop(224,192, 16, 16);
	    errorTile = gSheet.crop(176,16,16,16);
	    blackTile = gSheet.crop(16,48,16,16);
	    arrowitem = charSheet.crop(80, 112,16,16);
		dirt = sheet1.crop(w64, 0, w64, h64);
	    stone = gSheet.crop(48, 20, 16, 16);
	    charDown = charSheet.crop(0, 0, 32, 32);
	    grassTopL = gSheet.crop(0, 0, 16, 16);
	    grassTopM = gSheet.crop(16, 0, 16, 16);
	    grassTopR = gSheet.crop(32, 0, 16, 16);
	    grassMidL = gSheet.crop(0, 16, 16, 16);
	    grassMid = gSheet.crop(16, 16, 16, 16);
	    grassMidR = gSheet.crop(32, 16, 16, 16);
	    grassBotL = gSheet.crop(0, 32, 16, 16);
	    grassBotM = gSheet.crop(16, 32, 16, 16);
	    grassBotR =  gSheet.crop(32, 32, 16, 16);
	    fence1 = gSheet.crop(64,0, 16, 16);
	    fence2 = gSheet.crop(80,0, 16, 16);
	    fence3= gSheet.crop(96,0, 16, 16);
	    fence4= gSheet.crop(64,16, 16, 16);
	    fence5= gSheet.crop(96,16, 16, 16);
	    fence6= gSheet.crop(64,32, 16, 16);
	    fence7= gSheet.crop(80,32, 16, 16);
	    fence8= gSheet.crop(96,32, 16, 16);
	    tfenceL = gSheet.crop(112,16,16,16);
		tfenceR = gSheet.crop(112,0,16,16);
	    pathCenter = gSheet.crop(16,80,16,16);
	    path1 = gSheet.crop(0,64,16,16);
	    path2 = gSheet.crop(16,64,16,16);
	    path3 = gSheet.crop(32,64,16,16);
	    path4 = gSheet.crop(0,80,16,16);
	    path5 = gSheet.crop(32,80,16,16);
	    path6 = gSheet.crop(0,96,16,16);
	    path7 = gSheet.crop(16,96,16,16);
	    path8 = gSheet.crop(32,96,16,16);
	    path9 = gSheet.crop(0,128,16,16);
	    path10 = gSheet.crop(16,128,16,16);
	    path11 = gSheet.crop(32,128,16,16);
	    path12 = gSheet.crop(0,144,16,16);
	    path13 = gSheet.crop(32,144,16,16);
	    path14 = gSheet.crop(0,160,16,16);
	    path15 = gSheet.crop(16,160,16,16);
	    path16 = gSheet.crop(32,160,16,16);
		dungeon_wall = gSheet.crop(16,208, 16,16);
		dungeon_wall1 = gSheet.crop(0,192, 16,16);
		dungeon_wall2 = gSheet.crop(16,192, 16,16);
		dungeon_wall3 = gSheet.crop(32,192, 16,16);
		dungeon_wall4 = gSheet.crop(0,208, 16,16);
		dungeon_wall5 = gSheet.crop(32,208, 16,16);
		dungeon_wall6 = gSheet.crop(0,224, 16,16);
		dungeon_wall7 = gSheet.crop(16,224, 16,16);
		dungeon_wall8 = gSheet.crop(32,224, 16,16);
		dungeon_floor = gSheet.crop(80,208, 16,16);
		dungeon_floor1 = gSheet.crop(64,192, 16,16);
		dungeon_floor2 = gSheet.crop(80,192, 16,16);
		dungeon_floor3 = gSheet.crop(96,192, 16,16);
		dungeon_floor4 = gSheet.crop(64,208, 16,16);
		dungeon_floor5 = gSheet.crop(96,208, 16,16);
		dungeon_floor6 = gSheet.crop(64,224, 16,16);
		dungeon_floor7 = gSheet.crop(80,224, 16,16);
		dungeon_floor8 = gSheet.crop(96,224, 16,16);
		dungeon_floor_fence = gSheet.crop(128,224, 16,16);
		dungeon_floor_fence1 = gSheet.crop(128,192, 16,16);
		dungeon_floor_fence2 = gSheet.crop(144,192, 16,16);
		dungeon_floor_fence3 = gSheet.crop(128,208, 16,16);
		dungeon_floor_fence4 = gSheet.crop(144,208, 16,16);
		water1 = gSheet.crop(0,288,16,16);
		water2 = gSheet.crop(16,288,16,16);
		water3 = gSheet.crop(32,288,16,16);
		water4 = gSheet.crop(0,304,16,16);
		water5 = gSheet.crop(32,304,16,16);
		water6 = gSheet.crop(0,320,16,16);
		water7 = gSheet.crop(16,320,16,16);
		water8 = gSheet.crop(32,320,16,16);
		water9 = gSheet.crop(64,288,16,16);
		water10 = gSheet.crop(80,288,16,16);
		water11 = gSheet.crop(96,288,16,16);
		water12 = gSheet.crop(64,304,16,16);
		water13 = gSheet.crop(96,304,16,16);
		water14 = gSheet.crop(64,320,16,16);
		water15 = gSheet.crop(80,320,16,16);
		water16 = gSheet.crop(96,320,16,16);
		insidepath1 = gSheet.crop(0,368,16,16);
		insidepath2 = gSheet.crop(16,368,16,16);
		insidepath3 = gSheet.crop(32,368,16,16);
		insidepath4 = gSheet.crop(0,384,16,16);
		insidepath5 = gSheet.crop(32,384,16,16);
		insidepath6 = gSheet.crop(0,400,16,16);
		insidepath7 = gSheet.crop(16,400,16,16);
		insidepath8 = gSheet.crop(32,400,16,16);
		housewall1 = gSheet.crop(0,336,16,16);
		housewall2 = gSheet.crop(16,336,16,16);
		housewall3 = gSheet.crop(32,336,16,16);
		housewall4 = gSheet.crop(0,352,16,16);
		housewall5 = gSheet.crop(16,352,16,16);
		housewall6 = gSheet.crop(32,352,16,16);
		entercave = gSheet.crop(32, 48, 16, 16);
	   dirt = gSheet.crop(80,80, 16, 16);
	   dirt1 = gSheet.crop(64,64, 16, 16);
	   dirt2 = gSheet.crop(80,64, 16, 16);
	   dirt3 = gSheet.crop(96,64, 16, 16);
	   dirt4 = gSheet.crop(64,80, 16, 16);
	   dirt5 = gSheet.crop(96,80, 16, 16);
	   dirt6 = gSheet.crop(64,96, 16, 16);
	   dirt7 = gSheet.crop(80,96, 16, 16);
	   dirt8 = gSheet.crop(96,96, 16, 16);
	   dirt9 = gSheet.crop(64,128, 16, 16);
	   dirt10 = gSheet.crop(80,128, 16, 16);
	   dirt11 = gSheet.crop(96,128, 16, 16);
	   dirt12 = gSheet.crop(64,144, 16, 16);
	   dirt13= gSheet.crop(96,144, 16, 16);
	   dirt14= gSheet.crop(64,160, 16, 16);
	   dirt15= gSheet.crop(80,160, 16, 16);
	   dirt16= gSheet.crop(96,160, 16, 16);
	   water[0] = gSheet.crop(16,304, 16,16);
	  water[1] = gSheet.crop(16,272,16,16);
		//items
		checkpoint = charSheet.crop(336,16,16,16);
	   arrowup = charSheet.crop(112 ,96, 16,16);
	   arrowdown = charSheet.crop(80,96,16,16);
	   arrowleft = charSheet.crop(96,96,16,16);
	   arrowright = charSheet.crop(128,96,16,16);
	    
	    log1 = charSheet.crop(272,16, 16, 16);
	    coins_sml = charSheet.crop(240, 0, w16, h16);
	    meat = charSheet.crop(272, 0, 16,16);
	    healthpotion = charSheet.crop(288,80,16,16);
	    //entities
	    house1 = charSheet.crop(256, 48, 52, 48);
	    cursor = charSheet.crop(624, 0, 16, 16);
	    tree = charSheet.crop(128,176, 16, 32);	
	    tree2 = charSheet.crop(144,176, 16, 32);	
	    tree3 = charSheet.crop(160,176, 16, 32);	
	    tree4 = charSheet.crop(192,176, 16, 32);	
		  
	    //buildings
	    building1closed = buildingSheet.crop(16, 103, 67,73);
	    building1open = buildingSheet.crop(96, 103, 67, 73);
	
	    
	}
}
