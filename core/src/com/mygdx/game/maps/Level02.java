package com.mygdx.game.maps;


import com.mygdx.game.Entities.Enemy;
import com.mygdx.game.Entities.Skills.Element.Elements;

public class Level02 extends GameMap{	
	
	@Override
	protected void initMap() {
		Enemy e1 = new Enemy("dragon.png", "dragondetail.png", "Dragon Pup", 7, 7, 5, 30, 200, Elements.FIRE, 2);
		Enemy e2 = new Enemy("dragon.png", "dragondetail.png", "Dragon Pup", 7, 7, 5, 30, 200, Elements.FIRE, 2);
		Enemy e3 = new Enemy("dragon.png", "dragondetail.png", "Dragon Pup", 7, 7, 5, 30, 200, Elements.FIRE, 2);
		Enemy e4 = new Enemy("dragon.png", "dragondetail.png", "Dragon Pup", 7, 7, 5, 30, 200, Elements.FIRE, 2);
		Enemy e5 = new Enemy("dragon.png", "dragondetail.png", "Dragon Pup", 7, 7, 5, 30, 200, Elements.FIRE, 2);
		
		e.add(e1);
		e.add(e2);
		e.add(e3);
		e.add(e4);
		e.add(e5);
		
		super.initMap();
		// level 2
		// start 
		grid[7][1] = s;
		// goal
		grid[1][14] = g;
		// enemies 
		grid[4][1] = e.get(e.indexOf(e1)); // normal
		grid[1][10] = e.get(e.indexOf(e2));
		grid[4][9] = e.get(e.indexOf(e3));

		grid[4][14] = e.get(e.indexOf(e4)); // can move left [4][13]
		grid[2][5] = e.get(e.indexOf(e5)); // can move up [3][5]

		// walls
		grid[6][1] = w; // w1
		grid[6][2] = w;

		grid[4][2] = w; // w2
		grid[4][3] = w;
		grid[4][4] = w;
		grid[4][5] = w;
		grid[4][6] = w;
		grid[5][4] = w;
		grid[5][5] = w;
		grid[5][6] = w;
		grid[6][4] = w;
		grid[6][5] = w;
		grid[6][6] = w;
		grid[7][4] = w;
		grid[7][5] = w;
		grid[7][6] = w;

		grid[2][2] = w; // w3
		grid[2][3] = w;
		grid[2][4] = w;
		grid[2][6] = w;
		grid[1][4] = w;
		grid[1][5] = w;
		grid[1][6] = w;

		grid[6][8] = w; // w4
		grid[6][9] = w;
		grid[6][10] = w;
		grid[6][11] = w;
		grid[6][12] = w;
		grid[6][13] = w;
		grid[5][8] = w; 
		grid[5][9] = w;
		grid[5][10] = w;
		grid[5][11] = w;
		grid[5][12] = w;
		grid[5][13] = w;
		grid[4][8] = w;
		grid[3][8] = w;
		grid[3][9] = w;
		grid[3][10] = w;
		grid[3][11] = w;
		grid[3][12] = w;
		grid[3][13] = w;
		grid[2][8] = w;
		grid[2][9] = w;
		grid[2][11] = w;
		grid[2][13] = w;
		grid[1][13] = w;
	}

	//this code returns the grid position of the start point 
	public int[] getStartGridPosition() {
		int[] start = new int[2];
		start[0] = 1; //remember to update this on every new map
		start[1] = 7; // remember to update this on every new map
		return start;
	}
}
