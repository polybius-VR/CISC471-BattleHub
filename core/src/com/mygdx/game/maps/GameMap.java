package com.mygdx.game.maps;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Entities.Enemy;
import com.mygdx.game.Entities.GameEntity;
import com.mygdx.game.Entities.Goal;
import com.mygdx.game.Entities.HealPoint;
import com.mygdx.game.Entities.StartPoint;
import com.mygdx.game.Entities.Wall;

public class GameMap {
	static Integer min = 0;
	public static Integer max_X = 16; //The maps are defined as a 16x9 grid.
	public static Integer max_Y = 9;
	
	private Texture ground = new Texture(Gdx.files.internal("ground.png"));
	
	protected GameEntity[][] grid = new GameEntity[max_Y][max_X];	
	protected Wall w = new Wall();	
	protected StartPoint s = new StartPoint();
	protected Goal g = new Goal();	
	protected HealPoint h = new HealPoint();
	protected List<Enemy> e = new ArrayList<Enemy>();
	
	public GameMap() {		
		initMap();
	}
	
	protected void initMap() {		
		//here we initialize the objects we are going to use, then whether you can move through them or not and whether it is an enemy or not 
		w.setSprite(new Texture(Gdx.files.internal("wall.png")));
		g.setSprite(new Texture(Gdx.files.internal("goal.png")));
		s.setSprite(new Texture(Gdx.files.internal("start.png")));
		h.setSprite(new Texture(Gdx.files.internal("meat.png")));
		
		//this loop puts a wall all around the map so you don't have to manually set that up. No need to modify this.
		for (int i = min; i < max_Y; i++) {
			for (int j = min; j < max_X; j++) {
				if (i == min || i == max_Y - 1 || j == min || j == max_X - 1)
					grid[i][j] = w;
			}
		}
		
	}
	
	//this is the code that draws all the graphics on screen, no need to modify this at all
	public void draw(SpriteBatch batch) {
		for (int i = min; i < max_Y; i++) {
			for (int j = min; j < max_X; j++) {
				if (null != grid[i][j]) {
					if (grid[i][j].getClass().equals(Wall.class))
						batch.draw((grid[i][j]).getSprite(), (Gdx.graphics.getWidth()/2 - 512) + 64*j, (Gdx.graphics.getHeight()) - 64*(max_Y-i), 64, 64);
					if (grid[i][j].getClass().equals(Goal.class))
						batch.draw((grid[i][j]).getSprite(), (Gdx.graphics.getWidth()/2 - 512) + 64*j, (Gdx.graphics.getHeight()) - 64*(max_Y-i), 64, 64);
					if (grid[i][j].getClass().equals(StartPoint.class))
						batch.draw((grid[i][j]).getSprite(), (Gdx.graphics.getWidth()/2 - 512) + 64*j, (Gdx.graphics.getHeight()) - 64*(max_Y-i), 64, 64);
					if (grid[i][j].getClass().equals(Enemy.class)) {
						batch.draw(ground, (Gdx.graphics.getWidth()/2 - 512) + 64*j, (Gdx.graphics.getHeight()) - 64*(max_Y-i), 64, 64);
						batch.draw((grid[i][j]).getSprite(), (Gdx.graphics.getWidth()/2 - 512) + 64*j, (Gdx.graphics.getHeight()) - 64*(max_Y-i), 64, 64);
					}
					if (grid[i][j].getClass().equals(HealPoint.class)) {
						batch.draw(ground, (Gdx.graphics.getWidth()/2 - 512) + 64*j, (Gdx.graphics.getHeight()) - 64*(max_Y-i), 64, 64);
						batch.draw((grid[i][j]).getSprite(), (Gdx.graphics.getWidth()/2 - 512) + 64*j, (Gdx.graphics.getHeight()) - 64*(max_Y-i), 64, 64);
					}
				} else 
					batch.draw(ground, (Gdx.graphics.getWidth()/2 - 512) + 64*j, (Gdx.graphics.getHeight()) - 64*(max_Y-i), 64, 64);
			}			
		}		
	}
	
	//libgdx code to get rid of all the stuff in memory once you close the game
	public void dispose() {
		w.getSprite().dispose();
		g.getSprite().dispose();
		s.getSprite().dispose();
		h.getSprite().dispose();
		
		Iterator<Enemy> i = e.iterator();
		while (i.hasNext()) {
			i.next().getSprite().dispose();
		}
	}

	//this code returns the grid position of the start point 
	public int[] getStartGridPosition() {
		int[] start = new int[2];
		start[0] = 1; //remember to update this on every new map
		start[1] = 7; // remember to update this on every new map
		return start;
	}
	
	//this is the code used by the game to figure out what's on the grid position you want to move to. No need to modify this.
	public GameEntity getGridContentAt(int posX, int posY) {
		if (posY <= 9 || posX <= 16) {
			return grid[posY][posX];
		}
		else
			return null;
	}
	
	//this removes the content of the grid at a defined position. Used to remove defeated enemies.
	public void removeGridContentAt(int posX, int posY) {
		if (posY <= 9 || posX <= 16) {
			grid[posY][posX] = null;
		}
	}
}
