package com.mygdx.game.Screens;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Queue;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.Entities.BattleEntity;
import com.mygdx.game.Entities.Enemy;
import com.mygdx.game.Entities.GameEntity;
import com.mygdx.game.Entities.Player;
import com.mygdx.game.Entities.Skills.Element;
import com.mygdx.game.Entities.Skills.Skill;

public class BattleScreen implements Screen{
	private GameScreen gameScreen;
	private Stage stage;
	private Game game;
	private SpriteBatch batch;
	private Label lblTextbox;
	private Label lblPlayerStats;
	private Label lblEnemyStats;
	private Enemy enemy;
	private Player player;
	private String playerStats;
	private String enemyStats;
	private String txtLog = "";
	private Boolean AttackSelected = Boolean.FALSE;
	private Boolean firstTurn;
	private Queue<String> actionLog = new Queue<String>();
	private Boolean waitForKey = Boolean.TRUE;
	private Integer selectedAttackindex = 0;
	private Boolean fleeFlag;
	private Texture background;
	
	private BattleEntity first;
	private BattleEntity second;
	
	TextButton skill1;
	TextButton skill2;
	TextButton skill3;
	TextButton skill4;
	
	Queue<TextButton> initSkillList = new Queue<TextButton>();
	Queue<TextButton> skillList = new Queue<TextButton>();
	
	public BattleScreen(GameScreen aGameScreen, GameEntity aEnemy) {
		gameScreen = aGameScreen;
		game = aGameScreen.getGame();
		stage = new Stage(new ScreenViewport());
		batch = new SpriteBatch();
		lblTextbox = new Label("", MyGdxGame.skin);
		lblPlayerStats = new Label("", MyGdxGame.skin);
		lblEnemyStats = new Label("", MyGdxGame.skin);		
		background = new Texture(Gdx.files.internal("battleBG.png"));
		player = gameScreen.getPlayer();
		enemy = (Enemy) aEnemy;
		firstTurn = Boolean.TRUE;
		fleeFlag = Boolean.FALSE;
		
		initBattle();
	}
	
