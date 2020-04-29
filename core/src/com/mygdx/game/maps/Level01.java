package com.mygdx.game.maps;

import com.mygdx.game.Entities.Enemy;
import com.mygdx.game.Entities.HealPoint;
import com.mygdx.game.Entities.Skills.Element;

public class Level01 extends GameMap{;
	
	@Override
	protected void initMap() {
		Enemy e1 = new Enemy("darkknight.png", "darkknightdetail.png", "Dark Knight", 7, 7, 5, 75, 20, new Element(Element.Elements.NONE));
		Enemy e2 = new Enemy("slime.png", "slimedetail.png", "Slime", 7, 7, 5, 100, 20, new Element(Element.Elements.WATER));
		Enemy e3 = new Enemy("ent.png", "entdetail.png", "Ent", 7, 7, 5, 100, 20, new Element(Element.Elements.GRASS));
		Enemy e4 = new Enemy("dragon.png", "dragondetail.png", "Dragon Pup", 7, 7, 5, 100, 20, new Element(Element.Elements.FIRE));
		Enemy e5 = new Enemy("dragon.png", "dragondetail.png", "Dragon Pup", 7, 7, 5, 100, 20, new Element(Element.Elements.FIRE));
		
		e.add(e1);
		e.add(e2);
		e.add(e3);
		e.add(e4);
		e.add(e5);
		
		super.initMap();
		// level 1
		// start 
		grid[4][1] = s;
		// goal
		grid[3][14] = g;
		// enemies 
		grid[4][4] = e.get(e.indexOf(e1)); // normal
		grid[5][14] = e.get(e.indexOf(e2));
		grid[1][13] = e.get(e.indexOf(e3));

		grid[7][8] = e.get(e.indexOf(e4)); // can move down [6][8]
		grid[1][8] = e.get(e.indexOf(e5)); // can move up [2,8]
		
		//healpads
		grid[1][14] = h;

		// walls
		grid[5][1] = w; // w1
		grid[5][2] = w;
		grid[5][3] = w;

		grid[3][1] = w; // w2
		grid[3][2] = w;
		grid[3][3] = w;

		grid[5][5] = w; // w3
		grid[4][5] = w;
		grid[3][5] = w;

		grid[5][8] = w; // w4
		grid[4][8] = w;
		grid[3][8] = w;

		grid[5][10] = w; // w5
		grid[5][11] = w;
		grid[5][12] = w;
		grid[4][11] = w;
		grid[3][11] = w;

		grid[2][13] = w; // w6
		grid[2][14] = w;
	}

	//this code returns the grid position of the start point 
	public int[] getStartGridPosition() {
		int[] start = new int[2];
		start[0] = 1; //remember to update this on every new map
		start[1] = 4; // remember to update this on every new map
		return start;
	}
}
