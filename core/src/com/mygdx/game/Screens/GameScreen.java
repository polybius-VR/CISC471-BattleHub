package com.mygdx.game.Screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.Entities.GameEntity;
import com.mygdx.game.Entities.Player;
import com.mygdx.game.maps.GameMap;
import com.mygdx.game.maps.Level01;
import com.mygdx.game.maps.Level02;
import com.mygdx.game.maps.Level03;
import com.mygdx.game.maps.Level04;
import com.mygdx.game.maps.Level05;
import com.mygdx.game.maps.Level06;
import com.mygdx.game.maps.Level07;
import com.mygdx.game.maps.Level08;
import com.mygdx.game.maps.Level09;
import com.mygdx.game.maps.Level10;

public class GameScreen implements Screen{
	private Game game;
	private Stage stage;
	private Texture gridImage;
	private SpriteBatch batch;
	private Player player;
	private GameMap levelMap;
	private Label lblTextbox;
	private Texture txtBackground;
	private Integer currentLevel = 0;
	
	public GameScreen(Game aGame, Player aPlayer, Integer aCurrentLevel) {
		if (aCurrentLevel < 0 || aCurrentLevel > 9) {
			this.currentLevel = 0;
		} else
			this.currentLevel = aCurrentLevel;
		init(aGame, aPlayer);
	}
	
	public GameScreen(Game aGame, Player aPlayer) {
		init(aGame, aPlayer);
	}
	
	private void init(Game aGame, Player aPlayer) {
		this.game = aGame;
		this.stage = new Stage(new ScreenViewport());
		this.batch = new SpriteBatch();
		this.gridImage = new Texture(Gdx.files.internal("grid.png"));
		this.lblTextbox = new Label("", MyGdxGame.skin);
		
		player = aPlayer;
		if (player.getPlayerClass() == Player.PlayerClass.KNIGHT)
			player.setSprite(new Texture(Gdx.files.internal("knight.png")));
		else if (player.getPlayerClass() == Player.PlayerClass.SPELLCASTER)
			player.setSprite(new Texture(Gdx.files.internal("wizard.png")));
		
		lblTextbox.setColor(Color.BLACK);
		lblTextbox.setSize(Gdx.graphics.getWidth(),160);
		lblTextbox.setPosition(0, 0);
		lblTextbox.setWrap(Boolean.TRUE);

		txtBackground = new Texture(Gdx.files.internal("background.jpg"));
		txtBackground.setWrap(Texture.TextureWrap.MirroredRepeat, Texture.TextureWrap.MirroredRepeat);
		
		loadMap();
	}
	
	private void loadMap() {	
		switch (currentLevel) {
		case 1:
			levelMap = new Level02();
			break;
		case 2:
			levelMap = new Level03();
			break;
		case 3:
			levelMap = new Level04();
			break;
		case 4:
			levelMap = new Level05();
			break;
		case 5:
			levelMap = new Level06();
			break;
		case 6:
			levelMap = new Level07();
			break;
		case 7:
			levelMap = new Level08();
			break;
		case 8:
			levelMap = new Level09();
			break;
		case 9:
			levelMap = new Level10();
			break;
		default:
			levelMap = new Level01();
			break;
		}
		
		player.setX_pos( (Gdx.graphics.getWidth()/2 - 512) + (levelMap.getStartGridPosition()[0]*64));
		player.setY_pos( Gdx.graphics.getHeight() - (Level01.max_Y-levelMap.getStartGridPosition()[1])*64);
		player.setGridPosition(levelMap.getStartGridPosition()[0], levelMap.getStartGridPosition()[1]);
	}

