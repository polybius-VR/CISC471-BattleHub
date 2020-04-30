package com.mygdx.game.Screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.Entities.Player;
import com.mygdx.game.Entities.Skills.Skill;

import java.util.ArrayList;
import java.util.List;

public class SkillMenuScreen implements Screen {
	private GameScreen gameScreen;
	private Stage stage;
	private Game game;
	private Batch batch;
	
	private Label lblTextbox;
	private Texture txtBackground;
	private TextButton skill1;
	private TextButton skill2;
	private TextButton skill3;
	private TextButton skill4;
	private TextButton noSkill;
	private List<TextButton> attackButtons;
	
	private Integer skillIndex = 0; 
	private Boolean selected;
	private String text = "";
	private String text2 = "";	
	private String text3 = "";
	private String text4 = "";
	
	private Player player;
	
	public SkillMenuScreen(GameScreen aGameScreen) {
		gameScreen = aGameScreen;
		game = aGameScreen.getGame();
		stage = new Stage(new ScreenViewport());
		batch = new SpriteBatch();
		player = aGameScreen.getPlayer();
		selected = Boolean.FALSE;
		
		txtBackground = new Texture(Gdx.files.internal("background.jpg"));
		txtBackground.setWrap(Texture.TextureWrap.MirroredRepeat, Texture.TextureWrap.MirroredRepeat);
		
		lblTextbox = new Label("", MyGdxGame.skin);
		lblTextbox.setColor(Color.BLACK);
		lblTextbox.setSize(Gdx.graphics.getWidth(),160);
		lblTextbox.setPosition(0, 0);
		lblTextbox.setWrap(Boolean.TRUE);
		
		attackButtons = new ArrayList<TextButton>();		
		lblTextbox.setText(text + text2 + text3 + text4);
		
		init();
		
		TextButton playButton = new TextButton("Done",MyGdxGame.skin);
        playButton.setWidth(Gdx.graphics.getWidth()/2);
        playButton.setPosition(Gdx.graphics.getWidth()/2-playButton.getWidth()/2,Gdx.graphics.getHeight()/2-playButton.getHeight()/2);
        playButton.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
            	player.setLevelUpFlag(Boolean.FALSE);
            	if (player.getSkills().size() < 4) {
            		learnSkill();
            		game.setScreen(gameScreen);
            	} else {
            		if (selected) {
            			learnSkill();
            			game.setScreen(gameScreen);
            		} 
            		else 
            			text2 += "\nYou must select a skill to forget first!";
            	}
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        
        stage.addActor(playButton);
        stage.addActor(skill1);
        stage.addActor(skill2);
        stage.addActor(skill3);
        stage.addActor(skill4);
        stage.addActor(noSkill);
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
		stage.act();
		stage.draw();
		batch.begin();
		batch.draw(txtBackground, 0, 0, 1280, 144);
		lblTextbox.draw(batch, 1);	
		batch.end();
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
	
	private void init() {
		skill1 = new TextButton("",MyGdxGame.skin, "toggle");
		skill1.setWidth(Gdx.graphics.getWidth()/4);
		skill1.setPosition(0, 160);
		skill1.setVisible(Boolean.FALSE);
		attackButtons.add(skill1);
		        
		skill2 = new TextButton("",MyGdxGame.skin, "toggle");
        skill2.setWidth(Gdx.graphics.getWidth()/4);
        skill2.setPosition(skill2.getWidth(), 160);
        skill2.setVisible(Boolean.FALSE);
        attackButtons.add(skill2);
                
        skill3 = new TextButton("",MyGdxGame.skin, "toggle");
        skill3.setWidth(Gdx.graphics.getWidth()/4);
        skill3.setPosition(skill3.getWidth()*2, 160);
        skill3.setVisible(Boolean.FALSE);
        attackButtons.add(skill3);
        
        skill4 = new TextButton("",MyGdxGame.skin, "toggle");
        skill4.setWidth(Gdx.graphics.getWidth()/4);
        skill4.setPosition(skill4.getWidth()*3, 160);
        skill4.setVisible(Boolean.FALSE);
        attackButtons.add(skill4);
        
        noSkill = new TextButton("None",MyGdxGame.skin, "toggle");
        noSkill.setWidth(Gdx.graphics.getWidth()/4);
        noSkill.setPosition(Gdx.graphics.getWidth()-noSkill.getWidth(), 160 + noSkill.getHeight());
        noSkill.setVisible(Boolean.FALSE);
        
        if (player.getSkills().size() < 4) 
        	text3 = "\nYou learned " + player.getLearnableSkill().getName();
        else
        	text4 = "\nSelect a skill to forget. To learn " + player.getLearnableSkill().getName();        	
        
        
        for (int i = 0; i < player.getSkills().size(); i++) {
        	attackButtons.get(i).setText(player.getSkills().get(i).getName());
        	attackButtons.get(i).setVisible(Boolean.TRUE);
        }
        
        if (player.getSkills().size() >= 4)
        	noSkill.setVisible(Boolean.TRUE);
        
        skill1.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
            	selected = Boolean.TRUE;
            	skillIndex = 0;
            	skill2.setChecked(Boolean.FALSE);
                skill3.setChecked(Boolean.FALSE);
                skill4.setChecked(Boolean.FALSE);
                noSkill.setChecked(Boolean.FALSE);
                
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        skill2.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
            	selected = Boolean.TRUE;
            	skillIndex = 1;
            	skill1.setChecked(Boolean.FALSE);
                skill3.setChecked(Boolean.FALSE);
                skill4.setChecked(Boolean.FALSE);
                noSkill.setChecked(Boolean.FALSE);
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        skill3.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
            	selected = Boolean.TRUE;
            	skillIndex = 2;
            	skill2.setChecked(Boolean.FALSE);
                skill1.setChecked(Boolean.FALSE);
                skill4.setChecked(Boolean.FALSE);
                noSkill.setChecked(Boolean.FALSE);
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        skill4.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
            	selected = Boolean.TRUE;
            	skillIndex = 3;
            	skill2.setChecked(Boolean.FALSE);
                skill3.setChecked(Boolean.FALSE);
                skill1.setChecked(Boolean.FALSE);
                noSkill.setChecked(Boolean.FALSE);
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        
        noSkill.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
            	selected = Boolean.TRUE;
            	skill2.setChecked(Boolean.FALSE);
                skill3.setChecked(Boolean.FALSE);
                skill1.setChecked(Boolean.FALSE);
                skill4.setChecked(Boolean.FALSE);
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
	}
	
	private void learnSkill() {
		Skill newSkill = player.getLearnableSkill();
        
        if (player.getSkills().size() < 4)
        	player.learnSkill(newSkill);
        else {
        	if (!noSkill.isChecked())
        		player.learnSkill(newSkill, player.getSkills().get(skillIndex));
        }
	}
	
	private void updateTextbox() {
		lblTextbox.setText(text + text2 + text3 + text4);
	}

}