	private void initBattle() {
		List<TextButton> attackButtons = new ArrayList<TextButton>();
		skill1 = new TextButton("",MyGdxGame.skin);
		skill1.setWidth(Gdx.graphics.getWidth()/4);
		skill1.setPosition(0, 160);
		skill1.setVisible(Boolean.FALSE);
		attackButtons.add(skill1);
		        
        skill2 = new TextButton("",MyGdxGame.skin);
        skill2.setWidth(Gdx.graphics.getWidth()/4);
        skill2.setPosition(skill2.getWidth(), 160);
        skill2.setVisible(Boolean.FALSE);
        attackButtons.add(skill2);
                
        skill3 = new TextButton("",MyGdxGame.skin);
        skill3.setWidth(Gdx.graphics.getWidth()/4);
        skill3.setPosition(skill3.getWidth()*2, 160);
        skill3.setVisible(Boolean.FALSE);
        attackButtons.add(skill3);
        
        skill4 = new TextButton("",MyGdxGame.skin);
        skill4.setWidth(Gdx.graphics.getWidth()/4);
        skill4.setPosition(skill4.getWidth()*3, 160);
        skill4.setVisible(Boolean.FALSE);
        attackButtons.add(skill4);
        
        TextButton fleeButton = new TextButton("Flee!",MyGdxGame.skin);
        fleeButton.setWidth(Gdx.graphics.getWidth()/4);
        fleeButton.setPosition(fleeButton.getWidth()*3,Gdx.graphics.getHeight()-fleeButton.getHeight());
        fleeButton.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
            	AttackSelected = Boolean.TRUE;
            	fleeFlag = Boolean.TRUE;
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        
        for (int i = 0; i < player.getSkills().size(); i++) {
        	attackButtons.get(i).setText(player.getSkills().get(i).getName());
        	attackButtons.get(i).setVisible(Boolean.TRUE);;
        }
        
        skill1.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
            	selectedAttackindex = 0;
                AttackSelected = Boolean.TRUE;
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        skill2.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
            	selectedAttackindex = 1;
            	AttackSelected = Boolean.TRUE;
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        skill3.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
            	selectedAttackindex = 2;
            	AttackSelected = Boolean.TRUE;
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        skill4.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
            	selectedAttackindex = 3;
            	AttackSelected = Boolean.TRUE;
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        
        lblTextbox.setColor(Color.BLACK);
		lblTextbox.setSize(Gdx.graphics.getWidth(),125);
		lblTextbox.setPosition(5, 0);
		lblTextbox.setWrap(Boolean.TRUE);
		
		lblPlayerStats.setColor(Color.BLACK);
		lblPlayerStats.setSize(Gdx.graphics.getWidth(), 125);
		lblPlayerStats.setPosition(5, Gdx.graphics.getHeight()-75);
		lblPlayerStats.setWrap(Boolean.TRUE);
		
		lblEnemyStats.setColor(Color.BLACK);
		lblEnemyStats.setSize(300,125);
		lblEnemyStats.setPosition(Gdx.graphics.getWidth()/2 - lblEnemyStats.getWidth()/2, 500);
		lblEnemyStats.setWrap(Boolean.TRUE);
		
		battleLog("A wild " + enemy.getName() + " appeared");
		
        addBackgroundGuide();
        stage.addActor(skill1);
        stage.addActor(skill2);
        stage.addActor(skill3);
        stage.addActor(skill4);        
        stage.addActor(lblTextbox);
        stage.addActor(lblPlayerStats);
        stage.addActor(lblEnemyStats);
        stage.addActor(fleeButton);
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
		battleSystem();
		stage.act();		
		batch.begin();
		batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		batch.draw(enemy.getSpriteDetail(), Gdx.graphics.getWidth()/2 - enemy.getSpriteDetail().getWidth()/2, Gdx.graphics.getHeight()/2 - enemy.getSpriteDetail().getHeight()/2, enemy.getSpriteDetail().getWidth(), enemy.getSpriteDetail().getHeight());
		batch.end();
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
		enemy.getSpriteDetail().dispose();
		player.getSprite().dispose();
		background.dispose();
	}

	private void addBackgroundGuide(){
		Texture texture = new Texture(Gdx.files.internal("background.jpg"));
		texture.setWrap(Texture.TextureWrap.MirroredRepeat, Texture.TextureWrap.MirroredRepeat);

		TextureRegion textureRegion = new TextureRegion(texture);
		textureRegion.setRegion(0,0,texture.getWidth(),texture.getWidth());
		Image background = new Image(textureRegion);
		background.setSize(Gdx.graphics.getWidth(), 144);
		background.setPosition(0,0);
		stage.addActor(background);
	}
	
	private void battleSystem() {
		waitForKey = Boolean.TRUE;
		
		if (firstTurn) {
			if (player.getSpeed() >= enemy.getSpeed()) {
				first = player;
				second = enemy;				
			} else {
				first = enemy;
				second = player;
			}
			for (int i=0; i < actionLog.size; i++) {		
				txtLog += actionLog.get(i) + "\n";
			}
			firstTurn = Boolean.FALSE;
		}
		
		battleTurn(first, second);
	}
	
