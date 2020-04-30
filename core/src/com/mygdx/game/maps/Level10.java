package com.mygdx.game.maps;


import com.mygdx.game.Entities.Enemy;
import com.mygdx.game.Entities.Skills.Element.Elements;

public class Level10 extends GameMap{	
	
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
		// level 10
		// start 
		grid[1][14] = s;
		// goal
		grid[1][1] = g;
		// enemies 
		grid[2][1] = e.get(e.indexOf(e1)); // normal 
		grid[7][3] = e.get(e.indexOf(e2));  
		grid[1][11] = e.get(e.indexOf(e3));  

		grid[2][5] = e.get(e.indexOf(e4)); // can move up [3][5]  
		grid[5][7] = e.get(e.indexOf(e5));  // can move left [5][8]
		// walls
		grid[6][2] = w; // w1
		grid[5][2] = w;
		grid[4][2] = w;
		grid[6][3] = w;
		grid[5][3] = w;
		grid[4][3] = w;
		grid[7][4] = w;
		grid[6][4] = w;
		grid[5][4] = w;
		grid[5][5] = w;
		grid[5][6] = w;
		grid[4][4] = w;

		grid[2][2] = w; // w2
		grid[1][2] = w;
		grid[2][3] = w;
		grid[1][3] = w;
		grid[2][4] = w;
		grid[1][4] = w;

		grid[6][9] = w; // w3
		grid[5][9] = w;
		grid[4][9] = w;
		grid[3][9] = w;
		grid[2][9] = w;
		grid[1][9] = w; 

		grid[2][11] = w; // w4
		grid[3][11] = w;
		grid[4][11] = w;
		grid[5][11] = w;
		grid[6][11] = w;
		grid[7][11] = w;

		grid[6][13] = w; // w5
		grid[5][13] = w;
		grid[4][13] = w;
		grid[3][13] = w;
		grid[2][13] = w;
		grid[1][13] = w;
	}

	//this code returns the grid position of the start point 
	public int[] getStartGridPosition() {
		int[] start = new int[2];
		start[0] = 14; //remember to update this on every new map
		start[1] = 1; // remember to update this on every new map
		return start;
	}
}
