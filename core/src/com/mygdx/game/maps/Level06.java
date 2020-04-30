package com.mygdx.game.maps;


import com.mygdx.game.Entities.Enemy;
import com.mygdx.game.Entities.Skills.Element.Elements;;

public class Level06 extends GameMap{	
	
	@Override
	protected void initMap() {
		Enemy e1 = new Enemy("dragon.png", "dragondetail.png", "Dragon Pup", 7, 7, 5, 30, 5000, Elements.FIRE, 2);
		Enemy e2 = new Enemy("dragon.png", "dragondetail.png", "Dragon Pup", 7, 7, 5, 30, 5020, Elements.FIRE, 2);
		Enemy e3 = new Enemy("dragon.png", "dragondetail.png", "Dragon Pup", 7, 7, 5, 30, 5020, Elements.FIRE, 2);
		Enemy e4 = new Enemy("dragon.png", "dragondetail.png", "Dragon Pup", 7, 7, 5, 30, 5020, Elements.FIRE, 2);
		Enemy e5 = new Enemy("dragon.png", "dragondetail.png", "Dragon Pup", 7, 7, 5, 30, 5020, Elements.FIRE, 2);
		
		e.add(e1);
		e.add(e2);
		e.add(e3);
		e.add(e4);
		e.add(e5);
		
		super.initMap();
		// level 6
		// start 
		grid[7][1] = s;
		// goal
		grid[7][7] = g;
		// enemies 
		grid[6][4] = e.get(e.indexOf(e1)); // normal
		grid[6][7] = e.get(e.indexOf(e2));
		grid[7][14] = e.get(e.indexOf(e3));

		grid[1][6] = e.get(e.indexOf(e4)); // can move up [2][6]
		grid[2][9] = e.get(e.indexOf(e5)); // can move down [1][9]

		// walls
		grid[5][1] = w; // w1
		grid[5][2] = w;

		grid[3][2] = w; // w2
		grid[3][3] = w;
		grid[3][4] = w;
		grid[3][5] = w;
		grid[3][6] = w;
		grid[4][6] = w;
		grid[5][6] = w;
		grid[6][6] = w;
		grid[7][6] = w;

		grid[7][9] = w; // w3
		grid[6][9] = w;
		grid[5][9] = w;
		grid[4][9] = w;
		grid[3][9] = w;
		grid[3][10] = w;
		grid[3][11] = w;
		grid[3][12] = w;
		grid[3][13] = w;

		grid[5][14] = w; // w4
		grid[5][13] = w;

	}

	//this code returns the grid position of the start point 
	public int[] getStartGridPosition() {
		int[] start = new int[2];
		start[0] = 1; //remember to update this on every new map
		start[1] = 7; // remember to update this on every new map
		return start;
	}
}
