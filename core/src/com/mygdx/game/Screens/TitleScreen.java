package com.mygdx.game.Screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.Entities.Player;
import com.mygdx.game.Entities.Skills.Element.Elements;
import com.mygdx.game.Entities.Skills.Skill;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TitleScreen implements Screen{
	private Stage stage;
	private Game game;
	private Batch batch;
	private Texture titleScreen = new Texture(Gdx.files.internal("titlescreen.jpg"));
	
	public TitleScreen(Game aGame) {
		game = aGame;
		stage = new Stage(new ScreenViewport());
		this.batch = new SpriteBatch();
		
		TextButton newGameButton = new TextButton("New Game",MyGdxGame.skin);
		newGameButton.setWidth(Gdx.graphics.getWidth()/2);
		newGameButton.setPosition(Gdx.graphics.getWidth()/2-newGameButton.getWidth()/2,Gdx.graphics.getHeight()/2-newGameButton.getHeight()*7);
		newGameButton.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                game.setScreen(new NewGameScreen(game));
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
		TextButton playButton = new TextButton("Continue",MyGdxGame.skin);
        playButton.setWidth(Gdx.graphics.getWidth()/2);
        playButton.setPosition(Gdx.graphics.getWidth()/2-playButton.getWidth()/2,Gdx.graphics.getHeight()/2-playButton.getHeight()*8);
        playButton.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
            	List<String> data = new ArrayList<String>();
				List<Skill> s = new ArrayList<Skill>();
            	File tempFile = new File("SaveFile.txt");
            	boolean exists = tempFile.exists();
            	if (exists) {
            		try {
            			File myObj = new File("SaveFile.txt");
            			Scanner myReader = new Scanner(myObj);
            			while (myReader.hasNextLine()) {
            				data.add(myReader.nextLine());
            			}
            			myReader.close();
            			
            			Player p = new Player();
        				p.setName(data.get(1));
        				p.setAttack(Integer.valueOf(data.get(2)));
      	    		    p.setDefense(Integer.valueOf(data.get(3)));
      	    		    p.setSpeed(Integer.valueOf(data.get(4)));
      	    		    p.setHealth(Integer.valueOf(data.get(5)));
      	    		    p.setMaxHealth(Integer.valueOf(data.get(5)));
      	    		    p.setExperience(Integer.valueOf(data.get(6)));
      	    		    p.setLevel(Integer.valueOf(data.get(7)));
      	    		    if (data.get(8).contentEquals(Player.PlayerClass.KNIGHT.toString()))
      	    		    	p.setPlayerClass(Player.PlayerClass.KNIGHT);
      	    		    else 
      	    		    	p.setPlayerClass(Player.PlayerClass.SPELLCASTER);
      	    		    if (data.get(9).contentEquals(Elements.FIRE.toString()))
      	    		    	p.setElement(Elements.FIRE);
      	    		    else if (data.get(9).contentEquals(Elements.WATER.toString()))
      	    		    	p.setElement(Elements.WATER);
      	    		    else
      	    		    	p.setElement(Elements.GRASS);
      	    		    if (10 < data.size()) {
      	    		    	String[] val = data.get(10).split(",");
      	    		    	if (val[2].contentEquals(Elements.FIRE.toString()))
      	    		    		s.add(new Skill(val[0], Elements.FIRE, Integer.valueOf(val[1]), Boolean.valueOf(val[3]), Integer.valueOf(val[4])));
      	    		    	if (val[2].contentEquals(Elements.WATER.toString()))
      	    		    		s.add(new Skill(val[0], Elements.WATER, Integer.valueOf(val[1]), Boolean.valueOf(val[3]), Integer.valueOf(val[4])));
      	    		    	if (val[2].contentEquals(Elements.GRASS.toString()))
      	    		    		s.add(new Skill(val[0], Elements.GRASS, Integer.valueOf(val[1]), Boolean.valueOf(val[3]), Integer.valueOf(val[4])));
      	    		    	if (val[2].contentEquals(Elements.NONE.toString()))
      	    		    		s.add(new Skill(val[0], Elements.NONE, Integer.valueOf(val[1]), Boolean.valueOf(val[3]), Integer.valueOf(val[4])));
      	    		    }
      	    		    if (11 < data.size()) {
      	    		    	String[] val = data.get(11).split(",");
      	    		    	if (val[2].contentEquals(Elements.FIRE.toString()))
      	    		    		s.add(new Skill(val[0], Elements.FIRE, Integer.valueOf(val[1]), Boolean.valueOf(val[3]), Integer.valueOf(val[4])));
      	    		    	if (val[2].contentEquals(Elements.WATER.toString()))
      	    		    		s.add(new Skill(val[0], Elements.WATER, Integer.valueOf(val[1]), Boolean.valueOf(val[3]), Integer.valueOf(val[4])));
      	    		    	if (val[2].contentEquals(Elements.GRASS.toString()))
      	    		    		s.add(new Skill(val[0], Elements.GRASS, Integer.valueOf(val[1]), Boolean.valueOf(val[3]), Integer.valueOf(val[4])));
      	    		    	if (val[2].contentEquals(Elements.NONE.toString()))
      	    		    		s.add(new Skill(val[0], Elements.NONE, Integer.valueOf(val[1]), Boolean.valueOf(val[3]), Integer.valueOf(val[4])));
      	    		    }
      	    		    if (12 < data.size()) {
      	    		    	String[] val = data.get(12).split(",");
      	    		    	if (val[2].contentEquals(Elements.FIRE.toString()))
      	    		    		s.add(new Skill(val[0], Elements.FIRE, Integer.valueOf(val[1]), Boolean.valueOf(val[3]), Integer.valueOf(val[4])));
      	    		    	if (val[2].contentEquals(Elements.WATER.toString()))
      	    		    		s.add(new Skill(val[0], Elements.WATER, Integer.valueOf(val[1]), Boolean.valueOf(val[3]), Integer.valueOf(val[4])));
      	    		    	if (val[2].contentEquals(Elements.GRASS.toString()))
      	    		    		s.add(new Skill(val[0], Elements.GRASS, Integer.valueOf(val[1]), Boolean.valueOf(val[3]), Integer.valueOf(val[4])));
      	    		    	if (val[2].contentEquals(Elements.NONE.toString()))
      	    		    		s.add(new Skill(val[0], Elements.NONE, Integer.valueOf(val[1]), Boolean.valueOf(val[3]), Integer.valueOf(val[4])));
    	    		    }
      	    		    if (13 < data.size()) {
      	    		    	String[] val = data.get(13).split(",");
      	    		    	if (val[2].contentEquals(Elements.FIRE.toString()))
      	    		    		s.add(new Skill(val[0], Elements.FIRE, Integer.valueOf(val[1]), Boolean.valueOf(val[3]), Integer.valueOf(val[4])));
      	    		    	if (val[2].contentEquals(Elements.WATER.toString()))
      	    		    		s.add(new Skill(val[0], Elements.WATER, Integer.valueOf(val[1]), Boolean.valueOf(val[3]), Integer.valueOf(val[4])));
      	    		    	if (val[2].contentEquals(Elements.GRASS.toString()))
      	    		    		s.add(new Skill(val[0], Elements.GRASS, Integer.valueOf(val[1]), Boolean.valueOf(val[3]), Integer.valueOf(val[4])));
      	    		    	if (val[2].contentEquals(Elements.NONE.toString()))
      	    		    		s.add(new Skill(val[0], Elements.NONE, Integer.valueOf(val[1]), Boolean.valueOf(val[3]), Integer.valueOf(val[4])));
    	    		    }
      	    		    p.setSkills(s);
        				
        				game.setScreen(new GameScreen(game, p, Integer.valueOf(data.get(0))));
            		} catch (FileNotFoundException e) {
            			System.out.println("An error occurred.");
            			e.printStackTrace();
            		}
            	}
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        TextButton exitButton = new TextButton("Quit!",MyGdxGame.skin);
        exitButton.setWidth(Gdx.graphics.getWidth()/2);
        exitButton.setPosition(Gdx.graphics.getWidth()/2-exitButton.getWidth()/2,Gdx.graphics.getHeight()/2-exitButton.getHeight()*9);
        exitButton.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
               Gdx.app.exit();
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        stage.addActor(newGameButton);
        stage.addActor(playButton);
        stage.addActor(exitButton);
        	
	}

	@Override
	public void show() {
		Gdx.input.setInputProcessor(stage);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.392f, 0.584f, 0.929f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(titleScreen, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		batch.end();
		stage.act();
		stage.draw();		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		stage.dispose();
	}

}
