package com.mygdx.game.maps;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Entities.Enemy;
import com.mygdx.game.Entities.Goal;
import com.mygdx.game.Entities.StartPoint;
import com.mygdx.game.Entities.Wall;

public class Map001 {
	static Integer min = 0;
	public static Integer max_X = 16; //The maps are defined as a 16x9 grid.
	public static Integer max_Y = 9;
	
	Object[][] grid = new Object[max_Y][max_X];
	
	Wall w = new Wall();
	
	StartPoint s = new StartPoint();
	Goal g = new Goal();
	
	Enemy e1 = new Enemy();
	Enemy e2 = new Enemy();
	Enemy e3 = new Enemy();	
	List<Enemy> e = new ArrayList<Enemy>();
	
	public Map001() {
		e.add(e1);
		e.add(e2);
		e.add(e3);
		
		initMap();
	}
	
	private void initMap() {		
		w.setSprite(new Texture(Gdx.files.internal("wall.png")));
		w.setIsSolid(Boolean.TRUE);
		w.setIsFoe(Boolean.FALSE);
		g.setSprite(new Texture(Gdx.files.internal("goal.png")));
		g.setIsSolid(Boolean.FALSE);
		g.setIsFoe(Boolean.FALSE);
		s.setSprite(new Texture(Gdx.files.internal("start.png")));
		s.setIsSolid(Boolean.FALSE);
		s.setIsFoe(Boolean.FALSE);
		e1.setSprite(new Texture(Gdx.files.internal("dragon.png")));
		e1.setIsSolid(Boolean.FALSE);
		e1.setIsFoe(Boolean.TRUE);
		e2.setSprite(new Texture(Gdx.files.internal("dragon.png")));
		e2.setIsSolid(Boolean.FALSE);
		e2.setIsFoe(Boolean.TRUE);
		e3.setSprite(new Texture(Gdx.files.internal("dragon.png")));
		e3.setIsSolid(Boolean.FALSE);
		e3.setIsFoe(Boolean.TRUE);
		
		for (int i = min; i < max_Y; i++) {
			for (int j = min; j < max_X; j++) {
				if (i == min || i == max_Y - 1 || j == min || j == max_X - 1)
					grid[i][j] = w;
			}
		}
		
		grid[6][2] = w;
		grid[4][4] = w;
		grid[3][7] = w;
		grid[4][7] = w;
		grid[5][7] = w;
		grid[4][6] = w;
		grid[4][8] = w;
		grid[1][13] = w;
		grid[1][12] = w;
		grid[2][12] = w;
		
		grid[7][1] = s;
		grid[1][14] = g;
		grid[2][13] = e.get(e.indexOf(e1));
		grid[6][7] = e.get(e.indexOf(e1));
		grid[2][7] = e.get(e.indexOf(e1));
	}
	
	public void draw(SpriteBatch batch) {
		for (int i = min; i < max_Y; i++) {
			for (int j = min; j < max_X; j++) {
				if (null != grid[i][j]) {
					if (grid[i][j].getClass().equals(Wall.class))
						batch.draw(((Wall) grid[i][j]).getSprite(), (Gdx.graphics.getWidth()/2 - 512) + 64*j, (Gdx.graphics.getHeight()) - 64*(max_Y-i), 64, 64);
					if (grid[i][j].getClass().equals(Goal.class))
						batch.draw(((Goal) grid[i][j]).getSprite(), (Gdx.graphics.getWidth()/2 - 512) + 64*j, (Gdx.graphics.getHeight()) - 64*(max_Y-i), 64, 64);
					if (grid[i][j].getClass().equals(StartPoint.class))
						batch.draw(((StartPoint) grid[i][j]).getSprite(), (Gdx.graphics.getWidth()/2 - 512) + 64*j, (Gdx.graphics.getHeight()) - 64*(max_Y-i), 64, 64);
					if (grid[i][j].getClass().equals(Enemy.class))
						batch.draw(((Enemy) grid[i][j]).getSprite(), (Gdx.graphics.getWidth()/2 - 512) + 64*j, (Gdx.graphics.getHeight()) - 64*(max_Y-i), 64, 64);
				}
			}			
		}		
	}
	

	public void dispose() {
		w.getSprite().dispose();
		g.getSprite().dispose();
		s.getSprite().dispose();
		
		Iterator<Enemy> i = e.iterator();
		while (i.hasNext()) {
			i.next().getSprite().dispose();
		}
	}

	public int[] getStartGridPosition() {
		int[] start = new int[2];
		start[0] = 1;
		start[1] = 7;
		return start;
	}
	
	public Object getGridContentAt(int posX, int posY) {
		if (posY <= 9 || posX <= 16) {
			return grid[posY][posX];
		}
		else
			return null;
	}
}
