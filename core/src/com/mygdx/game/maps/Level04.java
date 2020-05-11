package com.mygdx.game.maps;


import com.mygdx.game.Entities.Enemy;
import com.mygdx.game.Entities.Skills.Element.Elements;;

public class Level04 extends GameMap{
	
	@Override
	protected void initMap() {
		Enemy e1 = new Enemy("dragon.png", "dragondetail.png", "Dragon Pup", 7, 7, 5, 30, 3200, Elements.FIRE, 2);
		Enemy e2 = new Enemy("dragon.png", "dragondetail.png", "Dragon Pup", 7, 7, 5, 30, 3200, Elements.FIRE, 2);
		Enemy e3 = new Enemy("dragon.png", "dragondetail.png", "Dragon Pup", 7, 7, 5, 30, 3200, Elements.FIRE, 2);
		Enemy e4 = new Enemy("dragon.png", "dragondetail.png", "Dragon Pup", 7, 7, 5, 30, 3200, Elements.FIRE, 2);
		Enemy e5 = new Enemy("dragon.png", "dragondetail.png", "Dragon Pup", 7, 7, 5, 30, 3200, Elements.FIRE, 2);
		
		e.add(e1);
		e.add(e2);
		e.add(e3);
		e.add(e4);
		e.add(e5);
		
		super.initMap();
		// level 4
		// start 
		grid[7][8] = s;
		// goal
		grid[7][10] = g;
		// enemies 
		grid[5][7] = e.get(e.indexOf(e1)); // normal
		grid[1][3] = e.get(e.indexOf(e2));
		grid[1][12] = e.get(e.indexOf(e3));

		grid[4][1] = e.get(e.indexOf(e4)); // can move right [4][2]
		grid[4][14] = e.get(e.indexOf(e5)); // can move left [4][13]
		// walls
		grid[7][7] = w; // w1
		grid[6][7] = w;

		grid[2][3] = w; // w2
		grid[3][3] = w;
		grid[4][3] = w;
		grid[4][4] = w;
		grid[4][5] = w;
		grid[4][6] = w;
		grid[4][7] = w;
		grid[4][8] = w;
		grid[4][9] = w;
		grid[5][9] = w;
		grid[6][9] = w;
		grid[7][9] = w;
		grid[4][10] = w;
		grid[4][11] = w;
		grid[4][12] = w;
		grid[3][12] = w;
		grid[2][12] = w;
		grid[2][11] = w;
		grid[2][10] = w;
		grid[2][9] = w;
		grid[2][8] = w;
		grid[2][7] = w;
		grid[2][6] = w;
		grid[2][5] = w;
	}

	//this code returns the grid position of the start point 
	public int[] getStartGridPosition() {
		int[] start = new int[2];
		start[0] = 8; //remember to update this on every new map
		start[1] = 7; // remember to update this on every new map
		return start;
	}
}
