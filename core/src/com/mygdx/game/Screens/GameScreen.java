package com.mygdx.game.Screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.Entities.Enemy;
import com.mygdx.game.Entities.GameEntity;
import com.mygdx.game.Entities.Player;
import com.mygdx.game.Entities.Wall;
import com.mygdx.game.maps.Map001;

public class GameScreen implements Screen{
	private Game game;
	private Stage stage;
	private Texture gridImage;
	private SpriteBatch batch;
	private Player player;
	private Enemy enemy;
	private Map001 map01;
	private Label lblTextbox;
	private Texture txtBackground;
	
	public GameScreen(Game aGame, Player aPlayer) {
		game = aGame;
		stage = new Stage(new ScreenViewport());
		batch = new SpriteBatch();
		gridImage = new Texture(Gdx.files.internal("grid.png"));
		lblTextbox = new Label("", MyGdxGame.skin);		
		
		player = aPlayer;
		if (player.getPlayerClass() == Player.PlayerClass.KNIGHT)
			player.setSprite(new Texture(Gdx.files.internal("knight.png")));
		else if (player.getPlayerClass() == Player.PlayerClass.SPELLCASTER)
			player.setSprite(new Texture(Gdx.files.internal("wizard.png")));

		map01 = new Map001();
		
		player.setX_pos( (Gdx.graphics.getWidth()/2 - 512) + (map01.getStartGridPosition()[0]*64) - 20);
		player.setY_pos( Gdx.graphics.getHeight() - (Map001.max_Y-map01.getStartGridPosition()[1])*64);
		player.setGridPosition(map01.getStartGridPosition()[0], map01.getStartGridPosition()[1]);
		
		lblTextbox.setColor(Color.BLACK);
		lblTextbox.setSize(Gdx.graphics.getWidth(),160);
		lblTextbox.setPosition(0, 0);
		lblTextbox.setWrap(Boolean.TRUE);

		txtBackground = new Texture(Gdx.files.internal("background.jpg"));
		txtBackground.setWrap(Texture.TextureWrap.MirroredRepeat, Texture.TextureWrap.MirroredRepeat);
		
		lblTextbox.setText(
				"Player: " + player.getName() 
				+ "  Element: " + player.getElement().getName()
				+ "  Level: " + player.getLevel()
				+ "\nHP: " + player.getHealth() + "/" + player.getMaxHealth()
				+ "  ATK: " + player.getAttack()
				+ "  DEF: " + player.getDefense()
				+ " SPD: " + player.getSpeed()
				+ "\nEXP: " + player.getExperience()
				+ "  grid=" + player.getGridPosition()[0] + "," + player.getGridPosition()[1]
				);
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
		batch.draw(gridImage, Gdx.graphics.getWidth()/2 - 512, Gdx.graphics.getHeight()-gridImage.getHeight(), 1024, 576);
		batch.draw(txtBackground, 0, 0, 1280, 144);
		map01.draw(batch);		
		lblTextbox.draw(batch, 1);		
		batch.draw(player.getSprite(), player.getX_pos(), player.getY_pos(), 64, 64);
		batch.end();
		
		if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE))
			game.setScreen(new MenuScreen(this));
		
		playerMovement();
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
		map01.dispose();
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
	
	private void playerMovement() {
		if (Gdx.input.isKeyJustPressed(Input.Keys.W)) {
			GameEntity temp = (GameEntity) map01.getGridContentAt(player.getGridPosition()[0], player.getGridPosition()[1] + 1);
			if (null == temp || !temp.getIsSolid()) {
				player.setY_pos(64);
				player.setGridPosition(player.getGridPosition()[0], player.getGridPosition()[1]+1);
			}	
			if (null != temp && temp.getIsFoe())
				game.setScreen(new BattleScreen(this));
		}
		if (Gdx.input.isKeyJustPressed(Input.Keys.S)) {
			GameEntity temp = (GameEntity) map01.getGridContentAt(player.getGridPosition()[0], player.getGridPosition()[1] - 1);
			if (null == temp || !temp.getIsSolid()) {
				player.setY_pos(-64);
				player.setGridPosition(player.getGridPosition()[0], player.getGridPosition()[1] - 1);
			}
			if (null != temp && temp.getIsFoe())
				game.setScreen(new BattleScreen(this));
		}
		if (Gdx.input.isKeyJustPressed(Input.Keys.A)) {
			GameEntity temp = (GameEntity) map01.getGridContentAt(player.getGridPosition()[0] - 1, player.getGridPosition()[1]);
			if (null == temp || !temp.getIsSolid()) {
				player.setX_pos(-64);
				player.setGridPosition(player.getGridPosition()[0] - 1, player.getGridPosition()[1]);
			}
			if (null != temp && temp.getIsFoe())
				game.setScreen(new BattleScreen(this));
		}
		if (Gdx.input.isKeyJustPressed(Input.Keys.D)) {
			GameEntity temp = (GameEntity) map01.getGridContentAt(player.getGridPosition()[0] + 1, player.getGridPosition()[1]);
			if (null == temp || !temp.getIsSolid()) {
				player.setX_pos(64);
				player.setGridPosition(player.getGridPosition()[0] + 1, player.getGridPosition()[1]);
			}
			if (null != temp && temp.getIsFoe())
				game.setScreen(new BattleScreen(this));
		}
	}
}
