package com.mygdx.game.maps;


import com.mygdx.game.Entities.Enemy;
import com.mygdx.game.Entities.Skills.Element.Elements;

public class Level03 extends GameMap{
	
	@Override
	protected void initMap() {
		Enemy e1 = new Enemy("dragon.png", "dragondetail.png", "Dragon Pup", 45, 45, 45, 800, 6400, Elements.FIRE, 10);
		Enemy e2 = new Enemy("dragon.png", "dragondetail.png", "Dragon", 30, 25, 30, 600, 3200, Elements.FIRE, 8);
		Enemy e3 = new Enemy("darkknight.png", "darkknightdetail.png", "Knight", 25, 50, 30, 400, 3200, Elements.NONE, 8);
		Enemy e4 = new Enemy("ent.png", "entdetail.png", "Ent", 25, 20, 20, 330, 3200, Elements.GRASS, 8);
		Enemy e5 = new Enemy("slime.png", "slimedetail.png", "Slime", 30, 40, 30, 330, 3200, Elements.WATER, 8);
		
		e.add(e1);
		e.add(e2);
		e.add(e3);
		e.add(e4);
		e.add(e5);
		
		super.initMap();
		// level 3
		// start 
		grid[4][7] = s;
		// goal
		grid[7][14] = g;
		// enemies 
		grid[7][1] = e.get(e.indexOf(e1)); // normal
		grid[1][1] = e.get(e.indexOf(e2));
		grid[1][13] = e.get(e.indexOf(e3));

		grid[3][4] = e.get(e.indexOf(e4)); // can move left [3][3]
		grid[5][12] = e.get(e.indexOf(e5)); // can move down [4][12]
		
		grid[4][1] = h;

		// walls
		grid[2][2] = w; // w1
		grid[3][2] = w;
		grid[4][2] = w;
		grid[5][2] = w;
		grid[5][6] = w;
		grid[5][7] = w;
		grid[5][8] = w;
		grid[6][2] = w;
		grid[6][3] = w;
		grid[6][4] = w;
		grid[6][5] = w;
		grid[6][6] = w;
		grid[6][7] = w;
		grid[6][8] = w;
		grid[6][9] = w;
		grid[6][10] = w;
		grid[6][11] = w;
		grid[6][12] = w;
		grid[6][13] = w;
		grid[6][14] = w;
		grid[5][14] = w;
		grid[4][14] = w;
		grid[3][14] = w;
		grid[2][14] = w;
		grid[1][14] = w;

		grid[2][4] = w; // w2
		grid[2][5] = w;
		grid[2][6] = w;
		grid[3][6] = w;

		grid[3][8] = w; // w3
		grid[2][8] = w;
		grid[2][9] = w;
		grid[2][10] = w;
		grid[2][11] = w;
		grid[2][12] = w;
		grid[3][12] = w;
	}

	//this code returns the grid position of the start point 
	public int[] getStartGridPosition() {
		int[] start = new int[2];
		start[0] = 7; //remember to update this on every new map
		start[1] = 4; // remember to update this on every new map
		return start;
	}
}
