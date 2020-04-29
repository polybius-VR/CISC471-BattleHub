package com.mygdx.game.maps;


import com.mygdx.game.Entities.Enemy;
import com.mygdx.game.Entities.Skills.Element;

public class Level07 extends GameMap{
	
	@Override
	protected void initMap() {
		Enemy e1 = new Enemy("dragon.png", "dragondetail.png", "Dragon Pup", 7, 7, 5, 30, 20, new Element(Element.Elements.FIRE));
		Enemy e2 = new Enemy("dragon.png", "dragondetail.png", "Dragon Pup", 7, 7, 5, 30, 20, new Element(Element.Elements.FIRE));
		Enemy e3 = new Enemy("dragon.png", "dragondetail.png", "Dragon Pup", 7, 7, 5, 30, 20, new Element(Element.Elements.FIRE));
		Enemy e4 = new Enemy("dragon.png", "dragondetail.png", "Dragon Pup", 7, 7, 5, 30, 20, new Element(Element.Elements.FIRE));
		Enemy e5 = new Enemy("dragon.png", "dragondetail.png", "Dragon Pup", 7, 7, 5, 30, 20, new Element(Element.Elements.FIRE));
		
		e.add(e1);
		e.add(e2);
		e.add(e3);
		e.add(e4);
		e.add(e5);
		
		super.initMap();
		// level 7
		// start 
		grid[7][7] = s;
		// goal
		grid[1][7] = g;
		// enemies 
		grid[3][4] = e.get(e.indexOf(e1)); // normal 
		grid[1][6] = e.get(e.indexOf(e2)); 
		grid[3][11] = e.get(e.indexOf(e3)); 

		grid[1][3] = e.get(e.indexOf(e4)); // can move up [2][3] 
		grid[2][12] = e.get(e.indexOf(e5)); // can move down [1][12]

		// walls
		grid[6][1] = w; // w1
		grid[6][2] = w;
		grid[6][3] = w; 
		grid[6][4] = w;
		grid[5][4] = w;
		grid[4][4] = w;  
		grid[6][5] = w;
		grid[6][6] = w; 

		grid[6][9] = w; // w2   
		grid[6][10] = w;  
		grid[6][11] = w;
		grid[5][11] = w;
		grid[4][11] = w;  
		grid[3][11] = w;
		grid[6][12] = w;
		grid[6][13] = w;
		grid[6][14] = w;       

		grid[2][4] = w; // w3
		grid[2][5] = w;
		grid[2][6] = w;
		grid[2][7] = w;
		grid[2][8] = w;
		grid[2][9] = w; 
		grid[2][10] = w;
		grid[2][11] = w;   

	}

	//this code returns the grid position of the start point 
	public int[] getStartGridPosition() {
		int[] start = new int[2];
		start[0] = 7; //remember to update this on every new map
		start[1] = 7; // remember to update this on every new map
		return start;
	}
}
