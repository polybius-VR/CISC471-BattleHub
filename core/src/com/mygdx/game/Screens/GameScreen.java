package com.mygdx.game.Screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class GameScreen implements Screen{
	private Game game;
	private Stage stage;
	private Texture gridImage;
	private SpriteBatch batch;
	
	public GameScreen(Game aGame) {
		game = aGame;
		stage = new Stage(new ScreenViewport());
		batch = new SpriteBatch();
		gridImage = new Texture(Gdx.files.internal("grid.png"));
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
		batch.draw(gridImage, 0, 0);
		batch.end();
		//stage.act();
		//stage.draw();
		if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE))
			game.setScreen(new MenuScreen(this));
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
		gridImage.dispose();
		batch.dispose();
	}

	public Game getGame() {
		return game;
	}
}
