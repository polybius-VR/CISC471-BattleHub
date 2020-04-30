package com.mygdx.game.maps;


import com.mygdx.game.Entities.Enemy;
import com.mygdx.game.Entities.Skills.Element.Elements;;

public class Level08 extends GameMap{
	
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
		// level 8
		// start 
		grid[2][8] = s; 
		// end
		grid[6][14] = g; 
		// enemies 
		grid[6][1] = e.get(e.indexOf(e1)); // normal
		grid[6][8] = e.get(e.indexOf(e2)); 
		grid[1][11] = e.get(e.indexOf(e3)); 

		grid[3][2] = e.get(e.indexOf(e4)); // can move left [3][1]
		grid[3][13] = e.get(e.indexOf(e5));  // can move right [3][14]

		// walls
		grid[5][1] = w; // w1
		grid[5][2] = w;
		grid[5][3] = w;
		grid[6][3] = w;
		grid[6][4] = w;
		grid[6][5] = w;  
		grid[6][6] = w;
		grid[6][7] = w;   
		grid[5][4] = w; 
		grid[5][5] = w;
		grid[5][6] = w;
		grid[5][7] = w;  

		grid[6][9] = w; // w2
		grid[6][10] = w;
		grid[6][11] = w; 
		grid[6][12] = w;
		grid[5][9] = w;
		grid[5][10] = w;
		grid[5][11] = w;
		grid[5][12] = w;
		grid[5][13] = w;
		grid[5][14] = w;     

		grid[3][3] = w; // w3
		grid[3][4] = w;
		grid[3][5] = w;
		grid[2][5] = w; 
		grid[3][6] = w; 
		grid[3][7] = w;
		grid[3][9] = w;
		grid[3][10] = w;      
		grid[3][11] = w;
		grid[2][11] = w;  
		grid[3][12] = w;    

	}

	//this code returns the grid position of the start point 
	public int[] getStartGridPosition() {
		int[] start = new int[2];
		start[0] = 8; //remember to update this on every new map
		start[1] = 2; // remember to update this on every new map
		return start;
	}
}