	private void battleLog(String txt) {
		if (actionLog.size > 6)
			actionLog.removeFirst();
		
		actionLog.addLast(txt);
	}
	
	
	private void battleTurn(BattleEntity source, BattleEntity target) {
		if (!player.getIsDefeat() && !enemy.getIsDefeat()) {
			if (!source.getIsNPC()) {
				if (AttackSelected) {
					AttackSelected = Boolean.FALSE;
					
					if (fleeFlag) {
						fleeFlag = Boolean.FALSE;
						Random random = new Random();
		            	int randomNumber = random.nextInt(101);
		            	if (randomNumber >= 50) {
		            		battleLog("Escape Successful!");		            		
		    				gameScreen.removeGridContentAt(player.getGridPosition()[0], player.getGridPosition()[1]);		    				
		            		game.setScreen(gameScreen);		            	
		            	} else {
		            		battleLog("Failed to Escape!");
		            		first = enemy;
		            		second = player;
		            		for (int i=0; i < actionLog.size; i++) {		
								txtLog += actionLog.get(i) + "\n";
							}
		            	}
					} else {
						battleLog(source.getName() + "'s Turn!");
						battleLog(source.getName() + " Attacks with " + source.getSkills().get(selectedAttackindex).getName());
						Integer dmg = damageCalc(source, target, source.getSkills().get(selectedAttackindex));
						target.setHealth(target.getHealth() - dmg);
						battleLog(target.getName() + " lost " + dmg + " HP");
						
						first = enemy;
						second = player;
						txtLog = "";
						for (int i=0; i < actionLog.size; i++) {		
							txtLog += actionLog.get(i) + "\n";
						}
					}
				}				
			} else {
				Random random = new Random();
				int randomNumber = random.nextInt(source.getSkills().size());

				battleLog(source.getName() + "'s Turn!");
				battleLog(source.getName() + " Attacks with " + source.getSkills().get(randomNumber).getName());
				Integer dmg = damageCalc(source, target, source.getSkills().get(randomNumber));
				target.setHealth(target.getHealth() - dmg);

				battleLog(target.getName() + " lost " + dmg + " HP");
				first = player;
				second = enemy;
				txtLog = "";
				for (int i=0; i < actionLog.size; i++)		
					txtLog += actionLog.get(i) + "\n";
			}
		} else {
			if (enemy.getIsDefeat()) {
				if (waitForKey){
					if (Gdx.input.isKeyJustPressed(Keys.ANY_KEY)) {
						//calculate EXP
						player.increaseExperience(enemy.getExperience());
						
						//remove enemy from map
						gameScreen.removeGridContentAt(player.getGridPosition()[0], player.getGridPosition()[1]);
						waitForKey = Boolean.FALSE;
						if (player.getLevelUpFlag())
							game.setScreen(new SkillMenuScreen(gameScreen));
						else
							game.setScreen(gameScreen);			        	
			        }
			    }
			}
			else {
				if (waitForKey){
					if (Gdx.input.isKeyJustPressed(Keys.ANY_KEY)) {
						gameScreen.mapReset();
						player.setHealth(player.getMaxHealth());
						player.setIsDefeat(Boolean.FALSE);
						waitForKey = Boolean.FALSE;
						game.setScreen(gameScreen);			        	
			        }
			    }
			}
		}
	}
	
	private void updateTextbox() {		
		playerStats = player.getName() + " HP:" + player.getHealth() + "/" + player.getMaxHealth();
		enemyStats = enemy.getName() + " HP:" + enemy.getHealth() + "/" + enemy.getMaxHealth();
				
		lblTextbox.setText(txtLog);
		lblPlayerStats.setText(playerStats);
		lblEnemyStats.setText(enemyStats);
	}
	
	private Integer damageCalc(BattleEntity source, BattleEntity target, Skill skill) {
		Float res;
		float atkLim = 5;
		float defBoost = 2;
		
		Random random = new Random();
		int randomNumber = random.nextInt(101);
		
		res = ((source.getAttack().floatValue() / atkLim) * skill.getBaseAttack()) - (target.getDefense() * defBoost);
		if (!skill.getElement().equals(Element.Elements.NONE)) {
			if (skill.getElement().equals(target.getWeakness())) { 
				res = res * 2;
				battleLog("It's an effective attack!");
			} 
			if (skill.getElement().equals(target.getAdvantage())) {
				res = res / 2;
				battleLog("It's not very effective!");
			}
		}
		if (res <= 0) 
			res = 1f;
		
		if (randomNumber >= 95) {
			res = res*2;
			battleLog("It's a critical hit!");
		}
		
		if (skill.getHealBonus()) {
			Integer heal = source.getHealth() + (int) Math.ceil(res/2); 
			if (heal > source.getMaxHealth())
				source.setHealth(source.getMaxHealth());
			else
				source.setHealth(heal);
			
			battleLog(source.getName() + " recovered HP thanks to " + skill.getName() + "'s bonus!");
		}
		
		return (int) Math.ceil(res);
	}
}
