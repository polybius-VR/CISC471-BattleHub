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
import com.mygdx.game.Entities.Enemy;
import com.mygdx.game.Entities.Player;

public class GameScreen implements Screen{
	private Game game;
	private Stage stage;
	private Texture gridImage;
	private SpriteBatch batch;
	private Player player;
	private Enemy enemy;
	
	public GameScreen(Game aGame) {
		game = aGame;
		stage = new Stage(new ScreenViewport());
		batch = new SpriteBatch();
		gridImage = new Texture(Gdx.files.internal("grid.png"));
		
		player = new Player();
		player.setSprite(new Texture(Gdx.files.internal("wizard.png")));
		
		enemy = new Enemy();
		enemy.setSprite(new Texture(Gdx.files.internal("knight.png")));
		enemy.setX_pos(1200);
		enemy.setY_pos(640);
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
		batch.draw(player.getSprite(), player.getX_pos(), player.getY_pos(), 40, 64);
		batch.draw(enemy.getSprite(), enemy.getX_pos(), enemy.getY_pos(), 64, 64);
		batch.end();
		
		if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE))
			game.setScreen(new MenuScreen(this));
		
		if (player.getX_pos() >= 1200 && player.getY_pos() >= 640)
			game.setScreen(new BattleScreen(this));
		
		if (Gdx.input.isKeyJustPressed(Input.Keys.W))
			if (player.getY_pos() < 640)
				player.setY_pos(80);
		if (Gdx.input.isKeyJustPressed(Input.Keys.A))
			if (player.getX_pos() > 20)
				player.setX_pos(-80);
		if (Gdx.input.isKeyJustPressed(Input.Keys.S))
			if (player.getY_pos() > 64)
				player.setY_pos(-80);
		if (Gdx.input.isKeyJustPressed(Input.Keys.D))
			if (player.getX_pos() < 1200)
				player.setX_pos(80);
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
		player.getSprite().dispose();
		enemy.getSprite().dispose();
		batch.dispose();
	}

	public Game getGame() {
		return game;
	}
	
	public Player getPlayer() {
		return player;
	}
}
