package com.mygdx.game.Screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.Entities.Player;
import com.mygdx.game.Entities.Skills.Skill;

import java.io.File;  // Import the File class
import java.io.FileWriter;
import java.io.IOException;  // Import the IOException class to handle errors
import java.util.Iterator;

public class MenuScreen implements Screen {
	private GameScreen gameScreen;
	private Stage stage;
	private Game game;
	private Player player;
	
	public MenuScreen(GameScreen aGameScreen) {
		gameScreen = aGameScreen;
		game = aGameScreen.getGame();
		stage = new Stage(new ScreenViewport());
		player = aGameScreen.getPlayer();
		
		TextButton playButton = new TextButton("Resume!",MyGdxGame.skin);
        playButton.setWidth(Gdx.graphics.getWidth()/2);
        playButton.setPosition(Gdx.graphics.getWidth()/2-playButton.getWidth()/2,Gdx.graphics.getHeight()/2-playButton.getHeight()/2);
        playButton.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                game.setScreen(gameScreen);
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        TextButton exitButton = new TextButton("Save and Quit!",MyGdxGame.skin);
        exitButton.setWidth(Gdx.graphics.getWidth()/2);
        exitButton.setPosition(Gdx.graphics.getWidth()/2-exitButton.getWidth()/2,Gdx.graphics.getHeight()/2-exitButton.getHeight()*2);
        exitButton.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
            	File tempFile = new File("SaveFile.txt");
            	boolean exists = tempFile.exists();
            	if (!exists) {
            	try {
            		
            	      File myObj = new File("SaveFile.txt");
            	      if (myObj.createNewFile()) {
            	        System.out.println("File created: " + myObj.getName());
            	      } else {
            	        System.out.println("File already exists.");
            	      }
            	    } catch (IOException e) {
            	      System.out.println("An error occurred.");
            	      e.printStackTrace();
            	    }
            	} 
            	try {
            	      FileWriter myWriter = new FileWriter("SaveFile.txt");
            	      myWriter.write(
            	    		  gameScreen.getCurrentLevel() + "\n" +
            	    		  player.getName() + "\n" +
            	    		  player.getAttack() + "\n" +
            	    		  player.getDefense() + "\n" +
            	    		  player.getSpeed() + "\n" +
            	    		  player.getMaxHealth() + "\n" +
            	    		  player.getExperience() + "\n" +
            	    		  player.getLevel() + "\n" +
            	    		  player.getPlayerClass().name() + "\n" +
            	    		  player.getElement() + "\n"            	    		  		 
            	    		  );
            	      Iterator<Skill> i = player.getSkills().iterator();
            	      while(i.hasNext()) {
            	    	  Skill s = i.next();
            	    	  myWriter.write(s.getName() + "," + s.getBaseAttack() + "," + s.getElement() + "," + s.getHealBonus() + "," + s.getLearnAtLevel() + "\n");
            	      }
            	      myWriter.close();
            	      System.out.println("Successfully wrote to the file.");
            	    } catch (IOException e) {
            	      System.out.println("An error occurred.");
            	      e.printStackTrace();
            	    }
            	game.setScreen(new TitleScreen(game));
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
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
