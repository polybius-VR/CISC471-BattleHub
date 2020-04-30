package com.mygdx.game.maps;


import com.mygdx.game.Entities.Enemy;
import com.mygdx.game.Entities.Skills.Element.Elements;;

public class Level09 extends GameMap{
	
	@Override
	protected void initMap() {
		Enemy e1 = new Enemy("dragon.png", "dragondetail.png", "Dragon Pup", 7, 7, 5, 30, 20, Elements.FIRE, 2);
		Enemy e2 = new Enemy("dragon.png", "dragondetail.png", "Dragon Pup", 7, 7, 5, 30, 20, Elements.FIRE, 2);
		Enemy e3 = new Enemy("dragon.png", "dragondetail.png", "Dragon Pup", 7, 7, 5, 30, 20, Elements.FIRE, 2);
		Enemy e4 = new Enemy("dragon.png", "dragondetail.png", "Dragon Pup", 7, 7, 5, 30, 20, Elements.FIRE, 2);
		Enemy e5 = new Enemy("dragon.png", "dragondetail.png", "Dragon Pup", 7, 7, 5, 30, 20, Elements.FIRE, 2);
		
		e.add(e1);
		e.add(e2);
		e.add(e3);
		e.add(e4);
		e.add(e5);
		
		super.initMap();
		// level 9
		// start 
		grid[7][14] = s;
		// goal
		grid[7][7] = g; 
		// enemies 
		grid[7][6] = e.get(e.indexOf(e1));  // normal 
		grid[1][3] = e.get(e.indexOf(e2));  
		grid[5][8] = e.get(e.indexOf(e3));  

		grid[6][2] = e.get(e.indexOf(e4)); // can move left [6][1] 
		grid[3][8] = e.get(e.indexOf(e5)); // can move up [4][8]
		// walls
		grid[6][3] = w; // w1 
		grid[5][3] = w;
		grid[4][3] = w; 
		grid[3][3] = w;
		grid[2][3] = w;
		grid[6][4] = w;    
		grid[5][4] = w;
		grid[4][4] = w; 
		grid[3][4] = w;
		grid[2][4] = w;
		grid[6][3] = w;    
		grid[5][3] = w;
		grid[4][3] = w; 
		grid[3][3] = w;
		grid[2][3] = w;
		grid[6][5] = w;
		grid[6][6] = w;
		grid[6][7] = w;
		grid[6][8] = w;
		grid[7][8] = w;

		grid[2][8] = w; // w2
		grid[1][8] = w;

		grid[5][11] = w; // w3
		grid[4][11] = w;
		grid[3][11] = w;
		grid[5][12] = w;
		grid[4][12] = w;
		grid[3][12] = w;  

	}

	//this code returns the grid position of the start point 
	public int[] getStartGridPosition() {
		int[] start = new int[2];
		start[0] = 14; //remember to update this on every new map
		start[1] = 7; // remember to update this on every new map
		return start;
	}
}