	@Override
	public void show() {
		Gdx.input.setInputProcessor(stage);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.392f, 0.584f, 0.929f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		updateTextbox();
		batch.begin();
		batch.draw(gridImage, Gdx.graphics.getWidth()/2 - 512, Gdx.graphics.getHeight()-gridImage.getHeight(), 1024, 576);
		batch.draw(txtBackground, 0, 0, 1280, 144);
		levelMap.draw(batch);		
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
		levelMap.dispose();
		stage.dispose();
		gridImage.dispose();
		player.getSprite().dispose();
		//enemy.getSprite().dispose();
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
			GameEntity temp = levelMap.getGridContentAt(player.getGridPosition()[0], player.getGridPosition()[1] + 1);
			if (null == temp || !temp.getIsSolid()) {
				player.moveY_pos(64);
				player.setGridPosition(player.getGridPosition()[0], player.getGridPosition()[1]+1);
			}	
			if (null != temp && temp.getIsFoe())
				game.setScreen(new BattleScreen(this, temp));
			if (null != temp && temp.getIsGoal())
				moveToNextLevel();
			if (null != temp && temp.getIsHeal()) {
				player.setHealth(player.getMaxHealth());
				levelMap.removeGridContentAt(player.getGridPosition()[0], player.getGridPosition()[1]);
			}
		}
		if (Gdx.input.isKeyJustPressed(Input.Keys.S)) {
			GameEntity temp = levelMap.getGridContentAt(player.getGridPosition()[0], player.getGridPosition()[1] - 1);
			if (null == temp || !temp.getIsSolid()) {
				player.moveY_pos(-64);
				player.setGridPosition(player.getGridPosition()[0], player.getGridPosition()[1] - 1);
			}
			if (null != temp && temp.getIsFoe())
				game.setScreen(new BattleScreen(this, temp));
			if (null != temp && temp.getIsGoal())
				moveToNextLevel();
			if (null != temp && temp.getIsHeal()) {
				player.setHealth(player.getMaxHealth());
				levelMap.removeGridContentAt(player.getGridPosition()[0], player.getGridPosition()[1]);
			}
		}
		if (Gdx.input.isKeyJustPressed(Input.Keys.A)) {
			GameEntity temp = levelMap.getGridContentAt(player.getGridPosition()[0] - 1, player.getGridPosition()[1]);
			if (null == temp || !temp.getIsSolid()) {
				player.moveX_pos(-64);
				player.setGridPosition(player.getGridPosition()[0] - 1, player.getGridPosition()[1]);
			}
			if (null != temp && temp.getIsFoe())
				game.setScreen(new BattleScreen(this, temp));
			if (null != temp && temp.getIsGoal()) 
				moveToNextLevel();
			if (null != temp && temp.getIsHeal()) {
				player.setHealth(player.getMaxHealth());
				levelMap.removeGridContentAt(player.getGridPosition()[0], player.getGridPosition()[1]);
			}
		}
		if (Gdx.input.isKeyJustPressed(Input.Keys.D)) {
			GameEntity temp = levelMap.getGridContentAt(player.getGridPosition()[0] + 1, player.getGridPosition()[1]);
			if (null == temp || !temp.getIsSolid()) {
				player.moveX_pos(64);
				player.setGridPosition(player.getGridPosition()[0] + 1, player.getGridPosition()[1]);
			}
			if (null != temp && temp.getIsFoe())
				game.setScreen(new BattleScreen(this, temp));
			if (null != temp && temp.getIsGoal())
				moveToNextLevel();		
			if (null != temp && temp.getIsHeal()) {
				player.setHealth(player.getMaxHealth());
				levelMap.removeGridContentAt(player.getGridPosition()[0], player.getGridPosition()[1]);
			}
		}
	}
	
	private void moveToNextLevel() {
		if (currentLevel == 9) {
			currentLevel = 0;
		} else {
			currentLevel += 1;
		}
		loadMap();
	}
	
	private void updateTextbox() {
		lblTextbox.setText(
				"Player: " + player.getName() 
				+ "  Element: " + player.getElement()
				+ "  Level: " + player.getLevel()
				+ "\nHP: " + player.getHealth() + "/" + player.getMaxHealth()
				+ "  ATK: " + player.getAttack()
				+ "  DEF: " + player.getDefense()
				+ " SPD: " + player.getSpeed()
				+ "\nEXP: " + player.getExperience()
				+ "  Position =" + player.getGridPosition()[0] + "," + player.getGridPosition()[1]
				+ "\n Death Count = " + player.getDeathCount()
				);
	}
	
	public void mapReset() {
		loadMap();
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
	
	public void removeGridContentAt(Integer posX, Integer posY) {
		levelMap.removeGridContentAt(posX, posY);
	}
	
	public Integer getCurrentLevel() {
		return this.currentLevel;
	}
	
	public void learnSkillMenu() {
		game.setScreen(new SkillMenuScreen(this));
	}
}
